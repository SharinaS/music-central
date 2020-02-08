package com.sharinastubbs.musiccentral.controllers;

import com.sharinastubbs.musiccentral.models.ApplicationUser;
import com.sharinastubbs.musiccentral.models.ApplicationUserRepository;
import com.sharinastubbs.musiccentral.models.ArtistRepository;
import com.sharinastubbs.musiccentral.models.SongRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class SongController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    SongRespository songRespository;

//    @GetMapping("/artists")
//    public String getSongsForEachArtist (@PathVariable long id, Principal p, Model m) {
//        if (p != null) {
//            m.addAttribute("username", p.getName());
//        }
//        //TODO: I'm at the artists page. I click on an artist, it has to access the id of the artist, pass that over
//        // via the model so the controller knows which id to use to then use that id to access the database, to then
//        // pull the artist info from the database. Then, I can create a list of songs associated with that artist id,
//        // to then display on the songs page.
//
////        // get the user and make it available to the model
////        ApplicationUser user = applicationUserRepository.getOne(id);
////        m.addAttribute("user", user);
//
//        // get the artist, which I have access to from the Model, because of what is in Thymeleaf over in the HTML.
////        m.addAttribute("artist", artistRepository.getOne(id));
//        // collect a list of songs of that artist.
//        return "home";
//    }
}
