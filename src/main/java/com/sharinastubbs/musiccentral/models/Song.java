package com.sharinastubbs.musiccentral.models;

import javax.persistence.*;

@Entity
public class Song {

    // Instance Variables and database relationship
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    // many to one database relationship: many songs to one artist
    @ManyToOne
    Artist artist;

    private String songTitle;
    private String linkToSong;
    private String imgSongURL;
    private String songGenre;

    public Song() {}

    public Song(String songTitle, String linkToSong, String imgSongURL, String songGenre, Artist artist) {
        this.songTitle = songTitle;
        this.linkToSong = linkToSong;
        this.imgSongURL = imgSongURL;
        this.songGenre = songGenre;
        this.artist = artist;
    }

    // Getters
    public String getSongTitle() {
        return songTitle;
    }

    public String getLinkToSong() {
        return linkToSong;
    }

    public String getImgSongURL() {
        return imgSongURL;
    }

    public String getSongGenre() {
        return songGenre;
    }

    public long getId() {
        return id;
    }

    public Artist getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "artist=" + artist +
                ", songTitle='" + songTitle + '\'' +
                '}';
    }
}

