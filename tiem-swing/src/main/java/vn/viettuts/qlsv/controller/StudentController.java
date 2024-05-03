package vn.viettuts.qlsv.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
//import java.util.Date;
//import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.RowFilter;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


import vn.viettuts.qlsv.func.StudentFunc;
import vn.viettuts.qlsv.entity.Student;
import vn.viettuts.qlsv.view.LoginView;
import vn.viettuts.qlsv.view.StudentView;
import vn.viettuts.qlsv.view.SPIN;


public class StudentController {
    public StudentFunc studentDao;
    private StudentView studentView;
 
    
    public StudentController(StudentView view) {
        this.studentView = view;
        studentDao = new StudentFunc();
        //view.addSearchListener(new SearchInforListener());
        view.addSpinListener(new SpinListener());
        view.addAddStudentListener(new AddStudentListener());
        view.addEdiStudentListener(new EditStudentListener());
        view.addDeleteStudentListener(new DeleteStudentListener());
        view.addClearListener(new ClearStudentListener());
        view.addSortStudentNumberListener(new SortStudentNumberListener());
        view.addSortStudentNameListener(new SortStudentNameListener());
        view.addListStudentSelectionListener(new ListStudentSelectionListener());
        view.addHabuttonListener(new HabuttonListener());
        view.addNAVtkeButtonListener(new NAVtkeButtonListener());
        view.addNAVExitButtonListener(new NAVExitButtonListener());
        view.addNAVtkiemButtonListener(new NAVtkiemButtonListener());
        view.addDCMListener(new StudentController.dcmListener());
    }

    class NAVExitButtonListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            studentView.setVisible(false);        
            try {
                LoginView view = new LoginView();
                LoginController controller = new LoginController(view);
                controller.showLoginView();
            } catch (IOException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }  
            studentView.setVisible(false);  
        }
    }
    
    public void showStudentView() {
        List<Student> studentList = studentDao.getListStudents();
        studentView.setVisible(true);
        studentView.showListStudents(studentList);
    }

    private static class SpinListener implements ActionListener {
         public void actionPerformed(ActionEvent e)  {
             SPIN spin = new SPIN();
             spin.showSpin();
        }
    }
    
    class NAVtkeButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) { 
            studentView.getChartpanel().removeAll();
            
            studentView.getChartpanel().add(showBarChart());
            
            //SpringLayout layout = new SpringLayout();
            //studentView.getChartpanel().setLayout(layout);
                      
            studentView.getChartpanel().revalidate(); 
            studentView.getChartpanel().repaint(); 
            
            studentView.getPiepanel().removeAll();
            studentView.getPiepanel().add(showPieChart());

        }
        
    }
    
    
    class HabuttonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "JPG & PNG Images", "jpg", "png");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                // Đọc dữ liệu từ tệp được chọn
                FileInputStream fis = new FileInputStream(selectedFile);
                byte[] imageData = new byte[(int) selectedFile.length()];
                fis.read(imageData);
                fis.close();
                
                // Thay đổi kích thước của hình ảnh trước khi hiển thị
                ImageIcon imageIcon = new ImageIcon(imageData);
                Image image = imageIcon.getImage();
                int width = 150; // Độ rộng mong muốn
                int height = 150; // Độ cao mong muốn
                Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
                
                // Hiển thị hình ảnh đã thay đổi kích thước trên lblHinhAnh
                studentView.setHinhAnh(scaledImageIcon);
                
                // Lưu dữ liệu hình ảnh cho việc thêm hoặc chỉnh sửa sinh viên
                studentView.setPicture(imageData);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}


 
    
    class NAVtkiemButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            studentDao = new StudentFunc();
            List<Student> listDh = studentDao.getListStudents();
            studentView.showListStudents(listDh);
//            studentView.getThemDonMoi().setVisible(false);
//            studentView.getThemMonMoi().setVisible(false);
//            studentView.getTkePanel().setVisible(false);
//            studentView.getTkiemPanel().setVisible(true);
        }   
    }
    
    

    class SearchInforListener implements ActionListener  {
       public void actionPerformed(ActionEvent e) {                                                   
        DefaultTableModel obj = (DefaultTableModel) studentView.copiedTable.getModel();
        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
        studentView.copiedTable.setRowSorter(obj1);
        obj1.setRowFilter(RowFilter.regexFilter(studentView.searchField.getText()));
        
        }       
    }
    
    class dcmListener implements DocumentListener {
        public void insertUpdate(DocumentEvent e) {
            try {
                search();
            } catch (IOException ex) {
                studentView.showMessage("Lỗi ở đọcListener!");
            }
            }

            public void removeUpdate(DocumentEvent e) {
            try {
                search();
            } catch (IOException ex) {
                studentView.showMessage("Lỗi ở đọc Listener!");
            }
            }

            public void changedUpdate(DocumentEvent e) {
            try {
                search();
            } catch (IOException ex) {
                studentView.showMessage("Lỗi ở đọc Listener!");
            }
            }

            private void search() throws IOException {
                String s = studentView.getSearchField().getText();
                List<Student> dhss = new ArrayList<Student>();
                if(studentView.tuyChonTkiemDonHang() == 0){
                    
                    dhss = searchTheoNgay(s);
                }
                else if(studentView.tuyChonTkiemDonHang() == 1){
                    dhss = searchTheoTen(s);
                    
                }
                else if(studentView.tuyChonTkiemDonHang() == 2){
                    dhss = searchTheoId(s);
                }
                else{
                    dhss = searchTheoGoitiem(s);
                }
                
                // Cập nhật view 
                if(!dhss.isEmpty()){
                    studentView.showListStudents(dhss);
                    studentView.getMessageL().setVisible(false);
                }else{
                    studentView.WPNotif("Không tìm thấy dữ liệu bạn cần tìm, vui lòng nhập lại !!!");
                }
                
            }
    }
    
    public List<Student> searchTheoNgay(String s){
        List<Student> DhTmp = new ArrayList<Student>();
        this.studentDao = new StudentFunc();
        List<Student> ldh = this.studentDao.getListStudents();
       // SimpleDateFormat cvt = new SimpleDateFormat("dd/MM/yyyy");
        for(Student dh : ldh){
//            if( cvt.format(dh.getNt()).toLowerCase().contains(s.toLowerCase())){
//                DhTmp.add(dh);
//            }
                if(String.valueOf(dh.getNt()).contains(s)){
                DhTmp.add(dh);
            }
        }
        return DhTmp;
    }
    
    public List<Student> searchTheoId(String s){
        List<Student> DhTmp = new ArrayList<Student>();
        this.studentDao = new StudentFunc();
        List<Student> ldh = this.studentDao.getListStudents();
        for(Student dh : ldh){
            if(String.valueOf(dh.getId()).contains(s)){
                DhTmp.add(dh);
            }
        }
        return DhTmp;
    }
    
    public List<Student> searchTheoGoitiem(String s){
        List<Student> DhTmp = new ArrayList<Student>();
        this.studentDao = new StudentFunc();
        List<Student> ldh = this.studentDao.getListStudents();
        for(Student dh : ldh){
            if( String.valueOf(dh.getGt()).contains(s) ){
                DhTmp.add(dh);
            }
        }
        return DhTmp;
    }
    
    public List<Student> searchTheoTen(String s){
        List<Student> DhTmp = new ArrayList<Student>();
        this.studentDao = new StudentFunc();
        List<Student> ldh = this.studentDao.getListStudents();
        for(Student dh : ldh){
            if( String.valueOf(dh.getName()).contains(s) ){
                DhTmp.add(dh);
            }
        }
        
        return DhTmp;
    }
    /**
     * Lớp AddStudentListener 
     * chứa cài đặt cho sự kiện click button "Add"
     * 
     * @author viettuts.vn
     */
    class AddStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                studentDao.add(student);
                studentView.showStudent(student);
                
                studentView.showListStudents(studentDao.getListStudents());
                studentView.showMessage("Thêm thành công!");
                
            }
        }
    
    }

    /**
     * Lớp EditStudentListener 
     * chứa cài đặt cho sự kiện click button "Edit"
     * 
     * @author viettuts.vn
     */
    class EditStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            
            if (student != null) {
                studentDao.edit(student);
                
                studentView.showStudent(student);
                
                studentView.showListStudents(studentDao.getListStudents());
                studentView.showMessage("Cập nhật thành công!");
            }
        }
    }

    /**
     * Lớp DeleteStudentListener 
     * chứa cài đặt cho sự kiện click button "Delete"
     * 
     * @author viettuts.vn
     */
    class DeleteStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                studentDao.delete(student);
                studentView.clearStudentInfo();
                studentView.showListStudents(studentDao.getListStudents());
                studentView.showMessage("Xóa thành công!");
            }
        }
    }

    /**
     * Lớp ClearStudentListener 
     * chứa cài đặt cho sự kiện click button "Clear"
     * 
     * @author viettuts.vn
     */
    class ClearStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentView.clearStudentInfo();
        }
    }

    /**
     * Lớp SortStudentGPAListener 
     * chứa cài đặt cho sự kiện click button "Sort By GPA"
     * 
     * @author viettuts.vn
     */
    class SortStudentNumberListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentDao.sortStudentByNumber();
            studentView.showListStudents(studentDao.getListStudents());
        }
    }

    /**
     * Lớp SortStudentGPAListener 
     * chứa cài đặt cho sự kiện click button "Sort By Name"
     * 
     * @author viettuts.vn
     */
    class SortStudentNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentDao.sortStudentByName();
            studentView.showListStudents(studentDao.getListStudents());
        }
    }

    /**
     * Lớp ListStudentSelectionListener 
     * chứa cài đặt cho sự kiện chọn student trong bảng student
     * 
     * @author viettuts.vn
     */
    class ListStudentSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            try {
                studentView.fillStudentFromSelectedRow();
            } catch (ParseException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ChartPanel showBarChart(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        HashMap<String, Integer> hm = new HashMap<>();
        studentDao = new StudentFunc();
        SimpleDateFormat cvt = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<String> fourSort = new ArrayList<String>();
        for(Student dh : studentDao.getListStudents()){
            
            String dateString = dh.getNt();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = null;
            try {
                date = formatter.parse(dateString);
            } catch (ParseException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(hm.containsKey(cvt.format(date)) ){
                hm.put(cvt.format(date), hm.get(cvt.format(date)) + 1 );
            }else{
               hm.put(cvt.format(date), 1);
            }
            if(!fourSort.contains(cvt.format(date))){
                fourSort.add(cvt.format(date));
            //fourSort.add(date);
            }
            //fourSort.add(dh.getNt());
        } 
        Collections.sort(fourSort);
        //int maxValue = Collections.max(hm.values());
        System.out.println(fourSort);
        
        try{
            for(int i = fourSort.size() - 10; i <= fourSort.size() -1; i ++){
                int value = hm.get(fourSort.get(i));
                dataset.setValue(value, "Amount", fourSort.get(i));
            }      
        }catch(IndexOutOfBoundsException e){
            studentView.showMessage("Cần nhập đủ 7 ngày để hiển thị bảng thống kê");
        }
        JFreeChart chart = ChartFactory.createBarChart("Thống Kê Lượng Bệnh Nhân Mỗi Ngày","Ngày/Tháng/Năm","Người đăng kí", 
                                                        dataset, PlotOrientation.VERTICAL, false,true,false);
     
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        
       
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(0, 0, 139);
        renderer.setSeriesPaint(0, clr3);
        
        categoryPlot.setRenderer(renderer);
        
        ChartPanel barChartPanel = new ChartPanel(chart);
        
        barChartPanel.setPreferredSize(new Dimension(975, 400));
        barChartPanel.removeAll();
        barChartPanel.validate();
        
        return barChartPanel; 

        }
    
    public ChartPanel showPieChart(){
        DefaultPieDataset barDataset = new DefaultPieDataset( );
        JFreeChart piechart = ChartFactory.createPieChart("Tỉ Lệ Các Mũi Tiêm",barDataset, false,true,false);
        PiePlot piePlot =(PiePlot) piechart.getPlot();
        HashMap<String, Integer> hm = new HashMap<>();
        studentDao = new StudentFunc();
        for(Student dh : studentDao.getListStudents()){
                       
                if(hm.containsKey(dh.getGt())){
                    hm.put(dh.getGt(),hm.get(dh.getGt()) + 1);
                }else{
                    hm.put(dh.getGt(), 1);
                }      
        }         
        for(String n : hm.keySet()){
            System.out.println(n  + "  " + hm.get(n));
            barDataset.setValue(n ,hm.get(n));
            Random randomGenerator = new Random();
            int red = randomGenerator.nextInt(256);
            int green = randomGenerator.nextInt(256);
            int blue = randomGenerator.nextInt(256);
            Color randomColour = new Color(red,green,blue);
            piePlot.setSectionPaint(hm.get(n), randomColour);
        }
       
        piePlot.setBackgroundPaint(Color.white);
        ChartPanel barChartPanel = new ChartPanel(piechart);
        barChartPanel.setPreferredSize(new Dimension(350, 320));
        barChartPanel.removeAll();
        barChartPanel.validate();
        return barChartPanel;
    }
    
    
}
