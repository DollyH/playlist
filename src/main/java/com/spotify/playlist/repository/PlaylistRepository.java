package com.spotify.playlist.repository;

import com.spotify.playlist.domain.Playlist;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PlaylistRepository extends ReactiveCrudRepository<Playlist, String> {
    Mono<Playlist> findByName(String name);
    Flux<Playlist> findAllByGenre(String genre);
}
