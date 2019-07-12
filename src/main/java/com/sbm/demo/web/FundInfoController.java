package com.sbm.demo.web;

import com.sbm.demo.service.FundInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FundInfoController {
    @Autowired
    private FundInfoService fundInfoService;



}
