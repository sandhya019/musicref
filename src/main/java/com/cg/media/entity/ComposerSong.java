package com.cg.media.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class ComposerSong {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "composerSongId")
	@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "composerSongId")
	private int composerSongId;
	@NotNull(message = "Please give a valid composerId or composerId should not be null.")
	private int composerId;

	@Column(unique = true)
	@NotNull(message = "Please give a valid songId or songId should not be null.")
	private int songId;
	private int createdBy;
	private String createdOn;
	private int updatedBy;
	private String updatedOn;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "composerId", insertable = false, updatable = false)
	private Composer composer;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "songId", insertable = false, updatable = false)
	private Song song;

	public int getComposerSongId() {
		return composerSongId;
	}

	public void setComposerSongId(int composerSongId) {
		this.composerSongId = composerSongId;
	}

	public Composer getComposer() {
		return composer;
	}

	public void setComposer(Composer composer) {
		this.composer = composer;
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

	public int getComposerId() {
		return composerId;
	}

	public void setComposerId(int composerId) {
		this.composerId = composerId;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

}
