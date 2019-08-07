package com.bookmanage.mapper;


import com.bookmanage.model.Reader;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReaderMapper {

    void insertReader(Reader reader);


    void deleteReader(int reader_id);


    void updateReader(Reader reader);


    Reader findByReaderId(int reader_id);


    List<Reader> findAll();

    List<Reader> findByAdmin(int admin_id);

}
