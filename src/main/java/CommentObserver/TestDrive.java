/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommentObserver;

import Community.Comment;

/**
 *
 * @author coqls
 */
public class TestDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CommentData cd = new CommentData();
        CommentDisplay display = new CommentDisplay();
        
        //int commentNumber, String commentWriter, String contents, int postNumber
        Comment c = new Comment(0, "ME", "CONTENTS", 3);  
        //addComment(c);
        //CommentData cd = new CommentData();
        //CommentDisplay display =;;
        //
        cd.subscribe(display);
        cd.setData(c.getCommentNumber(), c.getPostNumber());
        
        Comment c1 = new Comment(4, "aa", "asdf", 3);        
        cd.setData(c1.getCommentNumber(), c1.getPostNumber());
        
    }
    
}
