/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import CSE_Client.ClientSocket;
import CSE_Client.SocketSendData;
import DBServer.FindInfo;
import java.util.StringJoiner;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class FindInformation {

    private String name;
    private String phoneNumber;
    private String ID;
    private int selectQuestion;
    private String answer;

    public FindInformation(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public FindInformation(String ID, int selectQuestion, String answer) {
        this.ID = ID;
        this.selectQuestion = selectQuestion;
        this.answer = answer;
    }

       
    public String searchIDString() {
        StringJoiner stringjoin = new StringJoiner("#");
        stringjoin.add(name).add(phoneNumber);
        return stringjoin.toString();
    }

    public String searchPWString() {
        StringJoiner stringjoin = new StringJoiner("#");
        stringjoin.add(ID).add(Integer.toString(selectQuestion)).add(answer);
        return stringjoin.toString();
    }
    
    public String searchIDResult(/*ClientSocket clientsocket*/) {
//        SocketSendData socketsenddata = new SocketSendData(" ", name);
//        socketsenddata.setFunction("DB");
//        socketsenddata.setDbMethod("FINDINFO");
//        
//        socketsenddata.setData("ID!" + searchIDString());
//
//        return clientsocket.createThreadReturnString(socketsenddata);
          return new FindInfo(searchIDString(), "ID").findInformation();
    }

    public String searchPWResult(/*(ClientSocket clientsocket*/) {
//        SocketSendData socketsenddata = new SocketSendData(ID, " ");
//        socketsenddata.setFunction("DB");
//        socketsenddata.setDbMethod("FINDINFO");
//        socketsenddata.setData("PW!" +searchPWString());
//
//        return clientsocket.createThreadReturnString(socketsenddata);
           return new FindInfo(searchPWString(), "PW").findInformation();
    }

}
