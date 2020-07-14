/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBServer.ChatSearch;
import DBServer.PostSearch;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import GuiInitialize.ComponentsInit;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;

/**
 *
 * @author JeongEun Bae <byg0922@naver.com>
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     *
     * @param jtable
     */
    int mousePX;
    int mousePY;
    ComponentsInit componentsInit;
    String userID;
    String userType;
    String keyword;
    DefaultTableModel tableModel;
    DefaultTableModel chatTableModel;

    public static void initializePanel(JPanel panel, boolean type) {
        panel.setVisible(type);
        panel.setEnabled(type);
    }

    public MainPage(String userID, String userType) { // LoginPage 에서 userID 와 userType 을 받아옴
        //String userType = "admin";
        this.userID = userID;
        this.userType = userType;
        initComponents();

        /**
         * Color initialize
         */
        TopPanel.setBackground(new Color(255, 255, 255, 0));
        SearchField.setBackground(new Color(255, 255, 255, 0));

        /*-----------------------------------------------------------------------------------------------*/
        /**
         * Panel initialize
         */
        initializePanel(TopPanel, true);
        initializePanel(BasePanel, true);
        initializePanel(HomePanel, true);

        initializePanel(ChatPanel, false);
        initializePanel(PostPanel, false);
        initializePanel(PostManagePanel, false);
        initializePanel(BoardSelectedPanel, false);
        initializePanel(AdminMenuPanel, false);
        initializePanel(BoardPanel, false);

        if ("admin".equalsIgnoreCase(userType)) { // 메뉴 패널
            UserName.setText(userID + " 관리자님 반갑습니다.");
            initializePanel(AdminBaseMenuPanel, true);
            initializePanel(BaseMenuPanel, false);
        } else if ("user".equalsIgnoreCase(userType)) {
            UserName.setText(userID + " 회원님 반갑습니다.");
            initializePanel(AdminBaseMenuPanel, false);
            initializePanel(BaseMenuPanel, true);
        }

        /*-----------------------------------------------------------------------------------------------*/
        /**
         * Table initialize
         */
        JTable[] table = {jTable1, jTable2, jTable3, jTable4, jTable5, jTable6};

        for (JTable jTable : table) {
            ComponentsInit.initTable(jTable);

        }

        jScrollPane2.getHorizontalScrollBar().setOpaque(false);
        jScrollPane2.getHorizontalScrollBar().setBackground(new Color(255, 255, 255, 1));
        jScrollPane2.setUI(new BasicScrollPaneUI());

        tableModel = (DefaultTableModel) jTable4.getModel();
        chatTableModel = (DefaultTableModel) jTable2.getModel();

        /*-----------------------------------------------------------------------------------------------*/
        /**
         * Componants initialize
         */
        SearchComboBox.setOpaque(false);
        SearchComboBox.setBackground(new Color(255, 255, 255));
        SearchComboBox.setSelectedIndex(2);

        GradeField.setBackground(new Color(255, 255, 255, 0));

        SearchField1.setBackground(new Color(255, 255, 255, 0));
        SearchField2.setBackground(new Color(255, 255, 255, 0));
        SearchField3.setBackground(new Color(255, 255, 255, 0));
        //System.out.println(SearchComboBox.getUI());

        /*-----------------------------------------------------------------------------------------------*/
    }

    public MainPage() { // 기본 생성자 실제 프로그램 실행시에는 사용 x
        String userType = "admin";

        initComponents();

        /**
         * Color initialize
         */
        TopPanel.setBackground(new Color(255, 255, 255, 0));
        SearchField.setBackground(new Color(255, 255, 255, 0));

        /*-----------------------------------------------------------------------------------------------*/
        /**
         * Panel initialize
         */
        initializePanel(TopPanel, true);
        initializePanel(BasePanel, true);
        initializePanel(HomePanel, true);

        initializePanel(ChatPanel, false);
        initializePanel(PostPanel, false);
        initializePanel(PostManagePanel, false);
        initializePanel(BoardSelectedPanel, false);
        initializePanel(AdminMenuPanel, false);
        initializePanel(BoardPanel, false);

        if ("admin".equalsIgnoreCase(userType)) { // 메뉴 패널
            initializePanel(AdminBaseMenuPanel, true);
            initializePanel(BaseMenuPanel, false);
        } else if ("user".equalsIgnoreCase(userType)) {
            initializePanel(AdminBaseMenuPanel, false);
            initializePanel(BaseMenuPanel, true);
        }

        /*-----------------------------------------------------------------------------------------------*/
        /**
         * Table initialize
         */
        JTable[] table = {jTable1, jTable2, jTable3, jTable4, jTable5, jTable6};

        for (JTable jTable : table) {
            ComponentsInit.initTable(jTable);

        }

        jScrollPane2.getHorizontalScrollBar().setOpaque(false);
        jScrollPane2.getHorizontalScrollBar().setBackground(new Color(255, 255, 255, 1));
        jScrollPane2.setUI(new BasicScrollPaneUI());

        tableModel = (DefaultTableModel) jTable4.getModel();
        chatTableModel = (DefaultTableModel) jTable2.getModel();

        /*-----------------------------------------------------------------------------------------------*/
        /**
         * Componants initialize
         */
        SearchComboBox.setOpaque(false);
        SearchComboBox.setBackground(new Color(255, 255, 255));
        SearchComboBox.setSelectedIndex(2);

        GradeField.setBackground(new Color(255, 255, 255, 0));

        SearchField1.setBackground(new Color(255, 255, 255, 0));
        SearchField2.setBackground(new Color(255, 255, 255, 0));
        SearchField3.setBackground(new Color(255, 255, 255, 0));
        //System.out.println(SearchComboBox.getUI());

        /*-----------------------------------------------------------------------------------------------*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChatPanel = new javax.swing.JPanel();
        MakeChat = new javax.swing.JLabel();
        EnterChat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        SearchField = new javax.swing.JTextField();
        SearchLabel = new javax.swing.JLabel();
        SearchComboBox = new javax.swing.JComboBox<>();
        BoardPanel = new javax.swing.JPanel();
        BoardTitle = new javax.swing.JLabel();
        GradeField = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        AddPost = new javax.swing.JLabel();
        SearchField1 = new javax.swing.JTextField();
        SearchLabel1 = new javax.swing.JLabel();
        Refresh = new javax.swing.JLabel();
        PWQuestionField1 = new javax.swing.JComboBox<>();
        HomePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        TopPanel = new javax.swing.JPanel();
        UserName = new javax.swing.JLabel();
        Exit = new javax.swing.JLabel();
        PostPanel = new javax.swing.JPanel();
        PWQuestionField = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        SearchField2 = new javax.swing.JTextField();
        SearchLabel2 = new javax.swing.JLabel();
        PostTitle = new javax.swing.JLabel();
        ModifyPost = new javax.swing.JLabel();
        DeletePost = new javax.swing.JLabel();
        Refresh1 = new javax.swing.JLabel();
        PostManagePanel = new javax.swing.JPanel();
        PostManageTitle = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        SearchField3 = new javax.swing.JTextField();
        SearchLabel3 = new javax.swing.JLabel();
        ManageAdd = new javax.swing.JLabel();
        ManageModify = new javax.swing.JLabel();
        ManageDelete = new javax.swing.JLabel();
        BoardSelectedPanel = new javax.swing.JPanel();
        Board = new javax.swing.JLabel();
        Home = new javax.swing.JLabel();
        Chat = new javax.swing.JLabel();
        BoardSelectPanel = new javax.swing.JPanel();
        Senior = new javax.swing.JLabel();
        Junior = new javax.swing.JLabel();
        Sophomore = new javax.swing.JLabel();
        FreshMan = new javax.swing.JLabel();
        User1 = new javax.swing.JLabel();
        Setting1 = new javax.swing.JLabel();
        Alarm1 = new javax.swing.JLabel();
        MyPost = new javax.swing.JLabel();
        ScrabPost = new javax.swing.JLabel();
        BaseMenuPanel = new javax.swing.JPanel();
        Board1 = new javax.swing.JLabel();
        Home1 = new javax.swing.JLabel();
        Chat1 = new javax.swing.JLabel();
        AdminMenuPanel = new javax.swing.JPanel();
        AdminBoard = new javax.swing.JLabel();
        AdminHome = new javax.swing.JLabel();
        AdminBoardSelectPanel = new javax.swing.JPanel();
        PostManage = new javax.swing.JLabel();
        ReportManage = new javax.swing.JLabel();
        NoticeManage = new javax.swing.JLabel();
        UserMenu1 = new javax.swing.JLabel();
        AdminBaseMenuPanel = new javax.swing.JPanel();
        AdminBoard1 = new javax.swing.JLabel();
        AdminHome1 = new javax.swing.JLabel();
        UserMenu = new javax.swing.JLabel();
        BasePanel = new javax.swing.JPanel();
        User = new javax.swing.JLabel();
        Setting = new javax.swing.JLabel();
        Alarm = new javax.swing.JLabel();
        BackGroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ChatPanel.setBackground(new java.awt.Color(255, 255, 255));
        ChatPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MakeChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/ChatPanelImage/MakeChat.png"))); // NOI18N
        MakeChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MakeChatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MakeChatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MakeChatMouseExited(evt);
            }
        });
        ChatPanel.add(MakeChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 680, 170, 70));

        EnterChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/ChatPanelImage/EnterChat.png"))); // NOI18N
        EnterChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EnterChatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EnterChatMouseExited(evt);
            }
        });
        ChatPanel.add(EnterChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 680, 170, 70));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(138, 190, 255)));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollPane1MouseWheelMoved(evt);
            }
        });

        jTable2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Chatting Bang", "2020-06-16 05:26:00", "BangJang", "3", "private"}
            },
            new String [] {
                "Number", "ChatRoomName", "CreatationTime", "ChatManager", "PeopleNumber", "Property"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(40);
        jTable2.setSelectionBackground(new java.awt.Color(138, 190, 255));
        jTable2.setShowGrid(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        ChatPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 920, 530));

        SearchField.setText("Search...");
        SearchField.setToolTipText("Search...");
        SearchField.setBorder(null);
        SearchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SearchFieldFocusLost(evt);
            }
        });
        SearchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchFieldMouseClicked(evt);
            }
        });
        ChatPanel.add(SearchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 64, 140, 30));

        SearchLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/ChatPanelImage/Search.png"))); // NOI18N
        ChatPanel.add(SearchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, 40));

        SearchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SearchComboBox.setBorder(null);
        ChatPanel.add(SearchComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 70, 90, -1));

        getContentPane().add(ChatPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 1060, 750));

        BoardPanel.setBackground(new java.awt.Color(255, 255, 255));
        BoardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BoardTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BoardIcon/Board.png"))); // NOI18N
        BoardPanel.add(BoardTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 200, 80));

        GradeField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        GradeField.setToolTipText("");
        GradeField.setBorder(null);
        GradeField.setEnabled(false);
        BoardPanel.add(GradeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 64, 130, 20));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(138, 190, 255)));
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane4.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollPane4MouseWheelMoved(evt);
            }
        });

        jTable4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PostNumber", "Title", "Writer", "CreationTime", "ViewCount", "CommentCount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setRowHeight(40);
        jTable4.setSelectionBackground(new java.awt.Color(138, 190, 255));
        jTable4.setShowGrid(false);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setMinWidth(3);
            jTable4.getColumnModel().getColumn(0).setPreferredWidth(3);
        }

        BoardPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 920, 530));

        AddPost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BoardIcon/Add_post.png"))); // NOI18N
        AddPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddPostMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddPostMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddPostMouseExited(evt);
            }
        });
        BoardPanel.add(AddPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 670, 170, 70));

        SearchField1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SearchField1.setForeground(new java.awt.Color(204, 204, 204));
        SearchField1.setText("Search...");
        SearchField1.setToolTipText("Search...");
        SearchField1.setBorder(null);
        SearchField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SearchField1FocusLost(evt);
            }
        });
        SearchField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchField1MouseClicked(evt);
            }
        });
        BoardPanel.add(SearchField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 64, 140, 30));

        SearchLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/ChatPanelImage/Search.png"))); // NOI18N
        BoardPanel.add(SearchLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, 40));

        Refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BoardIcon/icons8_refresh_40px_1.png"))); // NOI18N
        Refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RefreshMouseEntered(evt);
            }
        });
        BoardPanel.add(Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 680, 40, 40));

        PWQuestionField1.setBackground(new java.awt.Color(255, 255, 255,0));
        PWQuestionField1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        PWQuestionField1.setForeground(new java.awt.Color(204, 204, 204));
        PWQuestionField1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Question1", "Question2" }));
        PWQuestionField1.setToolTipText("");
        PWQuestionField1.setBorder(null);
        PWQuestionField1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PWQuestionField1.setOpaque(false);
        PWQuestionField.setForeground(new Color(204,204,204));
        BoardPanel.add(PWQuestionField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 65, 130, 30));

        getContentPane().add(BoardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 1060, 740));

        HomePanel.setBackground(new java.awt.Color(255, 255, 255));
        HomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(138, 190, 255)));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollPane2MouseWheelMoved(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(40);
        jTable1.setSelectionBackground(new java.awt.Color(138, 190, 255));
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(25);
        }

        HomePanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 450, 300));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(138, 190, 255)));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setAutoscrolls(true);
        jScrollPane3.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollPane3MouseWheelMoved(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.setFocusable(false);
        jTable3.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable3.setRowHeight(40);
        jTable3.setSelectionBackground(new java.awt.Color(138, 190, 255));
        jTable3.setShowVerticalLines(false);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(25);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(25);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(25);
            jTable3.getColumnModel().getColumn(3).setPreferredWidth(25);
        }

        HomePanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 940, 260));

        getContentPane().add(HomePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 1060, 750));

        TopPanel.setBackground(new java.awt.Color(255, 255, 255));
        TopPanel.setOpaque(false);
        TopPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                TopPanelMouseDragged(evt);
            }
        });
        TopPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TopPanelMousePressed(evt);
            }
        });
        TopPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserName.setBackground(new java.awt.Color(255, 255, 255));
        UserName.setFont(new java.awt.Font("함초롬돋움", 0, 14)); // NOI18N
        UserName.setForeground(new java.awt.Color(153, 153, 153));
        TopPanel.add(UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 270, 30));

        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/ChatPanelImage/icons8_exit_40px_3.png"))); // NOI18N
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitMouseEntered(evt);
            }
        });
        TopPanel.add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 0, 40, 50));

        getContentPane().add(TopPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 50));

        PostPanel.setBackground(new java.awt.Color(255, 255, 255));
        PostPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PWQuestionField.setBackground(new java.awt.Color(255, 255, 255,0));
        PWQuestionField.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        PWQuestionField.setForeground(new java.awt.Color(204, 204, 204));
        PWQuestionField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Question1", "Question2" }));
        PWQuestionField.setToolTipText("");
        PWQuestionField.setBorder(null);
        PWQuestionField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PWQuestionField.setOpaque(false);
        PWQuestionField.setForeground(new Color(204,204,204));
        PostPanel.add(PWQuestionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 65, 130, 30));

        jScrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(138, 190, 255)));
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane5.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollPane5MouseWheelMoved(evt);
            }
        });

        jTable5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, "", null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setRowHeight(40);
        jTable5.setSelectionBackground(new java.awt.Color(138, 190, 255));
        jTable5.setShowGrid(false);
        jScrollPane5.setViewportView(jTable5);

        PostPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 920, 530));

        SearchField2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SearchField2.setForeground(new java.awt.Color(204, 204, 204));
        SearchField2.setText("Search...");
        SearchField2.setToolTipText("Search...");
        SearchField2.setBorder(null);
        SearchField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SearchField2FocusLost(evt);
            }
        });
        SearchField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchField2MouseClicked(evt);
            }
        });
        PostPanel.add(SearchField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 64, 140, 30));

        SearchLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/ChatPanelImage/Search.png"))); // NOI18N
        PostPanel.add(SearchLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, 40));

        PostTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BoardIcon/MyPost.png"))); // NOI18N
        PostPanel.add(PostTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 510, 90));

        ModifyPost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BoardIcon/Modify_Post.png"))); // NOI18N
        ModifyPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ModifyPostMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ModifyPostMouseExited(evt);
            }
        });
        PostPanel.add(ModifyPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 670, 160, -1));

        DeletePost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BoardIcon/Delete_Post.png"))); // NOI18N
        DeletePost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeletePostMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeletePostMouseExited(evt);
            }
        });
        PostPanel.add(DeletePost, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 670, 160, 70));

        Refresh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BoardIcon/icons8_refresh_40px_1.png"))); // NOI18N
        Refresh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Refresh1MouseEntered(evt);
            }
        });
        PostPanel.add(Refresh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 680, 40, 40));

        getContentPane().add(PostPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 1060, 740));

        PostManagePanel.setBackground(new java.awt.Color(255, 255, 255));
        PostManagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PostManageTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BoardIcon/PostManage.png"))); // NOI18N
        PostManagePanel.add(PostManageTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 510, 90));

        jScrollPane6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(138, 190, 255)));
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane6.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollPane6MouseWheelMoved(evt);
            }
        });

        jTable6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, "", null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.setRowHeight(40);
        jTable6.setSelectionBackground(new java.awt.Color(138, 190, 255));
        jTable6.setShowGrid(false);
        jScrollPane6.setViewportView(jTable6);

        PostManagePanel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 920, 530));

        SearchField3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SearchField3.setForeground(new java.awt.Color(204, 204, 204));
        SearchField3.setText("Search...");
        SearchField3.setToolTipText("Search...");
        SearchField3.setBorder(null);
        SearchField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchField3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SearchField3FocusLost(evt);
            }
        });
        SearchField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchField3MouseClicked(evt);
            }
        });
        PostManagePanel.add(SearchField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 64, 140, 30));

        SearchLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/ChatPanelImage/Search.png"))); // NOI18N
        PostManagePanel.add(SearchLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, 40));

        ManageAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BoardIcon/Add_post.png"))); // NOI18N
        ManageAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ManageAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ManageAddMouseExited(evt);
            }
        });
        PostManagePanel.add(ManageAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 680, 160, 70));

        ManageModify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BoardIcon/Modify_Post.png"))); // NOI18N
        ManageModify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ManageModifyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ManageModifyMouseExited(evt);
            }
        });
        PostManagePanel.add(ManageModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 680, 160, 70));

        ManageDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BoardIcon/Delete_Post.png"))); // NOI18N
        ManageDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ManageDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ManageDeleteMouseExited(evt);
            }
        });
        PostManagePanel.add(ManageDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 680, 160, 70));

        getContentPane().add(PostManagePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 1060, 750));

        BoardSelectedPanel.setBackground(new java.awt.Color(255, 255, 255));
        BoardSelectedPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Board.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/Board.png"))); // NOI18N
        Board.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BoardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BoardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BoardMouseExited(evt);
            }
        });
        BoardSelectedPanel.add(Board, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 60));

        Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/Home.png"))); // NOI18N
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeMouseExited(evt);
            }
        });
        BoardSelectedPanel.add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 60));

        Chat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/Chat.png"))); // NOI18N
        Chat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ChatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ChatMouseExited(evt);
            }
        });
        BoardSelectedPanel.add(Chat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 210, 60));

        BoardSelectPanel.setBackground(new java.awt.Color(255, 255, 255));

        Senior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/Senior.png"))); // NOI18N
        Senior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SeniorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SeniorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SeniorMouseExited(evt);
            }
        });

        Junior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/Junior.png"))); // NOI18N
        Junior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JuniorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JuniorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JuniorMouseExited(evt);
            }
        });

        Sophomore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/Sophomore.png"))); // NOI18N
        Sophomore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SophomoreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SophomoreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SophomoreMouseExited(evt);
            }
        });

        FreshMan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/FreshMan.png"))); // NOI18N
        FreshMan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FreshManMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FreshManMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FreshManMouseExited(evt);
            }
        });

        javax.swing.GroupLayout BoardSelectPanelLayout = new javax.swing.GroupLayout(BoardSelectPanel);
        BoardSelectPanel.setLayout(BoardSelectPanelLayout);
        BoardSelectPanelLayout.setHorizontalGroup(
            BoardSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
            .addGroup(BoardSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BoardSelectPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(BoardSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(FreshMan, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Sophomore, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Junior, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Senior, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        BoardSelectPanelLayout.setVerticalGroup(
            BoardSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
            .addGroup(BoardSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BoardSelectPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(FreshMan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(Sophomore, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(Junior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(Senior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        BoardSelectedPanel.add(BoardSelectPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 210, 140));

        User1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/icons8_customer_40px_2.png"))); // NOI18N
        BoardSelectedPanel.add(User1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, -1, 40));

        Setting1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/icons8_settings_40px_3.png"))); // NOI18N
        BoardSelectedPanel.add(Setting1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, 40, -1));

        Alarm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/icons8_notification_40px_1.png"))); // NOI18N
        BoardSelectedPanel.add(Alarm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 610, 40, 40));

        MyPost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/MyPost.png"))); // NOI18N
        MyPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MyPostMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MyPostMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MyPostMouseExited(evt);
            }
        });
        BoardSelectedPanel.add(MyPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 210, 40));

        ScrabPost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/ScrabPost.png"))); // NOI18N
        ScrabPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScrabPostMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ScrabPostMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ScrabPostMouseExited(evt);
            }
        });
        BoardSelectedPanel.add(ScrabPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 210, 40));

        getContentPane().add(BoardSelectedPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 210, 600));

        BaseMenuPanel.setBackground(new java.awt.Color(255, 255, 255));
        BaseMenuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Board1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/Board.png"))); // NOI18N
        Board1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Board1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Board1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Board1MouseExited(evt);
            }
        });
        BaseMenuPanel.add(Board1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 60));

        Home1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/Home.png"))); // NOI18N
        Home1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Home1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Home1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Home1MouseExited(evt);
            }
        });
        BaseMenuPanel.add(Home1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 60));

        Chat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/Chat.png"))); // NOI18N
        Chat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chat1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Chat1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Chat1MouseExited(evt);
            }
        });
        BaseMenuPanel.add(Chat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, 60));

        getContentPane().add(BaseMenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 210, 600));

        AdminMenuPanel.setBackground(new java.awt.Color(255, 255, 255));
        AdminMenuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AdminBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/Board.png"))); // NOI18N
        AdminBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminBoardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AdminBoardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AdminBoardMouseExited(evt);
            }
        });
        AdminMenuPanel.add(AdminBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, 60));

        AdminHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/Home.png"))); // NOI18N
        AdminHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AdminHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AdminHomeMouseExited(evt);
            }
        });
        AdminMenuPanel.add(AdminHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 60));

        AdminBoardSelectPanel.setBackground(new java.awt.Color(255, 255, 255));
        AdminBoardSelectPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PostManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AdminMainPage/PostManage.png"))); // NOI18N
        PostManage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PostManageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PostManageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PostManageMouseExited(evt);
            }
        });
        AdminBoardSelectPanel.add(PostManage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 45));

        ReportManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AdminMainPage/ReportManage.png"))); // NOI18N
        ReportManage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ReportManageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ReportManageMouseExited(evt);
            }
        });
        AdminBoardSelectPanel.add(ReportManage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 209, 44));

        NoticeManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AdminMainPage/NoticeManage.png"))); // NOI18N
        NoticeManage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NoticeManageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NoticeManageMouseExited(evt);
            }
        });
        AdminBoardSelectPanel.add(NoticeManage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 210, 40));

        AdminMenuPanel.add(AdminBoardSelectPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 210, 260));

        UserMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AdminMainPage/User.png"))); // NOI18N
        UserMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UserMenu1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UserMenu1MouseExited(evt);
            }
        });
        AdminMenuPanel.add(UserMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 60));

        getContentPane().add(AdminMenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 210, 600));

        AdminBaseMenuPanel.setBackground(new java.awt.Color(255, 255, 255));
        AdminBaseMenuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AdminBoard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/Board.png"))); // NOI18N
        AdminBoard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminBoard1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AdminBoard1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AdminBoard1MouseExited(evt);
            }
        });
        AdminBaseMenuPanel.add(AdminBoard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, 60));

        AdminHome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/Home.png"))); // NOI18N
        AdminHome1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminHome1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AdminHome1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AdminHome1MouseExited(evt);
            }
        });
        AdminBaseMenuPanel.add(AdminHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 60));

        UserMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AdminMainPage/User.png"))); // NOI18N
        UserMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UserMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UserMenuMouseExited(evt);
            }
        });
        AdminBaseMenuPanel.add(UserMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 60));

        getContentPane().add(AdminBaseMenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 210, 600));

        BasePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        User.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/icons8_customer_40px_2.png"))); // NOI18N
        User.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UserMouseEntered(evt);
            }
        });
        BasePanel.add(User, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 740, -1, 40));

        Setting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/icons8_settings_40px_3.png"))); // NOI18N
        BasePanel.add(Setting, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 740, 40, -1));

        Alarm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/icons8_notification_40px_1.png"))); // NOI18N
        BasePanel.add(Alarm, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 740, 40, 40));

        BackGroundLabel.setBackground(new java.awt.Color(255, 255, 255));
        BackGroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPageImage/MainBackGround.png"))); // NOI18N
        BackGroundLabel.setToolTipText("");
        BasePanel.add(BackGroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 800));

        getContentPane().add(BasePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseExited
        // TODO add your handling code here:
        Home.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Home.png")));
    }//GEN-LAST:event_HomeMouseExited

    private void HomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseEntered
        // TODO add your handling code here:
        Home.setCursor(new Cursor(HAND_CURSOR));
        Home.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Home_Entered.png")));
    }//GEN-LAST:event_HomeMouseEntered

    private void BoardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BoardMouseExited
        // TODO add your handling code here:
        Board.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Board.png")));
    }//GEN-LAST:event_BoardMouseExited

    private void BoardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BoardMouseEntered
        // TODO add your handling code here:
        Board.setCursor(new Cursor(HAND_CURSOR));
        Board.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Board_Entered.png")));
    }//GEN-LAST:event_BoardMouseEntered

    private void FreshManMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FreshManMouseExited
        // TODO add your handling code here:
        FreshMan.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/FreshMan.png")));
    }//GEN-LAST:event_FreshManMouseExited

    private void FreshManMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FreshManMouseEntered
        // TODO add your handling code here:
        FreshMan.setCursor(new Cursor(HAND_CURSOR));
        FreshMan.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/FreshMan_Entered.png")));
    }//GEN-LAST:event_FreshManMouseEntered

    private void SophomoreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SophomoreMouseExited
        // TODO add your handling code here:
        Sophomore.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Sophomore.png")));
    }//GEN-LAST:event_SophomoreMouseExited

    private void SophomoreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SophomoreMouseEntered
        // TODO add your handling code here:
        Sophomore.setCursor(new Cursor(HAND_CURSOR));
        Sophomore.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Sophomore_Entered.png")));
    }//GEN-LAST:event_SophomoreMouseEntered

    private void JuniorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JuniorMouseExited
        // TODO add your handling code here:
        Junior.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Junior.png")));
    }//GEN-LAST:event_JuniorMouseExited

    private void JuniorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JuniorMouseEntered
        // TODO add your handling code here:
        Junior.setCursor(new Cursor(HAND_CURSOR));
        Junior.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Junior_Entered.png")));
    }//GEN-LAST:event_JuniorMouseEntered

    private void SeniorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeniorMouseExited
        // TODO add your handling code here:
        Senior.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Senior.png")));
    }//GEN-LAST:event_SeniorMouseExited

    private void SeniorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeniorMouseEntered
        // TODO add your handling code here:
        Senior.setCursor(new Cursor(HAND_CURSOR));
        Senior.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Senior_Entered.png")));
    }//GEN-LAST:event_SeniorMouseEntered

    private void Board1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Board1MouseEntered
        // TODO add your handling code here:
        Board1.setCursor(new Cursor(HAND_CURSOR));
        Board1.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Board_Entered.png")));
    }//GEN-LAST:event_Board1MouseEntered

    private void Board1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Board1MouseExited
        // TODO add your handling code here:
        Board1.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Board.png")));
    }//GEN-LAST:event_Board1MouseExited

    private void Home1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Home1MouseEntered
        // TODO add your handling code here:
        Home1.setCursor(new Cursor(HAND_CURSOR));
        Home1.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Home_Entered.png")));
    }//GEN-LAST:event_Home1MouseEntered

    private void Home1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Home1MouseExited
        // TODO add your handling code here:
        Home1.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Home.png")));
    }//GEN-LAST:event_Home1MouseExited

    private void Board1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Board1MouseClicked
        // TODO add your handling code here:
        BaseMenuPanel.setVisible(false);
        BaseMenuPanel.setEnabled(false);

        BoardSelectedPanel.setVisible(true);
        BoardSelectedPanel.setEnabled(true);
    }//GEN-LAST:event_Board1MouseClicked

    private void BoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BoardMouseClicked
        // TODO add your handling code here:        
        BaseMenuPanel.setVisible(true);
        BaseMenuPanel.setEnabled(true);

        BoardSelectedPanel.setVisible(false);
        BoardSelectedPanel.setEnabled(false);
    }//GEN-LAST:event_BoardMouseClicked

    private void MyPostMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyPostMouseEntered
        // TODO add your handling code here:
        MyPost.setCursor(new Cursor(HAND_CURSOR));
        MyPost.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/MyPost_Entered.png")));
    }//GEN-LAST:event_MyPostMouseEntered

    private void MyPostMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyPostMouseExited
        // TODO add your handling code here:
        MyPost.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/MyPost.png")));
    }//GEN-LAST:event_MyPostMouseExited

    private void ScrabPostMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScrabPostMouseEntered
        // TODO add your handling code here:
        ScrabPost.setCursor(new Cursor(HAND_CURSOR));
        ScrabPost.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/ScrabPost_Entered.png")));
    }//GEN-LAST:event_ScrabPostMouseEntered

    private void ScrabPostMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScrabPostMouseExited
        // TODO add your handling code here:
        ScrabPost.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/ScrabPost.png")));
    }//GEN-LAST:event_ScrabPostMouseExited

    private void ChatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChatMouseEntered
        // TODO add your handling code here:
        Chat.setCursor(new Cursor(HAND_CURSOR));
        Chat.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Chat_Entered.png")));
    }//GEN-LAST:event_ChatMouseEntered

    private void ChatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChatMouseExited
        // TODO add your handling code here:
        Chat.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Chat.png")));
    }//GEN-LAST:event_ChatMouseExited

    private void Chat1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chat1MouseEntered
        // TODO add your handling code here:
        Chat1.setCursor(new Cursor(HAND_CURSOR));
        Chat1.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Chat_Entered.png")));
    }//GEN-LAST:event_Chat1MouseEntered

    private void Chat1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chat1MouseExited
        // TODO add your handling code here:
        Chat1.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Chat.png")));
    }//GEN-LAST:event_Chat1MouseExited

    private void MakeChatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MakeChatMouseEntered
        // TODO add your handling code here:
        MakeChat.setCursor(new Cursor(HAND_CURSOR));
        MakeChat.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/ChatPanelImage/MakeChat_Entered.png")));
    }//GEN-LAST:event_MakeChatMouseEntered

    private void MakeChatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MakeChatMouseExited
        // TODO add your handling code here:
        MakeChat.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/ChatPanelImage/MakeChat.png")));
    }//GEN-LAST:event_MakeChatMouseExited

    private void EnterChatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EnterChatMouseEntered
        // TODO add your handling code here:
        EnterChat.setCursor(new Cursor(HAND_CURSOR));
        EnterChat.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/ChatPanelImage/EnterChat_Entered.png")));
    }//GEN-LAST:event_EnterChatMouseEntered

    private void EnterChatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EnterChatMouseExited
        // TODO add your handling code here:
        EnterChat.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/ChatPanelImage/EnterChat.png")));
    }//GEN-LAST:event_EnterChatMouseExited

    private void TopPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TopPanelMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - mousePX, y - mousePY);
    }//GEN-LAST:event_TopPanelMouseDragged

    private void TopPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TopPanelMousePressed
        // TODO add your handling code here:
        mousePX = evt.getX();
        mousePY = evt.getY();
    }//GEN-LAST:event_TopPanelMousePressed

    private void ExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseEntered
        // TODO add your handling code here:
        Exit.setCursor(new Cursor(HAND_CURSOR));
    }//GEN-LAST:event_ExitMouseEntered

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitMouseClicked

    private void SearchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchFieldMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_SearchFieldMouseClicked

    private void SearchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchFieldFocusLost
        // TODO add your handling code here:
        SearchField.setText("Search...");
    }//GEN-LAST:event_SearchFieldFocusLost

    private void SearchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchFieldFocusGained
        // TODO add your handling code here:
        SearchField.setText("");
    }//GEN-LAST:event_SearchFieldFocusGained

    private void Home1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Home1MouseClicked
        // TODO add your handling code here:
        HomePanel.setVisible(true);
        HomePanel.setEnabled(true);

        ChatPanel.setVisible(false);
        ChatPanel.setVisible(false);
    }//GEN-LAST:event_Home1MouseClicked

    private void Chat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chat1MouseClicked
        // TODO add your handling code here:
        ChatPanel.setVisible(true);
        ChatPanel.setEnabled(true);

        HomePanel.setVisible(false);
        HomePanel.setEnabled(false);

    }//GEN-LAST:event_Chat1MouseClicked

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
        // TODO add your handling code here:
        HomePanel.setVisible(true);
        HomePanel.setEnabled(true);

        BoardPanel.setVisible(false);
        BoardPanel.setEnabled(false);

        PostPanel.setVisible(false);
        PostPanel.setEnabled(false);

        ChatPanel.setVisible(false);
        ChatPanel.setVisible(false);
    }//GEN-LAST:event_HomeMouseClicked

    private void ChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChatMouseClicked
        // TODO add your handling code here:

        //chatTableModel.setRowCount(0);

        ChatPanel.setVisible(true);
        ChatPanel.setEnabled(true);

        BoardPanel.setVisible(false);
        BoardPanel.setEnabled(false);

        HomePanel.setVisible(false);
        HomePanel.setEnabled(false);

//        chatTableModel.insertRow(chatTableModel.getRowCount(), new Object[]{"1", "chatting Bang", "2020-06-16 05:26:00", "BangJang", "3", "private"});
//        chatTableModel.insertRow(chatTableModel.getRowCount(), new Object[]{"2", "췌팅방", "2020-06-16 05:31:13", "뱅장", "3", "public"});
//        chatTableModel.insertRow(chatTableModel.getRowCount(), new Object[]{"3", "채튕방", "2020-06-16 05:33:54", "뷍장", "3", "private"});
    }//GEN-LAST:event_ChatMouseClicked

    private void jScrollPane1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollPane1MouseWheelMoved
        // TODO add your handling code here:
        ComponentsInit.TableMouseWheelMovedEvt(jScrollPane1, jTable2, evt);

    }//GEN-LAST:event_jScrollPane1MouseWheelMoved

    private void AdminBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminBoardMouseClicked
        // TODO add your handling code here:
        AdminBaseMenuPanel.setVisible(true);
        AdminBaseMenuPanel.setEnabled(true);

        AdminMenuPanel.setVisible(false);
        AdminMenuPanel.setEnabled(false);
    }//GEN-LAST:event_AdminBoardMouseClicked

    private void AdminBoardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminBoardMouseEntered
        // TODO add your handling code here:
        AdminBoard.setCursor(new Cursor(HAND_CURSOR));
        AdminBoard.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Board_Entered.png")));
    }//GEN-LAST:event_AdminBoardMouseEntered

    private void AdminBoardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminBoardMouseExited
        // TODO add your handling code here:
        AdminBoard.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Board.png")));
    }//GEN-LAST:event_AdminBoardMouseExited

    private void AdminHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminHomeMouseClicked
        // TODO add your handling code here:
        initializePanel(HomePanel, true);

        initializePanel(PostManagePanel, false);
        //initializePanel(UserPanel, true);
        //initializePanel(ReportManagePanel, true);
        //initializePanel(NoticeManagePanel, true);
    }//GEN-LAST:event_AdminHomeMouseClicked

    private void AdminHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminHomeMouseEntered
        // TODO add your handling code here:
        AdminHome.setCursor(new Cursor(HAND_CURSOR));
        AdminHome.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Home_Entered.png")));
    }//GEN-LAST:event_AdminHomeMouseEntered

    private void AdminHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminHomeMouseExited
        // TODO add your handling code here:
        AdminHome.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Home.png")));
    }//GEN-LAST:event_AdminHomeMouseExited

    private void PostManageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PostManageMouseClicked
        // TODO add your handling code here:
        initializePanel(PostManagePanel, true);
        initializePanel(HomePanel, false);
        //initializePanel(UserPanel, true);
        //initializePanel(ReportManagePanel, true);
        //initializePanel(NoticeManagePanel, true);

    }//GEN-LAST:event_PostManageMouseClicked

    private void PostManageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PostManageMouseEntered
        // TODO add your handling code here:
        PostManage.setCursor(new Cursor(HAND_CURSOR));
        PostManage.setIcon(new ImageIcon(getClass().getResource("/AdminMainPage/PostManage_Entered.png")));
    }//GEN-LAST:event_PostManageMouseEntered

    private void PostManageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PostManageMouseExited
        // TODO add your handling code here:
        PostManage.setIcon(new ImageIcon(getClass().getResource("/AdminMainPage/PostManage.png")));
    }//GEN-LAST:event_PostManageMouseExited

    private void ReportManageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportManageMouseEntered
        // TODO add your handling code here:
        ReportManage.setCursor(new Cursor(HAND_CURSOR));
        ReportManage.setIcon(new ImageIcon(getClass().getResource("/AdminMainPage/ReportManage_Entered.png")));
    }//GEN-LAST:event_ReportManageMouseEntered

    private void ReportManageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportManageMouseExited
        // TODO add your handling code here:
        ReportManage.setIcon(new ImageIcon(getClass().getResource("/AdminMainPage/ReportManage.png")));
    }//GEN-LAST:event_ReportManageMouseExited

    private void NoticeManageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoticeManageMouseEntered
        // TODO add your handling code here:
        NoticeManage.setCursor(new Cursor(HAND_CURSOR));
        NoticeManage.setIcon(new ImageIcon(getClass().getResource("/AdminMainPage/NoticeManage_Entered.png")));
    }//GEN-LAST:event_NoticeManageMouseEntered

    private void NoticeManageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoticeManageMouseExited
        // TODO add your handling code here:
        NoticeManage.setIcon(new ImageIcon(getClass().getResource("/AdminMainPage/NoticeManage.png")));
    }//GEN-LAST:event_NoticeManageMouseExited

    private void AdminBoard1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminBoard1MouseClicked
        // TODO add your handling code here:
        initializePanel(AdminMenuPanel, true);

        initializePanel(AdminBaseMenuPanel, false);
    }//GEN-LAST:event_AdminBoard1MouseClicked

    private void AdminBoard1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminBoard1MouseEntered
        // TODO add your handling code here:
        AdminBoard1.setCursor(new Cursor(HAND_CURSOR));
        AdminBoard1.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Board_Entered.png")));
    }//GEN-LAST:event_AdminBoard1MouseEntered

    private void AdminBoard1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminBoard1MouseExited
        // TODO add your handling code here:
        AdminBoard1.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Board.png")));
    }//GEN-LAST:event_AdminBoard1MouseExited

    private void AdminHome1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminHome1MouseClicked
        // TODO add your handling code here:
        initializePanel(HomePanel, true);

        initializePanel(ChatPanel, false);
    }//GEN-LAST:event_AdminHome1MouseClicked

    private void AdminHome1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminHome1MouseEntered
        // TODO add your handling code here:
        AdminHome1.setCursor(new Cursor(HAND_CURSOR));
        AdminHome1.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Home_Entered.png")));
    }//GEN-LAST:event_AdminHome1MouseEntered

    private void AdminHome1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminHome1MouseExited
        // TODO add your handling code here:
        AdminHome1.setIcon(new ImageIcon(getClass().getResource("/MainPageImage/Home.png")));
    }//GEN-LAST:event_AdminHome1MouseExited

    private void UserMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserMenuMouseEntered
        // TODO add your handling code here:
        UserMenu.setCursor(new Cursor(HAND_CURSOR));
        UserMenu.setIcon(new ImageIcon(getClass().getResource("/AdminMainPage/User_Entered.png")));
    }//GEN-LAST:event_UserMenuMouseEntered

    private void UserMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserMenuMouseExited
        // TODO add your handling code here:
        UserMenu.setIcon(new ImageIcon(getClass().getResource("/AdminMainPage/User.png")));
    }//GEN-LAST:event_UserMenuMouseExited

    private void UserMenu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserMenu1MouseEntered
        // TODO add your handling code here:
        UserMenu1.setCursor(new Cursor(HAND_CURSOR));
        UserMenu1.setIcon(new ImageIcon(getClass().getResource("/AdminMainPage/User_Entered.png")));
    }//GEN-LAST:event_UserMenu1MouseEntered

    private void UserMenu1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserMenu1MouseExited
        // TODO add your handling code here:
        UserMenu1.setIcon(new ImageIcon(getClass().getResource("/AdminMainPage/User.png")));
    }//GEN-LAST:event_UserMenu1MouseExited

    private void jScrollPane4MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollPane4MouseWheelMoved
        // TODO add your handling code here:
        ComponentsInit.TableMouseWheelMovedEvt(jScrollPane4, jTable4, evt);
    }//GEN-LAST:event_jScrollPane4MouseWheelMoved

    private void AddPostMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPostMouseEntered
        // TODO add your handling code here:
        AddPost.setCursor(new Cursor(HAND_CURSOR));
        AddPost.setIcon(new ImageIcon(getClass().getResource("/BoardIcon/Add_post_Entered.png")));
    }//GEN-LAST:event_AddPostMouseEntered

    private void AddPostMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPostMouseExited
        // TODO add your handling code here:
        AddPost.setIcon(new ImageIcon(getClass().getResource("/BoardIcon/Add_post.png")));
    }//GEN-LAST:event_AddPostMouseExited

    private void FreshManMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FreshManMouseClicked
        // TODO add your handling code here:
        tableModel.setRowCount(0);

        GradeField.setText("FreshMan");
        this.keyword = "FreshMan";
        initializePanel(BoardPanel, true);

        initializePanel(ChatPanel, false);
        initializePanel(PostPanel, false);
        initializePanel(HomePanel, false);

        Vector<String> vec = new Vector<>();
        vec = new PostSearch(2, "g").informationSearch();
        int size = vec.size();
        for (int i = 0; i < size / 6; i++) {
            tableModel.insertRow(tableModel.getRowCount(), new Object[]{vec.get(0 + (i * 6)), vec.get(1 + (i * 6)), vec.get(2 + (i * 6)), vec.get(3 + (i * 6)), vec.get(4 + (i * 6)), vec.get(5 + (i * 6))});
        }

//        for (String str : vec) {
//            System.out.println(str);
//        }

    }//GEN-LAST:event_FreshManMouseClicked

    private void SophomoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SophomoreMouseClicked
        // TODO add your handling code here:
        GradeField.setText("Sophomore");
        this.keyword = "Sophomore";
        initializePanel(BoardPanel, true);

        initializePanel(ChatPanel, false);
        initializePanel(PostPanel, false);
        initializePanel(HomePanel, false);

    }//GEN-LAST:event_SophomoreMouseClicked

    private void JuniorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JuniorMouseClicked
        // TODO add your handling code here:
        GradeField.setText("Junior");
        this.keyword = "Junior";
        initializePanel(BoardPanel, true);
        initializePanel(ChatPanel, false);
        initializePanel(PostPanel, false);
        initializePanel(HomePanel, false);
    }//GEN-LAST:event_JuniorMouseClicked

    private void SeniorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeniorMouseClicked
        // TODO add your handling code here:
        GradeField.setText("Senior");
        this.keyword = "Senior";
        initializePanel(BoardPanel, true);

        initializePanel(ChatPanel, false);
        initializePanel(PostPanel, false);
        initializePanel(HomePanel, false);
    }//GEN-LAST:event_SeniorMouseClicked

    private void SearchField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchField1FocusGained
        // TODO add your handling code here:
        ComponentsInit.TextFieldGained(SearchField1, "Search...");
    }//GEN-LAST:event_SearchField1FocusGained

    private void SearchField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchField1FocusLost
        // TODO add your handling code here:
        ComponentsInit.TextFieldLost(SearchField1, "Search...");
    }//GEN-LAST:event_SearchField1FocusLost

    private void SearchField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchField1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchField1MouseClicked

    private void MyPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyPostMouseClicked
        // TODO add your handling code here:
        initializePanel(PostPanel, true);
        initializePanel(BoardPanel, false);
        initializePanel(ChatPanel, false);
        initializePanel(HomePanel, false);

        ModifyPost.setVisible(true);
        ModifyPost.setEnabled(true);
        PostTitle.setIcon(new ImageIcon(getClass().getResource("/BoardIcon/MyPost.png")));
    }//GEN-LAST:event_MyPostMouseClicked

    private void RefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshMouseEntered
        // TODO add your handling code here:
        Refresh.setCursor(new Cursor(HAND_CURSOR));
    }//GEN-LAST:event_RefreshMouseEntered

    private void jScrollPane5MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollPane5MouseWheelMoved
        // TODO add your handling code here:
        ComponentsInit.TableMouseWheelMovedEvt(jScrollPane5, jTable5, evt);
    }//GEN-LAST:event_jScrollPane5MouseWheelMoved

    private void ScrabPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScrabPostMouseClicked
        // TODO add your handling code here:
        initializePanel(PostPanel, true);
        initializePanel(BoardPanel, false);
        initializePanel(ChatPanel, false);
        initializePanel(HomePanel, false);

        ModifyPost.setVisible(false);
        ModifyPost.setEnabled(false);
        PostTitle.setIcon(new ImageIcon(getClass().getResource("/BoardIcon/ScrabPost.png")));
    }//GEN-LAST:event_ScrabPostMouseClicked

    private void SearchField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchField2FocusGained
        // TODO add your handling code here:
        ComponentsInit.TextFieldGained(SearchField2, "Search...");
    }//GEN-LAST:event_SearchField2FocusGained

    private void SearchField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchField2FocusLost
        // TODO add your handling code here:
        ComponentsInit.TextFieldLost(SearchField2, "Search...");
    }//GEN-LAST:event_SearchField2FocusLost

    private void SearchField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchField2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchField2MouseClicked

    private void ModifyPostMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModifyPostMouseEntered
        // TODO add your handling code here:
        ModifyPost.setCursor(new Cursor(HAND_CURSOR));
        ModifyPost.setIcon(new ImageIcon(getClass().getResource("/BoardIcon/Modify_Post_Entered.png")));
    }//GEN-LAST:event_ModifyPostMouseEntered

    private void ModifyPostMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModifyPostMouseExited
        // TODO add your handling code here:
        ModifyPost.setIcon(new ImageIcon(getClass().getResource("/BoardIcon/Modify_Post.png")));
    }//GEN-LAST:event_ModifyPostMouseExited

    private void DeletePostMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeletePostMouseEntered
        // TODO add your handling code here:
        DeletePost.setCursor(new Cursor(HAND_CURSOR));
        DeletePost.setIcon(new ImageIcon(getClass().getResource("/BoardIcon/Delete_Post_Entered.png")));
    }//GEN-LAST:event_DeletePostMouseEntered

    private void DeletePostMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeletePostMouseExited
        // TODO add your handling code here:
        DeletePost.setIcon(new ImageIcon(getClass().getResource("/BoardIcon/Delete_Post.png")));
    }//GEN-LAST:event_DeletePostMouseExited

    private void Refresh1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Refresh1MouseEntered
        // TODO add your handling code here:
        Refresh1.setCursor(new Cursor(HAND_CURSOR));
    }//GEN-LAST:event_Refresh1MouseEntered

    private void jScrollPane6MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollPane6MouseWheelMoved
        // TODO add your handling code here:
        ComponentsInit.TableMouseWheelMovedEvt(jScrollPane6, jTable6, evt);
    }//GEN-LAST:event_jScrollPane6MouseWheelMoved

    private void SearchField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchField3FocusGained
        // TODO add your handling code here:
        ComponentsInit.TextFieldGained(SearchField3, "Search...");
    }//GEN-LAST:event_SearchField3FocusGained

    private void SearchField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchField3FocusLost
        // TODO add your handling code here:
        ComponentsInit.TextFieldLost(SearchField3, "Search...");
    }//GEN-LAST:event_SearchField3FocusLost

    private void SearchField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchField3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchField3MouseClicked

    private void ManageAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageAddMouseEntered
        // TODO add your handling code here:
        ManageAdd.setCursor(new Cursor(HAND_CURSOR));
        ManageAdd.setIcon(new ImageIcon(getClass().getResource("/BoardIcon/Add_post_Entered.png")));
    }//GEN-LAST:event_ManageAddMouseEntered

    private void ManageAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageAddMouseExited
        // TODO add your handling code here:
        ManageAdd.setIcon(new ImageIcon(getClass().getResource("/BoardIcon/Add_post.png")));
    }//GEN-LAST:event_ManageAddMouseExited

    private void ManageModifyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageModifyMouseEntered
        // TODO add your handling code here:
        ManageModify.setCursor(new Cursor(HAND_CURSOR));
        ManageModify.setIcon(new ImageIcon(getClass().getResource("/BoardIcon/Modify_Post_Entered.png")));
    }//GEN-LAST:event_ManageModifyMouseEntered

    private void ManageModifyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageModifyMouseExited
        // TODO add your handling code here:
        ManageModify.setIcon(new ImageIcon(getClass().getResource("/BoardIcon/Modify_Post.png")));
    }//GEN-LAST:event_ManageModifyMouseExited

    private void ManageDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageDeleteMouseEntered
        // TODO add your handling code here:
        ManageDelete.setCursor(new Cursor(HAND_CURSOR));
        ManageDelete.setIcon(new ImageIcon(getClass().getResource("/BoardIcon/Delete_Post_Entered.png")));
    }//GEN-LAST:event_ManageDeleteMouseEntered

    private void ManageDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageDeleteMouseExited
        // TODO add your handling code here:
        ManageDelete.setIcon(new ImageIcon(getClass().getResource("/BoardIcon/Delete_Post.png")));
    }//GEN-LAST:event_ManageDeleteMouseExited

    private void jScrollPane3MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollPane3MouseWheelMoved
        // TODO add your handling code here:
        ComponentsInit.TableMouseWheelMovedEvt(jScrollPane3, jTable3, evt);
    }//GEN-LAST:event_jScrollPane3MouseWheelMoved

    private void jScrollPane2MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollPane2MouseWheelMoved
        // TODO add your handling code here:
        ComponentsInit.TableMouseWheelMovedEvt(jScrollPane2, jTable1, evt);
    }//GEN-LAST:event_jScrollPane2MouseWheelMoved

    private void MakeChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MakeChatMouseClicked
        // TODO add your handling code here:
        MakeChat mc = new MakeChat();
        mc.setVisible(true);
        mc.setEnabled(true);
    }//GEN-LAST:event_MakeChatMouseClicked

    private void ManageAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageAddMouseClicked
        // TODO add your handling code here:
        // 매니저 게시물 추가 부분
        AddPostGUI ap = new AddPostGUI(userID, userType, keyword, jTable4);
        ap.setVisible(true);
        ap.setEnabled(true);
    }//GEN-LAST:event_ManageAddMouseClicked

    private void AddPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPostMouseClicked
        // TODO add your handling code here:
        String grade = GradeField.getText();

        // 글을 쓸 때, 자신의 학년에 맞는 게시판인지 확인하고 맞으면 AddPostGUI 호출
        AddPostGUI ap = new AddPostGUI(userID, userType, keyword, jTable4);
        ap.setVisible(true);
        ap.setEnabled(true);
    }//GEN-LAST:event_AddPostMouseClicked

    private void UserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserMouseEntered
        // TODO add your handling code here:
        User.setCursor(new Cursor(HAND_CURSOR));
    }//GEN-LAST:event_UserMouseEntered

    private void UserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserMouseClicked
        // TODO add your handling code here:

        MyInfo my = new MyInfo(userID, this);
        my.setVisible(true);
        my.setEnabled(true);

        System.out.println("asdodsa");
    }//GEN-LAST:event_UserMouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int row = jTable4.getSelectedRow();

            Object[] value = new Object[6];
            for (int i = 0; i < 6; i++) {
                value[i] = jTable4.getValueAt(row, i);
            }

            for (Object object : value) {
                System.out.println(object);
            }

            PostView pv = new PostView(new PostSearch(3, value[0].toString()).informationSearch());
            pv.setVisible(true);
            pv.setEnabled(true);
        }
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            try {
                Chatting chat = new Chatting();
                chat.setVisible(true);
                chat.setEnabled(true);
            } catch (BadLocationException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }//GEN-LAST:event_jTable2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //Nimbus
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainPage().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddPost;
    private javax.swing.JPanel AdminBaseMenuPanel;
    private javax.swing.JLabel AdminBoard;
    private javax.swing.JLabel AdminBoard1;
    private javax.swing.JPanel AdminBoardSelectPanel;
    private javax.swing.JLabel AdminHome;
    private javax.swing.JLabel AdminHome1;
    private javax.swing.JPanel AdminMenuPanel;
    private javax.swing.JLabel Alarm;
    private javax.swing.JLabel Alarm1;
    private javax.swing.JLabel BackGroundLabel;
    private javax.swing.JPanel BaseMenuPanel;
    private javax.swing.JPanel BasePanel;
    private javax.swing.JLabel Board;
    private javax.swing.JLabel Board1;
    private javax.swing.JPanel BoardPanel;
    private javax.swing.JPanel BoardSelectPanel;
    private javax.swing.JPanel BoardSelectedPanel;
    private javax.swing.JLabel BoardTitle;
    private javax.swing.JLabel Chat;
    private javax.swing.JLabel Chat1;
    private javax.swing.JPanel ChatPanel;
    private javax.swing.JLabel DeletePost;
    private javax.swing.JLabel EnterChat;
    private javax.swing.JLabel Exit;
    private javax.swing.JLabel FreshMan;
    private javax.swing.JTextField GradeField;
    private javax.swing.JLabel Home;
    private javax.swing.JLabel Home1;
    private javax.swing.JPanel HomePanel;
    private javax.swing.JLabel Junior;
    private javax.swing.JLabel MakeChat;
    private javax.swing.JLabel ManageAdd;
    private javax.swing.JLabel ManageDelete;
    private javax.swing.JLabel ManageModify;
    private javax.swing.JLabel ModifyPost;
    private javax.swing.JLabel MyPost;
    private javax.swing.JLabel NoticeManage;
    private javax.swing.JComboBox<String> PWQuestionField;
    private javax.swing.JComboBox<String> PWQuestionField1;
    private javax.swing.JLabel PostManage;
    private javax.swing.JPanel PostManagePanel;
    private javax.swing.JLabel PostManageTitle;
    private javax.swing.JPanel PostPanel;
    private javax.swing.JLabel PostTitle;
    private javax.swing.JLabel Refresh;
    private javax.swing.JLabel Refresh1;
    private javax.swing.JLabel ReportManage;
    private javax.swing.JLabel ScrabPost;
    private javax.swing.JComboBox<String> SearchComboBox;
    private javax.swing.JTextField SearchField;
    private javax.swing.JTextField SearchField1;
    private javax.swing.JTextField SearchField2;
    private javax.swing.JTextField SearchField3;
    private javax.swing.JLabel SearchLabel;
    private javax.swing.JLabel SearchLabel1;
    private javax.swing.JLabel SearchLabel2;
    private javax.swing.JLabel SearchLabel3;
    private javax.swing.JLabel Senior;
    private javax.swing.JLabel Setting;
    private javax.swing.JLabel Setting1;
    private javax.swing.JLabel Sophomore;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JLabel User;
    private javax.swing.JLabel User1;
    private javax.swing.JLabel UserMenu;
    private javax.swing.JLabel UserMenu1;
    private javax.swing.JLabel UserName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    // End of variables declaration//GEN-END:variables
}
