/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Community;

import java.util.Vector;
import UserManagement.UserInformation;

/**
 *
 * @author coqls
 */
public class PostManager implements Aggregate {

    private UserInformation ui;
    private final Vector<Post> posts = new Vector<>();

    public PostManager(UserInformation ui) {
        this.ui = ui;
    }

    public void add(Post p) {
        AddPost a = new AddPost(p);
        a.add();
        posts.add(p);
    }

    public void delete(String index) {
        DeletePost d = new DeletePost(index, ui.getId(), ui.getAuthority());
        d.delete();
        if (!posts.remove(getPostAt(Integer.parseInt(index)))) {
            System.out.println("Can't Remove");
        }
    }

    public void modify(Post p) {
        int idx = 0;
        ModifyPost m = new ModifyPost(p);
        m.modify();

        Iterator it = iterator();
        while (it.hasNext()) {
            Post post = (Post) it.next();
            if (post.getPostNumber() == post.getPostNumber()) {
                posts.set(idx, p);
            }
            idx++;
        }
    }

    public Vector<Post> search(int index, String keyword) {
        SearchPost s = new SearchPost(index, keyword);
        if (!s.search().isEmpty()) {
            return s.search();
        } else {
            return null;
        }
    }

    public Vector<Post> getPosts(){
        if(!posts.isEmpty())    return posts;
        else    return null;
    }
    
    public Post getPostAt(int index) {
        return posts.get(index);
    }

    public int getLength() {
        return posts.size();
    }

    @Override
    public Iterator iterator() {
        return new PostManagerIterator(this);
    }

}
