/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE_Client;

import java.io.BufferedReader;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class ClientReceiveThread extends Thread {
    
    private Socket socket = null;
    private BufferedReader br = null;
    private SocketReceiveData socketreceivedata;
    private volatile boolean done = false;
    
    public ClientReceiveThread(Socket socket, BufferedReader br) {
        this.socket = socket;
        this.br = br;
        
    }
    
    public void setSocketreceivedata(SocketReceiveData socketreceivedata) {
        
        this.socketreceivedata = socketreceivedata;
        System.out.println("들어왔냐? " + this.socketreceivedata.getData());
    }
    
    public SocketReceiveData getSocketreceivedata() {
        
        System.out.println("getSocketreceivedata 호출 = " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
        try {
           // Thread.sleep(1000);
        } catch (Exception e) {
        }
        
        System.out.println(socketreceivedata.getData());
        
        System.out.println("getSocketreceivedata 리턴 직전 = " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
        return socketreceivedata;
    }
    
    @Override
    public void run() {
        try {
            String receiveData = null;
            
            if ((receiveData = br.readLine()) != null) {
                this.socketreceivedata = new SocketReceiveData(receiveData);
                
                System.out.println("제대로 들어옴? " + socketreceivedata.getData());
                System.out.println("ReceiveThread set 직전 = " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
                
                setSocketreceivedata(socketreceivedata);
                
                System.out.println("ReceiveThread set 완료 = " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
            }
            if (receiveData == null) {
                System.out.println("시스템 접속에 실패하였습니다.");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /* unlock */
//            done = true;
//            synchronized(this){
//                this.notifyAll();
//            }
            
            try {
                
                if (socket != null) {
                    //socket.close();
                }
                if (br != null) {
                    //br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
