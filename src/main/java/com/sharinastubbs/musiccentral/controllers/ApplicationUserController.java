package com.sharinastubbs.musiccentral.controllers;

import com.sharinastubbs.musiccentral.models.ApplicationUser;
import com.sharinastubbs.musiccentral.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class ApplicationUserController {
    // Connection to user repository
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    // (bean added to WebSecurityConfig to allow for encoder)
    @Autowired
    PasswordEncoder passwordEncoder;

    //== GET routes for sign up page and login page ==
    @GetMapping("/signup")
    public String goToSignUpPage() {
        return "signup";
    }

    @GetMapping("/login")
    public String goToLoginPage() {
        return "login";
    }

    //== POST route for form data from account signup ==
    @PostMapping("/signup")
    public RedirectView signupForAccount(String username, String password, String firstname) {
        if (applicationUserRepository.findByUsername(username) == null) {
            // create and save a new user and let them stay logged in
            ApplicationUser newUser = new ApplicationUser(username, passwordEncoder.encode(password), firstname);
            applicationUserRepository.save(newUser);
            Authentication authentication = new UsernamePasswordAuthenticationToken(newUser,
                    null,
                    new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            //TODO: redirect over to albums page
            return new RedirectView("/");
        } else {
            // user needs to choose a different username. Note that taken is the param.
            return new RedirectView("/signup?taken=true");
        }
    }
}
