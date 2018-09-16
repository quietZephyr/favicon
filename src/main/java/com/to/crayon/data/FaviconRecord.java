package com.to.crayon.data;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FaviconRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String site;
	private String faviconUrl;
	private Timestamp dateCreated;
	private String errorMessage;
	
	public FaviconRecord()	{
	}
	
	public FaviconRecord(String site, String faviconUrl, String errorMessage)	{
		super();
		this.site = site;
		this.faviconUrl = faviconUrl;
		this.errorMessage = errorMessage;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getFaviconUrl() {
		return faviconUrl;
	}
	public void setFaviconUrl(String faviconUrl) {
		this.faviconUrl = faviconUrl;
	}
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
