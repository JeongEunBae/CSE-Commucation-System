package GuiInitialize;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.JTableHeader;


/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class ComponentsInit {
    public int s;
    public static void TextAreaGained(JTextArea jta, String baseStr) {
        if (jta.getText().trim().equals(baseStr.trim())) {
            jta.setFont(new java.awt.Font("맑은 고딕", 0, 12));
            jta.setForeground(new Color(0, 0, 0));
            jta.setText("");
        }
    }

    public static void TextAreaLost(JTextArea jta, String baseStr) {
        String text = jta.getText();

        if (("".equals(text.trim()))) {
            jta.setFont(new java.awt.Font("Dialog", 1, 14));
            jta.setForeground(new Color(204, 204, 204));
            jta.setText(baseStr);
        }
    }

    public static void TextFieldGained(JTextField jtf, String baseStr) {
        if (jtf.getText().trim().equals(baseStr.trim())) {
            jtf.setFont(new java.awt.Font("맑은 고딕", 0, 12));
            jtf.setForeground(new Color(0, 0, 0));
            jtf.setText("");
        }
    }

    public static void TextFieldLost(JTextField jtf, String baseStr) {
        String text = jtf.getText();

        if (("".equals(text.trim()))) {
            jtf.setFont(new java.awt.Font("Dialog", 1, 14));
            jtf.setForeground(new Color(204, 204, 204));
            jtf.setText(baseStr);
        }
    }

    public static void TextFieldGained(JLabel jlb, JTextField jtf, String baseStr) {
        
        if (jtf.getText().trim().equals(baseStr.trim())) {
//            jlb.setFont(new java.awt.Font("맑은 고딕", 0, 12));
//            jlb.setForeground(new Color(0, 0, 0));
//            jlb.setText("");
            jlb.setVisible(false);
            jlb.setEnabled(false);
        }
    }

    public static void TextFieldLost(JLabel jlb,JTextField jtf, String baseStr) {
        String text = jtf.getText();

        if (("".equals(text.trim()))) {
//            jlb.setFont(new java.awt.Font("Dialog", 1, 14));
//            jlb.setForeground(new Color(204, 204, 204));
//            jlb.setText(baseStr);
            jlb.setVisible(true);
            jlb.setEnabled(true);
        }
    }

    public static void ScrollPaneMouseWheelMovedEvt(JScrollPane jscroll, java.awt.event.MouseWheelEvent evt) {
        int scrollSize = 20;
        if (evt.getUnitsToScroll() > 0) {
            jscroll.getVerticalScrollBar().setValue(jscroll.getVerticalScrollBar().getValue() + scrollSize); // 각 행의 Height 만큼씩 Scroll이 움직인다.
            //TableRowHeight 자리에 원하는 숫자를 넣어 스크롤 속도를 조절할 수 있다.
        } else {
            jscroll.getVerticalScrollBar().setValue(jscroll.getVerticalScrollBar().getValue() - scrollSize);
        }
    }

    public static void TableMouseWheelMovedEvt(JScrollPane jscroll, JTable table, java.awt.event.MouseWheelEvent evt) {
        int TableRowHeight = table.getRowHeight();
        if (evt.getUnitsToScroll() > 0) {
            jscroll.getVerticalScrollBar().setValue(jscroll.getVerticalScrollBar().getValue() + TableRowHeight); // 각 행의 Height 만큼씩 Scroll이 움직인다.
            //TableRowHeight 자리에 원하는 숫자를 넣어 스크롤 속도를 조절할 수 있다.
        } else {
            jscroll.getVerticalScrollBar().setValue(jscroll.getVerticalScrollBar().getValue() - TableRowHeight);
        }
    }

    public static void initTable(JTable jtable) {
        jtable.setUI(new BasicTableUI());
        jtable.getTableHeader().setUI(new BasicTableHeaderUI());

        JTableHeader tbh = jtable.getTableHeader();
        tbh.setFont(new Font("Segoe UI", Font.BOLD, 12));
        tbh.setOpaque(false);
        tbh.setBackground(new Color(255, 255, 255));
        tbh.setForeground(new Color(0, 0, 0));
    }
}
