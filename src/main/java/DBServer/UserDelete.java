/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBServer;

import java.sql.*;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class UserDelete extends DBConnector implements DeleteInterface{
     private String selectedID;
     PreparedStatement pstmt = null;
    
     public UserDelete(String valueID) {
        this.selectedID = valueID;
     }
    
     @Override
     public boolean informationDelete() {
         DBConnector db = new DBConnector();
         boolean result = false;
        
         String sql = "DELETE FROM user_info WHERE ID = ?;";

         try {
             pstmt = conn.prepareStatement(sql);
             pstmt.setString(1, selectedID);
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
