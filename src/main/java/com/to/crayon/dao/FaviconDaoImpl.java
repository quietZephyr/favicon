package com.to.crayon.dao;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.to.crayon.data.FaviconRecord;

/**
 * Data Access Object for accessing favicon records from the database.
 * 
 * @author TOliveira
 *
 */
@Repository("faviconDao")
public class FaviconDaoImpl implements FaviconDao {
	
	@Autowired
    JdbcTemplate jdbcTemplate;	
	
	public FaviconRecord findBySite(String site) {
		ArrayList<FaviconRecord> results = (ArrayList<FaviconRecord>)jdbcTemplate.query("select * from favicon_record where site=?", new Object[] { site }, new BeanPropertyRowMapper<FaviconRecord>(FaviconRecord.class));
		return results != null && results.size() > 0? results.get(0) : null;
	}

	public int insert(FaviconRecord faviconRecord) {
		return jdbcTemplate.update("insert into favicon_record (site, favicon_url, date_created, error_message) " + "values(?, ?, ?, ?)",
				new Object[] { faviconRecord.getSite(), faviconRecord.getFaviconUrl(), new Timestamp(System.currentTimeMillis()), faviconRecord.getErrorMessage() });
	}
	
}
