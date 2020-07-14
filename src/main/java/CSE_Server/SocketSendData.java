/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE_Server;

import java.util.StringJoiner;
import java.util.Vector;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */

public class SocketSendData {
    private String authority;
    private String ID;
    private String userName;
    private String dataType;
    private String data;

    public SocketSendData(String authority, String ID, String userName) {
        this.ID = ID;
        this.userName = userName;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String setData(Vector inputData) {
        StringJoiner StringJoin = new StringJoiner("!");
        
        for(int i=0;i<inputData.size();i++) {
            StringJoin.add((CharSequence) inputData.get(i));
        }
        
        return StringJoin.toString();
    }
    
    public void setData(boolean inputData) {
        if(inputData) this.data = "true";
        else this.data = "false";
    }
    
    public void setData(String inputData) {
        this.data=inputData;
    }
    
    @Override
    public String toString() {
        StringJoiner StringJoin = new StringJoiner("@");
        StringJoin.add(authority).add(ID).add(userName).add(dataType).add(data);
        
        return StringJoin.toString();
    }
   
}
