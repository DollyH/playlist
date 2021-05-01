package com.spotify.playlist.service;

import com.spotify.playlist.domain.Playlist;
import com.spotify.playlist.repository.PlaylistRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public Mono<Playlist> getPlaylistByName(String name) {
        return playlistRepository.findPlaylistByName(name);
    }

    public Flux<Playlist> getPlaylistsByGenre(String genre) {
        return playlistRepository.findPlaylistsByGenre(genre);
    }
}
