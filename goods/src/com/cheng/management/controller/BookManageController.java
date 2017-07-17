package com.cheng.management.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cheng.book.serviceImpl.BookServiceImpl;
import com.cheng.category.pojo.Categorypojo;
import com.cheng.domain.Book;
import com.cheng.management.serviceImpl.BookManageServiceImpl;
import com.github.pagehelper.PageInfo;

@RequestMapping("bookmanage")
@Controller
public class BookManageController {

	@Autowired
	private BookManageServiceImpl bookManageServiceImpl;
	@Autowired
	private BookServiceImpl bookServiceImpl;

	/**
	 * 图书列表
	 */
	@RequestMapping("/getcategory")
	public String getCategory(Model model) {
		List<Categorypojo> categorys = bookManageServiceImpl.getCategory();
		model.addAttribute("categorys", categorys);
		return "adminjsps/admin/book/left";
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
		return "adminjsps/admin/book/list";
	}

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
		return "adminjsps/admin/book/list";
	}

	/**
	 * 查询出版社所有作品
	 */
	@RequestMapping(value = "/getpress", method = RequestMethod.GET)
	public String getPress(String press, Model model) {
		List<Book> books = bookServiceImpl.getPress(press);
		model.addAttribute("books", books);
		return "adminjsps/admin/book/list";
	}

	/**
	 * desc
	 */
	@RequestMapping(value = "/selectbybid/{bid}", method = RequestMethod.GET)
	public String selectByBid(@PathVariable String bid, Model model) {
		Book book = bookServiceImpl.selectByBid(bid);
		model.addAttribute("book", book);
		List<Categorypojo> categorys = bookManageServiceImpl.getCategory();
		model.addAttribute("categorys", categorys);
		return "adminjsps/admin/book/desc";
	}

	/**
	 * 获取2级目录
	 */
	@RequestMapping(value = "get2category", method = RequestMethod.POST)
	public @ResponseBody Categorypojo get2Category(Model model, String cid) {
		return bookManageServiceImpl.get2category(cid);
	}

	/**
	 * 添加图书页
	 */
	@RequestMapping("toadd")
	public String toAdd(Model model) {
		List<Categorypojo> categorys = bookManageServiceImpl.getCategory();
		model.addAttribute("categorys", categorys);
		return "adminjsps/admin/book/add";
	}

	/**
	 * 添加图书
	 */
	@RequestMapping(value = "addbook", method = RequestMethod.POST)
	public String addBook(MultipartFile image_w, MultipartFile image_b,
			Book book, Model model, HttpServletRequest request) {
		String msg = bookManageServiceImpl.addBook(book, image_w, image_b,
				request.getSession().getServletContext()
						.getRealPath("book_img"));
		model.addAttribute("msg", msg);
		model.addAttribute("link", "../bookmanage/toadd");
		return "adminjsps/admin/msg";
	}

	/**
	 * 删除图书
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(Book book, Model model, HttpServletRequest request) {
		String msg = bookManageServiceImpl.delete(book, request.getSession()
				.getServletContext().getRealPath("/"));
		model.addAttribute("msg", msg);
		model.addAttribute("link", "../adminjsps/admin/book/body.jsp");
		return "adminjsps/admin/msg";
	}

	/**
	 * 修改图书
	 */
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(Book book, Model model) {
		String msg = bookManageServiceImpl.edit(book);
		model.addAttribute("msg", msg);
		model.addAttribute("link", "../adminjsps/admin/book/body.jsp");
		return "adminjsps/admin/msg";
	}

}
