package com.cheng.classified.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheng.category.pojo.Categorypojo;
import com.cheng.classified.serviceImpl.ClassifiedServiceImpl;
import com.cheng.domain.Category;

@RequestMapping("/classified")
@Controller
public class ClassifiedController {
    @Autowired
    private ClassifiedServiceImpl classifiedServiceImpl;

    /*
     * 查询分类列表
     */
    @RequestMapping("/getcategory")
    public String getCategory(Model model) throws Exception {
        List<Categorypojo> categorys = classifiedServiceImpl.getCategory();
        model.addAttribute("categorys", categorys);
        return "/adminjsps/admin/category/list";
    }

    /*
     * 添加二级分类列表页面
     */
    @RequestMapping("toadd2")
    public String toAdd2(Model model) throws Exception {
        List<Categorypojo> categorys = classifiedServiceImpl.getCategory();
        model.addAttribute("categorys", categorys);
        return "/adminjsps/admin/category/add2";
    }

    /*
     * 添加一级分类列表
     */
    @RequestMapping("/add")
    public String add(Category category, Model model) {
        String msg = classifiedServiceImpl.add(category);
        model.addAttribute("msg", msg);
        if ("添加失败，该列表已存在！".equals(msg)) {
            return "/adminjsps/admin/category/add";
        }
        model.addAttribute("link", "getcategory");
        return "/adminjsps/admin/msg";
    }

    /*
     * 修改一级分类列表页面
     */
    @RequestMapping("/toedit/{cid}")
    public String toEdit(@PathVariable String cid, Model model) {
        Category category = classifiedServiceImpl.toEdit(cid);
        model.addAttribute("category", category);
        return "/adminjsps/admin/category/edit";
    }

    /*
     * 修改二级分类列表页面
     */
    @RequestMapping("/toedit2/{cid}")
    public String toEdit2(@PathVariable String cid, Model model)
            throws Exception {
        List<Categorypojo> categorys = classifiedServiceImpl.getCategory();
        model.addAttribute("categorys", categorys);
        Category category = classifiedServiceImpl.toEdit(cid);
        model.addAttribute("category", category);
        return "/adminjsps/admin/category/edit2";
    }

    /*
     * 修改分类列表
     */
    @RequestMapping("/edit")
    public String edit(Category category, Model model) {
        String msg = classifiedServiceImpl.edit(category);
        model.addAttribute("msg", msg);
        model.addAttribute("link", "getcategory");
        return "/adminjsps/admin/msg";
    }

    /*
     * 删除一级分类列表
     */
    @RequestMapping("/deletecategory1/{cid}")
    public String deleteCategory1(@PathVariable String cid, Model model) {
        String msg = classifiedServiceImpl.deleteCategory1(cid);
        model.addAttribute("msg", msg);
        model.addAttribute("link", "../getcategory");
        return "/adminjsps/admin/msg";
    }

    /*
     * 删除二级分类列表
     */
    @RequestMapping("/deletecategory2/{cid}")
    public String deleteCategory2(@PathVariable String cid, Model model) {
        String msg = classifiedServiceImpl.deleteCategory2(cid);
        model.addAttribute("msg", msg);
        model.addAttribute("link", "../getcategory");
        return "/adminjsps/admin/msg";
    }
}
