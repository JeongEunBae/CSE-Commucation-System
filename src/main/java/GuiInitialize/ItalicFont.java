/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiInitialize;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class ItalicFont implements FontState {
    
    public void setFont(JTextField jta, String baseStr) {

        if (jta.getText().trim().equals(baseStr.trim())) {
            jta.setFont(new java.awt.Font("맑은 고딕", Font.ITALIC, 12));
            jta.setForeground(new Color(0, 0, 0));
            jta.setText(baseStr);
        }
    }
}
