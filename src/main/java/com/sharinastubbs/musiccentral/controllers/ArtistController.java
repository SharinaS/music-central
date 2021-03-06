package com.sharinastubbs.musiccentral.controllers;

import com.sharinastubbs.musiccentral.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;

// a logged in user can see their favorite artists, pulled from the database,
// and add another favorite artist to the database.

@Controller
public class ArtistController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    SongRespository songRespository;


    @GetMapping("/artists")
    public String showArtistsThatHaveBeenSavedInDatabase(Principal p, Model m){
        // p is the logged in user, so get user's name if logged in.
        if (p != null) {
            m.addAttribute("username", p.getName());
        }
        // get the name of the user via the Java Persistence API (JPA), and put user's artists into a list
        ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
        List<Artist> listOfArtistsUserLikes = user.getArtists();
        // add the list to the model so the view can access it
        m.addAttribute("artistsList", listOfArtistsUserLikes);
        return "artists";
    }


    @PostMapping("/artists")
    public RedirectView addArtistToDatabase(Principal p, Model m, String artistName, String artistImageURL){
        if (p != null) {
            m.addAttribute("username", p.getName());
        }
        //TODO: Consider making a timestamp for artists, to organize them from new to old, etc.
        ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
        // create a new artist and associate artist with current user
        Artist artist = new Artist(artistName, artistImageURL, user);
        // save the new artist into the relational database
        artistRepository.save(artist);
        return new RedirectView("/artists");
    }


    @PostMapping("/artist/delete")
    public RedirectView deleteArtistFromDatabaseAndAssociatedSongs (Long artistId) {
        // set a variable as the artist id and get a list of all the artists songs
        Artist artist = artistRepository.getOne(artistId);
        List<Song> listOfArtistSongs = artist.getSongs();

        // if the list is full, delete the songs from the song repo by their id, otherwise, just delete the artist.
        if(!listOfArtistSongs.isEmpty()) {
            for (Song song : listOfArtistSongs) {
                Long songId = song.getId();
                songRespository.deleteById(songId);
            }
        }
        artistRepository.deleteById(artistId);
        return new RedirectView("/artists");
    }


    // With button click of 'Edit,' a form apears for user to edit and save the updated artist data
    @PostMapping("/artist/edit")
    public RedirectView editArtistDetails (Long artistId, String newArtistName, String newImgArtistURL) {

        // set old artist details to the new artist details
        Artist artistBeingEdited = artistRepository.getOne(artistId);
        artistBeingEdited.setArtistName(newArtistName);
        artistBeingEdited.setArtistImageURL(newImgArtistURL);

        // save into repository
        artistRepository.save(artistBeingEdited);

        // stay at view of artists
        return new RedirectView("/artists");
    }

    //TODO: Add dummy image for when a user adds a musician and for when they add a song.
}
