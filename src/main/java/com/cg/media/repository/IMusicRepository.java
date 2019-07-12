package com.cg.media.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.media.entity.Artist;

@Repository
public interface IMusicRepository extends JpaRepository<Artist, Integer>{
	

}
