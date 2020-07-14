/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBServer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author user=JeongEun Bae <byg0922@naver.com>
 */
public class PostDelete extends DBConnector implements DeleteInterface {

    private String selectedPost;
    private String userID;
    private String authority;
    PreparedStatement pstmt = null;

    public PostDelete(String selectedPost, String userID, String authority) {
        this.selectedPost = selectedPost;
        this.userID = userID;
        this.authority = authority;
    }
    
    
    private boolean deletePostByAdmin() throws Exception { // 관리자가 게시물을 삭제할 경우
        String  sql = String.format("DELETE FROM post_info WHERE PostNumber = '%s';", selectedPost);
        pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
        
        return true;
    }
    
    private boolean deletePostByUser() throws Exception{ // 사용자가 게시물을 삭제할 경우
        String sql = String.format("SELECT PostNumber FROM post_info WHERE PostNumber = '%s' AND ID = '%s';", selectedPost, userID);
        pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            sql = String.format("DELETE FROM post_info WHERE PostNumber = '%s' AND ID = '%s';", selectedPost, userID);
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            
            return true;
        }
        else{
            System.out.println("본인의 게시글만 삭제할 수 있습니다.");
            return false;
        }
        
    }
    
    @Override
    public boolean informationDelete() {
        DBConnector db = new DBConnector();
        boolean result = false;

        try {
            if("admin".equals(authority)) result = deletePostByAdmin();
            else result = deletePostByUser();
            
            pstmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
         }
         return result;
    }
}