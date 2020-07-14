/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE_Client;

import java.util.StringJoiner;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class SocketSendData {
    private String authority="user";
    private String ID= " ";
    private String userName= " ";
    private String function = " ";
    private String dbMethod = " ";
    private String purpose = " ";
    private String data = " "; 

    public SocketSendData(String ID, String userName) {
        this.ID = ID;
        this.userName = userName;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    
    public void setFunction(String function) {
        this.function = function;
    }

    public void setDbMethod(String dbMethod) {
        this.dbMethod = dbMethod;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getID() {
        return ID;
    }
    
    @Override
    public String toString(){
        StringJoiner stringjoin = new StringJoiner("@");  
        stringjoin.add(authority).add(ID).add(userName).add(function).add(dbMethod).add(purpose).add(data);
        return stringjoin.toString();
    }
}
