package com.cg.media.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data

@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Composer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "composerSeq")
	@SequenceGenerator(initialValue = 100000, allocationSize = 1, name = "composerSeq", sequenceName = "composerSeq")
	private int composerId;
	@NotNull(message = "Please give a valid composer name or composer name should not be null.")
	@Size(min = 1, max = 200, message = "composerName Name must be between 1 and 200 characters")
	private String composerName;
	@NotNull(message = "Please give a composerBornDate its should not be null.")
	private String composerBornDate;
	private String composerDiedDate;
	@Size(min = 1, max = 5, message = "composerCaeipiNumber Name must be between 1 and 5 characters")
	private String composerCaeipiNumber;

	@NotNull(message = "Please give a Valid composerMusicSocietyId or composerMusicSocietyId should not be a null... ")
	private int composerMusicSocietyId;
	private int createdBy;
	private String createdOn;
	private int updatedBy;
	private String updatedOn;
	private boolean composerDeletedFlag;

	@JsonIgnore
	@OneToMany(mappedBy = "composer")
	private List<ComposerSong> composerSong;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "composerMusicSocietyId", insertable = false, updatable = false)
	private MusicSociety musicSociety;

	public int getComposerId() {
		return composerId;
	}

	public void setComposerId(int composerId) {
		this.composerId = composerId;
	}

	public String getComposerName() {
		return composerName;
	}

	public void setComposerName(String composerName) {
		this.composerName = composerName;
	}

	public String getComposerBornDate() {
		return composerBornDate;
	}

	public void setComposerBornDate(String composerBornDate) {
		this.composerBornDate = composerBornDate;
	}

	public String getComposerDiedDate() {
		return composerDiedDate;
	}

	public void setComposerDiedDate(String composerDiedDate) {
		this.composerDiedDate = composerDiedDate;
	}

	public String getComposerCaeipiNumber() {
		return composerCaeipiNumber;
	}

	public void setComposerCaeipiNumber(String composerCaeipiNumber) {
		this.composerCaeipiNumber = composerCaeipiNumber;
	}

	public int getComposerMusicSocietyId() {
		return composerMusicSocietyId;
	}

	public void setComposerMusicSocietyId(int composerMusicSocietyId) {
		this.composerMusicSocietyId = composerMusicSocietyId;
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

	public boolean isComposerDeletedFlag() {
		return composerDeletedFlag;
	}

	public void setComposerDeletedFlag(boolean composerDeletedFlag) {
		this.composerDeletedFlag = composerDeletedFlag;
	}

}