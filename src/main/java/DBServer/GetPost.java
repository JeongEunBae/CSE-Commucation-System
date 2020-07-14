/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBServer;

import java.sql.PreparedStatement;
import Information.*;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class GetPost extends DBConnector {

    PreparedStatement pstmt = null;
    private String ID;
    private String authority;

    public GetPost(String ID, String authority) {
        this.ID = ID;
        this.authority = authority;
    }

    public String getAdminPost() {
        DBConnector db = new DBConnector();
        String result = "false";

        //String sql = String.format("INSERT INTO post_info VALUE(%s);", post.toString());
        String sql = String.format("SELECT * FROM post_info;");
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //pstmt = conn.prepareStatement(sql);
            //pstmt.executeUpdate();

            while (rs.next()) {
                String PostNumber = rs.getString("PostNumber");
                String Title = rs.getString("Title");
                String Writer = rs.getString("Writer");
                String ID = rs.getString("ID");
                String CreationTime = rs.getString("CreationTime");
                String UploadFile = rs.getString("UploadFile");
                String Contents = rs.getString("Contents");
                String Keyword = rs.getString("Keyword");
                String ViewCount = rs.getString("ViewCount");
                String CommentNumber = rs.getString("CommentNumber");
                String CommentCount = rs.getString("CommentCount");
                String Authority = rs.getString("Authority");

                System.out.format("PostNumber : %s | Title : %s | ID : %s | Writer : %s | Time : %s | "
                        + "Contents : %s | Keyword : %s | Authority : %s\n",
                        PostNumber, Title, ID, Writer, CreationTime, Contents, Keyword, Authority);

            }
            st.close();
            result = "true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getUserPost() {
        DBConnector db = new DBConnector();
        String result = "false";

        //String sql = String.format("INSERT INTO post_info VALUE(%s);", post.toString());
        String sql = String.format("SELECT * FROM post_info;");
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //pstmt = conn.prepareStatement(sql);
            //pstmt.executeUpdate();

            while (rs.next()) {
                String PostNumber = rs.getString("PostNumber");
                String Title = rs.getString("Title");
                String Writer = rs.getString("Writer");
                String ID = rs.getString("ID");
                String CreationTime = rs.getString("CreationTime");
                String UploadFile = rs.getString("UploadFile");
                String Contents = rs.getString("Contents");
                String Keyword = rs.getString("Keyword");
                String ViewCount = rs.getString("ViewCount");
                String CommentNumber = rs.getString("CommentNumber");
                String CommentCount = rs.getString("CommentCount");
                String Authority = rs.getString("Authority");

                if (ID.equals(this.ID)) {
                    System.out.format("PostNumber : %s | Title : %s | ID : %s | Writer : %s | Time : %s | "
                            + "Contents : %s | Keyword : %s | Authority : %s\n",
                            PostNumber, Title, ID, Writer, CreationTime, Contents, Keyword, Authority);
                }
            }
            st.close();
            result = "true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getAllPost() {
        DBConnector db = new DBConnector();
        String result = "false";

        //String sql = String.format("INSERT INTO post_info VALUE(%s);", post.toString());
        String sql = String.format("SELECT * FROM post_info;");
        try {
            if("admin".equals(authority)) result = getAdminPost();
            else result = getUserPost();
                        
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
         }
         return result;
    }
}
