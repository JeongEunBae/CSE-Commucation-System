/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE_Server;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class SocketReceiveData {
    private String authority=" ";
    private String ID=" ";
    private String userName=" ";
    private String function = " ";
    private String dbMethod = " ";
    private String purpose = " ";
    private String data = " ";

    public SocketReceiveData(String sendData) {
        System.out.println("sendData = " + sendData);
        String[] splitData = sendData.split("@");
        System.out.println(splitData.length);
        this.authority = splitData[0];
        this.ID = splitData[1];
        this.userName = splitData[2];
        this.function = splitData[3];
        this.dbMethod = splitData[4];
        this.purpose = splitData[5];
        this.data = splitData[6];
        
        
    }

    public String getID() {
        return ID;
    }

    public String getAuthority() {
        return authority;
    }

    public String getUserName() {
        return userName;
    }

    public String getFunction() {
        return function;
    }

    public String getDbMethod() {
        return dbMethod;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getData() {
        return data;
    }

}
