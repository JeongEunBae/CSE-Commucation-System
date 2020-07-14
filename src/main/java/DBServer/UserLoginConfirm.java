/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBServer;

import Information.*;
import java.sql.ResultSet;
import java.util.Vector;
/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class UserLoginConfirm extends DBConnector{

    private String ID;
    private String PW;

    public UserLoginConfirm(String ID, String PW) {
        this.ID = ID;
        this.PW = PW;
    }

    
    public String loginConfirm() {
        DBConnector db = new DBConnector();
        Vector<String> vec = new Vector<>();
        String  result = "false";
        
        String sql = String.format("(SELECT Authority FROM user_info WHERE ID = \"%s\" AND PW = \"%s\") "
                + "UNION (SELECT Authority FROM manager_info WHERE ID = \"%s\" AND PW = \"%s\");", ID, PW, ID, PW);
        // 관리자, 사용자 테이블에 값이 있는지 확인 
        
        try {
            ResultSet rs = db.state.executeQuery(sql);
            while (rs.next()) {
                vec.add(rs.getString(1));
                result = "true";
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if(result.equals("true")) return vec.get(0);
        else return result;
    }
}
