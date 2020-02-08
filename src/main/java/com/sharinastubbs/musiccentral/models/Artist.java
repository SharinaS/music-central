package com.sharinastubbs.musiccentral.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Artist {

    // Instance Variables and database relationships
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    // many to one database relationship: many artists to one user
    @ManyToOne
    ApplicationUser user;

    // one to many database relationship: one artist to many songs
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "artist")
    List<Song> songs;

    private String artistName;
    private String artistImageURL;

    // Constructors
    public Artist() {}

    public Artist(String artistName, String artistImageURL, ApplicationUser user) {
        this.artistName = artistName;
        this.artistImageURL = artistImageURL;
        this.user = user;
    }

    // Getters
    public String getArtistName() {
        return artistName;
    }

    public String getArtistImageURL() {
        return artistImageURL;
    }

    public long getId() {
        return id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    // ToString
    @Override
    public String toString() {
        return String.format("The artist is %s and the url to the image is %s", this.artistName, this.artistImageURL);
    }
}
