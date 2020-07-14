/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE_Server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class ServerThread extends Thread {

    private Socket socket;
    private String inputData;
    private BufferedReader br;
    private HashMap<String, Object> userHashmap;
    private SocketReceiveData socketreceivedata;
    private boolean initFlag = false;
    private boolean endFlag = false;

    public ServerThread(Socket socket, HashMap<String, Object> userHashmap) {
        this.socket = socket;
        this.userHashmap = userHashmap;
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            inputData = br.readLine();
            System.out.println("inputData = " + inputData);
            this.socketreceivedata = new SocketReceiveData(inputData);

            System.out.println(socketreceivedata.getID() + "님이 로그인하셨습니다.");
            synchronized (userHashmap) {
                userHashmap.put(this.socketreceivedata.getID(), pw);
            }

            initFlag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            if(initFlag) inputData = br.readLine();
            
            while (inputData != null) {
                if(inputData.equals("QUIT")) {
                    endFlag = true;
                    //break;
                }
                else {
                    this.socketreceivedata = new SocketReceiveData(inputData);
                    sendmsg(this.socketreceivedata);
                    inputData = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            synchronized (userHashmap) {
                if(initFlag) userHashmap.remove(socketreceivedata.getID());
            }
            try {
                if (socket != null && endFlag == true) {
                    System.out.println(socketreceivedata.getID() + "님이 로그아웃하셨습니다.");
                    socket.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void sendmsg(SocketReceiveData socketreceivedata) throws FileNotFoundException, IOException {
        String function = socketreceivedata.getFunction();
        if (function.equals("DB")) {            
            String result = new DBManage(socketreceivedata).excuteDB();

//            int start = result.indexOf(" ") + 1;
//            int end = result.indexOf(" ", start);
//            if (end != -1) {
//                String to = result.substring(start, end);
//                String msg2 = result.substring(end + 1);
//                Object obj = userHashmap.get(to);
//                if (obj != null) {
//                    PrintWriter pw = (PrintWriter) obj;
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
                    pw.println(result);
                    System.out.println("result = " + result);
                    pw.flush();
               // }

            } else if (function.equals("CHAT")) {
                // new ChatManage(socketreceivedata);
            }
        }
    //}
}
