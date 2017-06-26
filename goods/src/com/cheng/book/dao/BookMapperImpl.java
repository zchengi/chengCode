package com.cheng.book.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cheng.dao.BookMapper;
import com.cheng.domain.Book;
import com.cheng.domain.BookExample;
import com.github.pagehelper.PageHelper;

@Repository
public class BookMapperImpl implements BookMapper {

	@Autowired
	private BookMapper bookMapper;

	public List<Book> selectByCidForBooks(String cid) {
		BookExample bookExample = new BookExample();
		bookExample.createCriteria().andCidEqualTo(cid);
		return bookMapper.selectByExample(bookExample);
	}

	public List<Book> selectByCidForBookList(Integer page, Integer pagesize,
			String cid) {
		BookExample bookExample = new BookExample();
		bookExample.createCriteria().andCidEqualTo(cid);
		PageHelper.startPage(page, pagesize);
		return bookMapper.selectByExample(bookExample);
	}

	public List<Book> selectByPressForBooks(String press) {
		BookExample bookExample = new BookExample();
		bookExample.createCriteria().andPressEqualTo(press);
		return bookMapper.selectByExample(bookExample);
	}

	public List<Book> selectByAuthorForBooks(String author) {
		BookExample bookExample = new BookExample();
		bookExample.createCriteria().andAuthorEqualTo(author);
		return bookMapper.selectByExample(bookExample);
	}

	public List<Book> selectByBnameForBooks(String bname) {
		BookExample bookExample = new BookExample();
		bookExample.createCriteria().andBnameLike("%" + bname + "%");
		return bookMapper.selectByExample(bookExample);

	}

	public Book selectByBid(String bid) {
		BookExample bookExample = new BookExample();
		bookExample.createCriteria().andBidEqualTo(bid);
		return bookMapper.selectByExample(bookExample).get(0);
	}

	public List<Book> selectByCidForAllBook(String cid) {
		return this.bookMapper.selectByCidForAllBook(cid);
	}

	@Override
	public List<Book> selectForBooks(Book book) {
		return this.selectForBooks(book);
	}

	@Override
	public int countByExample(BookExample example) {
		return 0;
	}

	@Override
	public int deleteByExample(BookExample example) {
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String bid) {
		return 0;
	}

	@Override
	public int insert(Book record) {
		return 0;
	}

	@Override
	public int insertSelective(Book record) {
		return 0;
	}

	@Override
	public List<Book> selectByExample(BookExample example) {
		return null;
	}

	@Override
	public Book selectByPrimaryKey(String bid) {
		return null;
	}

	@Override
	public int updateByExampleSelective(Book record, BookExample example) {
		return 0;
	}

	@Override
	public int updateByExample(Book record, BookExample example) {
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Book record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Book record) {
		return 0;
	}

}
