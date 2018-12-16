package com.akulinski.poolsapplication.core.components.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private static final String USERNAME = "USERNAME";

    @GetMapping("/")
    public String greeting(HttpServletRequest httpServletRequest, Model model) {
        model.addAttribute(USERNAME, httpServletRequest.getUserPrincipal().getName());
        return "HomePage";
    }

    @GetMapping("/user")
    public String useringo(HttpServletRequest httpServletRequest, Model model) {


        return "UserInfo";
    }
}
