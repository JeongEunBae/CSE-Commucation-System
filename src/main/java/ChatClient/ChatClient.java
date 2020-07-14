/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class ChatClient {

    /**
     * @param args the command line arguments
     */
    private ChatSocketData chatsocketdata;
    Socket sock = null;
    BufferedReader br = null;
    PrintWriter pw = null;
    boolean endflag = false;

    public ChatClient(String ID, JTextArea chatField) {
        try {
            sock = new Socket("172.20.10.2", 8890);//아아디,포트
            pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            pw.println(ID);
            pw.flush();

            InputThread it = new InputThread(sock, br, chatField);
            it.start();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendData(ChatSocketData chatsocketdata) {
        try{
            String line = null;
            line = new ClientProxy(chatsocketdata).SendData();
            
            while( line != null) {
                pw.println(line);
                pw.flush();
                if(line.equals("QUIT")) {
                    endflag = true;
                    break;
                }
            }
            System.out.println("클라이언트 접속 종료");
        }catch(Exception e) {
        e.printStackTrace();
        }finally {
            try {
                if(pw != null) {
                    pw.close();
                }
                if(br != null) {
                    br.close();
                }
                if(sock != null) {
                    sock.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


