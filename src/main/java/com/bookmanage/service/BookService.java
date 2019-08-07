package com.bookmanage.service;



import com.bookmanage.model.Book;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BookService {

    //图书上架
    void insertBook(Book book);

    //图书下架
    void deleteBook(String book_id);

    //修改图书信息
    void updateBook(Book book);

    //查询单个图书
    Book findByBookId(String book_id);

    //查询所有图书信息
    List<Book> findAll();

    PageInfo listBookByPage(int pageNum, int pageSize);

    PageInfo listBookAndRankByPage(int pageNum, int pageSize, int rank);
}
