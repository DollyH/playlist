package com.spotify.playlist.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Playlist {
    @Id
    private String id;
    private String name;
    private String genre;
    private Set<String> tracks;
}
