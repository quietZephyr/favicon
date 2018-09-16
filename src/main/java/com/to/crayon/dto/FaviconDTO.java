package com.to.crayon.dto;
/**
 * Data Transfer Object for favicon data.
 * Contains data that is relevant to display on the web page.
 * 
 * @author TOliveira
 *
 */
public class FaviconDTO {

	private String site;
	private String faviconUrl;
	private String errorMessage;
	private boolean fetchedFromDB;
	private Long databaseId;
	
	public FaviconDTO(){
	}
	
	public FaviconDTO(String site)	{
		this.site = site;
	}
	
	public FaviconDTO(String site, String faviconUrl, String errorMessage, boolean fetchedFromDB, Long databaseId) {
		this.site = site;
		this.faviconUrl = faviconUrl;
		this.errorMessage = errorMessage;
		this.fetchedFromDB = fetchedFromDB;
		this.databaseId = databaseId;
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
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isFetchedFromDB() {
		return fetchedFromDB;
	}

	public void setFetchedFromDB(boolean fetchedFromDB) {
		this.fetchedFromDB = fetchedFromDB;
	}

	public Long getDatabaseId() {
		return databaseId;
	}

	public void setDatabaseId(Long databaseId) {
		this.databaseId = databaseId;
	}
}
