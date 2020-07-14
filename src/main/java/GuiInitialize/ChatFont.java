/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiInitialize;

import javax.swing.JTextField;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class ChatFont {

    private FontState fontState;

    public ChatFont(FontState fontState) {
        this.fontState = fontState;
    }

    public void setFontState(FontState fontState) {
        this.fontState = fontState;
    }

    public void SetFont(JTextField jta, String baseStr) {
        fontState.setFont(jta, baseStr);
    }

}
