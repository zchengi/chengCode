package com.cheng.book.service;

import java.util.List;

import com.cheng.domain.Book;

public interface BookService {
	List<Book> getBooks(String cid);

	List<Book> getAuthor(String author);

	List<Book> getPress(String press);

	List<Book> searchBook(String bname);

	List<Book> getBookgj(Book book);

	List<Book> selectForBooks(Book book);

	Book selectByBid(String bid);

	List<Book> pageHelper(Integer page, Integer pagesize, String book);
}
