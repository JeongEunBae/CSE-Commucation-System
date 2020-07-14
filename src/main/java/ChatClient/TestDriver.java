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
public class TestDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ChatSocketData chatsocketdata = new ChatSocketData("배정은", "님이 프록시패턴 테스트중입니다@1.");
        ChatProxy proxy = new ChatProxy(chatsocketdata);

        System.out.println("입력 값 > " + chatsocketdata.SendData());

        System.out.println("프록시 값 > " + proxy.SendData());

    }

}
