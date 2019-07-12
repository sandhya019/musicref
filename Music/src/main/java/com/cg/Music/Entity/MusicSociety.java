package com.cg.Music.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class MusicSociety {
	@Id
	private int composerMusicSocietyId;//---- Fixed ID's-------
	private String composerMusicSocietyName;

}
