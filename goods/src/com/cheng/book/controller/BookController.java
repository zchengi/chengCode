package com.cheng.book.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cheng.book.serviceImpl.BookServiceImpl;
import com.cheng.domain.Book;
import com.github.pagehelper.PageInfo;

@RequestMapping("/book")
@Controller
public class BookController {

	@Autowired
	private BookServiceImpl bookServiceImpl;

	/**
	 * 查询作者所有作品
	 */
	@RequestMapping(value = "/getauthor/{author}", method = RequestMethod.GET)
	public String getAuthor(@PathVariable String author, Model model) {
		try {
			author = new String(author.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		List<Book> books = bookServiceImpl.getAuthor(author);
		model.addAttribute("books", books);
		return "jsps/book/list";
	}

	/**
	 * 查询出版社所有作品
	 */
	@RequestMapping(value = "/getpress", method = RequestMethod.GET)
	public String getPress(String press, Model model) {
		List<Book> books = bookServiceImpl.getPress(press);
		model.addAttribute("books", books);
		return "jsps/book/list";
	}

	/**
	 * 简单查询
	 */
	@RequestMapping(value = "/searchbook", method = RequestMethod.POST)
	public String searchBook(String bname, Model model) {
		List<Book> books = bookServiceImpl.searchBook(bname);
		model.addAttribute("books", books);
		return "jsps/book/list";
	}

	/**
	 * 高级查询
	 */
	@RequestMapping(value = "/getbookgj", method = RequestMethod.POST)
	public String getBookgj(Book book, Model model) {
		List<Book> books = bookServiceImpl.getBookgj(book);
		model.addAttribute("books", books);
		return "jsps/book/list";
	}

	/**
	 * desc
	 */
	@RequestMapping(value = "/selectbybid/{bid}", method = RequestMethod.GET)
	public String selectByBid(@PathVariable String bid, Model model) {
		Book book = bookServiceImpl.selectByBid(bid);
		model.addAttribute("book", book);
		return "jsps/book/desc";
	}

	/**
	 * 图书分页
	 */
	@RequestMapping(value = "/pagehelper")
	public String pageHelper(
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "8") Integer pagesize,
			String cid, Model model) {
		List<Book> books = bookServiceImpl.pageHelper(page, pagesize, cid);
		PageInfo<Book> pageInfo = new PageInfo<Book>(books);
		model.addAttribute("books", books);
		model.addAttribute("page", pageInfo);
		return "jsps/book/list";
	}

}
