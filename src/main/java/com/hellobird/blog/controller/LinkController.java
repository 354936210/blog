package com.hellobird.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HelloBird
 */
@Controller
@RequestMapping("/link")
public class LinkController {
    @RequestMapping
    public String article(){
        return "link";
    }
}
