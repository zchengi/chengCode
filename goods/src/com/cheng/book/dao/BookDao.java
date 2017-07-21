package com.cheng.book.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cheng.dao.BookMapper;
import com.cheng.domain.Book;
import com.cheng.domain.BookExample;
import com.github.pagehelper.PageHelper;

@Repository
public class BookDao implements BookMapper {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> selectByCidForBooks(String cid) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andCidEqualTo(cid);
        return this.bookMapper.selectByExample(bookExample);
    }

    public List<Book> selectByCidForBookList(Integer page, Integer pagesize,
            String cid) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andCidEqualTo(cid);
        PageHelper.startPage(page, pagesize);
        return this.bookMapper.selectByExample(bookExample);
    }

    public List<Book> selectByPressForBooks(String press) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andPressEqualTo(press);
        return this.bookMapper.selectByExample(bookExample);
    }

    public List<Book> selectByAuthorForBooks(String author) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andAuthorEqualTo(author);
        return this.bookMapper.selectByExample(bookExample);
    }

    public List<Book> selectByBnameForBooks(String bname) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andBnameLike("%" + bname + "%");
        return this.bookMapper.selectByExample(bookExample);

    }

    public Book selectByBid(String bid) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andBidEqualTo(bid);
        return this.bookMapper.selectByExample(bookExample).get(0);
    }

    public List<Book> selectByCidForAllBook(String cid) {
        return this.bookMapper.selectByCidForAllBook(cid);
    }

    @Override
    public List<Book> selectForBooks(Book book) {
        return this.bookMapper.selectForBooks(book);
    }

    @Override
    public int countByExample(BookExample example) {
        return this.bookMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(BookExample example) {
        return this.bookMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String bid) {
        return this.bookMapper.deleteByPrimaryKey(bid);
    }

    @Override
    public int insert(Book record) {
        return this.bookMapper.insert(record);
    }

    @Override
    public int insertSelective(Book record) {
        return this.bookMapper.insertSelective(record);
    }

    @Override
    public List<Book> selectByExample(BookExample example) {
        return this.bookMapper.selectByExample(example);
    }

    @Override
    public Book selectByPrimaryKey(String bid) {
        return this.bookMapper.selectByPrimaryKey(bid);
    }

    @Override
    public int updateByExampleSelective(Book record, BookExample example) {
        return this.bookMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Book record, BookExample example) {
        return this.bookMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return this.bookMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return this.bookMapper.updateByPrimaryKey(record);
    }

}
