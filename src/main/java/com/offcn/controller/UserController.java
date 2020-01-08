package com.offcn.controller;

import com.offcn.UserService;
import com.offcn.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//.........我是控制层的头注释...............
@Controller
public class UserController {
    @Autowired
    UserService us;
    // 获取列表数据，将数据返回到列表模板
    @RequestMapping("/")
    public  String findAll(Model m){
        List<User> ulist = us.findAll();
        m.addAttribute("ulist",ulist);
        return "list";
    }
    //点击add按钮跳转添加页面
    @RequestMapping("/toAdd")
    public  String toAdd(Model m){

       return "useradd";
    }

    /**
     * 新的注释
     * @param user
     * @return
     */
    //添加用户
    @PostMapping("/add")
    public  String add(User user){
      us.add(user);
       return "redirect:/";
    }
    //点击编辑跳转到编辑页面
    @RequestMapping("toEdit/{id}")
    public  String toEdit(@PathVariable("id") Long id,Model m){
        User user = us.findOne(id);
        m.addAttribute("user",user);
        return "useredit";
    }
    //更新用户数据
    @PostMapping("update")
    public  String update(User user){
        us.update(user);
       return "redirect:/";
    }
    //删除数据
    @RequestMapping("/delete/{id}")
    public  String delete(@PathVariable("id") Long id){
       us.delete(id);
       return "redirect:/";
    }
}
