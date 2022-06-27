package com.iflytek.datasourcemultiple.controller;

import com.iflytek.datasourcemultiple.dao.DimExtDao;
import com.iflytek.datasourcemultiple.entity.DimExtDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/")
public class TestController {

    @Resource
    DimExtDao dimExtDao;

    @GetMapping("/dimExtGet")
    public List<DimExtDTO> dimExtGet(){
        return dimExtDao.demoSelect();
    }

}
