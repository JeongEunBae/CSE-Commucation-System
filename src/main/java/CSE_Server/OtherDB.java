/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE_Server;

import DBServer.*;
import Information.UserInformationServer;
/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class OtherDB {
    private String function;
    private String data;
    private String purpose;
    
    public OtherDB(String function, String purpose, String data) {
        this.data = data;
        this.purpose = purpose;
        this.function = function;
    }

    public String otherMethod() {
        String result = "false";
        
        if(function.equals("LOGIN")) {
            String[] splitData = data.split("!");
            result = new UserLoginConfirm(splitData[0], splitData[1]).loginConfirm();
        }
        else if(function.equals("FINDINFO")) {
            String[] splitdata = data.split("!");
            result = new FindInfo(splitdata[0], splitdata[1]).findInformation();
        }
        else if(function.equals("GETPOST")) {
            String[] splitData = data.split("!");
            if(purpose.equals("ADMIN")) result = new GetPost(splitData[0], splitData[1]).getAdminPost();
            else if (purpose.equals("USER")) result = new GetPost(splitData[0], splitData[1]).getUserPost();
            else if(purpose.equals("ALL")) result = new GetPost(splitData[0], splitData[1]).getAllPost();
        }
        else if(function.equals("CHATCHECK")) {
            String[] splitData = data.split("!");
            result = new ChatRoomCheck(splitData[0], splitData[1]).chatRoomChecking();
        }
             
        return result;
    }
}
