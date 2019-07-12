package com.sbm.demo.service;

import com.sbm.demo.bean.Person;
import com.sbm.demo.mapper.PersonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class PersonService  {

    @Autowired
    private PersonMapper mapper;

    public List<Person> findAll() {
        return mapper.findAll();
    }
}
