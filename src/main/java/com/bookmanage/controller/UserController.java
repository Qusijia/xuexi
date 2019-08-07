package com.bookmanage.controller;


import com.bookmanage.model.*;
import com.bookmanage.service.*;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "管理员功能")
public class UserController {

    @Autowired
    BookService bookService;//图书Service

    @Autowired
    ReaderService readerService;

    @Autowired
    LendInfoService lendInfoService;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;


    @ApiOperation(value = "用户权限", notes = "用户权限信息")
    @GetMapping("/findAction")
    public User findAction(HttpSession session) {

        session.setAttribute("id",1);

        int id=(int)session.getAttribute("id");

        User users = userService.findRolesByUserid(id);

        List<Role> roles = users.getRoles();

        List<Role> list=new ArrayList<Role>();
        System.out.println(roles.size());

        for (int i = 0; i < roles.size(); i++) {

            Role role = roleService.findActionsByRoleid(roles.get(i).getRoleid());
            if(role.getRoleid()==1){
                list.clear();
                list.add(role);
                break;
            }
            list.add(role);
        }

        users.setRoles(list);
        return users;

    }


    @ApiOperation(value = "分页查询图书信息接口", notes = "查询图书信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "指定的页", name = "pageNum", paramType = "query"),
            @ApiImplicitParam(value = "指定页容量", name = "pageSize", paramType = "query"),
    })
    @GetMapping("/pageBook")
    public PageInfo findBookPage(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, HttpSession session) {

        int id = (int)session.getAttribute("id");
        Reader reader=readerService.findByReaderId(id);
        if(reader.getReader_type()==0){//学生
           return  bookService.listBookAndRankByPage(pageNum,pageSize,0);//学生等级看到的图书
        }
           return bookService.listBookByPage(pageNum, pageSize);//教师能够查看所有等级的图书信息
    }


    @ApiOperation(value = "借阅图书接口", notes = "借阅图书信息")
    @ApiImplicitParam(value = "指定的id", name="id",paramType = "path")
    @PostMapping("/addlend/{id}")
    public String lendBook(@PathVariable("id") String id, HttpSession session) {
        int admin_id = (int) session.getAttribute("id");
        if(lendInfoService.findByreaderIdAndbookIdAndState(admin_id,id,0)==null) {
            Book book = bookService.findByBookId(id);
            int num = book.getBook_num();
            if (num > 0) { //图书库存
                LendInfo lendInfo = new LendInfo();//添加借阅信息
                lendInfo.setReaderId(admin_id);
                lendInfo.setBookId(id);
                lendInfo.setLend_date(new Date(System.currentTimeMillis()));
                lendInfo.setState(0);
                lendInfoService.insertLendInfo(lendInfo);
                book.setBook_num(num - 1);//修改图书库存
                bookService.updateBook(book);
                return "success";
            } else {

                return "1";//图书库存不足
            }
        }else{

            return  "fail";//书籍还未还
        }
    }

    @ApiOperation(value = "归还图书记录接口", notes = "归还图书记录信息")
    @GetMapping("/findbackBook")
    public List<LendInfo> findbackBook(HttpSession session) {
        int id = (int) session.getAttribute("id");
        List<LendInfo> lendInfos = lendInfoService.findlendByAReadidAndState(id, 1);
        return lendInfos;
    }

    @ApiOperation(value = "待归还图书接口", notes = "待归还图书信息")
    @GetMapping("/findlendBook")
    public List<LendInfo> findlendBook(HttpSession session) {
        int id = (int) session.getAttribute("id");
        List<LendInfo> lendInfos = lendInfoService.findlendByAReadidAndState(id, 0);
        return lendInfos;
    }

    @ApiOperation(value = "归还图书接口", notes = "归还图书信息")
    @ApiImplicitParam(value = "指定的id",name="id", paramType = "path")
    @PutMapping("/addback/{id}")
    public String backBook(@PathVariable("id") String id, HttpSession session) {
        int admin_id = (int) session.getAttribute("id");

            Book book = bookService.findByBookId(id);
            int num = book.getBook_num();

            LendInfo lendInfo = lendInfoService.findByreaderIdAndbookIdAndState(admin_id, id,0);
            lendInfo.setBack_date(new Date(System.currentTimeMillis()));
            lendInfo.setState(1);
            lendInfoService.updateLendInfo(lendInfo);
            book.setBook_num(num + 1);//修改图书库存
            bookService.updateBook(book);

            return "success";
    }


}
