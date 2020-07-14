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
public class ServerManage {
    protected SocketReceiveData socketreceivedata;
            
    public ServerManage( SocketReceiveData socketreceivedata) {
        this.socketreceivedata = socketreceivedata;
    }
}
