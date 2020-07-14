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
public class TestDriver {
    
    public static void main(String[] args) {
        
        new Thread(() -> {
            ClientSocket clientsocket = ClientSocketRef.getInstance();
            System.out.println("싱글턴 객체1 정보 : " + clientsocket);
        }).start();
        
        try{
            Thread.sleep(500);
        }catch(InterruptedException ex) {
            System.err.println(ex);
        }
        
        new Thread(() -> {
            ClientSocket clientsocket = ClientSocketRef.getInstance();
            System.out.println("싱글턴 객체2 정보 : " + clientsocket);
        }).start();        
    }
}
