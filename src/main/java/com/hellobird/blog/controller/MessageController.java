package com.hellobird.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HelloBird
 */
@Controller
@RequestMapping("/message")
public class MessageController {
    @RequestMapping("")
    public String article(){
        return "message";
    }
}
