package com.cg.media.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Song {

	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "songSeq")
	@SequenceGenerator(initialValue=900000,allocationSize=1, name = "songSeq",sequenceName = "songSeq")
	private int songId;
	@NotNull(message = "Please give a valid songName or songName should not be null.")
	@Size(min = 1, max = 200, message = "songName must be between 1 and 200 characters")
	private String songName;
	@NotNull(message = "Please give a songDuration its should not be null.")
	private String songDuration;
	private int createdBy;
	private String createdOn;
	private int updatedBy;
	private String updatedOn;
	private boolean songDeletedFlag;
	
	@JsonIgnore
	@OneToOne(mappedBy = "song")
	private ComposerSong composerSong;
	
	public ComposerSong getComposerSong() {
		return composerSong;
	}
	public void setComposerSong(ComposerSong composerSong) {
		this.composerSong = composerSong;
	}
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSongDuration() {
		return songDuration;
	}
	public void setSongDuration(String songDuration) {
		this.songDuration = songDuration;
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
	public boolean isSongDeletedFlag() {
		return songDeletedFlag;
	}
	public void setSongDeletedFlag(boolean songDeletedFlag) {
		this.songDeletedFlag = songDeletedFlag;
	}
	
}
