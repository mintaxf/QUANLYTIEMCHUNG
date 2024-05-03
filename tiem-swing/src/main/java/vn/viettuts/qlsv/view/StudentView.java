package vn.viettuts.qlsv.view;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser; 
import javax.swing.JTabbedPane;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.*;
import java.awt.*;
import static java.awt.Font.ITALIC;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import org.jfree.chart.ChartPanel;
import vn.viettuts.qlsv.controller.StudentController;


import vn.viettuts.qlsv.entity.Student;
import vn.viettuts.qlsv.utils.FileUtils;


public class StudentView extends JFrame implements ActionListener, ListSelectionListener {

    private static final long serialVersionUID = 1L;
    private JButton addStudentBtn;
    private JButton editStudentBtn;
    private JButton deleteStudentBtn;
    private JButton clearBtn, NAVtke;
    private JButton spinBtn, NAVExit;
    private JButton sortStudentNumberBtn;
    private JButton sortStudentNameBtn;
    private JButton searchBtn;
    private JScrollPane jScrollPaneStudentTable;
    private JScrollPane jScrollPaneAddress;
    private JScrollPane copiedScrollPane;

//    ChartPanel bestSellerPie;
    public JTable studentTable;
    public JTable copiedTable;
    private JLabel searchLabel;

    private JLabel gifLabel;
    private JLabel ntLabel;

    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel addressLabel;
    private JLabel tsbLabel;
    private JLabel costLabel;
    private JLabel gtLabel;
    
    private JLabel text;

   // private JTabbedPane tabbedPane;
    private JPanel paneltk, chartpanel, piepanel;

    
    public JPanel getPiepanel() {
        return piepanel;
    }

    public void setPiepanel(JPanel piepanel) {
        this.piepanel = piepanel;
    }
    
    private JPanel tab3;
    
    private JLabel messageL;
    private ButtonGroup sexbtn;
    

//    public JPanel getBarChart() {
//        return BarChart;
//    }
//
//    public void setBarChart(JPanel BarChart) {
//        this.BarChart = BarChart;
//    }
//    

    public JPanel getPaneltk() {
        return paneltk;
    }

    public void setPaneltk(JPanel paneltk) {
        this.paneltk = paneltk;
    }

    private JLabel lblhinhanh;

    public JLabel getLblhinhanh() {
        return lblhinhanh;
    }

    public void setLblhinhanh(JLabel lblhinhanh) {
        this.lblhinhanh = lblhinhanh;
    }
    private JButton habutton;

    private JTextField tsbField;
    private JComboBox costField;
    private JComboBox gtField;
    
    private JComboBox cbTkiem;
    
    public JTextField searchField;

    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextArea addressTA;
    
    private JRadioButton radioBtn1, radioBtn2;

    private JDateChooser calendar;
   // private JButton button;

    private byte[] picture;

    // định nghĩa các cột của bảng student
    private final String[] columnNames = new String[]{
        "ID", "Họ Và Tên", "Tuổi", "Quê Quán", "Giới tính", "Ngày Tiêm", "Tiểu Sử Bệnh", "Gói Tiêm", "Giá Tiền", "Hình Ảnh" };
    // định nghĩa dữ liệu mặc định của bẳng student là rỗng
    private final Object data = new Object[][]{};

    /**
     *
     */
    
    public StudentView() {      
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        radioBtn1 = new JRadioButton("Nam");
        radioBtn2 = new JRadioButton("Nữ");
        
        sexbtn = new ButtonGroup();
        
        sexbtn.add(radioBtn1);
        sexbtn.add(radioBtn2);
        
        // khởi tạo các phím chức năng
        addStudentBtn = new JButton("Add");
        addStudentBtn.setForeground(new Color(0, 0, 139));
        
        
        
        editStudentBtn = new JButton("Edit");
        editStudentBtn.setForeground(new Color(0, 0, 139));

        deleteStudentBtn = new JButton("Delete");
        deleteStudentBtn.setForeground(new Color(0, 0, 139));

        clearBtn = new JButton("Clear");
        clearBtn.setForeground(new Color(0, 0, 139));

        spinBtn = new JButton("tại đây");
        spinBtn.setForeground(Color.YELLOW);
        spinBtn.setFont(new Font("Arial", Font.BOLD, 17));

        sortStudentNumberBtn = new JButton("Sort By ID");
        sortStudentNumberBtn.setForeground(new Color(0, 0, 139));

        sortStudentNameBtn = new JButton("Sort By Name");
        sortStudentNameBtn.setForeground(new Color(0, 0, 139));

        // khởi tạo bảng student
        jScrollPaneStudentTable = new JScrollPane();
        studentTable = new JTable();

        copiedScrollPane = new JScrollPane();
        copiedTable = new JTable();

        copiedTable.setModel(studentTable.getModel());
        copiedTable.setSelectionModel(studentTable.getSelectionModel());
        copiedTable.setColumnModel(studentTable.getColumnModel());
        // Thêm JTable vào JScrollPane sao chép
        copiedScrollPane.setViewportView(copiedTable);

        searchBtn = new JButton();
        
        searchBtn.addActionListener(this);
        searchBtn.setBackground(Color.WHITE);
        

        // khởi tạo các label
        idLabel = new JLabel("Id");

        idLabel.setFont(new Font("Arial", Font.BOLD, 15));
        idLabel.setForeground(new Color(0, 0, 139)); // Xanh đậm

        nameLabel = new JLabel("Họ Và Tên");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        nameLabel.setForeground(new Color(0, 0, 139)); // Xanh đậm

        ageLabel = new JLabel("Tuổi");
        ageLabel.setFont(new Font("Arial", Font.BOLD, 15));
        ageLabel.setForeground(new Color(0, 0, 139)); // Xanh đậm

        addressLabel = new JLabel("Quê Quán");
        addressLabel.setFont(new Font("Arial", Font.BOLD, 15));
        addressLabel.setForeground(new Color(0, 0, 139)); // Xanh đậm

        tsbLabel = new JLabel("Tiểu Sử Bệnh");
        tsbLabel.setFont(new Font("Arial", Font.BOLD, 13));
        tsbLabel.setForeground(new Color(0, 0, 139)); // Xanh đậm

        costLabel = new JLabel("Giá Tiền");
        costLabel.setFont(new Font("Arial", Font.BOLD, 15));
        costLabel.setForeground(new Color(0, 0, 139)); // Xanh đậm

        gtLabel = new JLabel("Gói Tiêm");
        gtLabel.setFont(new Font("Arial", Font.BOLD, 15));
        gtLabel.setForeground(new Color(0, 0, 139)); // Xanh đậm

        searchLabel = new JLabel("Nhập Thông Tin");
        searchLabel.setFont(new Font("Arial", Font.BOLD, 15));
        searchLabel.setForeground(new Color(0, 0, 139)); // Xanh đậm

        ntLabel = new JLabel("Ngày Tiêm");
        ntLabel.setFont(new Font("Arial", Font.BOLD, 15));
        ntLabel.setForeground(new Color(0, 0, 139)); // Xanh đậm
        
        JLabel sexlb = new JLabel("Giới Tính");
        sexlb.setFont(new Font("Arial", Font.BOLD, 15));
        sexlb.setForeground(new Color(0, 0, 139));

        lblhinhanh = new JLabel();
        lblhinhanh.setOpaque(true);
        lblhinhanh.setBackground(Color.LIGHT_GRAY);
        lblhinhanh.setPreferredSize(new Dimension(150, 150));
        
        messageL = new JLabel();
       
        habutton = new JButton("Image");
        habutton.setForeground(new Color(0, 0, 139));
        habutton.addActionListener(this);
        
        NAVtke = new JButton();
        NAVtke.addActionListener(this);
        NAVtke.setBackground(Color.WHITE);
        
        NAVExit = new JButton("EXIT");
        NAVExit.setBorderPainted(false);
        NAVExit.addActionListener(this);
        
        text = new JLabel("<html>*   Dịp lễ 30/4, tại một số thành phố lớn, khu du lịch, các khu mua sắm, trung tâm thương mại, lượng người dân tập trung "
                + "<br>mua sắm, đi lại rất đông, nhất là vào ngày cuối tuần. Các chuyên gia y tế cảnh báo, trước sự gia tăng giao lưu đi lại, tiếp xúc"
                + "<br> của người dân là điều kiện lý tưởng cho việc bùng phát và lây lan các bệnh truyền nhiễm, như: Cúm, sởi, thủy đậu,…");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.BOLD, 15));
        
        JLabel text2 = new JLabel("<html>*  Nhằm hướng đến “Năm hành động vì một cộng đồng được bảo vệ bởi vắc xin”, Hệ thống tiêm chủng VNVC bùng nổ"
                + "<br> chuỗi ưu đãi giá và quà tặng hấp dẫn, giúp thêm nhiều trẻ em và người lớn có cơ hội tiêm vắc xin an toàn, chất lượng cao,"
                + "<br> chủ động phòng các bệnh truyền nhiễm nguy hiểm.");
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("Arial", Font.BOLD, 15));
        
        JLabel text3 = new JLabel("Áp dụng: 01.04.2024 - 30.04.2024");
        text3.setForeground(Color.YELLOW);
        text3.setFont(new Font("Arial", Font.ITALIC, 17));
        
        JLabel text4 = new JLabel("<html>•	Ưu đãi giá lẻ cho các mũi vắc xin quan trọng\n" +
"<br>•	Miễn phí tiêm vắc xin Lao\n" +
"<br>•	Miễn phí tiêm vắc xin uốn ván cho phụ nữ mang thai \n" +
"<br>•	Tặng voucher ưu đãi và quà tặng giá trị\n" +
"<br>•	Tặng phiếu ưu đãi 100.000đ\n" +
"<br>•	Hỗ trợ trả góp 0% Gói vắc xin \n" +
"<br>•	Miễn phí đo huyết áp ");
        
        text4.setForeground(Color.YELLOW);
        text4.setFont(new Font("Arial", Font.BOLD, 17));
        
        
        
        JLabel text5 = new JLabel("CHÀO MỪNG ĐẠI LỄ");
        JLabel text6 = new JLabel("30/4 - 1/5"); 
        text5.setForeground(Color.WHITE);
        text5.setFont(new Font("Arial", Font.BOLD, 35));
        text6.setForeground(Color.YELLOW);
        text6.setFont(new Font("Arial", Font.BOLD, 39));
        
        JLabel text7 = new JLabel("Ngoài ra, nhận phần quà may mắn");
        text7.setForeground(Color.YELLOW);
        text7.setFont(new Font("Arial", Font.ITALIC, 17));
        
        // khởi tạo các trường nhập dữ liệu cho student
        searchField = new JTextField(20);
        idField = new JTextField(6);
        idField.setEditable(false);
        nameField = new JTextField(15);
        ageField = new JTextField(6);
        addressTA = new JTextArea();
        addressTA.setColumns(15);
        addressTA.setRows(1);
        jScrollPaneAddress = new JScrollPane();
        jScrollPaneAddress.setViewportView(addressTA);
        tsbField = new JTextField(15);
        String cost[] = {"Mặc định", "12 triệu - 6 tháng", "15 triệu - 9 tháng", "20 triệu - 12 tháng", "24 triệu - 24 tháng"};
        costField = new JComboBox(cost);
        String gt[] = {"Mặc định", "SỞI - QUAI BỊ - RUBELLA", "CÚM", "THỦY ĐẬU", "BẠCH HẦU - HO GÀ - UỐN VÁN", "VIÊM GAN B"} ;
        gtField = new JComboBox(gt);
        
        String opKhac[] = {"Tìm theo Ngày Tiêm", "Tìm theo Tên", "Tìm theo ID", "Tìm theo Gói Tiêm"};
        cbTkiem = new JComboBox(opKhac);
        cbTkiem.addActionListener(this);
        
        
//        ImageIcon iconsearch = new ImageIcon("image1/Search.png");
//        searchBtn.setIcon(iconsearch);
        
        ImageIcon iconadd = new ImageIcon(getClass().getResource("/image1/add5.png"));
        addStudentBtn.setIcon(iconadd);
        
        ImageIcon iconedit = new ImageIcon(getClass().getResource("/image1/edit5.png"));
        editStudentBtn.setIcon(iconedit);
        
        ImageIcon icondelete = new ImageIcon(getClass().getResource("/image1/Delete3.png"));
        deleteStudentBtn.setIcon(icondelete);
        
        ImageIcon iconclear = new ImageIcon(getClass().getResource("/image1/Clear2.png"));
        clearBtn.setIcon(iconclear);
        
        ImageIcon iconsid = new ImageIcon(getClass().getResource("/image1/son1.png"));
        sortStudentNumberBtn.setIcon(iconsid);

        ImageIcon iconsnm = new ImageIcon(getClass().getResource("/image1/sona.png"));
        sortStudentNameBtn.setIcon(iconsnm);

//        ImageIcon iconspn = new ImageIcon("image1/images.png");
//        spinBtn.setIcon(iconspn);
        spinBtn.setBackground(new Color(223, 0, 41));
        
        ImageIcon iconimg = new ImageIcon(getClass().getResource("/image1/image2.png"));
        habutton.setIcon(iconimg);
        
        ImageIcon iconex = new ImageIcon(getClass().getResource("/image1/exit1.png"));
        NAVExit.setIcon(iconex);
        NAVExit.setBackground(Color.WHITE);

        calendar = new JDateChooser();
        calendar.setPreferredSize(new Dimension(150, 25));
        
        // cài đặt các cột và data cho bảng student
       
       // copiedTable.setAutoCreateRowSorter(true);
        // Thêm bảng sao chép vào JScrollPane
        JScrollPane copiedScrollPane = new JScrollPane(copiedTable);
        copiedScrollPane.setPreferredSize(new Dimension(900, 120));
        //DefaultTableModel copiedTableModel = new DefaultTableModel((Object[][]) data, columnNames);
        

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setForeground(new Color(0, 0, 139)); // Đặt màu chữ là màu đỏ cho tất cả các ô
        cellRenderer.setBackground(Color.WHITE); // Đặt màu nền là màu vàng cho tất cả các ô
        copiedTable.setDefaultRenderer(Object.class, cellRenderer); // Áp dụng Renderer cho tất cả các ô
        
        
               
        studentTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));    
        
//        studentTable.getModel();
        //studentTable.setAutoCreateRowSorter(true);
//        TableColumnModel columnModel = studentTable.getColumnModel();

        
        
        jScrollPaneStudentTable.setViewportView(studentTable);
        jScrollPaneStudentTable.setPreferredSize(new Dimension(900, 200));
        //studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        DefaultTableCellRenderer cellRenderer1 = new DefaultTableCellRenderer();
        cellRenderer1.setForeground(new Color(0, 0, 139)); // Đặt màu chữ là màu đỏ cho tất cả các ô
        cellRenderer1.setBackground(Color.WHITE); // Đặt màu nền là màu vàng cho tất cả các ô
        studentTable.setDefaultRenderer(Object.class, cellRenderer1); // Áp dụng Renderer cho tất cả các ô
       
       
       
//        TableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable studentTable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(studentTable, value, isSelected, hasFocus, row, column);
//                setForeground(Color.GREEN);  // Đặt màu chữ là màu xanh lá cây
//                return this;
//            }
//        };
//
//        // Đặt TableCellRenderer cho tất cả các cột
//        for (int i = 0; i < studentTable.getModel().getColumnCount(); i++) {
//            studentTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
//        }
        
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Student
//        UIManager.put("TabbedPane.selected", Color.RED);
//       // UIManager.put("TabbedPane.tabAreaBackground", Color.RED);
//        UIManager.put("TabbedPane.unselectedBackground", new Color(0, 0, 139));
//        UIManager.put("TabbedPane.unselectedForeground", new Color(255, 255, 255));
        
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        //TitledBorder titledBorder = BorderFactory.createTitledBorder("Vaccination Information");
        //tabbedPane.setBorder(titledBorder);
       

        add(tabbedPane);
        setSize(975, 825);
        setTitle("Vaccination Information");
        ImageIcon load1 = new ImageIcon(getClass().getResource("/image1/logo4.png"));
        Image scaleImage = load1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon load21 = new ImageIcon(scaleImage);
        setIconImage(load21.getImage());
//        setIconImage(Toolkit.getDefaultToolkit().getImage("image1/logo4.png"));
        
        JPanel panel = new JPanel();

        tab3 = new JPanel();
        
        JPanel tab4 = new JPanel();
                
        tabbedPane.addTab("Thông Tin Bệnh Nhân", tab3);
        tabbedPane.setTitleAt(0, "Thông Tin Bệnh Nhân");
        tab3.setBackground(Color.WHITE);
        tabbedPane.setTabComponentAt(0, new CustomTabComponent("image1/List.png", "Thông Tin Bệnh Nhân"));

//        String gifPath = "image1/robot5.gif";
        // Tạo một ImageIcon từ file GIF
        //ImageIcon gifIcon = new ImageIcon(gifPath);
        //Image gifImage = gifIcon.getImage();
        //Image resizedGif = gifImage.getScaledInstance(150, 184, Image.SCALE_DEFAULT);
        
        // Tạo một ImageIcon từ hình ảnh đã chỉnh kích thước
        ImageIcon resizedGifIcon = new ImageIcon(getClass().getResource("/image1/robot5.gif"));
        Image i2 = resizedGifIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        // Tạo một JLabel với ImageIcon
        gifLabel = new JLabel(i3);
        
        ImageIcon resizedGifIcon1 = new ImageIcon(getClass().getResource("/image1/edit3.gif"));
        Image i21 = resizedGifIcon1.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
        ImageIcon i31 = new ImageIcon(i21);
        
//        // Tạo một JLabel với ImageIcon
//        gifLabel = new JLabel(i3);
//        
//        String gifPath1 = "/image1/edit3.gif";
//        
//        ImageIcon gifIcon1 = new ImageIcon(gifPath1);
//        Image gifImage1 = gifIcon1.getImage();
//        Image resizedGif1 = gifImage1.getScaledInstance(200, 150, Image.SCALE_DEFAULT);

        // Tạo một ImageIcon từ hình ảnh đã chỉnh kích thước
//        ImageIcon resizedGifIcon1 = new ImageIcon(resizedGif1);
        // Tạo một JLabel với ImageIcon
        JLabel gifLabel1 = new JLabel(i31);
        
        ImageIcon resizedGifIcon2 = new ImageIcon(getClass().getResource("/image1/bieudo.gif"));
        Image i22 = resizedGifIcon2.getImage().getScaledInstance(420, 280, Image.SCALE_DEFAULT);
        ImageIcon i32 = new ImageIcon(i22);
        
//        String gifPath2 = "image1/bieudo.gif";
//        // Tạo một ImageIcon từ file GIF
//        ImageIcon gifIcon2 = new ImageIcon(gifPath2);
//        Image gifImage2 = gifIcon2.getImage();
//        Image resizedGif2 = gifImage2.getScaledInstance(420, 280, Image.SCALE_DEFAULT);

        // Tạo một ImageIcon từ hình ảnh đã chỉnh kích thước
//        ImageIcon resizedGifIcon2 = new ImageIcon(resizedGif2);
        // Tạo một JLabel với ImageIcon
        JLabel gifLabel2 = new JLabel(i32);
        
        
        
        ImageIcon resizedGifIcon3 = new ImageIcon(getClass().getResource("/image1/304.png"));
        Image i23 = resizedGifIcon3.getImage().getScaledInstance(450, 200, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i23);
        
        
//        String gifPath3 = "image1/304.png";
//        // Tạo một ImageIcon từ file GIF
//        ImageIcon gifIcon3 = new ImageIcon(gifPath3);
//        Image gifImage3 = gifIcon3.getImage();
//        Image resizedGif3 = gifImage3.getScaledInstance(450, 201, Image.SCALE_DEFAULT);
//        // Tạo một ImageIcon từ hình ảnh đã chỉnh kích thước
//        ImageIcon resizedGifIcon3 = new ImageIcon(resizedGif3);
//        // Tạo một JLabel với ImageIcon
        JLabel gifLabel3 = new JLabel(i33);
        
        ImageIcon resizedGifIcon4 = new ImageIcon(getClass().getResource("/image1/3042.jpg"));
        Image i24 = resizedGifIcon4.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i34 = new ImageIcon(i24);
        
//         String gifPath4 = "image1/3042.jpg";
//        // Tạo một ImageIcon từ file GIF
//        ImageIcon gifIcon4 = new ImageIcon(gifPath4);
//        Image gifImage4 = gifIcon4.getImage();
//        Image resizedGif4 = gifImage4.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
//        // Tạo một ImageIcon từ hình ảnh đã chỉnh kích thước
//        ImageIcon resizedGifIcon4 = new ImageIcon(resizedGif4);
//        // Tạo một JLabel với ImageIcon
        JLabel gifLabel4 = new JLabel(i34);
        
        ImageIcon resizedGifIcon5 = new ImageIcon(getClass().getResource("/image1/bg304.jpg"));
        Image i25 = resizedGifIcon5.getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
        ImageIcon i35 = new ImageIcon(i25);
        
        
//         String gifPath5 = "image1/bg304.jpg";
//        // Tạo một ImageIcon từ file GIF
//        ImageIcon gifIcon5 = new ImageIcon(gifPath5);
//        Image gifImage5 = gifIcon5.getImage();
//        Image resizedGif5 = gifImage5.getScaledInstance(200, 230, Image.SCALE_DEFAULT);
//        // Tạo một ImageIcon từ hình ảnh đã chỉnh kích thước
//        ImageIcon resizedGifIcon5 = new ImageIcon(resizedGif5);
       
        JLabel gifLabel5 = new JLabel(i35);
        
        JLabel vienlbn = new JLabel();
        vienlbn.setOpaque(true);
        vienlbn.setBackground(new Color(0, 0, 139));
        vienlbn.setPreferredSize(new Dimension(1050, 250));
        
        JLabel vienlbd = new JLabel();
        vienlbd.setOpaque(true);
        vienlbd.setBackground(new Color(0, 0, 139));
        vienlbd.setPreferredSize(new Dimension(100, 730));
        
        JLabel vienlbn1 = new JLabel();
        vienlbn1.setOpaque(true);
        vienlbn1.setBackground(new Color(0, 0, 139));
        vienlbn1.setPreferredSize(new Dimension(1050, 100));
        
        JLabel vienlbd1 = new JLabel();
        vienlbd1.setOpaque(true);
        vienlbd1.setBackground(new Color(0, 0, 139));
        vienlbd1.setPreferredSize(new Dimension(100, 730));
        

        tabbedPane.addTab("Tab 1", panel);
        tabbedPane.setTitleAt(1, "Chỉnh Sửa Thông Tin");
        panel.setBackground(Color.WHITE);
        tabbedPane.setTabComponentAt(1, new CustomTabComponent("image1/Notes.png", "Chỉnh Sửa Thông Tin"));
        
        paneltk = new JPanel();
        tabbedPane.addTab("Thống Kê", paneltk);
        tabbedPane.setTitleAt(2, "Thống Kê");
        paneltk.setBackground(Color.WHITE);
        tabbedPane.setTabComponentAt(2, new CustomTabComponent("image1/Best.png", "Thống Kê"));
        
        tabbedPane.addTab("Chương Trình Tri Ân", tab4);
        tabbedPane.setTitleAt(3, "Chương Trình Tri Ân");
        tab4.setBackground(new Color(223, 0, 41));
        
        //JLabel backgroundLabel = new JLabel(new ImageIcon("image1/bg3042.jpg"));
         
        tabbedPane.setTabComponentAt(3, new CustomTabComponent("image1/gift3.png", "Chương Trình Tri Ân"));
        
        
        
        
        chartpanel = new JPanel();
        chartpanel.setPreferredSize(new Dimension(1000, 400));
        paneltk.add(chartpanel);
        
        
        
        piepanel = new JPanel();
        piepanel.setPreferredSize(new Dimension(350, 350));
        paneltk.add(piepanel);
        
        SpringLayout layout = new SpringLayout();
        
        paneltk.setLayout(layout);
        //paneltk.add(barChartPanel);
        
//        tabbedPane.setForeground(Color.WHITE);
        
        tab3.setLayout(layout);
        tab4.setLayout(layout);
        
        //panel.setSize(1000, 1000);
        panel.setLayout(layout);
        panel.add(jScrollPaneStudentTable);
        panel.add(addStudentBtn);
        panel.add(editStudentBtn);
        panel.add(deleteStudentBtn);
        panel.add(clearBtn);

        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(ageLabel);
        panel.add(addressLabel);
        panel.add(tsbLabel);
        panel.add(costLabel);
        panel.add(gtLabel);
        panel.add(idField);
        panel.add(nameField);
        panel.add(ageField);
        panel.add(tsbField);
        panel.add(costField);
        panel.add(gtField);
        panel.add(jScrollPaneAddress);
        panel.add(searchField);
        panel.add(searchBtn);
        panel.add(searchLabel);

        panel.add(ntLabel);
        panel.add(calendar);

        panel.add(habutton);
        panel.add(lblhinhanh);
        panel.add(gifLabel1);
        
        panel.add(radioBtn1);
        panel.add(radioBtn2);
        panel.add(sexlb);
        
        ImageIcon resizedGifIcon6 = new ImageIcon(getClass().getResource("/image1/vnvc2.png"));
        Image i26 = resizedGifIcon6.getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(i26);
        
       
        
        
        
        //String imagePath = "image1/vnvc2.png";

        // Đọc ảnh từ tập tin
        
        // Tạo ImageIcon từ ảnh đã thay đổi kích thước
        
        
        //ImageIcon imageIcon1 = new ImageIcon(resizedImage1);
        // Tạo JLabel và đặt ImageIcon vào đó
        JLabel label = new JLabel(imageIcon);
        JLabel label1 = new JLabel(imageIcon);
        JLabel label2 = new JLabel(imageIcon);
        JLabel label6 = new JLabel(imageIcon);
        JLabel label3 = new JLabel("THÔNG TIN BỆNH NHÂN");
        label3.setFont(new Font("Arial", Font.BOLD, 47));
        label3.setForeground(new Color(0, 0, 139)); // Xanh đậm
        JLabel label4 = new JLabel("CHỈNH SỬA THÔNG TIN");
        label4.setFont(new Font("Arial", Font.BOLD, 47));
        label4.setForeground(new Color(0, 0, 139)); // Xanh đậm
        JLabel label5 = new JLabel("THỐNG KÊ");
        label5.setFont(new Font("Arial", Font.BOLD, 47));
        label5.setForeground(new Color(0, 0, 139)); // Xanh đậm
        tabbedPane.addChangeListener((ChangeEvent e) -> {
            if(tabbedPane.getSelectedIndex() == 2) {
                // Kích hoạt nút khi chọn Tab 1
                NAVtke.doClick();
                
            }
        });
        paneltk.add(label1);
        paneltk.add(label5);
        paneltk.add(NAVtke);
        paneltk.add(gifLabel2);
        tab3.add(label2);
        tab3.add(label3);
        tab3.add(sortStudentNumberBtn);
        tab3.add(sortStudentNameBtn);
        tab4.add(spinBtn);
        tab3.add(searchField);
        tab3.add(searchBtn);
        tab3.add(searchLabel);
        tab3.add(copiedScrollPane);
        tab3.add(NAVExit);
        tab3.add(messageL);
        tab3.add(gifLabel);
        tab3.add(cbTkiem);
        tab3.add(vienlbn);
        //tab3.add(vienlbd);
        tab4.add(label6);
        tab4.add(text);
        tab4.add(text2);
        // tab4.add(text3);
        tab4.add(text4);
        tab4.add(text5);
        tab4.add(text6);
        tab4.add(gifLabel3);
        tab4.add(gifLabel4);
        tab4.add(gifLabel5);
        //tab3.add(gifLabel);
        //tab4.add(backgroundLabel);
        tab4.add(text7);
        panel.add(label);
        panel.add(label4);
        panel.add(vienlbn1);
        panel.add(vienlbd1);
        layout.putConstraint(SpringLayout.WEST, label6, 10, SpringLayout.WEST, tab4);
        layout.putConstraint(SpringLayout.NORTH, label6, 10, SpringLayout.NORTH, tab4);
        layout.putConstraint(SpringLayout.WEST, text, 20, SpringLayout.WEST, tab4);
        layout.putConstraint(SpringLayout.NORTH, text, 310, SpringLayout.NORTH, tab4);
        layout.putConstraint(SpringLayout.WEST, text2, 20, SpringLayout.WEST, tab4);
        layout.putConstraint(SpringLayout.NORTH, text2, 380, SpringLayout.NORTH, tab4);
        layout.putConstraint(SpringLayout.WEST, text4, 20, SpringLayout.WEST, tab4);
        layout.putConstraint(SpringLayout.NORTH, text4, 450, SpringLayout.NORTH, tab4);
        layout.putConstraint(SpringLayout.WEST, text5, 320, SpringLayout.WEST, tab4);
        layout.putConstraint(SpringLayout.NORTH, text5, 50, SpringLayout.NORTH, tab4);
        layout.putConstraint(SpringLayout.WEST, text6, 410, SpringLayout.WEST, tab4);
        layout.putConstraint(SpringLayout.NORTH, text6, 90, SpringLayout.NORTH, tab4);
        layout.putConstraint(SpringLayout.WEST, text7, 20, SpringLayout.WEST, tab4);
        layout.putConstraint(SpringLayout.NORTH, text7, 610, SpringLayout.NORTH, tab4);
        layout.putConstraint(SpringLayout.WEST, spinBtn, 290, SpringLayout.WEST, tab4);
        layout.putConstraint(SpringLayout.NORTH, spinBtn, 610, SpringLayout.NORTH, tab4);
        layout.putConstraint(SpringLayout.WEST, gifLabel3, 515, SpringLayout.WEST, tab4);
        layout.putConstraint(SpringLayout.NORTH, gifLabel3, 545, SpringLayout.NORTH, tab4);
        layout.putConstraint(SpringLayout.WEST, gifLabel4, 0, SpringLayout.WEST, tab4);
        layout.putConstraint(SpringLayout.NORTH, gifLabel4, 50, SpringLayout.NORTH, tab4);
        layout.putConstraint(SpringLayout.WEST, gifLabel5, 750, SpringLayout.WEST, tab4);
        layout.putConstraint(SpringLayout.NORTH, gifLabel5, 50, SpringLayout.NORTH, tab4);
        layout.putConstraint(SpringLayout.WEST, label1, 10, SpringLayout.WEST, paneltk);
        layout.putConstraint(SpringLayout.NORTH, label1, 10, SpringLayout.NORTH, paneltk);
        layout.putConstraint(SpringLayout.WEST, label5, 320, SpringLayout.WEST, paneltk);
        layout.putConstraint(SpringLayout.NORTH, label5, 30, SpringLayout.NORTH, paneltk);
        layout.putConstraint(SpringLayout.WEST, NAVtke, 500, SpringLayout.WEST, paneltk);
        layout.putConstraint(SpringLayout.NORTH, NAVtke, 500, SpringLayout.NORTH, paneltk);
        layout.putConstraint(SpringLayout.WEST, chartpanel, -20, SpringLayout.WEST, paneltk);
        layout.putConstraint(SpringLayout.NORTH, chartpanel, 320, SpringLayout.NORTH, paneltk);
        layout.putConstraint(SpringLayout.WEST, piepanel, 610, SpringLayout.WEST, paneltk);
        layout.putConstraint(SpringLayout.NORTH, piepanel, -5, SpringLayout.NORTH, paneltk);
        layout.putConstraint(SpringLayout.WEST, gifLabel2, 30, SpringLayout.WEST, paneltk);
        layout.putConstraint(SpringLayout.NORTH, gifLabel2, 50, SpringLayout.NORTH, paneltk);
        layout.putConstraint(SpringLayout.WEST, label2, 10, SpringLayout.WEST, tab3);
        layout.putConstraint(SpringLayout.NORTH, label2, 10, SpringLayout.NORTH, tab3);
        layout.putConstraint(SpringLayout.WEST, label3, 260, SpringLayout.WEST, tab3);
        layout.putConstraint(SpringLayout.NORTH, label3, 30, SpringLayout.NORTH, tab3);
        layout.putConstraint(SpringLayout.WEST, NAVExit, 865, SpringLayout.WEST, tab3);
        layout.putConstraint(SpringLayout.NORTH, NAVExit, 650, SpringLayout.NORTH, tab3);
        layout.putConstraint(SpringLayout.WEST, vienlbn, 0, SpringLayout.WEST, tab3);
        layout.putConstraint(SpringLayout.NORTH, vienlbn, 610, SpringLayout.NORTH, tab3);
//            layout.putConstraint(SpringLayout.WEST, vienlbd, 980, SpringLayout.WEST, tab3);
//            layout.putConstraint(SpringLayout.NORTH, vienlbd, 0, SpringLayout.NORTH, tab3);
layout.putConstraint(SpringLayout.WEST, copiedScrollPane, 30, SpringLayout.WEST, tab3);
layout.putConstraint(SpringLayout.NORTH, copiedScrollPane, 400, SpringLayout.NORTH, tab3);
layout.putConstraint(SpringLayout.WEST, sortStudentNumberBtn, 500, SpringLayout.WEST, tab3);
layout.putConstraint(SpringLayout.NORTH, sortStudentNumberBtn, 331, SpringLayout.NORTH, tab3);
layout.putConstraint(SpringLayout.WEST, sortStudentNameBtn, 145, SpringLayout.WEST, sortStudentNumberBtn);
layout.putConstraint(SpringLayout.NORTH, sortStudentNameBtn, 330, SpringLayout.NORTH, tab3);
layout.putConstraint(SpringLayout.WEST, searchLabel, 340, SpringLayout.WEST, tab3);
layout.putConstraint(SpringLayout.NORTH, searchLabel, 200, SpringLayout.NORTH, tab3);
layout.putConstraint(SpringLayout.WEST, searchField, 470, SpringLayout.WEST, tab3);
layout.putConstraint(SpringLayout.NORTH, searchField, 200, SpringLayout.NORTH, tab3);
layout.putConstraint(SpringLayout.WEST, searchBtn, -100, SpringLayout.WEST, tab3);
layout.putConstraint(SpringLayout.NORTH, searchBtn, -80, SpringLayout.NORTH, tab3);
layout.putConstraint(SpringLayout.WEST, cbTkiem, 690, SpringLayout.WEST, tab3);
layout.putConstraint(SpringLayout.NORTH, cbTkiem, 200, SpringLayout.NORTH, tab3);
layout.putConstraint(SpringLayout.WEST, gifLabel, 40, SpringLayout.WEST, tab3);
layout.putConstraint(SpringLayout.NORTH, gifLabel, 150, SpringLayout.NORTH, tab3);
layout.putConstraint(SpringLayout.WEST, messageL, 470, SpringLayout.WEST, tab3);
layout.putConstraint(SpringLayout.NORTH, messageL, 230, SpringLayout.NORTH, tab3);
layout.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST, panel);
layout.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, panel);
layout.putConstraint(SpringLayout.WEST, label4, 270, SpringLayout.WEST, panel);
layout.putConstraint(SpringLayout.NORTH, label4, 30, SpringLayout.NORTH, panel);
layout.putConstraint(SpringLayout.WEST, vienlbn1, 0, SpringLayout.WEST, panel);
layout.putConstraint(SpringLayout.NORTH, vienlbn1, 725, SpringLayout.NORTH, panel);
layout.putConstraint(SpringLayout.WEST, vienlbd1, 980, SpringLayout.WEST, panel);
layout.putConstraint(SpringLayout.NORTH, vienlbd1, 0, SpringLayout.NORTH, panel);
         
        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 120, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageLabel, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressLabel, 180, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, tsbLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, tsbLabel, 280, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, costLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, costLabel, 340, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gtLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gtLabel, 310, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, ntLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ntLabel, 240, SpringLayout.NORTH, panel);

       
        layout.putConstraint(SpringLayout.WEST, calendar, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, calendar, 240, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, lblhinhanh, 495, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, lblhinhanh, 120, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, habutton, 520, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, habutton, 290, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 120, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageField, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneAddress, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneAddress, 178, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, tsbField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, tsbField, 280, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, costField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, costField, 340, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gtField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gtField, 310, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneStudentTable, 30, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneStudentTable, 400, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addStudentBtn, 450, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addStudentBtn, 350, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editStudentBtn, 100, SpringLayout.WEST, addStudentBtn);
        layout.putConstraint(SpringLayout.NORTH, editStudentBtn, 350, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteStudentBtn, 100, SpringLayout.WEST, editStudentBtn);
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 350, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 115, SpringLayout.WEST, deleteStudentBtn);
        layout.putConstraint(SpringLayout.NORTH, deleteStudentBtn, 350, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, gifLabel1, 700, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gifLabel1, 170, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, radioBtn1, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, radioBtn1, 210, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, radioBtn2, 170, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, radioBtn2, 210, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, sexlb, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sexlb, 210, SpringLayout.NORTH, panel);
        

        // disable Edit and Delete buttons
        editStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        // enable Add button
        addStudentBtn.setEnabled(true);

    }
    //public String imgname = null;

    public JPanel getChartpanel() {
        return chartpanel;
    }

    public void setChartpanel(JPanel chartpanel) {
        this.chartpanel = chartpanel;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }

    /**
     * hiển thị list student vào bảng studentTable
     *
     * @param list
     */
    public void updateSelectedRowImage() {
    int row = studentTable.getSelectedRow();
    if (row >= 0) {
        Object value = studentTable.getModel().getValueAt(row, 8);
        if (value instanceof byte[]) {
            byte[] imageData = (byte[]) value;
            ImageIcon imageIcon = new ImageIcon(imageData);
            setHinhAnh(imageIcon);
        } else {
            // Xử lý trường hợp không có dữ liệu hình ảnh
            setHinhAnh(null); // Xóa hình ảnh nếu không có dữ liệu
        }
    }
}
    
 
    
    public void showListStudents(List<Student> list) {
        int size = list.size();

        Object[][] students = new Object[size][10];
        for (int i = 0; i < size; i++) {
            students[i][0] = list.get(i).getId();
            students[i][1] = list.get(i).getName();
            students[i][2] = list.get(i).getAge();
            students[i][3] = list.get(i).getAddress();
            students[i][4] = list.get(i).isGioitinh() ? "Nam" : "Nữ";
            students[i][5] = list.get(i).getNt();
            students[i][6] = list.get(i).getTsb();
            students[i][7] = list.get(i).getGt();
            students[i][8] = list.get(i).getCost();
            //students[i][8] = list.get(i).getHinhAnh();
            
            byte[] imageData = list.get(i).getHinhAnh();
            if (imageData != null) {
            // If the student object has an image, keep the existing image data
                students[i][9] = imageData;
            } else {
            // If the student object doesn't have an image, keep it null
                students[i][9] = null;
            }
        }
        

        studentTable.setModel(new DefaultTableModel(students, columnNames));
        TableColumn coolluumm = studentTable.getColumnModel().getColumn(0);
        coolluumm.setPreferredWidth(3);
        TableColumn coolluumm2 = studentTable.getColumnModel().getColumn(1);
        coolluumm2.setPreferredWidth(140);
        TableColumn coolluumm3 = studentTable.getColumnModel().getColumn(2);
        coolluumm3.setPreferredWidth(25);
        TableColumn coolluumm4 = studentTable.getColumnModel().getColumn(3);
        coolluumm4.setPreferredWidth(80);
        TableColumn coolluumm5 = studentTable.getColumnModel().getColumn(4);
        coolluumm5.setPreferredWidth(50);
        TableColumn coolluumm6 = studentTable.getColumnModel().getColumn(5);
        coolluumm6.setPreferredWidth(80);
        TableColumn coolluumm7 = studentTable.getColumnModel().getColumn(6);
        coolluumm7.setPreferredWidth(80);
        TableColumn coolluumm8 = studentTable.getColumnModel().getColumn(7);
        coolluumm8.setPreferredWidth(190);
        TableColumn coolluumm9 = studentTable.getColumnModel().getColumn(8);
        coolluumm9.setPreferredWidth(125);
        TableColumn coolluumm10 = studentTable.getColumnModel().getColumn(9);
        coolluumm10.setPreferredWidth(-1);        
        

        copiedTable.setModel(new DefaultTableModel(students, columnNames));
        TableColumn coolluumm1 = studentTable.getColumnModel().getColumn(0);
        coolluumm1.setPreferredWidth(3);
        TableColumn coolluumm21 = studentTable.getColumnModel().getColumn(1);
        coolluumm21.setPreferredWidth(140);
        TableColumn coolluumm31 = studentTable.getColumnModel().getColumn(2);
        coolluumm31.setPreferredWidth(25);
        TableColumn coolluumm41 = studentTable.getColumnModel().getColumn(3);
        coolluumm41.setPreferredWidth(80);
        TableColumn coolluumm51 = studentTable.getColumnModel().getColumn(4);
        coolluumm51.setPreferredWidth(50);
        TableColumn coolluumm61 = studentTable.getColumnModel().getColumn(5);
        coolluumm61.setPreferredWidth(80);
        TableColumn coolluumm71 = studentTable.getColumnModel().getColumn(6);
        coolluumm71.setPreferredWidth(80);
        TableColumn coolluumm81 = studentTable.getColumnModel().getColumn(7);
        coolluumm81.setPreferredWidth(190);
        TableColumn coolluumm91 = studentTable.getColumnModel().getColumn(8);
        coolluumm91.setPreferredWidth(125);
        TableColumn coolluumm101 = studentTable.getColumnModel().getColumn(9);
        coolluumm101.setPreferredWidth(-1);
      
       

    }
    
    /**
     * điền thông tin của hàng được chọn từ bảng student vào các trường tương
     * ứng của student.
     */
    public void fillStudentFromSelectedRow() throws ParseException {
        // lấy chỉ số của hàng được chọn 
        int row = studentTable.getSelectedRow();

        if (row >= 0) {

            String id = studentTable.getValueAt(row, 0).toString();
            String name = studentTable.getValueAt(row, 1).toString();
            String age = studentTable.getValueAt(row, 2).toString();
            String address = studentTable.getValueAt(row, 3).toString();
            
            String gioitinhStr = String.valueOf(studentTable.getModel().getValueAt(row, 4)); // Chuỗi giới tính từ bảng
            if (gioitinhStr.equals("Nam")) {
                radioBtn1.setSelected(true); // Nếu là "Nam", chọn nút radio Nam
                radioBtn2.setSelected(false); // Đảm bảo nút radio Nữ không được chọn
            } else if (gioitinhStr.equals("Nữ")) {
                radioBtn1.setSelected(false); // Đảm bảo nút radio Nam không được chọn
                radioBtn2.setSelected(true); // Nếu là "Nữ", chọn nút radio Nữ
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String nt= studentTable.getValueAt(row, 5).toString();
          //  JDateChooser datechooser = new JDateChooser();
                       
            String tsb = studentTable.getValueAt(row, 6).toString();
            String gt = studentTable.getValueAt(row, 7).toString();
            String cost = studentTable.getValueAt(row, 8).toString();
            
            byte[] imageBytes = (byte[]) studentTable.getValueAt(row, 9);
            
            
            idField.setText(id);
            nameField.setText(name);
            ageField.setText(age);
            addressTA.setText(address);
            tsbField.setText(tsb);
            costField.setSelectedItem(cost);
            gtField.setSelectedItem(gt);
            
            Date date = dateFormat.parse(nt);
            calendar.setDate(date);
            

            ImageIcon imageIcon = new ImageIcon(imageBytes);
            Image image = imageIcon.getImage();
            Image scaledImage = image.getScaledInstance(lblhinhanh.getWidth(), lblhinhanh.getHeight(), Image.SCALE_SMOOTH);
            lblhinhanh.setIcon(new ImageIcon(scaledImage));
                   
            editStudentBtn.setEnabled(true);
            deleteStudentBtn.setEnabled(true);
            // disable Add button
            addStudentBtn.setEnabled(false);
        }
    }

    /**
     * xóa thông tin student
     */
    public void clearStudentInfo() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        addressTA.setText("");
        tsbField.setText("");
        costField.setSelectedItem("Mặc định");
        gtField.setSelectedItem("Mặc định");
        //lblhinhanh.removeAll();
        lblhinhanh.setIcon(null);
        sexbtn.clearSelection();
        
        
        SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
        String nt = "01/01/2011";
        //JDateChooser dateChooser = new JDateChooser();
        try
        {
            Date date = dateFormat.parse(nt);
            calendar.setDate(date);
        }
        catch (ParseException e)
        {
        }
            
        
        //calendar.setDate(null);

        // disable Edit and Delete buttons
        editStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        // enable Add button
        addStudentBtn.setEnabled(true);
    }


    public void showStudent(Student student) {
        idField.setText("" + student.getId());
        nameField.setText(student.getName());
        ageField.setText("" + student.getAge());
        addressTA.setText(student.getAddress());
        tsbField.setText("" + student.getTsb());
        costField.setSelectedItem(costField.getSelectedIndex());
        gtField.setSelectedItem(gtField.getSelectedIndex());
        
        if (student.isGioitinh()) {
        radioBtn1.setSelected(true); // Nam
        } else {
        radioBtn2.setSelected(true); // Nữ
        }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
        String nt = student.getNt();
        //JDateChooser dateChooser = new JDateChooser();
        try
        {
            Date date = dateFormat.parse(nt);
            calendar.setDate(date);
        }
        catch (ParseException e)
        {
        }
            

        byte[] imageData = student.getHinhAnh();
        
        if (imageData != null) {
            // Tạo ImageIcon từ dữ liệu byte
            //ImageIcon imageIcon = new ImageIcon(imageData);
            ImageIcon imageIcon =new ImageIcon(new ImageIcon(imageData).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
            // Đặt image icon cho nhãn lblHinhAnh
            lblhinhanh.setIcon(imageIcon);
            }
//        } else {
//            // Nếu không có dữ liệu hình ảnh, xóa nhãn
//            lblhinhanh.setIcon(null);
//        }
//        
        // enable Edit and Delete buttons
        editStudentBtn.setEnabled(true);
        deleteStudentBtn.setEnabled(true);
        // disable Add button
        addStudentBtn.setEnabled(false);
    }

    /**
     * lấy thông tin student
     *
     * @return
     */
    public Student getStudentInfo() {
        // validate student
        if (!validateName() || !validateAge() || !validateAddress() || !validateTsb() || !validateCost() || !validateGt() || !validateNt() || !validateGioitinh()) {
            //System.out.println("loi nhap lieu");
            return null;
        }
        try {
            Student student = new Student();

            String idText = idField.getText();
            if (idText != null && !idText.isEmpty()) {
                int id = Integer.parseInt(idText);
                student.setId(id);
            }
            
            /*if (idField.getText() != null && !"".equals(idField.getText())) {
                student.setId(Integer.parseInt(idField.getText()));
            }*/
            student.setName(nameField.getText().trim());
            student.setAge(Byte.parseByte(ageField.getText().trim()));
            student.setAddress(addressTA.getText().trim());
            
            boolean gioitinh;
            if (radioBtn1.isSelected()) {
                gioitinh = true; // Nam
            } else {
                gioitinh = false; // Nữ
            }
                student.setGioitinh(gioitinh);
        
            student.setTsb(tsbField.getText().trim());
            student.setGt((String) gtField.getItemAt(gtField.getSelectedIndex()));
            student.setCost((String) costField.getItemAt(costField.getSelectedIndex()));
            //student.setHinhAnh(picture);
            byte[] imageData = picture;
            student.setHinhAnh(imageData); 
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            student.setNt(dateFormat.format(calendar.getDate()));
            return student;
        } catch (NumberFormatException e) {
            showMessage(e.getMessage());
        }
        return null;
    }
    
//    private boolean validateImage(){
//        try{
//            byte[] img =  getHinhAnh();
//            
//        }
//    }
  // private boolean validateHinhanh() {
//    byte[] img =  student.getHinhAnh();
//    ImageIcon i3=new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
//    lblhinhanh = new JLabel(i3);
//    
//    lblhinhanh.setIcon(i3);
//    if (hinhanh == null || hinhanh.length == 0) {
//        studentView.requestFocus();
//        showMessage("Hình ảnh không được trống.");
//        return false;
//    }
//
//    ImageIcon imageIcon = new ImageIcon(hinhanh);
//    Image image = imageIcon.getImage();
//    if (image == null) {
//        studentView.requestFocus();
//        showMessage("Hình ảnh không hợp lệ.");
//        return false;
//    }

    //return true;
//}
    
   
    private boolean validateNt() {
        try {
            java.util.Date today = new java.util.Date();
            Date date = calendar.getDate();
            if (date.compareTo(today) == 1) {
                calendar.requestFocus();
                showMessage("Ngày nhập không tồn tại hoặc lớn hơn ngày hôm nay");
                return false;
            }
        } catch (Exception e) {
            calendar.requestFocus();
            showMessage("Bạn đã nhập ngày sai định dạng");
            return false;
        }
        return true;

    }
    
    private boolean validateGioitinh() {
    if (!radioBtn1.isSelected() && !radioBtn2.isSelected()) { // Kiểm tra xem có nút radio nào được chọn không
        showMessage("Vui lòng chọn giới tính.");
        return false;
    }
    return true;
    }

    private boolean validateName() {
        String name = nameField.getText();
        if (name == null || "".equals(name.trim())) {
            nameField.requestFocus();
            showMessage("Tên không được trống.");
            return false;
        }
        return true;
    }

    private boolean validateAddress() {
        String address = addressTA.getText();
        if (address == null || "".equals(address.trim())) {
            addressTA.requestFocus();
            showMessage("Địa chỉ không được trống.");
            return false;
        }
        return true;
    }

    private boolean validateAge() {
        try {
            Byte age = Byte.valueOf(ageField.getText().trim());
            if (age < 0 || age > 100) {
                ageField.requestFocus();
                showMessage("Tuổi không hợp lệ!");
                return false;
            }
        } catch (NumberFormatException e) {
            ageField.requestFocus();
            showMessage("Tuổi không hợp lệ!");
            return false;
        }
        return true;
    }

    private boolean validateTsb() {
        String tiensubenh = tsbField.getText();
        if (tiensubenh == null || "".equals(tiensubenh.trim())) {
            tsbField.requestFocus();
            showMessage("Tiểu sử bệnh không được trống.");
            return false;
        }
        return true;
    }

    private boolean validateCost() {
        String cost = (String) costField.getItemAt(costField.getSelectedIndex());
        if ("Mặc định".equals(cost.trim())) {
            costField.requestFocus();
            showMessage("Bạn chưa chọn giá gói tiêm");
            return false;
        }
        return true;
    }

    private boolean validateGt() {
        String gt = (String) gtField.getItemAt(gtField.getSelectedIndex());
        if ("Mặc định".equals(gt.trim())) {
            gtField.requestFocus();
            showMessage("Bạn chưa chọn gói tiêm");
            return false;
        }
        return true;
    }

    
    public int tuyChonTkiemDonHang(){
        switch (cbTkiem.getSelectedIndex()) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                break;
        }
        return 0;
    }
    
    public void setHinhAnh(ImageIcon imageIcon) {
    // Xóa ảnh cũ để tránh việc ảnh cũ vẫn còn hiển thị khi ảnh mới không tồn tại
    lblhinhanh.setIcon(null); 
    // Xóa văn bản nếu có
    lblhinhanh.setText(""); 

    // Kích thước cố định cho ảnh
    int width = 150; // Độ rộng mong muốn
    int height = 150; // Độ cao mong muốn

    // Lấy đối tượng Image từ ImageIcon
    Image image = imageIcon.getImage();

    // Thay đổi kích thước của hình ảnh
    Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

    // Tạo mới ImageIcon từ hình ảnh đã thay đổi kích thước
    ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

    // Thiết lập hình ảnh đã thay đổi kích thước cho JLabel
    lblhinhanh.setIcon(scaledImageIcon);
}
    
    public void WPNotif(String s){
        messageL.setVisible(true);
        messageL.setForeground(Color.RED);
        messageL.setText(s);
    }
    
    public JLabel getMessageL() {
        return messageL;
    }       
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public void valueChanged(ListSelectionEvent e) {
    }

    public void addAddStudentListener(ActionListener listener) {
        addStudentBtn.addActionListener(listener);
    }

    public void addEdiStudentListener(ActionListener listener) {
        editStudentBtn.addActionListener(listener);
    }

    public void addDeleteStudentListener(ActionListener listener) {
        deleteStudentBtn.addActionListener(listener);
    }

    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }

    public void addSortStudentNumberListener(ActionListener listener) {
        sortStudentNumberBtn.addActionListener(listener);
    }

    public void addSortStudentNameListener(ActionListener listener) {
        sortStudentNameBtn.addActionListener(listener);
    }

    public void addListStudentSelectionListener(ListSelectionListener listener) {
        studentTable.getSelectionModel().addListSelectionListener(listener);
    }

//    public void addSearchListener(ActionListener listener) {
//        searchBtn.addActionListener(listener);
//    }

    public void addSpinListener(ActionListener listener) {
        spinBtn.addActionListener(listener);
    }
    public void addHabuttonListener(ActionListener listener) {
        habutton.addActionListener(listener);
    }
    
    public void addNAVtkeButtonListener(ActionListener listener) {
        NAVtke.addActionListener(listener);
    }
    
    public void addNAVExitButtonListener(ActionListener l) {
        NAVExit.addActionListener(l);
    }

    /* public void upImage(String imageName) {
        ImageIcon icon = new ImageIcon("src\\image\\" + imageName);
        Image image = icon.getImage();
        ImageIcon icon1 = new ImageIcon(image.getScaledInstance(lblHinhanh.getWidth(), lblHinhanh.getHeight(), image.SCALE_SMOOTH));
        lblHinhanh.setIcon(icon1);
    }
    
    private void lblHinhanhMouseClicked(java.awt.event.MouseEvent evt) {
        JFileChooser file = new JFileChooser("src\\image\\");
        int kq = file.showOpenDialog(file);
        if (kq == JFileChooser.APPROVE_OPTION) {
            imgname = file.getSelectedFile().getName();
            upImage(imgname);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn ảnh...");
        }    
    }*/
    private Date parseDate(String nt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void showMessage(String s) {
       JOptionPane.showMessageDialog(this, s);
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] imageData) {
        this.picture = imageData;
    }    

    public void addNAVtkiemButtonListener(ActionListener listener) {
        searchBtn.addActionListener(listener);
    }
    
    public void addDCMListener(DocumentListener l){
        searchField.getDocument().addDocumentListener(l);
    }
    
}   
        



class CustomTabComponent extends JPanel {

    public CustomTabComponent(String imagePath, String title) {
        setOpaque(false);

        // Tạo ảnh logo
        ImageIcon icon = new ImageIcon(imagePath);
        JLabel label = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));

        // Tạo tiêu đề
        JLabel titleLabel = new JLabel(title);

        // Thêm ảnh logo và tiêu đề vào thành phần tùy chỉnh
        add(label);
        add(titleLabel);
    }


}

