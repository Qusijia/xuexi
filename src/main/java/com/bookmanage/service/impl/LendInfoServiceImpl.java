package com.bookmanage.service.impl;

import com.bookmanage.mapper.LendInfoMapper;
import com.bookmanage.model.LendInfo;
import com.bookmanage.service.LendInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LendInfoServiceImpl implements LendInfoService {

    @Autowired
    LendInfoMapper lendInfoMapper;

    @Override
    public void insertLendInfo(LendInfo lendInfo) {
        lendInfoMapper.insertLendInfo(lendInfo);
    }

    @Override
    public void deleteLendInfo(int lend_id) {
        lendInfoMapper.deleteLendInfo(lend_id);
    }

    @Override
    public void updateLendInfo(LendInfo lendInfo) {
        lendInfoMapper.updateLendInfo(lendInfo);
    }

    @Override
    public LendInfo findByLendId(int lend_id) {
        return lendInfoMapper.findByLendId(lend_id);
    }

    @Override
    public List<LendInfo> findAll() {
        return lendInfoMapper.findAll();
    }

    @Override
    public PageInfo listLendInfoByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<LendInfo> bookList=lendInfoMapper.findAll();
        PageInfo pageInfo=new PageInfo(bookList);
        return pageInfo;
    }

    @Override
    public List<LendInfo>  findlendByAReadidAndState(int readerId, int state) {
        return lendInfoMapper.findlendByAReadidAndState(readerId,state);
    }

    @Override
    public LendInfo findByreaderIdAndbookId(int readerId, String bookId) {
        return lendInfoMapper.findByreaderIdAndbookId(readerId,bookId);
    }

    @Override
    public void deleteLendInfoByreaderId(int readerId) {
        lendInfoMapper.deleteLendInfoByreaderId(readerId);
    }

    @Override
    public List<LendInfo> findlendByBookAndState(String bookId, int state) {
        return lendInfoMapper.findlendByBookAndState(bookId,state);
    }

    @Override
    public void deleteLendInfoBybookId(String bookId) {
        lendInfoMapper.deleteLendInfoBybookId(bookId);
    }

    @Override
    public LendInfo findByreaderIdAndbookIdAndState(int readerId, String bookId, int state) {
        return lendInfoMapper.findByreaderIdAndbookIdAndState(readerId,bookId,state);
    }
}
