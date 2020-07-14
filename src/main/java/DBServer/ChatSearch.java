/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBServer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class ChatSearch extends DBConnector{
   
    public Vector informationSearch() {
        Vector<String> vec = new Vector<>();
        DBConnector db = new DBConnector();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        
        String sql = "SELECT ChatroomNumber, ChatroomName, CreatationTime, ChatManager, PeopleNumber, Property FROM chat_info";
        
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            rsmd = rs.getMetaData();                        
            
            int count = rsmd.getColumnCount();
            
            while (rs.next()) {
                    for(int i = 1; i<=count ;i++) 
                        vec.add(rs.getString(i));
                }
             rs.close();
            pstmt.close();
            conn.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
}
