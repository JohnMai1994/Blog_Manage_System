package com.jiadong.web.admin;

import com.jiadong.bean.User;
import com.jiadong.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.net.http.HttpResponse;

@Controller
@RequestMapping(value = "/admin")
public class LoginController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.checkUser(username,password);
        if (user!= null){
            System.out.println(user);
            user.setPassword(null);
            session.setAttribute("user", user);
            return "admin/index";
        }else {
            System.out.println("密码错误");
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }




}
