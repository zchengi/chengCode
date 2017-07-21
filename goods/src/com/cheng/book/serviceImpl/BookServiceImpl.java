package com.cheng.book.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheng.book.dao.BookDao;
import com.cheng.book.service.BookService;
import com.cheng.domain.Book;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookMapperImpl;

    /**
     * 查询所有书籍
     */
    @Override
    public List<Book> getBooks(String cid) {
        return bookMapperImpl.selectByCidForBooks(cid);

    }

    @Override
    public List<Book> getAuthor(String author) {

        return bookMapperImpl.selectByAuthorForBooks(author);
    }

    @Override
    public List<Book> getPress(String press) {

        return bookMapperImpl.selectByPressForBooks(press);
    }

    @Override
    public List<Book> searchBook(String bname) {

        return bookMapperImpl.selectByBnameForBooks(bname);
    }

    @Override
    public List<Book> getBookgj(Book book) {
        return bookMapperImpl.selectForBooks(book);
    }

    @Override
    public List<Book> selectForBooks(Book book) {
        return bookMapperImpl.selectForBooks(book);
    }

    public Book selectByBid(String bid) {
        return bookMapperImpl.selectByBid(bid);
    }

    /**
     * 图书分页
     */
    public List<Book> pageHelper(Integer page, Integer pagesize, String cid) {
        List<Book> books = bookMapperImpl.selectByCidForBookList(page,
                pagesize, cid);
        return books;
    }
}
