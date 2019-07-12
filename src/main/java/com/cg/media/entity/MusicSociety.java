package com.cg.media.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class MusicSociety {
	
	@Id
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

	private int composerMusicSocietyId;
	@Size(min = 1, max = 20, message = "composerMusicSocietyName  must be between 1 and 20 characters")
	private String composerMusicSocietyName;

	@JsonIgnore
	@OneToMany(mappedBy = "composerMusicSocietyId")
	private List<Composer> composer;

	public int getComposerMusicSocietyId() {
		return composerMusicSocietyId;
	}

	public void setComposerMusicSocietyId(int composerMusicSocietyId) {
		this.composerMusicSocietyId = composerMusicSocietyId;
	}

	public String getComposerMusicSocietyName() {
		return composerMusicSocietyName;
	}

	public void setComposerMusicSocietyName(String composerMusicSocietyName) {
		this.composerMusicSocietyName = composerMusicSocietyName;
	}

}
