package com.spotify.playlist.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Playlist {
    private Integer id;
    private String name;
    private String genre;
    private Set<Song> songs;

    public boolean addSong(Song song) {
        return songs.add(song);
    }

    public boolean removeSong(Song song) {
        return songs.remove(song);
    }
}
