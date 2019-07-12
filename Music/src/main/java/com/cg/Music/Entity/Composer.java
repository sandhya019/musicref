package com.cg.Music.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class Composer {
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(initialValue=100000,allocationSize=1, name = "composerId")
	private int composerId;
	private String composerName;
	private String composerBornDate;
	private String composerDiedDate;
	private String composerCaeipiNumber;
	private int composerMusicSocietyId;
	private int createdBy;
	private String createdOn;
	private int updatedBy;
	private String updatedOn;
	private boolean composerDeletedFlag;


}
