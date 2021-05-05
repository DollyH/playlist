package com.spotify.playlist.controller;

import com.spotify.playlist.domain.Playlist;
import com.spotify.playlist.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {
    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("/{name}")
    private Mono<Playlist> getPlaylist(String name) {
        return playlistService.getPlaylistByName(name);
    }

    @GetMapping("type/{genre}")
    private Flux<Playlist> getPlaylistsByGenre(String genre) {
        return playlistService.getPlaylistsByGenre(genre);
    }

    @GetMapping("/all")
    private List<String> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }
}
