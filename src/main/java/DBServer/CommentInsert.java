/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBServer;

import Information.*;
import java.sql.PreparedStatement;

/**
 *
 * @author Administrator
 */
public class CommentInsert extends DBConnector implements InsertInterface{

    PreparedStatement pstmt = null;
    private Comment commentinfo;

    public CommentInsert(Comment commentinfo) {
        this.commentinfo = commentinfo;
    }

    @Override
    public boolean informationInsert() {
        DBConnector db = new DBConnector();
        boolean result = false;

        String sql = String.format("INSERT INTO comment_info VALUE(%s);", commentinfo.toString());

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
