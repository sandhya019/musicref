package com.cg.media.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.media.entity.MusicSociety;

@Repository
public interface iMusicSocietyRepository extends JpaRepository<MusicSociety, Integer>{

}
