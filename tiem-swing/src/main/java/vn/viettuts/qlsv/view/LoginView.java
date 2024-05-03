package vn.viettuts.qlsv.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import vn.viettuts.qlsv.entity.User;

public class LoginView extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel userNameLabel;
    private JLabel passwordlabel;
    private JPasswordField passwordField;
    private JTextField userNameField;
    private JButton loginBtn;
    private JLabel name1;
    private JLabel name2;
    
    
    
    public LoginView() throws IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        userNameLabel = new JLabel("Tên Đăng Nhập");
        userNameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        userNameLabel.setForeground(new Color(0, 0, 139)); // Xanh đậm
        
        passwordlabel = new JLabel("Mật Khẩu");
        passwordlabel.setFont(new Font("Arial", Font.BOLD, 15));
        passwordlabel.setForeground(new Color(0, 0, 139)); // Xanh đậm
        
        
        userNameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginBtn = new JButton();
        loginBtn.setText("Đăng Nhập");
        loginBtn.addActionListener(this);
        loginBtn.setForeground(Color.WHITE); 
        loginBtn.setBackground(new Color(0, 0, 139));
        
        name1 = new JLabel("TRUNG TÂM TIÊM CHỦNG VẮC XIN");
        name1.setFont(new Font("Arial", Font.BOLD, 15));
        name1.setForeground(new Color(0, 0, 139)); // Xanh đậm
        
        
        name2 = new JLabel("Dành cho trẻ em & người lớn");
        name2.setFont(new Font("Arial", Font.BOLD, 15));
        name2.setForeground(new Color(0, 0, 139)); // Xanh đậm
        
        
        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        // tạo đối tượng panel để chứa các thành phần của màn hình login
        panel.setSize(800, 800);
        panel.setLayout(layout);
        panel.setBackground(Color.WHITE); // Chỉnh màu nền của JPanel thành màu xanh lam
        
//        setIconImage(getClass().getResource("/image1/logo4.png"));

        ImageIcon load = new ImageIcon(getClass().getResource("/image1/logo4.png"));
        Image scaleImage = load.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon load2 = new ImageIcon(scaleImage);
        setIconImage(load2.getImage());
        
//        JFrame frame = new JFrame("");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);              
//        String imagePath = "/image1/vnvc2.png";
        ImageIcon i1 = new ImageIcon(getClass().getResource("/image1/vnvc2.png"));
        Image i2 = i1.getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        // Tạo ImageIcon từ tập tin ảnh
        
//        JFrame frame1 = new JFrame("");
//        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
//        String imagePath1 = "/image1/vnvc4.jpg";
        ImageIcon i11 = new ImageIcon(getClass().getResource("/image1/vnvc4.jpg"));
        Image i21 = i11.getImage().getScaledInstance(650, 580, Image.SCALE_DEFAULT);
        ImageIcon i31 = new ImageIcon(i21);
        JLabel label1 = new JLabel(i31);
        
//        JFrame frame2 = new JFrame("");
//        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
//        String imagePath2 = "/image1/vnvc5.jpg";

        ImageIcon i12 = new ImageIcon(getClass().getResource("/image1/vnvc5.jpg"));
        Image i22 = i12.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon i32 = new ImageIcon(i22);
        JLabel label2 = new JLabel(i32);

        ImageIcon i13 = new ImageIcon(getClass().getResource("/image1/vnvc6.png"));
        Image i23 = i13.getImage().getScaledInstance(230, 100, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i23);
        JLabel label3 = new JLabel(i33);


        //            // Đọc ảnh từ tập tin
//        //Image originalImage = ImageIO.read(new File(imagePath));
//            // Kích thước mới của ảnh
//        int newWidth = 150;
//        int newHeight = 50;
//            // Thay đổi kích thước ảnh
//        Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
//            // Tạo ImageIcon từ ảnh đã thay đổi kích thước
//        ImageIcon imageIcon = new ImageIcon(resizedImage);
//            // Tạo JLabel và đặt ImageIcon vào đó

panel.add(label);
layout.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST, panel);
layout.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, panel);
//Image originalImage1 = ImageIO.read(new File(imagePath1));
// Kích thước mới của ảnh
//int newWidth1 = 650;
//int newHeight1 = 580;
// Thay đổi kích thước ảnh
//Image resizedImage1 = originalImage1.getScaledInstance(newWidth1, newHeight1, Image.SCALE_SMOOTH);
// Tạo ImageIcon từ ảnh đã thay đổi kích thước
//ImageIcon imageIcon1 = new ImageIcon(resizedImage1);
// Tạo JLabel và đặt ImageIcon vào đó

panel.add(label1);
layout.putConstraint(SpringLayout.WEST, label1, 440, SpringLayout.WEST, panel);
layout.putConstraint(SpringLayout.NORTH, label1, 0, SpringLayout.NORTH, panel);
//Image originalImage2 = ImageIO.read(new File(imagePath2));
// Kích thước mới của ảnh
//int newWidth2 = 80;
//int newHeight2 = 80;
// Thay đổi kích thước ảnh
//Image resizedImage2 = originalImage2.getScaledInstance(newWidth2, newHeight2, Image.SCALE_SMOOTH);
// Tạo ImageIcon từ ảnh đã thay đổi kích thước
//ImageIcon imageIcon2 = new ImageIcon(resizedImage2);
// Tạo JLabel và đặt ImageIcon vào đó
//JLabel label2 = new JLabel(imageIcon2);
panel.add(label2);
layout.putConstraint(SpringLayout.WEST, label2, 10, SpringLayout.WEST, panel);
layout.putConstraint(SpringLayout.NORTH, label2, 460, SpringLayout.NORTH, panel);
//
// Kích thước mới của ảnh
//        int newWidth3 = 230;
//        int newHeight3 = 100;
// Thay đổi kích thước ảnh
//        Image resizedImage3 = originalImage3.getScaledInstance(newWidth3, newHeight3, Image.SCALE_SMOOTH);
//            // Tạo ImageIcon từ ảnh đã thay đổi kích thước
//        ImageIcon imageIcon3 = new ImageIcon(resizedImage3);
// Tạo JLabel và đặt ImageIcon vào đó
//JLabel label3 = new JLabel(imageIcon3);
panel.add(label3);
layout.putConstraint(SpringLayout.WEST, label3, 120, SpringLayout.WEST, panel);
layout.putConstraint(SpringLayout.NORTH, label3, 440, SpringLayout.NORTH, panel);
        
        // Tạo JLabel và đặt ImageIcon vào đó
             
        panel.add(userNameLabel);
        panel.add(passwordlabel);
        panel.add(userNameField);
        panel.add(passwordField);
        panel.add(loginBtn);
        panel.add(name1);
        panel.add(name2);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, userNameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, userNameLabel, 200, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordlabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordlabel, 230, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, userNameField, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, userNameField, 200, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordField, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordField, 230, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, loginBtn, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, loginBtn, 260, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, name1, 170, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, name1, 19, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, name2, 190, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, name2, 39, SpringLayout.NORTH, panel);
        
        
        
        // add panel tới JFrame
        
        this.add(panel);
        this.pack();
        
        // cài đặt các thuộc tính cho JFrame
        this.setTitle("Đăng Nhập");
        this.setSize(1100, 600);
        this.setResizable(false);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public User getUser() {
        return new User(userNameField.getText(), 
                String.copyValueOf(passwordField.getPassword()));
    }

    public void actionPerformed(ActionEvent e) {
    }
    
    public void addLoginListener(ActionListener listener) {
        loginBtn.addActionListener(listener);
    }
    
       
        
    }

   
