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
        // p is the logged in user, so get user's name if logged in.
        if (p != null) {
            m.addAttribute("username", p.getName());
        }
        // get the name of the user via the Java Persistence API (JPA), put user's artists into a list,
        // and save list so the model of MVC can access it.
        ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
        List<Artist> listOfArtistsUserLikes = user.getArtists();
        m.addAttribute("artistsList", listOfArtistsUserLikes);
        return "artists";
    }

    @PostMapping("/artists")
    public RedirectView addArtist(Principal p, Model m, String artistName, String artistImageURL){
        if (p != null) {
            m.addAttribute("username", p.getName());
        }
        //TODO: Do I want artists associated with a timestamp, to organize them from new to old?

        ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
        // create a new artist and associate artist with current user
        Artist artist = new Artist(artistName, artistImageURL, user);
        // save the new artist into the relational database
        artistRepository.save(artist);
        return new RedirectView("/artists");
    }
}
