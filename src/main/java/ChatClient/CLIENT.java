/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatClient;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
 
class ClientReader extends Thread {
    Socket clientSocket;
    ChatSocketData chatsocketdata;
 
    ClientReader(Socket clientSocket, ChatSocketData chatsocketdata) {
        this.clientSocket = clientSocket;
        this.chatsocketdata = chatsocketdata;
    }
 
    @Override
    public void run() {
        try {
            //InputStream inputStream = clientSocket.getInputStream(); // 여기서 받아오겠네 
//            String senddata = "hi hello";
//            InputStream inputStream = new ByteArrayInputStream(senddata.getBytes());
           // byte[] byte = senddata.getBytes();
            String inputData = new ClientProxy(chatsocketdata).SendData();
            
            InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
            byte[] byteArray = new byte[256];
            while (true) {
                int size = inputStream.read(byteArray); // 받은 내용의 크기만큼 
                String readMessage = new String(byteArray, 0, size, "UTF-8"); 
                System.out.println(" > " + readMessage); // 출력 
            }
        } catch (Exception e) {}
    }
}//
 
public class CLIENT {
    ChatSocketData chatsocketdata;
    public CLIENT() {   
        System.out.println("-Client2 시작");
        
        try {
            Socket clientSocket = null; // 클라이언트 소켓을 만든다.
//            Scanner input = new Scanner(System.in); 
//            System.out.print("-접속 하시겠습니까? : "); // 접속하시겠습니까?
//            int temp= input.nextInt(); 
            
            clientSocket = new Socket(); // 접속 시키고
            clientSocket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8890));
            System.out.print("-접속 성공"); // 접속
            
            
            while (true) {  // 내 소켓 주소를 가진 스레드 실행 
                this.chatsocketdata = new ChatSocketData();
                ClientReader clientReader = new ClientReader(clientSocket, chatsocketdata);
                clientReader.start();
                
                String sendMessage = input.nextLine(); 
                byte[] byteArray = sendMessage.getBytes("UTF-8"); // 내꺼에 출력하면 서버에 보냄 
                OutputStream outputStream = clientSocket.getOutputStream();
                outputStream.write(byteArray);
            }
        } catch (Exception e) {
        }
        System.out.println("-Client2 종료");
    }//
}
