package com.cheng.classified.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uuid.UUIDHelper;

import com.cheng.book.dao.BookDao;
import com.cheng.category.dao.CategoryDao;
import com.cheng.category.pojo.Categorypojo;
import com.cheng.classified.service.ClassifiedService;
import com.cheng.domain.Book;
import com.cheng.domain.Category;

@Service
public class ClassifiedServiceImpl implements ClassifiedService {

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private BookDao bookDao;

	@Override
	public List<Categorypojo> getCategory() throws Exception {
		return categoryDao.selectAllcategorys();
	}

	@Override
	public String deleteCategory1(String cid) {
		List<Category> categorys = categoryDao.selectByCidForPid(cid);
		if (categorys.size() > 0) {
			return "该一级分类存在子分类，无法删除！";
		}
		categoryDao.deleteByPrimaryKey(cid);
		return "删除成功!";
	}

	@Override
	public String deleteCategory2(String cid) {
		List<Book> books = bookDao.selectByCidForBooks(cid);
		if (books.size() > 0) {
			return "该二级分类下存在图书，无法删除！";
		}
		categoryDao.deleteByPrimaryKey(cid);
		return "删除成功!";
	}

	@Override
	public String add(Category category) {
		List<Category> categories = categoryDao.selectByCname(category);
		if (categories.size() == 0) {
			category.setCid(UUIDHelper.getUUID());
			categoryDao.insert(category);
			return "添加成功！";
		}
		return "添加失败，该列表已存在！";
	}

	public Category toEdit(String cid) {
		return categoryDao.selectByPrimaryKey(cid);
	}

	public String edit(Category category) {
		int i = categoryDao.updateByPrimaryKeySelective(category);
		if (i > 0) {
			return "修改成功！";
		}
		return "修改失败！";
	}
}
