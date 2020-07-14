/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Community;

import UserManagement.UserInformation;
import java.util.Vector;

/**
 *
 * @author coqls
 */
public class CommentManager implements Aggregate {

    private UserInformation ui;
    private final Vector<Comment> comments = new Vector<>();

    public CommentManager(UserInformation ui) {
        this.ui = ui;
    }
    
    public void add(Comment c){
        AddComment a = new AddComment(c);
        a.add();
        comments.add(c);
    }
    
    public void delete(String index){
        DeleteComment d = new DeleteComment(index, ui);
        d.delete();
    }
    
    public void modify(Comment c){
        int idx = 0;
        ModifyComment m = new ModifyComment(c, ui);
        m.modify();
        
        Iterator it = iterator();
        while(it.hasNext()){
            Comment comment = (Comment)it.next();
            if(comment.getCommentNumber() == c.getCommentNumber())  comments.set(idx, c);
            idx++;
        }
    }
    
    public Vector<Comment> getComments(){
        if(!comments.isEmpty()) return comments;
        else return null;
    }    
    
    public Comment getCommentAt(int index) {
        return comments.get(index);
    }

    public int getLength() {
        return comments.size();
    }

    @Override
    public Iterator iterator() {
        return new CommentManagerIterator(this);
    }

}
