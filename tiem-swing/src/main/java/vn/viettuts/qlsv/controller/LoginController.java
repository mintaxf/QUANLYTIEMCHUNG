package vn.viettuts.qlsv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vn.viettuts.qlsv.func.UserFunc;
import vn.viettuts.qlsv.entity.User;
import vn.viettuts.qlsv.func.UserFunc;
import vn.viettuts.qlsv.view.LoginView;
import vn.viettuts.qlsv.view.StudentView;

public class LoginController {
    private UserFunc userDao;
    private LoginView loginView;
    private StudentView studentView;
    private LoginCheck check=new LoginCheck();
    
    public LoginController(LoginView view) {
        this.loginView = view;
        this.userDao = new UserFunc();
        view.addLoginListener(new LoginListener());
    }
    
    public void showLoginView() {
        loginView.setVisible(true);
    }
    
    /**
     * Lớp LoginListener chứa cài đặt cho sự kiện click button "Login"
     * 
     * @author viettuts.vn
     */
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();
            if (userDao.checkUser(user)) {
                // nếu đăng nhập thành công, mở màn hình quản lý sinh viên
                studentView = new StudentView();
                StudentController studentController = new StudentController(studentView);
                studentController.showStudentView();
                loginView.setVisible(false);
            } else {
                if(check.Check()==false) 
                 {
                     while(check.Check()!=true)
                  {
                      loginView.showMessage("Bạn đã đăng nhập sai quá số lần, vui lòng thử lại sau"); 
                  }
                 } 
                 else{  
                loginView.showMessage("username hoặc password không đúng.");
                 }
            }
        }
    }
}
