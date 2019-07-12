package com.cg.Music.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Music.Entity.Artist;
import com.cg.Music.Entity.Composer;
import com.cg.Music.Entity.MusicSociety;
import com.cg.Music.Repository.IComposerRepository;
import com.cg.Music.Repository.IMusicRepository;
import com.cg.Music.Repository.iMusicSocietyRepository;

@Service
public class ComposerService implements IComposerService {

	@Autowired
	IComposerRepository iComposerRepository;
	@Autowired
	IMusicRepository iMusicRepository;
	@Autowired
	iMusicSocietyRepository iMusicSocietyRepository;

	@Override
	public Composer createComposer(Composer composer) {
		return iComposerRepository.save(composer);
	}

	@Override
	public List<Composer> getAllComposer() {
		return (List<Composer>) iComposerRepository.findAll();
	}

	@Override
	public Composer getOneComposer(int composerId) {
		return iComposerRepository.getOne(composerId);
	}

	@Override
	public void updateComposer(Composer composer, int composerId) {
		iComposerRepository.save(composer);
	}

	// -----------ARTIST----------------------------
	@Override
	public Artist createArtist(Artist artist) {
		return iMusicRepository.save(artist);
	}

	@Override
	public List<Artist> getAllArtist() {
		return iMusicRepository.findAll();
	}

	//--------------MUSICSOCIETYT--------------------------
	@Override
	public MusicSociety createMusicSociety(MusicSociety musicSociety) {
		return iMusicSocietyRepository.save(musicSociety);
	}

	@Override
	public List<MusicSociety> getAllMusicSociety() {
		// TODO Auto-generated method stub
		return iMusicSocietyRepository.findAll();
	}

}
