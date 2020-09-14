package com.hellobird.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HelloBird
 */
@Controller
@RequestMapping("/read")
public class ReadController {
    @RequestMapping("")
    public String article(){
        return "read";
    }
}
