/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBServer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class CommentIndex extends DBConnector {
    PreparedStatement pstmt = null;

    public int getNextIndex() {
        int index = 0;

        String sql = String.format("SELECT * FROM comment_info;");
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                index = Integer.parseInt(rs.getString("CommentNumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return index + 1;
    }
}
