package com.cg.media.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.media.entity.Song;

public interface ISongRepository extends JpaRepository<Song, Integer> {

}
