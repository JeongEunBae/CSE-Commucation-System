/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiInitialize;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class CustomCellRenderer extends DefaultTableCellRenderer {

    private JTextArea textArea;
    private JScrollPane scrollPane;

    public CustomCellRenderer(JScrollPane scrollPane) {
        super();
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        this.scrollPane = scrollPane;
    }

    public CustomCellRenderer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel)value;
        
        if (label.getText() != null) //셀 안에 내용이 있다면 텍스트 에리어 추가
        {
            textArea.setText(value.toString());
        }

        return scrollPane; //내용이 칸을 넘어간다면 스크롤 
    }
}
