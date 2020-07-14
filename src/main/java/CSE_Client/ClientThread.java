/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE_Client;

import java.io.BufferedReader;
import java.net.Socket;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class ClientThread extends Thread {

    private Socket socket = null;
    private BufferedReader br = null;
    private SocketSendData socketsenddata;

    public ClientThread(Socket socket, BufferedReader br) {
        this.socket = socket;
        this.br = br;
    }

    public void setSocketsenddata(SocketSendData socketsenddata) {
        this.socketsenddata = socketsenddata;
    }

    @Override
    public void run() {
        try {
            String line = socketsenddata.toString();
            while(line!= null) {System.out.println(line);}

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
