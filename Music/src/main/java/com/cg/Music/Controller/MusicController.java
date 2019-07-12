package com.cg.Music.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Music.Entity.Artist;
import com.cg.Music.Entity.Composer;
import com.cg.Music.Entity.MusicSociety;
import com.cg.Music.Service.IComposerService;

@RestController
public class MusicController {
	@Autowired
	IComposerService iService;

	@RequestMapping("/Hello")
	public String GetAllComposer() {
		return "SayHello";

	}

	@RequestMapping(value = "/Composer", method = RequestMethod.POST)
	public Composer createComposer(@RequestBody Composer composer) {
		return iService.createComposer(composer);

	}

//----------------List All Composer Details----------
	@RequestMapping("/Composer")
	public List<Composer> getAllComposer() {
		return iService.getAllComposer();

	}
//--------------Get Single Composer Details--------------
	@RequestMapping("/Composer/{composerId}")
	public Composer getOneComposer(@PathVariable int composerId) {
		return iService.getOneComposer(composerId);
		
	}
	@RequestMapping(value="/Composer/{composerId}",method=RequestMethod.PUT)
	public void updateComposer(@RequestBody Composer composer,@PathVariable int composerId) {
		iService.updateComposer(composer,composerId);
		
	}
	//----------------------ARTIST DETAILS------------------------------------------------------------------
	
	//----------Create Artist------
	@RequestMapping(value="/Artist",method=RequestMethod.POST)
	public Artist createArtist(@RequestBody Artist artist) {
		return iService.createArtist(artist);
		
	}
	@RequestMapping("/Artist")
	public List<Artist> getAllArtist(){
		return iService.getAllArtist();
		
	}
	
	//---------------------MusicSociety Details-----------------------------------
	
	@RequestMapping(value="/MusicSociety",method=RequestMethod.POST)
	public MusicSociety createMusicSociety(@RequestBody MusicSociety musicSociety) {
		return iService.createMusicSociety(musicSociety);
		}
	
	@RequestMapping("/MusicSociety")
	public List<MusicSociety> getAllMusicSociety(){
		return iService.getAllMusicSociety();
		
	}
}

