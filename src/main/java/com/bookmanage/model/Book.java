package com.bookmanage.model;

public class Book {
    private String book_id;//图书编号
    private String book_name;//图书名称
    private String book_author;//作者
    private String book_publisher;//出版社
    private double book_price;//金额
    private int book_rank=0;//图书等级 0：学生等级  1：教师等级
    private int book_num;//图书数量



    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_publisher() {
        return book_publisher;
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
    }

    public double getBook_price() {
        return book_price;
    }

    public void setBook_price(double book_price) {
        this.book_price = book_price;
    }

    public int getBook_rank() {
        return book_rank;
    }

    public void setBook_rank(int book_rank) {
        this.book_rank = book_rank;
    }

    public int getBook_num() {
        return book_num;
    }

    public void setBook_num(int book_num) {
        this.book_num = book_num;
    }


}
