package com.sharinastubbs.musiccentral.controllers;

import com.sharinastubbs.musiccentral.models.ApplicationUserRepository;
import com.sharinastubbs.musiccentral.models.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SongController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    ArtistRepository artistRepository;
//    @Autowired
//    SongRepository songRepository;
}
