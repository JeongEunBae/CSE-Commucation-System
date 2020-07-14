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
public class PostInformationServer {

    private String postNumber;
    private String title;
    private String userName;
    private String ID;
    private String time;
    private String uploadFile;
    private String contents;
    private String keyword;
    private String viewCount;
    private String commentCount;
    private String authority;

    public PostInformationServer(String inputData) {
        String[] data = inputData.split("!");
        
        this.postNumber = data[0];
        this.title = data[1];
        this.userName = data[2];
        this.ID = data[3];
        this.time = data[4];
        this.uploadFile = data[5];
        this.contents = data[6];
        this.keyword = data[7];
        this.viewCount = data[8];
        this.commentCount = data[9];
        this.authority = data[10];
    }
    
    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("!");
        sj.add(postNumber).add(title).add(userName).add(ID).add(time).add(uploadFile).add(contents).add(keyword)
                .add(viewCount).add(commentCount).add(authority);
        
        return sj.toString();
    }
    
}
