/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE_Server;

import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class ServerSocket {
    public static void main(String[] args) {
        try {
            java.net.ServerSocket serversocket = new java.net.ServerSocket(8889);
            HashMap<String, Object> userHashmap = new HashMap<String, Object>();

            System.out.println("------------------------------------------");
            System.out.println("CSE-Communication-System Server 작동합니다.");
            System.out.println("------------------------------------------");

            while (true) {
                System.out.println("사용자 접속을 기다립니다.");

                Socket socket = serversocket.accept();
                ServerThread serverThread = new ServerThread(socket, userHashmap);
                serverThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
