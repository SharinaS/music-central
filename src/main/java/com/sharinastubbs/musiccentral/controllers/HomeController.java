package com.sharinastubbs.musiccentral.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getHome(Principal p, Model m) {
        if (p != null) {
            // grab the username and use it to personalize the homepage
            m.addAttribute("username", p.getName());
            System.out.println("************ The username is " + p.getName());
        } else {
            System.out.println("There's nobody logged in :( ");
        }
        return "home";
    }
}
