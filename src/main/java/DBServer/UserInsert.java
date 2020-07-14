/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBServer;

import Information.UserInformationServer;
import UserManagement.UserInformation;

import java.sql.PreparedStatement;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class UserInsert extends DBConnector implements InsertInterface{
    PreparedStatement pstmt = null;
    private UserInformation userinfo;

    public UserInsert(UserInformation userinfo) {
        this.userinfo = userinfo;
    }
    
    @Override
    public boolean informationInsert() {
        DBConnector db = new DBConnector();
        boolean result = false;
        
        String sql = String.format("INSERT INTO user_info VALUE(%s);", userinfo.toString());

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            
            result = true;       
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
