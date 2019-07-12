package com.cg.media.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.media.entity.Artist;
import com.cg.media.entity.ArtistSong;
import com.cg.media.entity.Composer;
import com.cg.media.entity.ComposerSong;
import com.cg.media.entity.MusicSociety;
import com.cg.media.entity.Song;
import com.cg.media.repository.IArtistRepository;
import com.cg.media.repository.IArtistSongRepository;
import com.cg.media.repository.IComposerRepository;
import com.cg.media.repository.IComposerSongRepository;
import com.cg.media.repository.IMusicRepository;
import com.cg.media.repository.ISongRepository;
import com.cg.media.repository.iMusicSocietyRepository;

@Service
public class ComposerServiceImpl implements IComposerService {

	@Autowired
	IComposerRepository iComposerRepository;
	@Autowired
	IMusicRepository iMusicRepository;
	@Autowired
	iMusicSocietyRepository iMusicSocietyRepository;
	@Autowired
	IArtistRepository iArtistRepository;
	@Autowired
	IArtistSongRepository iArtistSongRepository;
	@Autowired
	IComposerSongRepository iComposerSongRepository;
	@Autowired
	ISongRepository iSongRepository;

	@Override
	public Composer createComposer(Composer composer) {
		return iComposerRepository.save(composer);
	}

	@Override
	public List<Composer> getAllComposer() {
		return iComposerRepository.findAll();
	}

	@Override
	public Composer getOneComposer(int composerId) {
		return iComposerRepository.getOne(composerId);
	}

	@Override
	public Composer updateComposer(Composer composer, int composerId) {
		Composer existing = iComposerRepository.getOne(composerId);
		composer.setComposerId(composerId);
		BeanUtils.copyProperties(composer, existing);
		int status = iComposerRepository.updateComposer(composerId, existing.getComposerBornDate(),
				existing.getComposerDiedDate());
		return iComposerRepository.getOne(composerId);
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

	/*
	 * @Override public Artist updateArtist(Artist artist, int artistId) { Artist
	 * existing=iArtistRepository.getOne(artistId); //artist.setArtistId(artistId);
	 * BeanUtils.copyProperties(artist, existing); int
	 * status=iArtistRepository.updateArtist(artistId,existing.getArtistName(),
	 * existing.getArtistType()); return iArtistRepository.getOne(artistId); }
	 */

	@Override
	public Artist updateArtist(int artistId, String artistName, String artistType) {
		Artist existing = iArtistRepository.getOne(artistId);
		existing.setArtistName(artistName);
		existing.setArtistType(artistType);
		iArtistRepository.save(existing);
		// artist.setArtistId(artistId);
		// BeanUtils.copyProperties(artist, existing);
		// int
		// status=iArtistRepository.updateArtist(artistId,existing.getArtistName(),existing.getArtistType());
		return iArtistRepository.getOne(artistId);
	}

	// --------------MUSICSOCIETYT--------------------------
	@Override
	public MusicSociety createMusicSociety(MusicSociety musicSociety) {
		return iMusicSocietyRepository.save(musicSociety);
	}

	@Override
	public List<MusicSociety> getAllMusicSociety() {
		// TODO Auto-generated method stub
		return iMusicSocietyRepository.findAll();
	}

	/*
	 * @Override public ComposerSong createComposerSong(ComposerSong composerSong) {
	 * composerSong.setComposer(iComposerRepository.getOne(composerSong.getComposer(
	 * ).getComposerId())); return iComposerSongRepository.save(composerSong); }
	 */

	// -------------------------SONG DETAILS-----------------------------------
	@Override
	public Song createSong(Song song) {
		return iSongRepository.save(song);
	}

	@Override
	public List<Song> getAllSong() {
		return iSongRepository.findAll();
	}

//----------------------------------COMPOSER SONG DETAILS
	@Override
	public ComposerSong createComposerSong(ComposerSong composerSong) {
		return iComposerSongRepository.save(composerSong);
	}

	@Override
	public List<ComposerSong> getAllComposerSong() {
		return iComposerSongRepository.findAll();
	}

	@Override
	public ComposerSong getComposerSong(int composerSongId) {
		return iComposerSongRepository.getOne(composerSongId);
	}

	// -----ARTIST SONG DETAILS---------
	@Override
	public ArtistSong createArtistSong(ArtistSong artistSong) {

		return iArtistSongRepository.save(artistSong);
	}

	@Override
	public List<ArtistSong> getAllArtistSong() {
		return iArtistSongRepository.findAll();
	}

	@Override
	public ArtistSong getArtistSong(int artistSongId) {
		return iArtistSongRepository.getOne(artistSongId);
	}
}
