package com.cg.Music.Service;

import java.util.List;

import com.cg.Music.Entity.Artist;
import com.cg.Music.Entity.Composer;
import com.cg.Music.Entity.MusicSociety;

public interface IComposerService {

	
	public Composer createComposer(Composer composer);

	public List<Composer> getAllComposer();

	public Composer getOneComposer(int composerId);

	public void updateComposer(Composer composer, int composerId);

	public Artist createArtist(Artist artist);

	public List<Artist> getAllArtist();

	public MusicSociety createMusicSociety(MusicSociety musicSociety);

	public List<MusicSociety> getAllMusicSociety();

}
