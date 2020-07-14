/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

//import CSE_Client.ClientSocket;
import CSE_Client.SocketSendData;
import DBServer.UserInsert;
import UserManagement.UserInformation;
import static javax.swing.text.html.HTML.Attribute.ID;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class SignUp {

    private UserInformation userInfo;

    public SignUp(UserInformation userInfo) {
        this.userInfo = userInfo;
    }

    public boolean SignUpResult(/*ClientSocket clientsocket*/) {

//        SocketSendData socketsenddata = new SocketSendData(userInfo.getID(), userInfo.getUserName());
//        socketsenddata.setFunction("DB");
//        socketsenddata.setDbMethod("INSERT");
//        socketsenddata.setPurpose("USER");
//        socketsenddata.setData(userInfo.toString());
//        
//        return clientsocket.createThreadReturnBool(socketsenddata);
        return new UserInsert(userInfo).informationInsert();
    }
}
