package com.cheng.category.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheng.category.dao.CategoryDao;
import com.cheng.category.pojo.Categorypojo;
import com.cheng.category.service.ICategorService;

@Service
public class CategoryServiceImpl implements ICategorService {

	@Autowired
	private CategoryDao categoryMapperImpl;

	/**
	 * 图书列表实现
	 */
	@Override
	public List<Categorypojo> getCategory() throws Exception {
		return categoryMapperImpl.selectAllcategorys();
	}

}
