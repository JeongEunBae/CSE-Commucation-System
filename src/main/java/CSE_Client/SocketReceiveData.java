/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE_Client;

import java.util.Vector;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class SocketReceiveData {
    private String authority;
    private String ID;
    private String userName;
    private String dataType;
    private String data;
    
    public SocketReceiveData(String sendData) {
        String[] splitData = sendData.split("@");
        
        this.authority = splitData[0];
        this.ID = splitData[1];
        this.userName = splitData[2];
        this.dataType = splitData[3];
        this.data = splitData[4];
    }
    
    public String getData() {
        return data;
    }

    public String getDataType() {
        return dataType;
    }
    
    
    public Vector makeVec() {
        Vector<String> vec = new Vector<>();
        
        String[] splitdata = data.split("!");
        for (String sd : splitdata) {
            vec.add(sd);
        }
        return vec;
    }
    
    public String  makeString() {
        return this.data;
    }
    
    public boolean  makeBool() {
        if(this.data.equals("true")) return true;
        else return false;
    }
}
