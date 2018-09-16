package com.to.crayon.service;

import com.to.crayon.dto.FaviconDTO;

/**
 * Interface for a service that retrieves favicon data from the data access layer 
 * and performs some business logic to determine the output in the data transfer object (DTO)..
 * 
 * @author TOliveira
 *
 */
public interface FaviconService {

	public void updateFaviconDTO(FaviconDTO faviconDTO);
	
}
