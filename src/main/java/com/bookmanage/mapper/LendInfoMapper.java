package com.bookmanage.mapper;



import com.bookmanage.model.LendInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LendInfoMapper {


    void insertLendInfo(LendInfo lendInfo);


    void deleteLendInfo(int lend_id);


    void updateLendInfo(LendInfo lendInfo);


    LendInfo findByLendId(int lend_id);

    LendInfo findByreaderIdAndbookId(int readerId, String bookId);

    List<LendInfo> findlendByAReadidAndState(int readerId, int state);

    List<LendInfo> findlendByBookAndState(String bookId, int state);

    List<LendInfo> findAll();

    LendInfo findByreaderIdAndbookIdAndState(int readerId, String bookId,int state);

    void deleteLendInfoByreaderId(int readerId);

    void deleteLendInfoBybookId(String bookId);

}
