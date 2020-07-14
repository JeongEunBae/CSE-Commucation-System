/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE_Client;

import ChatClient.InputThread;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class ClientSocket {

    private Socket socket = null;
    private BufferedReader br = null;
    private PrintWriter pw = null;
    private boolean endflag = false;
    private SocketSendData socketsenddata;

    public boolean createThreadReturnBool(SocketSendData socketsenddata) {
        ClientReceiveThread clientreceivethread = new ClientReceiveThread(socket, br);

        ClientSendThread clientsendthread = new ClientSendThread(socket, pw);
        clientsendthread.setSocketsenddata(socketsenddata);

        clientreceivethread.start();
        clientsendthread.start();

        return clientreceivethread.getSocketreceivedata().makeBool();
    }

    public Vector createThreadReturnVector(SocketSendData socketsenddata) {
        ClientReceiveThread clientreceivethread = new ClientReceiveThread(socket, br);

        ClientSendThread clientsendthread = new ClientSendThread(socket, pw);
        clientsendthread.setSocketsenddata(socketsenddata);

        clientreceivethread.start();
        clientsendthread.start();

        return clientreceivethread.getSocketreceivedata().makeVec();
    }

    public String createThreadReturnString(SocketSendData socketsenddata) {
        System.out.println("createThreadReturnString 호출 = " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
        ClientReceiveThread clientreceivethread = new ClientReceiveThread(socket, br);

        ClientSendThread clientsendthread = new ClientSendThread(socket, pw);
        clientsendthread.setSocketsenddata(socketsenddata);

        String result = " ";
        try {
            clientreceivethread.start();
            clientsendthread.start();
            Thread.sleep(3000);

            result = clientreceivethread.getSocketreceivedata().makeString();
            
            //Thread.sleep(2000);
        } catch (Exception e) {
        }
        System.out.println("createThreadReturnString 리턴 직전 = " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
        return result;
    }

    public ClientSocket() {
        try {
            socket = new Socket("172.20.10.2", 8889);//아아디,포트
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("클라이언트 접속 종료");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null) {
                    //pw.close();
                }
                if (br != null) {
                    //br.close();
                }
                if (socket != null) {
                    //socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
