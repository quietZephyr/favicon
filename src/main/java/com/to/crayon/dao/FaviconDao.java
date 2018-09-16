package com.to.crayon.dao;

import com.to.crayon.data.FaviconRecord;

/**
 * Interface for Data Access Object for accessing favicon records from the database.
 * 
 * @author TOliveira
 *
 */
public interface FaviconDao {
	
	public FaviconRecord findBySite(String site);

	public int insert(FaviconRecord faviconRecord);
}
