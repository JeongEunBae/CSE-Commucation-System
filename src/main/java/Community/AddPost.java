/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Community;

import DBServer.PostInsert;

/**
 *
 * @author coqls
 */
public class AddPost implements AddInterface {
    
    private final Post p;
    
    public AddPost(Post p) {
        this.p = p;
    }

    @Override
    public void add() {
        PostInsert pi = new PostInsert(p);
        pi.informationInsert();
    }
}
