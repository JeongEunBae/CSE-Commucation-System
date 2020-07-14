/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CSE_Client.ClientSocket;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class ClientSocketRef {
    
    private static class CreateClientSocket{
        public static final ClientSocket clientsocket = new ClientSocket();
    }
           
    public static ClientSocket getInstance() {
        return CreateClientSocket.clientsocket;
    }
    
}
