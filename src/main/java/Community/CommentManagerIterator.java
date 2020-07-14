/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Community;

/**
 *
 * @author coqls
 */
public class CommentManagerIterator implements Iterator{

    private CommentManager cm;
    private int index;
    
    public CommentManagerIterator(CommentManager cm){
        this.cm = cm;
        this.index = 0;
    }
    
    @Override
    public boolean hasNext() {
        return index < cm.getLength();
    }

    @Override
    public Object next() {
        Comment comment = cm.getCommentAt(index);
        index++;
        return comment;
    }
    
}
