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
 * @author Administrator
 */
public class CommentDelete extends DBConnector implements DeleteInterface {
    
    private String selectedComment;
    private String writer;
    private String authority;
    PreparedStatement pstmt = null;

    public CommentDelete(String inputData, String authority) {
        String[] splitdata = inputData.split("!");
                       
        this.selectedComment = splitdata[0];
        this.writer = splitdata[1];
        this.authority = authority;
    }    
    
    private boolean deleteCommentByAdmin() throws Exception { // 관리자가 게시물을 삭제할 경우
        String  sql = String.format("DELETE FROM comment_info WHERE CommentNumber = '%s';", selectedComment);
        pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
        
        return true;
    }
    
    private boolean deleteCommentByUser() throws Exception{ // 사용자가 게시물을 삭제할 경우
        String sql = String.format("SELECT CommentNumber FROM comment_info WHERE CommentNumber = '%s' AND CommentWriter = '%s';", selectedComment, writer);
        pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            sql = String.format("DELETE FROM comment_info WHERE CommentNumber = '%s' AND CommentWriter = '%s';", selectedComment, writer);
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
            if("admin".equals(authority)) result = deleteCommentByAdmin();
            else result = deleteCommentByUser();
            
            pstmt.close();
            conn.close(); 
            
        } catch (Exception e) {
            e.printStackTrace();
         }
         return result;
    }
}
