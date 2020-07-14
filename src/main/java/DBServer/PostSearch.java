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
public class PostSearch extends DBConnector implements SearchInterface {
    private int selectedIndex;
    private String keyword;
    
    public PostSearch(int selectedIndex, String keyword) {
        this.selectedIndex = selectedIndex;
        this.keyword = keyword;
    }
    
    private String makeSQL() {
        String sql="";
        if(selectedIndex==0) { // index가 0이면 작성자 이름으로 검색
             sql = String.format("SELECT PostNumber, Title, Writer, Contents, CreationTime, ViewCount, CommentCount "
                + "FROM post_info WHERE Writer = \"%s\";", keyword);
        }
        else if(selectedIndex ==1) { // index가 1일 경우, 제목이나 게시물 내용에 keyword값이 포함되는 값 출력
            sql = String.format("SELECT PostNumber, Title, Writer, Contents, CreationTime, ViewCount, CommentCount "
                + "FROM post_info WHERE (Title LIKE \'%%%s%%\') OR (Contents LIKE \'%%%s%%\');", keyword, keyword);
        }
        else if(selectedIndex == 3) {
            sql = String.format("SELECT * FROM post_info WHERE PostNumber = '%s'", keyword);
        }
        else sql = "SELECT * FROM post_info";
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
             
                
                if(selectedIndex == 3) {
                    for(int i = 1; i<=count ;i++) 
                        vec.add(rs.getString(i));
                }
                else {
                vec.add(rs.getString("PostNumber"));
                vec.add(rs.getString("Title"));
                vec.add(rs.getString("Writer"));
                vec.add(rs.getString("CreationTime"));
                vec.add(rs.getString("ViewCount"));
                vec.add(rs.getString("CommentCount"));
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
