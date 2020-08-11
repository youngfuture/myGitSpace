package com.xx.autoconfig;


import com.xx.autoconfig.impl.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestMsgServiceController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/test")
    public void test() {
        contentService.doSomething();
        return;
    }

}
