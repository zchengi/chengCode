package com.cheng.management.serviceImpl;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import uuid.UUIDHelper;

import com.cheng.category.dao.CategoryDao;
import com.cheng.category.pojo.Categorypojo;
import com.cheng.domain.Book;
import com.cheng.management.dao.BookManageDao;
import com.cheng.management.service.BookManageService;

@Service
public class BookManageServiceImpl implements BookManageService {

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private BookManageDao bookManageDao;

	public List<Categorypojo> getCategory() {
		try {
			return categoryDao.selectAllcategorys();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Categorypojo get2category(String cid) {
		try {
			List<Categorypojo> selectAllcategorys = categoryDao
					.selectAllcategorys();
			for (Categorypojo categorypojo : selectAllcategorys) {
				if (cid.equals(categorypojo.getCid())) {
					return categorypojo;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String addBook(Book book, MultipartFile image_w,
			MultipartFile image_b, String path) {
		book.setImageB("book_img/" + image_b.getOriginalFilename());
		book.setImageW("book_img/" + image_w.getOriginalFilename());
		book.setBid(UUIDHelper.getUUID());

		BigDecimal price = book.getPrice();
		book.setCurrprice(price.multiply(new BigDecimal(Double.toString(0.1)))
				.multiply(book.getDiscount()));

		// 上传图片
		String image_b_name = image_b.getOriginalFilename();
		String image_w_name = image_w.getOriginalFilename();
		File targetFile1 = new File(path, image_b_name);
		File targetFile2 = new File(path, image_w_name);
		// 创建
		if (!targetFile1.exists() && !targetFile2.exists()) {
			targetFile1.mkdirs();
			targetFile2.mkdirs();
		}
		// 保存
		try {
			image_b.transferTo(targetFile1);
			image_w.transferTo(targetFile2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(book);
		int i = bookManageDao.insert(book);
		if (i > 0) {
			return "添加成功";
		}
		return "添加失败";
	}

	public String edit(Book book) {
		BigDecimal price = book.getPrice();
		book.setCurrprice(price.multiply(new BigDecimal(Double.toString(0.1)))
				.multiply(book.getDiscount()));
		System.out.println(book);
		int i = bookManageDao.updateByPrimaryKeySelective(book);
		if (i > 0) {
			return "修改成功";
		}
		return "修改失败";
	}

	public String delete(Book book, String path) {
		int i = bookManageDao.deleteByPrimaryKey(book.getBid());
		File file1 = new File(path + book.getImageB());
		File file2 = new File(path + book.getImageW());
		if (file1.exists() && file2.exists()) {
			file1.delete();
			file2.delete();
		}
		if (i > 0) {
			return "删除成功";
		}
		return "删除失败";
	}
}
