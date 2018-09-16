package com.to.crayon.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.to.crayon.dao.FaviconDaoImpl;
import com.to.crayon.data.FaviconRecord;
import com.to.crayon.dto.FaviconDTO;

/**
 * Service that retrieves favicon data from the data access layer 
 * and performs some business logic to determine the output in the data transfer object (DTO)..
 * 
 * @author TOliveira
 *
 */
@Service("faviconService")
public class FaviconServiceImpl implements FaviconService {
	
	@Resource(name="faviconDao")
	FaviconDaoImpl faviconDao;
	
	
	public void updateFaviconDTO(FaviconDTO faviconDTO) {
		String site = faviconDTO.getSite();
		
		// Attempt to find favicon information stored in the database.
		FaviconDTO favicon = getFaviconFromDB(site);
		
		// If favicon not in the database, find favicon information on the web.
		if (favicon == null) {
			favicon = getFaviconFromWeb(site);
			saveNewFavicon(favicon);
		}
		
		// Set information in the passed data transfer object.
		faviconDTO.setSite(favicon.getSite());
		faviconDTO.setFaviconUrl(favicon.getFaviconUrl());
		faviconDTO.setErrorMessage(favicon.getErrorMessage());
		faviconDTO.setFetchedFromDB(favicon.isFetchedFromDB());
		faviconDTO.setDatabaseId(favicon.getDatabaseId());
	}
	
	
	private FaviconDTO getFaviconFromDB(String site) {
		FaviconRecord record = findFavicon(site);
		if (record == null) {
			return null;
		}
		return new FaviconDTO(record.getSite(), record.getFaviconUrl(), record.getErrorMessage(), true, record.getId());
	}
	
	
	private FaviconDTO getFaviconFromWeb(String site) {		
		FaviconDTO faviconDTO = new FaviconDTO(site);
		String faviconUrl = site + "/favicon.ico";
		URL url = null;
		try {
			url = new URL(faviconUrl);
			
			if (url != null) {
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        	con.connect();	     
	        	
	        	// Get Redirect URL, if there is one.
	        	con.getHeaderField("Location");	
	        	faviconUrl = con.getURL() != null? con.getURL().toString() : faviconUrl;
			}
			
		} catch (MalformedURLException | IllegalArgumentException e) {
			String msg = "Not a valid URL: " + site;
			faviconDTO.setErrorMessage(msg);
		} catch (IOException e) {
			String msg = "Could not connect to given URL: " + site;
			faviconDTO.setErrorMessage(msg);
		}
		
		faviconDTO.setFaviconUrl(faviconUrl);
		faviconDTO.setFetchedFromDB(false);
		return faviconDTO;
    }
	
	
	private FaviconRecord findFavicon(String site) {
		return faviconDao.findBySite(site);
	}

	private int saveNewFavicon(FaviconDTO faviconDTO) {
		return faviconDao.insert(new FaviconRecord(faviconDTO.getSite().trim(), faviconDTO.getFaviconUrl(), faviconDTO.getErrorMessage()));
	}
}
