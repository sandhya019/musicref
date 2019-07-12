package com.cg.media.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.media.entity.Artist;
import com.cg.media.entity.Composer;

@Repository
public interface IComposerRepository extends JpaRepository<Composer, Integer>  {

@Transactional
@Modifying
@Query("UPDATE Composer m SET m.composerBornDate=:composerBornDate,m.composerDiedDate=:composerDiedDate WHERE m.composerId=:composerId ")
	int updateComposer(int composerId, String composerBornDate, String composerDiedDate);


}
