/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBServer;

import Community.Post;
import java.sql.PreparedStatement;
import Information.*;
/**
 *
 * @author user=JeongEun Bae <byg0922@naver.com>
 */

public class PostInsert extends DBConnector implements InsertInterface{  
    PreparedStatement pstmt = null;
    private Post postinfo;

    public PostInsert(Post postinfo) {
        this.postinfo = postinfo;
    }
    
    @Override
    public boolean informationInsert(){
        DBConnector db = new DBConnector();
        boolean result = false;
        
        String sql = String.format("INSERT INTO post_info VALUE(%s);", postinfo.toString());

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