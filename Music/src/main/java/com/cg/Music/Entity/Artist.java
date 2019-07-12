package com.cg.Music.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Artist {
    
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(initialValue=200000,allocationSize=1,name="artistId")
	private int artistId;
	private String artistName;
	private String artistType;
	private String artistBornDate;
	private String artistDiedDate;
	private int createdBy;
	private String createdOn;
	private int updatedBy;
	private String updatedOn;
	private boolean artistDeletedFlag;
	
}
