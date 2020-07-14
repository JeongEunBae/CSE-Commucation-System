/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManagement;

import java.util.StringJoiner;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class UserInformation {
    //필수
    private final String id;
    private final String pw;
    private final String userName;
    private final String studentNumber;
    private final String major;
    private final String grade;
    private final String confirmQuestion;
    private final String confirmCode;
    //선택
    private final String phoneNumber;
    private final String email;
    private final String scrabPost;
    private final String authority;

    public String getID() {
        return id;
    }

    public String getPW() {
        return pw;
    }

    public String getUserName() {
        return userName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getMajor() {
        return major;
    }

    public String getGrade() {
        return grade;
    }

    public String getConfirmQuestion() {
        return confirmQuestion;
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getScrabPost() {
        return scrabPost;
    }

    public String getAuthority() {
        return authority;
    }

    public static class Builder {
        //필수

        private final String id;
        private final String pw;
        private final String userName;
        private final String studentNumber;
        private final String major;
        private final String grade;
        private final String confirmQuestion;
        private final String confirmCode;
        //선택
        private String phoneNumber = "PHONENUMBER";
        private String email = "EMAIL";
        private String scrabPost = "SCRABPOST";
        private String authority = "USER";

        public Builder(String id, String pw, String userName, String studentNumber, String major, String grade, String confirmQuestion, String confirmCode) {

            this.id = id;
            this.pw = pw;
            this.userName = userName;
            this.studentNumber = studentNumber;
            this.major = major;
            this.grade = grade;
            this.confirmQuestion = confirmQuestion;
            this.confirmCode = confirmCode;
        }

        public Builder phoneNumber(String var) {
            phoneNumber = var;
            return this;
        }

        public Builder email(String var) {
            email = var;
            return this;
        }

        public Builder ScrabPost(String var) {
            scrabPost = var;
            return this;
        }

        public Builder authority(String var) {
            authority = var;
            return this;
        }

        public UserInformation build() {
            return new UserInformation(this);
        }

    }

    public UserInformation(Builder builder) {
        //필수
        id = builder.id;
        pw = builder.pw;
        userName = builder.userName;
        studentNumber = builder.studentNumber;

        major = builder.major;
        grade = builder.grade;
        confirmQuestion = builder.confirmQuestion;
        confirmCode = builder.confirmCode;
        //선택
        phoneNumber = builder.phoneNumber;
        email = builder.email;
        scrabPost = builder.scrabPost;
        authority = builder.authority;
    }

    @Override
    public String toString() {
        StringJoiner StringJoin = new StringJoiner("\",\"", "\"", "\"");
        StringJoin.add(id).add(pw).add(userName).add(studentNumber).add(major).add(grade).add(phoneNumber).add(email).add(scrabPost).
                add(confirmQuestion).add(confirmCode).add(authority);

        return StringJoin.toString();
    }
}
