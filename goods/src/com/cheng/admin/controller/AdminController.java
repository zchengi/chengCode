package com.cheng.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cheng.admin.serviceImpl.AdminServiceImpl;
import com.cheng.domain.Admin;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    /**
     * 管理员登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Admin admin, Model Model, HttpSession session) {
        Admin searchAdmin = adminServiceImpl.login(admin);
        if (searchAdmin != null) {
            session.setAttribute("admin", searchAdmin);
            return "adminjsps/admin/index";
        } else {
            Model.addAttribute("errAdmin", admin);
            Model.addAttribute("msg", "管理员名或密码错误！");
            return "adminjsps/login";
        }
    }

    /**
     * 管理员退出
     */
    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.invalidate();
        return "adminjsps/login";
    }
}
