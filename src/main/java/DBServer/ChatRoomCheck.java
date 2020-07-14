/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBServer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class ChatRoomCheck extends DBConnector {

    PreparedStatement pstmt = null;
    private final String chatRoomNumber;
    private final String chatPassword;

    public ChatRoomCheck(String chatRoomNumber, String chatPassword) {
        this.chatRoomNumber = chatRoomNumber;
        this.chatPassword = chatPassword;
    }
    
    public String chatRoomChecking() {
        DBConnector db = new DBConnector();
        ResultSet rs = null;

        String sql = String.format("SELECT ChatroomNumber, RoomPassword FROM CHAT_INFO WHERE ChatroomNumber = %s AND RoomPassword = '%s';", chatRoomNumber, chatPassword);

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                pstmt.close();
                conn.close();
                return "true";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "false";
    }

}
