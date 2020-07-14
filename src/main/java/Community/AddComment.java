/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Community;

import DBServer.CommentInsert;

/**
 *
 * @author coqls
 */
public class AddComment implements AddInterface {
    
    private final Comment c;
    
    public AddComment(Comment c){
        this.c = c;
    }
    
    @Override
    public void add() {
        CommentInsert ci = new CommentInsert(c);
        ci.informationInsert();
    }   
}
