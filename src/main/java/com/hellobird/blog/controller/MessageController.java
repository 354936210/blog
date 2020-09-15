package com.hellobird.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author HelloBird
 */
@Controller
@RequestMapping("/message")
public class MessageController {
    @RequestMapping
    public String article(){
        return "message";
    }

    @PostMapping("/leaveMessage")
    public String leaveMessage(@RequestParam String editorContent){
        System.out.println(editorContent);
        return  "redirect:/message";
    }
}
