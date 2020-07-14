/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatClient;

import java.util.StringJoiner;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class Chat implements ChatSocket {

    private ChatSocketData chatsoketdata;
    
    public Chat(ChatSocketData chatsoketdata) {
        this.chatsoketdata = chatsoketdata;
    }

    @Override
    public String SendData() {
        System.out.println("실제 객체 값 > " + chatsoketdata.SendData());
        return chatsoketdata.SendData();
    }

//    @Override
//    public void ReceiveData(String inputData) {
//        this.chatsoketdata.ReceiveData(inputData);
//    }

}
