/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBServer;

import java.sql.*;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class DBConnector {
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //드라이버
    private final String DB_URL = "jdbc:mysql://113.198.235.240:3192/cse?serverTimezone=Asia/Seoul&useSSL=false"; //접속할 DB 서버

    private final String USER_NAME = "root"; //DB에 접속할 사용자 이름을 상수로 정의
    private final String PASSWORD = "0922"; //사용자의 비밀번호를 상수로 정의

    Connection conn = null;
    Statement state = null;
    
    public DBConnector() { // DB 연동
         try {
             Class.forName(JDBC_DRIVER);
             conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
             state = conn.createStatement();   
             
             String sql = "USE cse";
             ResultSet rs = state.executeQuery(sql);
             
             rs.close();
         }
         catch(Exception e ) {
             e.printStackTrace();
         }
     }
}
