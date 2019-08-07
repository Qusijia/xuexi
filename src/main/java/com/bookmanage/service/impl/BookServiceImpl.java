package com.bookmanage.service.impl;



import com.bookmanage.mapper.BookMapper;
import com.bookmanage.model.Book;
import com.bookmanage.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public void insertBook(Book book) {
        bookMapper.insertBook(book);
    }

    @Override
    public void deleteBook(String book_id) {
        bookMapper.deleteBook(book_id);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public Book findByBookId(String book_id) {
        return bookMapper.findByBookId(book_id);
    }

    @Override
    public List<Book> findAll() {
        return bookMapper.findAll();
    }

    @Override
    public PageInfo listBookByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Book> bookList=bookMapper.findAll();
        PageInfo pageInfo=new PageInfo(bookList);
        return pageInfo;
    }

    @Override
    public PageInfo listBookAndRankByPage(int pageNum, int pageSize, int rank) {
        PageHelper.startPage(pageNum, pageSize);
        List<Book> bookList=bookMapper.findByRank(rank);
        PageInfo pageInfo=new PageInfo(bookList);
        return pageInfo;
    }
}
