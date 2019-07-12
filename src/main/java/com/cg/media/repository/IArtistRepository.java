package com.cg.media.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.media.entity.Artist;

@Repository
public interface IArtistRepository extends JpaRepository<Artist, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE Artist m SET m.artistName=:artistName,m.artistType=:artistType WHERE m.artistId=:artistId")
	int updateArtist(int artistId, String artistName, String artistType);

}
