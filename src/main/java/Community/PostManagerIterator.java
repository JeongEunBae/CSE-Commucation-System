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
public class PostManagerIterator implements Iterator {

    private PostManager pm;
    private int index;

    public PostManagerIterator(PostManager pm) {
        this.pm = pm;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < pm.getLength();
    }

    @Override
    public Object next() {
        Post post = pm.getPostAt(index);
        index++;
        return post;
    }

}
