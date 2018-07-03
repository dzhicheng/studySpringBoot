package com.dongzhic.study.controller;

import com.dongzhic.study.domain.Demo;
import com.dongzhic.study.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author dongzc
 * @date 2018/6/22 16:44
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girl;

    @RequestMapping(value = "/say/{id}", method = RequestMethod.GET)
    public String say (@PathVariable("id") Integer id) {
        return "id:" +id;
    }

//    @RequestMapping(value = "/say1", method = RequestMethod.GET)
    @GetMapping(value = "/say1")
    public String say1 (@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "id:" +id;
    }

    /**
     * sring boot默认使用json框架是jackson
     * @return
     */
    @RequestMapping(value = "/getDemo", method = RequestMethod.GET)
    public Demo getDemo () {

        Demo demo = new Demo();
        demo.setIt(1);
        demo.setName("张三");
        return demo;
    }
}
