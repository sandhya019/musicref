package com.cg.media.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.media.entity.Artist;
import com.cg.media.entity.ArtistSong;
import com.cg.media.entity.Composer;
import com.cg.media.entity.ComposerSong;
import com.cg.media.entity.MusicSociety;
import com.cg.media.entity.Song;
import com.cg.media.exception.MediaComposerManagementSystemException;
import com.cg.media.service.IComposerService;

@RestController
public class MusicRestController {
	@Autowired
	IComposerService iService;

	@RequestMapping("/Hello")
	public String GetAllComposer() {
		return "SayHello";

	}

	// ---------------------MusicSociety Details-----------------------------------

	@RequestMapping(value = "/MusicSociety", method = RequestMethod.POST)
	public MusicSociety createMusicSociety(@Valid @RequestBody MusicSociety musicSociety)
			throws MediaComposerManagementSystemException {
		try {
			return iService.createMusicSociety(musicSociety);

		} catch (Exception e) {
			throw new MediaComposerManagementSystemException(204, e.getMessage());
		}
	}

	@RequestMapping("/MusicSociety")
	public List<MusicSociety> getAllMusicSociety() throws MediaComposerManagementSystemException {
		try {
			return iService.getAllMusicSociety();

		} catch (Exception e) {
			throw new MediaComposerManagementSystemException(201, e.getMessage());
		}

	}

	// ----------------List All Composer Details----------
	@RequestMapping(value = "/Composer", method = RequestMethod.POST)
	public Composer createComposer(@Valid @RequestBody Composer composer)
			throws MediaComposerManagementSystemException {

		try {
			return iService.createComposer(composer);

		} catch (Exception e) {
			throw new MediaComposerManagementSystemException(204, e.getMessage());

		}

	}

	@RequestMapping("/Composer")
	public List<Composer> getAllComposer() throws MediaComposerManagementSystemException {
		try {
			return iService.getAllComposer();

		} catch (Exception e) {
			throw new MediaComposerManagementSystemException(204, e.getMessage());
		}

	}

//--------------Get Single Composer Details--------------
	@RequestMapping("/Composer/{composerId}")
	public Composer getOneComposer(@PathVariable int composerId) throws MediaComposerManagementSystemException {
		try {
			return iService.getOneComposer(composerId);

		} catch (Exception e) {

			throw new MediaComposerManagementSystemException(204, e.getMessage());
		}

	}

	@RequestMapping(value = "/Composer/{composerId}", method = RequestMethod.PUT)
	public Composer updateComposer(@RequestBody Composer composer, @PathVariable int composerId)
			throws MediaComposerManagementSystemException {
		try {
			return iService.updateComposer(composer, composerId);

		} catch (Exception e) {
			throw new MediaComposerManagementSystemException(204, e.getMessage());

		}

	}
	// ----------------------ALL ARTIST
	// DETAILS------------------------------------------------------------------

	// ----------Create Artist------
	@RequestMapping(value = "/Artist", method = RequestMethod.POST)
	public Artist createArtist(@Valid @RequestBody Artist artist) throws MediaComposerManagementSystemException {
		try {
			return iService.createArtist(artist);

		} catch (Exception e) {
			throw new MediaComposerManagementSystemException(204, e.getMessage());
		}

	}

	@RequestMapping("/Artist")
	public List<Artist> getAllArtist() throws MediaComposerManagementSystemException {
		try {
			return iService.getAllArtist();

		} catch (Exception e) {
			throw new MediaComposerManagementSystemException(204, e.getMessage());
		}

	}

	/*
	 * @RequestMapping(value="/Artist/{artistId}",method=RequestMethod.PUT) public
	 * Artist updateArtist(@RequestBody Artist artist,@PathVariable int artistId) {
	 * return iService.updateArtist(artist,artistId);
	 * 
	 * }
	 */

	@RequestMapping(value = "/Artist/{artistId}/{artistName}/{artistType}", method = RequestMethod.PUT)
	public Artist updateArtist(@PathVariable int artistId, @PathVariable String artistName,
			@PathVariable String artistType) throws MediaComposerManagementSystemException {
		try {
			return iService.updateArtist(artistId, artistName, artistType);

		} catch (Exception e) {
			throw new MediaComposerManagementSystemException(204, e.getMessage());
		}

	}

	// ----------------ALL Song Details--------------------

	@RequestMapping(value = "/Song", method = RequestMethod.POST)
	public Song createSong(@Valid @RequestBody Song song) throws MediaComposerManagementSystemException {
		try {
			return iService.createSong(song);

		} catch (Exception e) {
			throw new MediaComposerManagementSystemException(204, e.getMessage());
		}

	}

	@RequestMapping("/Song")
	public List<Song> getAllSong() throws MediaComposerManagementSystemException {
		try {
			return iService.getAllSong();

		} catch (Exception e) {
			throw new MediaComposerManagementSystemException(204, e.getMessage());
		}

	}

	// -------------ALL ARTIST SONG DETAILS--------------------
	@RequestMapping(value = "/ArtistSong", method = RequestMethod.POST)
	public ArtistSong createArtistSong(@Valid @RequestBody ArtistSong artistSong)
			throws MediaComposerManagementSystemException {
		try {
			return iService.createArtistSong(artistSong);

		} catch (Exception e) {
			throw new MediaComposerManagementSystemException(204, e.getMessage());
		}

	}

	@RequestMapping("/ArtistSong")
	public List<ArtistSong> getAllArtistSong() throws MediaComposerManagementSystemException {
		try {
			return iService.getAllArtistSong();

		} catch (Exception e) {
			throw new MediaComposerManagementSystemException(204, e.getMessage());
		}

	}

	@RequestMapping("/ArtistSong/{artistSongId}")
	public ArtistSong getArtistSong(@PathVariable int artistSongId) throws MediaComposerManagementSystemException {
		try {
			return iService.getArtistSong(artistSongId);

		} catch (Exception e) {
			throw new MediaComposerManagementSystemException(204, e.getMessage());
		}

	}

	// -=-------------ALL Composer SONG DEetails---------------
	@RequestMapping(value = "/ComposerSong", method = RequestMethod.POST)
	public ComposerSong createComposerSong(@Valid @RequestBody ComposerSong composerSong) throws MediaComposerManagementSystemException {
		try {
			return iService.createComposerSong(composerSong);

		} catch (Exception e) {
			throw new MediaComposerManagementSystemException(204, e.getMessage());
		}

	}

	@RequestMapping("/ComposerSong")
	public List<ComposerSong> getAllComposerSong() throws MediaComposerManagementSystemException{
		try {
			return iService.getAllComposerSong();

		} catch (Exception e) {
			throw new MediaComposerManagementSystemException(204, e.getMessage());

		}

	}

	@RequestMapping("/ComposerSong/{composerSongId}")
	public ComposerSong getComposerSong(@PathVariable int composerSongId) throws MediaComposerManagementSystemException{
		try {
			return iService.getComposerSong(composerSongId);

		} catch (Exception e) {
			throw new MediaComposerManagementSystemException(204, e.getMessage());
		}

	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
