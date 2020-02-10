package com.sharinastubbs.musiccentral.controllers;

import com.sharinastubbs.musiccentral.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class SongController {
    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    SongRespository songRespository;


    @GetMapping("/artists/{id}")
    public String getDetailViewOfAnArtistAndSongs (@PathVariable long id, Principal p, Model m) {
        if (p != null) {
            m.addAttribute("username", p.getName());
        }
        // get the id of the artist via the Model to put into URL, and head to the view called songs,
        m.addAttribute("artist", artistRepository.getOne(id));
        return "songs";
    }

    // takes the information gathered in the form and adds it to the database
    @PostMapping("artists/{id}")
    public RedirectView addSongToDatabase(@PathVariable long id,
                                          String songTitle,
                                          String linkToSong,
                                          String imgSongURL,
                                          String songGenre) {
        // find artist in the db and grab their id, so song will belong to that artist.
        Artist artist = artistRepository.getOne(id);
        Song newSong = new Song (songTitle, linkToSong, imgSongURL, songGenre, artist);
        songRespository.save(newSong);
        return new RedirectView("/artists/" + id);
    }

   @PostMapping("/song/delete")
    public RedirectView deleteSongFromDatabase (Long songId, Long artistId) {
        songRespository.deleteById(songId);
        return new RedirectView("/artists/" + artistId);
   }

    // TODO: add in JS alert - are you sure you want to delete song?

    @PostMapping("/song/edit")
    public RedirectView updateSongDetails(Long songId, Long artistId, Model m) {
        // when user clicks on the update button, the information about that song is collected in a list from the
        // DB. Over in th, iterate through that list and populate the form with that info. Or, can we just
        // do it through the model? Send the songName via the model, for example, and have th update the form.

        // add the data about the song to the model
        m.addAttribute("songId", songRespository.getOne(songId).getSongTitle());
        m.addAttribute("linkToSong", songRespository.getOne(songId).getLinkToSong());
        m.addAttribute("imgSongURL", songRespository.getOne(songId).getImgSongURL());
        m.addAttribute("songGenre", songRespository.getOne(songId).getSongGenre());

        return new RedirectView("/artists/" + artistId);
    }
}
