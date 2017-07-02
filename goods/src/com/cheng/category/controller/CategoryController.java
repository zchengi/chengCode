package com.cheng.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheng.category.pojo.Categorypojo;
import com.cheng.category.serviceImpl.CategoryServiceImpl;

@RequestMapping("/category")
@Controller
public class CategoryController {
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	/**
	 * 图书列表
	 */
	@RequestMapping("/getcategory")
	public String getCategory(Model model) throws Exception {
		List<Categorypojo> categorys = categoryServiceImpl.getCategory();
		// System.out.println(categorys);
		model.addAttribute("categorys", categorys);
		return "jsps/left";
	}

}
