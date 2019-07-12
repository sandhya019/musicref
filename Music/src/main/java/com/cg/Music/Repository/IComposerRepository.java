package com.cg.Music.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.Music.Entity.Artist;
import com.cg.Music.Entity.Composer;

@Repository
public interface IComposerRepository extends JpaRepository<Composer, Integer>  {


}
