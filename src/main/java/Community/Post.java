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
public class Post {

    private final int postNumber;
    private final String title;
    private final String userName;
    private final String id;
    private final String contents;
    private final String keyword;
    private final String authority;
    private final String uploadFile;
    private final int viewCount;
    private final int commentCount;

    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Date now = new Date();
    private final String time = f.format(now);

    public int getPostNumber() {
        return postNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getUserName() {
        return userName;
    }

    public String getId() {
        return id;
    }

    public String getContents() {
        return contents;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getAuthority() {
        return authority;
    }

    public String getUploadFile() {
        return uploadFile;
    }

    public int getViewCount() {
        return viewCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public static class Builder {

        //필수
        private final int postNumber;
        private final String title;
        private final String userName;
        private final String id;
        private final String contents;
        private final String keyword;
        private final String authority;
        //선택
        private String uploadFile = "Files";
        private int viewCount = 0;
        private int commentCount = 0;

        public Builder(int postNumber, String title, String userName, String id, String contents, String keyword, String authority) {
            this.postNumber = postNumber;
            this.title = title;
            this.userName = userName;
            this.id = id;
            this.contents = contents;
            this.keyword = keyword;
            this.authority = authority;
        }

        public Builder uploadFile(String val) {
            uploadFile = val;
            return this;
        }

        public Builder viewCount(int val) {
            viewCount = val;
            return this;
        }

        public Builder commentCount(int val) {
            commentCount = val;
            return this;
        }
        
        public Post build(){
            return new Post(this);
        }
    }

    private Post(Builder builder) {
        // 필수 속성
        postNumber = builder.postNumber;
        title = builder.title;
        userName = builder.userName;
        id = builder.id;
        keyword = builder.keyword;
        contents = builder.contents;
        authority = builder.authority;
        // 선택 속성
        uploadFile = builder.uploadFile;
        viewCount = builder.viewCount;
        commentCount = builder.commentCount;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\",\"", "\"", "\"");
        sj.add(postNumber + "").add(title).add(userName).add(id).add(time).add(uploadFile).add(contents).add(keyword).add(viewCount + "").add(commentCount + "").add(authority);
        //postNumber, file, contents, keyword, commentNumber, CommentCount 추가 필요
        return sj.toString();
    }

}
