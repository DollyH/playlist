package com.spotify.playlist.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Song {
    private Integer id;
    private String name;
    private List<String> artists;
    private String genre;
    private String image;

    public Song(Integer id, String name, List<String> artists, String genre, String image) {
        this.id = id;
        this.name = name;
        this.artists = artists;
        this.genre = genre;
        this.image = image;
    }
}
