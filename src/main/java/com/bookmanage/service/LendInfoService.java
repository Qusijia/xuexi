package com.bookmanage.service;

import com.bookmanage.model.LendInfo;
import com.github.pagehelper.PageInfo;


import java.util.List;

public interface LendInfoService {

    void insertLendInfo(LendInfo lendInfo);


    void deleteLendInfo(int lend_id);


    void updateLendInfo(LendInfo lendInfo);


    LendInfo findByLendId(int lend_id);

    LendInfo findByreaderIdAndbookId(int readerId, String bookId);


    List<LendInfo> findAll();

    List<LendInfo> findlendByAReadidAndState(int readerId, int state);

    List<LendInfo> findlendByBookAndState(String bookId, int state);

    PageInfo listLendInfoByPage(int pageNum, int pageSize);

    LendInfo findByreaderIdAndbookIdAndState(int readerId, String bookId,int state);

    void deleteLendInfoByreaderId(int readerId);

    void deleteLendInfoBybookId(String bookId);

}
