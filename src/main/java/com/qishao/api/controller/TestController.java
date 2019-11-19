package com.qishao.api.controller;

import com.qishao.api.service.TestService;
import com.qishao.api.vo.TestScene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO desc of class
 *
 * @author liuzixi
 * date 2019/11/19
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/qishao/test")
    public String test(@RequestBody TestScene testScene) {
        testService.insertScene(testScene);
        return "success";
    }
}
