package com.hellobird.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HelloBird
 */
@Controller
@RequestMapping("/diary")
public class DiaryController {
    @RequestMapping("")
    public String article(){
        return "diary";
    }
}
