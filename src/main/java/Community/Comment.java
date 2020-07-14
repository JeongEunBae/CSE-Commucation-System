/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Community;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;

/**
 *
 * @author Administrator
 */
public class Comment {

    private int commentNumber;
    private String commentWriter;
    private String contents;
    private String creationTime;
    private int postNumber;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Date now = new Date();

    public Comment(int commentNumber, String commentWriter, String contents, int postNumber) {
        this.commentNumber = commentNumber;
        this.commentWriter = commentWriter;
        this.contents = contents;
        this.creationTime = format.format(now);
        this.postNumber = postNumber;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\",\"", "\"", "\"");
        sj.add(commentNumber + "").add(commentWriter).add(contents).add(postNumber + "").add(creationTime);
        //postNumber, file, contents, keyword, commentNumber, CommentCount 추가 필요
        return sj.toString();
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public String getCommentWriter() {
        return commentWriter;
    }

    public String getContents() {
        return contents;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public int getPostNumber() {
        return postNumber;
    }

}
