/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Community;

import UserManagement.UserInformation;

/**
 *
 * @author coqls
 */
public class ModifyComment implements ModifyInterface {

    private final Comment c;
    private UserInformation ui;

    public ModifyComment(Comment c, UserInformation ui) {
        this.c = c;
        this.ui = ui;
    }

    @Override
    public void modify() {
        DeleteComment d = new DeleteComment(Integer.toString(c.getCommentNumber()), ui);
        d.delete();
        AddComment a = new AddComment(c);
        a.add();
    }

}
