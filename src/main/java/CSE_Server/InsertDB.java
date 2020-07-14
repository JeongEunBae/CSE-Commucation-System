/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE_Server;

import Information.*;
import DBServer.*;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class InsertDB {

    private String purpose;
    private String data;
    private UserInformationServer userinfoserver;
    private PostInformationServer postinfoserver;
    private Comment commentinfo;
    private ChatInformationServer chatinfoserver;
    
    public InsertDB(String purpose, String data) {
        this.purpose = purpose;
    }

    public boolean insertMethod() {
        boolean result = false;

        if (purpose.equals("USER")) {
            this.userinfoserver = new UserInformationServer(data);
            result = new UserInsert(userinfoserver).informationInsert();
        } else if (purpose.equals("POST")) {
            this.postinfoserver = new PostInformationServer(data);
            result = new PostInsert(postinfoserver).informationInsert();
        }
        else if(purpose.equals("COMMENT")) {
            this.commentinfo = new Comment(data);
            result = new CommentInsert(commentinfo).informationInsert();
        }
        else if(purpose.equals("CHAT")) {
            this.chatinfoserver = new ChatInformationServer(data);
            result = new ChatInsert(chatinfoserver).informationInsert();
        }
        return result;
    }
}
