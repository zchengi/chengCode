package com.cheng.user.service;

import java.util.List;

import com.cheng.domain.User;
import com.cheng.user.vo.UserPwdVo;

public interface UserService {
    void regUser(User user);

    List<String> activation(String activationCode);

    User login(User user);

    boolean editPwd(UserPwdVo vo, String uid);

}
