package com.cg.Music.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.Music.Entity.Artist;

@Repository
public interface IMusicRepository extends JpaRepository<Artist, Integer>{
	

}
