/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBServer;

import Information.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class UserSearch extends DBConnector implements SearchInterface {

    private UserInformationServer userinfo;
    private String searchtype;

    public UserSearch(UserInformationServer userinfo, String inputData) {
        String[] data = inputData.split("!");

        this.userinfo = userinfo;
        this.searchtype = data[data.length - 1];
    }

    private String makeSQL() {
        String sql = "";
        if (searchtype.equals("ALL")) { // 사용자 정보 전체 출력
            sql = "SELECT * FROM user_info";
        } else if (searchtype.equals("USER")) { // 한 사용자 정보 출력
            sql = String.format("SELECT * FROM user_info WHERE ID = \"%s\" AND UserName = \"%s\";", userinfo.getID(), userinfo.getUserName());
        } else if (searchtype.equals("CHECK_ID")) { // ID 중복 확인
            sql = String.format("SELECT * FROM user_info WHERE ID = '%s'", userinfo.getID());

        } 
        
        return sql;
    }

    @Override
    public Vector informationSearch() {
        Vector<String> vec = new Vector<>();
        DBConnector db = new DBConnector();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;

        String sql = makeSQL();

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            rsmd = rs.getMetaData();

            int count = rsmd.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= count; i++) {
                    vec.add(rs.getString(i));
                }
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
}
