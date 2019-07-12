package com.cg.media.repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.media.entity.ArtistSong;

public interface IArtistSongRepository extends JpaRepository<ArtistSong, Integer>{

}
