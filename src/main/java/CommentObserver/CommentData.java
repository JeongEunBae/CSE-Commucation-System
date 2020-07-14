/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommentObserver;

import java.util.concurrent.SubmissionPublisher;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author coqls
 */
public class CommentData extends SubmissionPublisher<CommentData.Values> {
    
    private CommentData.Values val = new CommentData.Values(0, 0);
    
    public void setData(int commentNumber, int postNumber){
        this.val.setCommentNumber(commentNumber);
        this.val.setPostNumber(postNumber);
        
        this.submit(val);
        try{
            Thread.sleep(150);
        } catch (InterruptedException ex){
            Logger.getLogger(CommentData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public class Values {

        private int commentNumber;
        private int postNumber;

        public Values(int commentNumber, int postNumber) {
            this.commentNumber = commentNumber;
            this.postNumber = postNumber;
        }
        
        public int getCommentNumber() {
            return commentNumber;
        }

        public int getPostNumber() {
            return postNumber;
        }

        public void setCommentNumber(int commentNumber) {
            this.commentNumber = commentNumber;
        }

        public void setPostNumber(int postNumber) {
            this.postNumber = postNumber;
        }
        
        
    }
}
