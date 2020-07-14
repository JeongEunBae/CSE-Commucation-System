package DBServer;

import Information.*;
import java.sql.PreparedStatement;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class ChatInsert extends DBConnector implements InsertInterface{
    PreparedStatement pstmt = null;
    private final ChatInformationServer chatinfo;

    public ChatInsert(ChatInformationServer chatinfo) {
        this.chatinfo = chatinfo;
    }
    
    @Override
    public boolean informationInsert() {
        DBConnector db = new DBConnector();
        boolean result = false;
        
        String sql = String.format("INSERT INTO chat_info VALUE(%s);", chatinfo.toString());

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