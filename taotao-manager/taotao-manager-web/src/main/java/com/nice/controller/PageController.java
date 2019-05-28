package com.nice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转Controller
 * @author ningh
 */
@Controller
public class PageController {

    /**
     * 打开首页
     * @return String
     */
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String showpage(@PathVariable String page){
        return page;
    }
}
