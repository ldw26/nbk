package com.sbm.demo.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.sbm.demo.bean.User;
import com.sbm.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/user/findOne")
    @ResponseBody
    public ModelAndView findOne(@RequestBody User user) {

        System.out.println(user);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("hello");

        modelAndView.addObject("key", 12345);

        //System.out.println("test");

        return modelAndView;
    }


    //TODO 查看全部user
    @RequestMapping("/user/findAll")
    public String findAll(Model m) {
        List<User> list = userService.selectAll();
        m.addAttribute("allUsers", list);
        return "user/userList";
    }

    /**
     * TODO 删除用户
     */
    @RequestMapping("/user/deleteUser")
    public String deleteUser(@RequestParam("uid") Integer uid) {
        userService.delete(uid);
        return "redirect:/user/findAll";  //删除等操作需要重定向
    }

    //TODO 添加新用户的请求
    @RequestMapping("/user/editUser")
    public String toAddUserPage(@RequestParam("uid") int id, Model model) {
        User user = userService.selectOne(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    /**
     * TODO 保存用户
     */
    @RequestMapping(value = "/user/userSave", method = RequestMethod.POST) //表示只处理post方式过来的信息
    public String saveUser(User u) {
        userService.save(u);
        return "redirect:/user/findAll";
    }

    //TODO 访问html静态资源的请求
    @RequestMapping("/user/hello")
    public String accessHtml() {
        System.out.println("访问html静态资源的请求");
        return "forward:/html/hello.html";
        //需要请求转发，不然经过视图解析器(不是jsp会有问题)
        //重定向也可以，但是一般不能让用户直接访问某一个页面，要有发送请求的步骤
    }

}
