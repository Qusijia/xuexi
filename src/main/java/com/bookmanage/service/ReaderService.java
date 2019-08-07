package com.bookmanage.service;

import com.bookmanage.model.Reader;
import com.github.pagehelper.PageInfo;


import java.util.List;

public interface ReaderService {


    void insertReader(Reader reader);


    void deleteReader(int reader_id);


    void updateReader(Reader reader);


    Reader findByReaderId(int reader_id);


    List<Reader> findAll();

    PageInfo listReaderByPage(int pageNum, int pageSize);

    PageInfo listReaderAndAdminByPage(int pageNum, int pageSize, int admin_id);

    List<Reader> findByAdmin(int admin_id);
}
