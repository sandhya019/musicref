package com.cg.media.service;

import java.util.List;

import com.cg.media.entity.Artist;
import com.cg.media.entity.ArtistSong;
import com.cg.media.entity.Composer;
import com.cg.media.entity.ComposerSong;
import com.cg.media.entity.MusicSociety;
import com.cg.media.entity.Song;

public interface IComposerService {

	
	public Composer createComposer(Composer composer);

	public List<Composer> getAllComposer();

	public Composer getOneComposer(int composerId);

	public Composer updateComposer(Composer composer, int composerId);

	public Artist createArtist(Artist artist);

	public List<Artist> getAllArtist();

	public MusicSociety createMusicSociety(MusicSociety musicSociety);

	public List<MusicSociety> getAllMusicSociety();

	//public Artist updateArtist(Artist artist, int artistId);
	
	public Artist updateArtist(int artistId, String artistName, String artistType);

	public ArtistSong createArtistSong(ArtistSong artistSong);

	public ComposerSong createComposerSong(ComposerSong composerSong);

	public Song createSong(Song song);

	public List<Song> getAllSong();



	public List<ComposerSong> getAllComposerSong();

	public ComposerSong getComposerSong(int composerSongId);

	public List<ArtistSong> getAllArtistSong();

	public ArtistSong getArtistSong(int artistSongId);

	
}
