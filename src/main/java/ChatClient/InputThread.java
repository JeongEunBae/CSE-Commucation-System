/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatClient;

import java.io.BufferedReader;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class InputThread extends Thread{
    private Socket sock = null;
    private BufferedReader br = null;
    JTextArea chatArea;
    public InputThread(Socket sock,BufferedReader br, JTextArea chatArea) {
        this.sock = sock;
        this.br = br;
        this.chatArea = chatArea;
    }
    @Override
    public void run() {
        try {
            String line = null;
            while((line = br.readLine()) != null) {
                System.out.println(line);
                chatArea.setText(chatArea.getText() + "\n" + line);
                ClientProxy clientproxy = new ClientProxy();
                clientproxy.ReceiveData(line);
                //System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
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
