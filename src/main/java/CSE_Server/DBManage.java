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
public final class DBManage extends ServerManage{
    private SocketSendData socketsenddata;
    
    public DBManage(SocketReceiveData socketreceivedata) {
        super(socketreceivedata);
    }
       
    public String excuteDB() {
       String function = socketreceivedata.getDbMethod();
       socketsenddata = new SocketSendData(socketreceivedata.getAuthority(), socketreceivedata.getID(), socketreceivedata.getUserName());
       
       if(function.equals("INSERT")) {
           socketsenddata.setDataType("BOOLEAN");
           socketsenddata.setData(new InsertDB(socketreceivedata.getPurpose(), socketreceivedata.getData()).insertMethod());
       }
       else if(function.equals("SEARCH")) {
           socketsenddata.setDataType("VECTOR");
           socketsenddata.setData(new SearchDB(socketreceivedata.getPurpose(), socketreceivedata.getData()).searchMethod());
       }
       else if(function.equals("DELETE")) {
           socketsenddata.setDataType("BOOLEAN");
           socketsenddata.setData(new DeleteDB(socketreceivedata.getPurpose(), socketreceivedata.getAuthority(), socketreceivedata.getID(), socketreceivedata.getData()).deleteMethod());
       }
       else {
           socketsenddata.setDataType("STRING");
           socketsenddata.setData(new OtherDB(function, socketreceivedata.getPurpose(), socketreceivedata.getData()).otherMethod());
       }
       
       return socketsenddata.toString();
    }
  
}
