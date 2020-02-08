package com.sharinastubbs.musiccentral.models;

import javax.persistence.*;

@Entity
public class Artist {
    // Instance Variables and database relationship
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    ApplicationUser user;

    //TODO: Set up DB wiring to Song class.

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

    // ToString
    @Override
    public String toString() {
        return String.format("The artist is %s and the url to the image is %s", this.artistName, this.artistImageURL);
    }


//    public class Song {
//        //TODO: Wire into database - for each artist, there are many songs.
//        // Consider: Sometimes there are many artists for each song (many to many)
//
//        // Instance Variables
//        private String songTitle;
//        private String linkToSongOnYouTube;
//        private String imgSongURL;
//        private String songGenre;
//
//        public Song() {}
//
//        public Song(String songTitle, String linkToSongOnYouTube, String imgSongURL, String songGenre) {
//            this.songTitle = songTitle;
//            this.linkToSongOnYouTube = linkToSongOnYouTube;
//            this.imgSongURL = imgSongURL;
//            this.songGenre = songGenre;
//        }
//
//        // Getters
//        public String getSongTitle() {
//            return songTitle;
//        }
//
//        public String getLinkToSongOnYouTube() {
//            return linkToSongOnYouTube;
//        }
//
//        public String getImgSongURL() {
//            return imgSongURL;
//        }
//
//        public String getSongGenre() {
//            return songGenre;
//        }
//    }
}
