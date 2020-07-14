/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE_Server;

import DBServer.*;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class DeleteDB {
    private String purpose;
    private String data;
    private String authority;
    private String ID;

    public DeleteDB(String purpose, String authority, String ID, String data) {
        this.purpose = purpose;
        this.authority = authority;
        this.ID = ID;
        this.data = data;
    }    
    
    public boolean deleteMethod() {
        boolean result = false;
       
        if(purpose.equals("USER")) result = new UserDelete(data).informationDelete();
        else if(purpose.equals("POST")) result = new PostDelete(data, ID, authority).informationDelete();
        else if(purpose.equals("COMMENT")) result = new CommentDelete(data, authority).informationDelete();
        
        return result;
    }
}
