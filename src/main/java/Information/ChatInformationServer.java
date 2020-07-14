/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Information;

import java.util.StringJoiner;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class ChatInformationServer {

    private String chatRoomNumber;
    private String chatRoomName;
    private String chatIntroduce;
    private String creationTime; //LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    private String chatManager;
    private String currentPeopleNumber;
    private String peopleNumber;
    private String property;
    private String roomPassword;

    public ChatInformationServer(String inputData) {
        String[] data = inputData.split("!");

        this.chatRoomNumber = data[0];
        this.chatRoomName = data[1];
        this.chatIntroduce = data[2];
        this.creationTime = data[3];
        this.chatManager = data[4];
        this.currentPeopleNumber = data[5];
        this.peopleNumber = data[6];
        this.property = data[7];
        this.roomPassword = data[8];
    }
    
    @Override
    public String toString(){
        StringJoiner sj = new StringJoiner("\",\"", "\"", "\"");
        sj.add(chatRoomNumber).add(chatRoomName).add(chatIntroduce).add(creationTime).add(chatManager)
                .add(currentPeopleNumber).add(peopleNumber).add(property).add(roomPassword);
        
        
        return sj.toString();
    }
}
