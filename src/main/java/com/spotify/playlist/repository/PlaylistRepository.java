package com.spotify.playlist.repository;

import com.spotify.playlist.domain.Playlist;
import com.spotify.playlist.domain.Song;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PlaylistRepository {

    private final List<Playlist> playlists;

    public PlaylistRepository() {
        Song song1 = new Song(1, "Dynamite", Arrays.asList("Jin", "Suga", "RM", "J-Hope", "Jimin", "V", "Jungkook"), "Cheer");
        Song song2 = new Song(2, "Filter", Arrays.asList("Jimin"), "Fun");
        Song song3 = new Song(3, "Sweet Night", Arrays.asList("V"), "Soothing");
        Song song4 = new Song(4, "Telepathy", Arrays.asList("Jin", "Suga", "RM", "J-Hope", "Jimin", "V", "Jungkook"), "Love");
        Song song5 = new Song(5, "Just the way you are", Arrays.asList("Bruno Mars"), "Love");
        Song song6 = new Song(6, "Spring Day", Arrays.asList("Jin", "Suga", "RM", "J-Hope", "Jimin", "V", "Jungkook"), "Love");
        Set<Song> btsSongs = new HashSet<>();
        btsSongs.add(song1);
        btsSongs.add(song2);
        btsSongs.add(song3);
        btsSongs.add(song4);
        Set<Song> slowSongs = new HashSet<>();
        slowSongs.add(song3);
        slowSongs.add(song5);
        Set<Song> loveSongs = new HashSet<>();
        loveSongs.add(song4);
        loveSongs.add(song5);
        loveSongs.add(song6);
        playlists = new ArrayList<>();
        Playlist bts = new Playlist(1, "BTS", "K-pop", btsSongs);
        playlists.add(bts);
        Playlist slow = new Playlist(2, "Slow", "Love", slowSongs);
        playlists.add(slow);
        Playlist love = new Playlist(3, "Love", "Love", loveSongs);
        playlists.add(love);
    }

    public Mono<Playlist> findPlaylistByName(String name) {
        Optional<Playlist> playlistOptional = playlists
                .stream()
                .filter(playlist -> playlist.getName().equalsIgnoreCase(name))
                .findFirst();
        Playlist playlist = playlistOptional.isPresent() ? playlistOptional.get() : null;
        return Mono.just(playlist);
    }

    public Flux<Playlist> findPlaylistsByGenre(String genre) {
        List<Playlist> playlists = this.playlists
                .stream()
                .filter(playlist -> playlist.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
        return Flux.fromIterable(playlists);
    }
}
