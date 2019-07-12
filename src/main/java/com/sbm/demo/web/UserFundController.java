package com.sbm.demo.web;

import com.sbm.demo.service.UserFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserFundController {

    @Autowired
    private UserFundService userFundService;

}
