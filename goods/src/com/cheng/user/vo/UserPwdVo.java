package com.cheng.user.vo;

import com.cheng.domain.User;

public class UserPwdVo extends User {
    private String newpass;

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

}
