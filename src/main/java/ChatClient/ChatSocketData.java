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
public class ChatSocketData {
    private String ID;
    private String data;
    private String str;

    public ChatSocketData(String Id, String data) {
        this.ID = Id;
        this.data = data;
    }

    public String getID() {
        return ID;
    }
      
   public String SendData() {
       String str = ID + data;
       return str;
   }
   
//   public void ReceiveData(String InputData) {
//       this.str = InputData;
//   }
}
