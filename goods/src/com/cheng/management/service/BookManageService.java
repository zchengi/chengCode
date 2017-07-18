package com.cheng.management.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cheng.category.pojo.Categorypojo;
import com.cheng.domain.Book;

public interface BookManageService {

	List<Categorypojo> getCategory();

	Categorypojo get2category(String cid);

	String addBook(Book book, MultipartFile image_w, MultipartFile image_b,
			String path);

	String edit(Book book);

	String delete(Book book, String path);
}
