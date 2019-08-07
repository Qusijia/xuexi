package com.bookmanage.controller;


import com.bookmanage.model.Book;
import com.bookmanage.model.LendInfo;
import com.bookmanage.model.Reader;
import com.bookmanage.model.Role;
import com.bookmanage.service.BookService;
import com.bookmanage.service.LendInfoService;
import com.bookmanage.service.ReaderService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/admin")
@Api(value = "管理员功能")
public class AdminController {

    @Autowired
    BookService bookService;//图书Service

    @Autowired
    ReaderService readerService;////读者Service

    @Autowired
    LendInfoService lendInfoService;


    @ApiOperation(value = "增加图书信息接口", notes = "增加图书信息")
    @ApiImplicitParam(value="增加的图书信息",name="book",paramType="body")
    @PostMapping("/addBook")
    public String  addBook(@RequestBody Book book,HttpSession session){

                System.out.println("进入add");
                bookService.insertBook(book);
                return "success";

    }

    @ApiOperation(value = "删除图书信息接口", notes = "删除图书信息")
    @ApiImplicitParam(value="指定的id",name="id",paramType="path")
    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")String id,HttpSession session) {

        List<LendInfo> lendInfos = lendInfoService.findlendByBookAndState(id, 0);
        if (lendInfos.size() != 0) {
            return "fail";//有读者借阅书籍未还
        }

                lendInfoService.deleteLendInfoBybookId(id);
                bookService.deleteBook(id);
                return "success";

    }

    @ApiOperation(value = "修改图书信息接口", notes = "修改图书信息")
    @ApiImplicitParam(value="修改的图书信息",name="book",paramType="body")
    @PutMapping("/updateBook")
    public String  updateBook(@RequestBody Book book,HttpSession session){

                System.out.println("进入update");
                bookService.updateBook(book);

                return "success";

    }


    @ApiOperation(value = "分页查询图书信息接口", notes = "查询图书信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value="指定的页",name="pageNum",paramType="query"),
            @ApiImplicitParam(value="指定页容量",name="pageSize",paramType="query"),
    })
    @GetMapping("/pageBook")
    public PageInfo findBookPage(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){

        return bookService.listBookByPage(pageNum,pageSize);
    }



    @ApiOperation(value = "增加读者信息接口", notes = "增加读者信息")
    @ApiImplicitParam(value="增加的读者信息",name="reader",paramType="body")
    @PostMapping("/addReader")
    public String  addReader(@RequestBody Reader reader, HttpSession session){
        System.out.println("进入add");
        reader.setAdmin_id((int)session.getAttribute("id"));
        readerService.insertReader(reader);

                return "success";
    }

    @ApiOperation(value = "修改读者信息接口", notes = "修改读者信息")
    @ApiImplicitParam(value="修改的读者信息",name="reader",paramType="body")
    @PutMapping("/updateReader")
    public String  updateReader(@RequestBody Reader reader, HttpSession session){


                System.out.println("进入update");
                reader.setAdmin_id((int)session.getAttribute("id"));
                readerService.updateReader(reader);
                return "success";

    }

    @ApiOperation(value = "删除读者信息接口", notes = "删除读者信息")
    @ApiImplicitParam(value="指定的id",name="id",paramType="path")
    @DeleteMapping("/deleteReader/{id}")
    public String deleteReader(@PathVariable("id")int id, HttpSession session){
        List<LendInfo> lendInfos=lendInfoService.findlendByAReadidAndState(id,0);
        if(lendInfos.size()!=0){
            return "fail";//有未还书籍
        }

        lendInfoService.deleteLendInfoByreaderId(id);
        readerService.deleteReader(id);

        return "success";

    }

    @ApiOperation(value = "分页查询所有读者信息接口", notes = "查询读者信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value="指定的页",name="pageNum",paramType="query"),
            @ApiImplicitParam(value="指定页容量",name="pageSize",paramType="query"),
    })
    @GetMapping("/pageReader")
    public PageInfo findReaderPage(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, HttpSession session){

                return readerService.listReaderByPage(pageNum, pageSize);

    }

    @ApiOperation(value = "分页查询处理的读者信息接口", notes = "查询处理的读者信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value="指定的页",name="pageNum",paramType="query"),
            @ApiImplicitParam(value="指定页容量",name="pageSize",paramType="query"),
    })
    @GetMapping("/pageReaderByAdmin")
    public PageInfo findReaderByAdminPage(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, HttpSession session){
        int id=(int)session.getAttribute("id");
        return readerService.listReaderAndAdminByPage(pageNum,pageSize,id);
    }

}
