package com.cg.media.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.media.entity.ComposerSong;

public interface IComposerSongRepository extends JpaRepository<ComposerSong, Integer>{

}
