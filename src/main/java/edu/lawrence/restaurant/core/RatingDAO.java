package edu.lawrence.restaurant.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RatingDAO {
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	public Rating findByRestaurant(String restaurantId) {
		String sql = "select * from review_summary where restaurantID=?";
		Rating results = null;
		RowMapper<Rating> rowMapper = new RatingRowMapper();
		try {
			results = jdbcTemplate.queryForObject(sql, rowMapper, restaurantId);		
		} catch (Exception ex) {
			results = new Rating();
		}
		return results;	
	}
	

}
