package com.ssm.crud.controller;

import com.ssm.crud.entity.MXD;
import com.ssm.crud.entity.User;
import com.ssm.crud.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

//@ResponseBody
@Controller
public class adminController {

    @Autowired
    adminService adminservice;

    @GetMapping("/hh")
    public String hh(){
        return "index_test";
    }

    @GetMapping("/")
    public String test1(){
        return "index_test";
    }
    @GetMapping("/index.html")
    @ResponseBody
    public String test2(){
        return "test2/";
    }

    @GetMapping("/hello")
    public String hello(Map<String,Object> map){
        map.put("hello","米大都督");
        map.put("two","tree");
        map.put("msg","出错啦");
        map.put("secces","成功啦");
        return "index_test";
    }



    @GetMapping("/selectAll")
    public String selectAll(Map<String,Object> map) {
        List<User> users = adminservice.selectAll();
        map.put("user",users);
        return "admin-list";
    }

    @GetMapping("/selectid/{id}")
    public String selectById(@PathVariable("id") Integer id, Model model){
        User user = adminservice.selectById(id);
        model.addAttribute("user",user);
        return "user";
    }

    //登录请求，防止页面表单重复提交，采用重定向
    @GetMapping("/selectbyId")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
        if (!StringUtils.isEmpty(username) && password.equals("123456"))
        {
            session.setAttribute("username",username);
            return "redirect:/main.html";
        }else {
            map.put("msg","账号或密码错误");
            return "login";
        }

    }

    @GetMapping("/update")
    @ResponseBody
    public String updatetest(User user){
        System.out.println(user);
        User user1 = adminservice.updateById(user);
        return "成功";
    }

    //测试使用   update?userId=3&userName=66&userPass=mi191919&userEmail=1191998028@qq.com&userAddr=中国香港
    @GetMapping("/dete/{id}")
    @ResponseBody
    public String deletetest(@PathVariable("id") Integer id){
        adminservice.deleteTest(id);
        return "成功";
    }

    //?userId=null&userName="米大嘟嘟"&userPass="哈hou"&userEmail="112233445566@qq.com"&userAddr="黑背石家庄"
    @PutMapping("/insertuser")
    public int insertUser(User user){
        return adminservice.insertUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public int deleteUser(@PathVariable("id") Integer id){
        return adminservice.deleteUser(id);
    }

    @GetMapping("/Allmxd" )
    public List<MXD> deleteMXD(){
        return adminservice.selectAllmxd();
    }

}
