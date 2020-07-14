/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBServer;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import Information.*;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class FindInfo extends DBConnector {

    private UserInformationServer user;
    private Vector<String> vec = new Vector<>();
    private String searchTarget = "";
    private String searchType = "";
    private String sql = "";
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private ResultSetMetaData rsmd = null;

    public FindInfo(String searchTarget, String searchType) {
        this.searchTarget = searchTarget;
        this.searchType = searchType;
    }

    private String searchID() throws Exception {
        // 아이디 찾기 ( 이름, 전화번호로)
        String[] info = searchTarget.split("#"); 
        // 0 : 이름
        // 1 : 번호

        if (info[0].matches("^[가-힣]*$") && info[1].matches("^010-\\d{4}-\\d{4}$")) {
            sql = String.format("SELECT ID FROM user_info WHERE UserName = \"%s\" AND PhoneNumber = \"%s\";", info[0], info[1]);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
        }
        String result = "";
        while(rs.next()){
            result = rs.getString(1);
        }
        
        return result;
    }

    private String searchPW() throws Exception {
        String[] inputData = searchTarget.split("#");
        // 0 : 아이디
        // 1 : 질문 인덱스
        // 2 : 인증코드 (답변)

        sql = String.format("SELECT PW FROM user_info WHERE ID = \"%s\" AND ConfirmQuestion = \"%s\" AND ConfirmCode = \"%s\";",
                inputData[0], inputData[1], inputData[2]);
        
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        
        String result = "";
        if (rs.next()) {
            result = rs.getString(1);
        }

        return result;
    }

    public String findInformation() { // void 
        DBConnector db = new DBConnector();
        String result = "";
        try {
            if(searchType.equals("ID")) result = searchID();
            else if(searchType.equals("PW")) result = searchPW();
                        
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
