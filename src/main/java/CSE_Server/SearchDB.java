/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE_Server;

import Information.*;
import DBServer.*;
import java.util.Vector;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class SearchDB {
    private String purpose;
    private String data;
    private UserInformationServer userinfoserver;
    private PostInformationServer postinfoserver;

    public SearchDB(String purpose, String data) {
        this.purpose = purpose;
        this.data = data;
        this.userinfoserver = new UserInformationServer(data);
    }
    
    public Vector searchMethod() {
        Vector<String> resultVec = new Vector<>();
        
        if(purpose.equals("USER")) resultVec = new UserSearch(userinfoserver, data).informationSearch();
        else if(purpose.equals("POST")) {
            String[] splitdata = data.split("!");
            resultVec = new PostSearch(Integer.parseInt(splitdata[0]), splitdata[1]).informationSearch();
        }
        else if(purpose.equals("COMMENT")) {
            resultVec = new CommentSearch(data).informationSearch();
        }
        
        return resultVec;
    }
}
