package com.bookmanage.mapper;

import com.bookmanage.model.Book;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookMapper {

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

    //查询所有图书信息
    List<Book> findByRank(int book_rank);


}
