/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatClient;


/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class ChatProxy implements ChatSocket {
    private ChatSocketData chatsoketdata;
    private ChatSocket ChatSocket;

    public ChatProxy() {
    }
    
     
    public ChatProxy(ChatSocketData chatsoketdata) {
        this.chatsoketdata = chatsoketdata;
    }
        
    @Override
    public String SendData() {
        if(ChatSocket == null) ChatSocket = new Chat(chatsoketdata);
        return ChatSocket.SendData();
    }
    
//    @Override
//    public void ReceiveData(String inputData) {
//        ChatSocket.ReceiveData(inputData);
//    }
}
