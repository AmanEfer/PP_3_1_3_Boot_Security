package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.security.UserDetailsImpl;
@Controller
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public String index() {
        return "index";
    }

//    @GetMapping("/showUserInfo")
//    public String showUserInfo() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
//
//        System.out.println(userDetailsImpl.getPerson());
//
//        return "/index";
//    }
}
