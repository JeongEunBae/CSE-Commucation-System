/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Community;

import DBServer.CommentDelete;
import UserManagement.UserInformation;

/**
 *
 * @author coqls
 */
public class DeleteComment implements DeleteInterface {
    
    private final String index;
    private final UserInformation ui;

    public DeleteComment(String index, UserInformation ui) {
        this.index = index;
        this.ui = ui;
    }
    
    @Override
    public void delete() {
        CommentDelete cd = new CommentDelete(index, ui.getUserName(), ui.getAuthority());
        cd.informationDelete();
    }
    
}
