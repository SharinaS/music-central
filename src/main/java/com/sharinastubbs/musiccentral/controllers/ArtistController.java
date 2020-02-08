package com.sharinastubbs.musiccentral.controllers;

import com.sharinastubbs.musiccentral.models.ApplicationUser;
import com.sharinastubbs.musiccentral.models.ApplicationUserRepository;
import com.sharinastubbs.musiccentral.models.Artist;
import com.sharinastubbs.musiccentral.models.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;

// a logged in user can see their favorite artists and be able to quickly add in another favorite artist.

@Controller
public class ArtistController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    ArtistRepository artistRepository;

    @GetMapping("/artists")
    public String showArtists(Principal p, Model m){
        if (p != null) {
            m.addAttribute("username", p.getName());
        }
        return "artists";
    }

//    @PostMapping("/artists")
//    public RedirectView addArtist(String artistName, String artistImageURL){
//        Artist artist = new Artist(artistName, artistImageURL);
//        return new RedirectView("/artists");
//    }
}
