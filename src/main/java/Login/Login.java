/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import CSE_Client.*;
import DBServer.*;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class Login {
    private String ID;
    private String PW;
    
    public Login(String ID, String PW) {
        this.ID = ID;
        this.PW = PW;
    }
   
    public String loginResult(/*ClientSocket clientsocket*/) {
//        SocketSendData socketsenddata = new SocketSendData(ID, " ");
//        socketsenddata.setFunction("DB");
//        socketsenddata.setDbMethod("LOGIN");
//        socketsenddata.setData(ID + "!" + PW);
//        
//        if(clientsocket.createThreadReturnString(socketsenddata).equalsIgnoreCase("USER")) return "user";
//        else if(clientsocket.createThreadReturnString(socketsenddata).equalsIgnoreCase("ADMIN")) return "admin";
//        else return "false";
           
        String userloginResult = new UserLoginConfirm(ID, PW).loginConfirm();
        return userloginResult;
    }
}
