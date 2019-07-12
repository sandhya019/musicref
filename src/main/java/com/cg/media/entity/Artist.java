package com.cg.media.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;


@Entity
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Artist {
    
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator ="artistId" )
	@SequenceGenerator(initialValue = 200000, allocationSize = 1, name = "artistId")
	private int artistId;
	@NotNull(message = "Please give a valid artistName or artistName should not be null.")
	@Size(min = 1, max = 20, message = "artistName Name must be between 1 and 20 characters")
	private String artistName;
	@NotNull(message = "Please give a valid artistType or artistType should not be null.")
	private String artistType;
	@NotNull(message = "Please give a artistBornDate its should not be null.")
	private String artistBornDate;
	private String artistDiedDate;
	private int createdBy;
	private String createdOn;
	private int updatedBy;
	private String updatedOn;
	private boolean artistDeletedFlag;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "artist")
	private List<ArtistSong> ArtistSong;

	
	
	
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getArtistType() {
		return artistType;
	}
	public void setArtistType(String artistType) {
		this.artistType = artistType;
	}
	public String getArtistBornDate() {
		return artistBornDate;
	}
	public void setArtistBornDate(String artistBornDate) {
		this.artistBornDate = artistBornDate;
	}
	public String getArtistDiedDate() {
		return artistDiedDate;
	}
	public void setArtistDiedDate(String artistDiedDate) {
		this.artistDiedDate = artistDiedDate;
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
	public boolean isArtistDeletedFlag() {
		return artistDeletedFlag;
	}
	public void setArtistDeletedFlag(boolean artistDeletedFlag) {
		this.artistDeletedFlag = artistDeletedFlag;
	}
	public List<ArtistSong> getArtistSong() {
		return ArtistSong;
	}
	public void setArtistSong(List<ArtistSong> artistSong) {
		ArtistSong = artistSong;
	}
		public Artist() {
		
	}
		/**
		 * @param artistId
		 * @param artistName
		 * @param artistType
		 * @param artistBornDate
		 * @param artistDiedDate
		 * @param createdBy
		 * @param createdOn
		 * @param updatedBy
		 * @param updatedOn
		 * @param artistDeletedFlag
		 */
		public Artist(int artistId,
				@NotNull(message = "Please give a valid artistName or artistName should not be null.") @Size(min = 1, max = 20, message = "artistName Name must be between 1 and 20 characters") String artistName,
				@NotNull(message = "Please give a valid artistType or artistType should not be null.") String artistType,
				@NotNull(message = "Please give a artistBornDate its should not be null.") String artistBornDate,
				String artistDiedDate, int createdBy, String createdOn, int updatedBy, String updatedOn,
				boolean artistDeletedFlag) {
			super();
			this.artistId = artistId;
			this.artistName = artistName;
			this.artistType = artistType;
			this.artistBornDate = artistBornDate;
			this.artistDiedDate = artistDiedDate;
			this.createdBy = createdBy;
			this.createdOn = createdOn;
			this.updatedBy = updatedBy;
			this.updatedOn = updatedOn;
			this.artistDeletedFlag = artistDeletedFlag;
		}
		
		
}
