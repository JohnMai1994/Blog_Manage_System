package com.jiadong.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BlogController {
    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @GetMapping("/blogs")
    public String list() {


        return "admin/blogs";
    }

}
