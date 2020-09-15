package com.hellobird.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HelloBird
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @RequestMapping
    public String article(){
        return "index";
    }
}
