package com.spotify.playlist.service;

import com.spotify.playlist.domain.Playlist;
import com.spotify.playlist.repository.SpotifyRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PlaylistService {
    private final SpotifyRepository spotifyRepository;

    public PlaylistService(SpotifyRepository spotifyRepository) {
        this.spotifyRepository = spotifyRepository;
    }

    public Mono<Playlist> getPlaylistByName(String name) {
        return spotifyRepository.findPlaylistByName(name);
    }

    public Flux<Playlist> getPlaylistsByGenre(String genre) {
        return spotifyRepository.findPlaylistsByGenre(genre);
    }

    public List<String> getAllPlaylists() {
        return spotifyRepository.getAllPlaylists();
    }
}
