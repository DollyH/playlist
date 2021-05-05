package com.spotify.playlist.service;

import com.spotify.playlist.domain.Song;
import com.spotify.playlist.repository.SpotifyRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class SongService {
    private final SpotifyRepository spotifyRepository;

    public SongService(SpotifyRepository spotifyRepository) {
        this.spotifyRepository = spotifyRepository;
    }

    public Flux<Song> getAllSongs() {
        return spotifyRepository.getAllSongs();
    }
}
