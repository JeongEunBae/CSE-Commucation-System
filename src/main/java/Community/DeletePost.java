/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Community;

import DBServer.PostDelete;

/**
 *
 * @author coqls
 */
public class DeletePost implements DeleteInterface {

    private final String index;
    private final String id;
    private final String authority;

    public DeletePost(String index, String id, String authority) {
        this.index = index;
        this.id = id;
        this.authority = authority;
    }

    @Override
    public void delete() {
        PostDelete pd = new PostDelete(index, id, authority);
        pd.informationDelete();
    }
}
