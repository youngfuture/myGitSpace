package cn.enjoyedu.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类说明：
 */
@RestController
@RequestMapping("/btrace")
public class DemoController {

    @RequestMapping("/test")
    public String test(@RequestParam("name") String name){
        return "hello,"+name;
    }

    @RequestMapping("/exception")
    public String exception(){
        try {
            System.out.println("start.......");
            System.out.println(1/0);
            System.out.println("end.........");
        } catch (Exception e) {

        }
        return "success";
    }

}
