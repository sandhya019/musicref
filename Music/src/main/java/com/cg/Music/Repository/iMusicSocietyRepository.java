package com.cg.Music.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.Music.Entity.MusicSociety;

@Repository
public interface iMusicSocietyRepository extends JpaRepository<MusicSociety, Integer>{

}
