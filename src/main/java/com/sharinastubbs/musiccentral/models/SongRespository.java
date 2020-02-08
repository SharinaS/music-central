package com.sharinastubbs.musiccentral.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRespository extends JpaRepository<Song, Long> {
}
