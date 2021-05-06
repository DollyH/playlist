package com.spotify.playlist.repository;

import com.spotify.playlist.domain.Playlist;
import com.spotify.playlist.domain.Song;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class SpotifyRepository {

    private final List<Playlist> playlists;
    private final List<Song> songs;

    public SpotifyRepository() throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(ResourceUtils.getFile("classpath:images/bts-dynamite.jpg"));
        String image = Base64.getEncoder().encodeToString(fileContent);
        Song song1 = new Song(1, "Dynamite", Arrays.asList("Jin", "Suga", "RM", "J-Hope", "Jimin", "V", "Jungkook"), "Cheer", image);
        fileContent = FileUtils.readFileToByteArray(ResourceUtils.getFile("classpath:images/bts-filter.jpeg"));
        image = Base64.getEncoder().encodeToString(fileContent);
        Song song2 = new Song(2, "Filter", Arrays.asList("Jimin"), "Fun", image);
        fileContent = FileUtils.readFileToByteArray(ResourceUtils.getFile("classpath:images/bts-sweetnight.jpg"));
        image = Base64.getEncoder().encodeToString(fileContent);
        Song song3 = new Song(3, "Sweet Night", Arrays.asList("V"), "Soothing", image);
        fileContent = FileUtils.readFileToByteArray(ResourceUtils.getFile("classpath:images/bts-telepathy.jpg"));
        image = Base64.getEncoder().encodeToString(fileContent);
        Song song4 = new Song(4, "Telepathy", Arrays.asList("Jin", "Suga", "RM", "J-Hope", "Jimin", "V", "Jungkook"), "Love", image);
        fileContent = FileUtils.readFileToByteArray(ResourceUtils.getFile("classpath:images/bm-just.jpg"));
        image = Base64.getEncoder().encodeToString(fileContent);
        Song song5 = new Song(5, "Just the way you are", Arrays.asList("Bruno Mars"), "Love", image);
        fileContent = FileUtils.readFileToByteArray(ResourceUtils.getFile("classpath:images/bts-springday.jpg"));
        image = Base64.getEncoder().encodeToString(fileContent);
        Song song6 = new Song(6, "Spring Day", Arrays.asList("Jin", "Suga", "RM", "J-Hope", "Jimin", "V", "Jungkook"), "Love", image);
        fileContent = FileUtils.readFileToByteArray(ResourceUtils.getFile("classpath:images/bts-idol.jpg"));
        image = Base64.getEncoder().encodeToString(fileContent);
        Song song7 = new Song(7, "Idol", Arrays.asList("Jin", "Suga", "RM", "J-Hope", "Jimin", "V", "Jungkook"), "Cheer", image);
        Set<Song> btsSongs = new HashSet<>();
        btsSongs.add(song1);
        btsSongs.add(song2);
        btsSongs.add(song3);
        btsSongs.add(song4);
        btsSongs.add(song6);
        btsSongs.add(song7);
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
        songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);
        songs.add(song6);
        songs.add(song7);
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

    public List<String> getAllPlaylists() {
        return this.playlists.stream().map(Playlist::getName).collect(Collectors.toList());
    }

    public Flux<Song> getAllSongs() {
        return Flux.fromIterable(songs);
    }
}
