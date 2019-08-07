package com.bookmanage.service.impl;

import com.bookmanage.mapper.ReaderMapper;
import com.bookmanage.model.Reader;
import com.bookmanage.service.ReaderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    ReaderMapper readerMapper;


    @Override
    public void insertReader(Reader reader) {
        readerMapper.insertReader(reader);
    }

    @Override
    public void deleteReader(int reader_id) {
        readerMapper.deleteReader(reader_id);
    }

    @Override
    public void updateReader(Reader reader) {
        readerMapper.updateReader(reader);
    }

    @Override
    public Reader findByReaderId(int reader_id) {

        return readerMapper.findByReaderId(reader_id);
    }

    @Override
    public List<Reader> findAll() {
        return readerMapper.findAll();
    }

    @Override
    public PageInfo listReaderByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Reader> bookList=readerMapper.findAll();
        PageInfo pageInfo=new PageInfo(bookList);
        return pageInfo;
    }

    @Override
    public List<Reader> findByAdmin(int admin_id) {
        return readerMapper.findByAdmin(admin_id);
    }

    @Override
    public PageInfo listReaderAndAdminByPage(int pageNum, int pageSize, int admin_id) {
        PageHelper.startPage(pageNum, pageSize);
        List<Reader> bookList=readerMapper.findByAdmin(admin_id);
        PageInfo pageInfo=new PageInfo(bookList);
        return pageInfo;
    }
}
