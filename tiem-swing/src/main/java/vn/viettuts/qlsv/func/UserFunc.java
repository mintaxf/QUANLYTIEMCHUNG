package vn.viettuts.qlsv.func;

import vn.viettuts.qlsv.entity.User;

public class UserFunc {
    public boolean checkUser(User user) {
        if (user != null) {
            if ("".equals(user.getUserName()) 
                    && "".equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
