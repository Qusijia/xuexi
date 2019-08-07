package com.bookmanage.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Reader {
    private int reader_id;//读者编号
    private String reader_name;//读者姓名
    private int reader_age;//读者年龄
    private int reader_sex;//读者性别
    private int reader_type;//读者类型 0:学生 1：教师
    private int reader_phone;//读者电话
    private String reader_department;//读者院系
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date reader_date;//注册时间
    private int admin_id;//管理员编号


    public int getReader_type() {
        return reader_type;
    }

    public void setReader_type(int reader_type) {
        this.reader_type = reader_type;
    }

    public String getReader_name() {
        return reader_name;
    }

    public void setReader_name(String reader_name) {
        this.reader_name = reader_name;
    }

    public int getReader_age() {
        return reader_age;
    }

    public void setReader_age(int reader_age) {
        this.reader_age = reader_age;
    }

    public int getReader_sex() {
        return reader_sex;
    }

    public void setReader_sex(int reader_sex) {
        this.reader_sex = reader_sex;
    }

    public int getReader_phone() {
        return reader_phone;
    }

    public void setReader_phone(int reader_phone) {
        this.reader_phone = reader_phone;
    }

    public String getReader_department() {
        return reader_department;
    }

    public void setReader_department(String reader_department) {
        this.reader_department = reader_department;
    }

    public Date getReader_date() {
        return reader_date;
    }

    public void setReader_date(Date reader_date) {
        this.reader_date = reader_date;
    }


    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }
}
