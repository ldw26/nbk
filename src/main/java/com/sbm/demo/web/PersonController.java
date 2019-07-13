package com.sbm.demo.web;

import com.sbm.demo.bean.Person;
import com.sbm.demo.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author 不若为止
 * @version 1.0
 * @class PersonController
 * @package com.wzhi.tableserver.controller
 * @desc 个人信息交互
 * @copyright weizhi
 * @date 2018/09/04
 */
@RestController
@Slf4j
public class PersonController {
    @Autowired
    private PersonService service;

    @RequestMapping(value = "findAll")
    public List<Person> findAll(){

        System.out.println("查询所有的角色信息");
        //log.info("查询所有的角色信息");
        List<Person>  list= service.findAll();
        System.out.println(list);
        return list;
    }
}
