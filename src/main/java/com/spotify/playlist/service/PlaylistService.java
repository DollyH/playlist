package com.spotify.playlist.service;

import com.spotify.playlist.domain.Playlist;
import com.spotify.playlist.repository.PlaylistRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public Mono<Playlist> getPlaylistByName(String name) {
        return playlistRepository.findByName(name);
    }

    public Flux<Playlist> getPlaylistsByGenre(String genre) {
        return playlistRepository.findAllByGenre(genre);
    }

    public Flux<String> getAllPlaylists() {
        Flux<Playlist> playlists = playlistRepository.findAll();
        return playlists.map(Playlist::getName);
    }
}
