package com.cg.media.entity;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class ArtistSong {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artsistSongId")
	@SequenceGenerator(initialValue=1,allocationSize=1,name="artsistSongId")
	private int artsistSongId;
	
	public int getArtsistSongId() {
		return artsistSongId;
	}
	public void setArtsistSongId(int artsistSongId) {
		this.artsistSongId = artsistSongId;
	}
	private int artistId;
	private int songId;
	private int createdBy;
	private String createdOn;
	private int updatedBy;
	private String updatedOn;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "artistId", insertable = false, updatable = false)
	private Artist artist;

	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "songId",insertable = false, updatable = false)
	private Song song;
	
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}
	
}
