/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Information;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;

/**
 *
 * @author Administrator
 */
public class Comment {

    private String commentNumber;
    private String commentWriter;
    private String contents;
    private String creationTime;
    private String postNumber;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Date now = new Date();

    public Comment(String inputData) {
        String[] data = inputData.split("!");
        
        this.commentNumber = data[0];
        this.commentWriter = data[1];
        this.contents = data[2];
        this.creationTime = data[3];
        this.postNumber = data[4];
    }

    @Override
    public String toString() {
        StringJoiner stringjoin = new StringJoiner("\",\"", "\"", "\"");
        stringjoin.add(commentNumber).add(commentWriter).add(contents).add(creationTime).add(postNumber);
        
        return stringjoin.toString();
    }
}
