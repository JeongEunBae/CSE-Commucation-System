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
public class UserInformationServer {
    private String id;
    private String pw;
    private String userName;
    private String studentNumber;
    private String major;
    private String grade;
    private String phoneNumber;
    private String email;
    private String scrabPost="";
    private String confirmQuestion;
    private String confirmCode;
    private String authority;
    
    public UserInformationServer(String inputData) {
    String[] data = inputData.split("!");
    
    this.id = data[0];
    this.pw = data[1];
    this.userName = data[2];
    this.studentNumber = data[3];
    this.major = data[4];
    this.grade = data[5];
    this.phoneNumber = data[6];
    this.email = data[7];
    this.scrabPost = data[8];
    this.confirmQuestion = data[9];
    this.confirmCode = data[10];
    this.authority = data[11];
    }

    public String getID() {
        return id;
    }

    public String getPW() {
        return pw;
    }

    public String getUserName() {
        return userName;
    }
    
    @Override
    public String toString() {
        StringJoiner StringJoin = new StringJoiner("\",\"", "\"", "\"");
        StringJoin.add(id).add(pw).add(userName).add(studentNumber).add(major).add(grade).add(phoneNumber).add(email).
                add(scrabPost).add(confirmQuestion).add(confirmCode).add(authority);

        return StringJoin.toString();
    }
}
