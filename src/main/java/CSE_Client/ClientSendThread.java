/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE_Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class ClientSendThread extends Thread{
    private Socket socket = null;
    private SocketSendData socketsenddata;
    private PrintWriter pw;
    
    public ClientSendThread(Socket socket, PrintWriter pw) {
        this.socket = socket;
        this.pw = pw;
    }

    public void setSocketsenddata(SocketSendData socketsenddata) {
        this.socketsenddata = socketsenddata;
    }
    
    @Override
    public void run() {
        try{
           String sendData;
     
                sendData  = socketsenddata.toString();
                pw.println(sendData);
                pw.flush();

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    //socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
