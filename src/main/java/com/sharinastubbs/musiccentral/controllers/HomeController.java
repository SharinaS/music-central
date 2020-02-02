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
            m.addAttribute("username", p.getName());
        }
        return "home";
        //TODO: Create logic etc to have home page for logged in versus non-logged in users
    }
}
