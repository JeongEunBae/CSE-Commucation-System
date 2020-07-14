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
public class ModifyPost implements ModifyInterface {
    private final Post p;

    public ModifyPost(Post p) {
        this.p = p;
    }

    @Override
    public void modify() {
        DeletePost dp = new DeletePost(Integer.toString(p.getPostNumber()), p.getId(), p.getAuthority());
        dp.delete();
        AddPost ap = new AddPost(p);
        ap.add();
    }
    
}
