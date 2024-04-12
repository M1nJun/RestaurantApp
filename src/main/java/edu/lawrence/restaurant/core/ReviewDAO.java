package edu.lawrence.restaurant.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReviewDAO {
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	//should i return something here?
	// save review
	
	//do i need to return key because when i save it do i need response entitye
	//make sure this is correct
	public String save(Review review) {
        String insertSQL = "insert into restaurant_reviews(restaurantID, userID, posted, quality, ambiance, price, comment) "
        +"values (?, ?, ?,?, ?, ?,?)";
        jdbcTemplate.update(insertSQL, review.getRestaurantId(), review.getUserId(), review.getPosted(), review.getQuality(), review.getAmbiance(), review.getPrice(), review.getComment());
        String query = "select last_insert_id()";
        String result = jdbcTemplate.queryForObject(query,String.class);
        return result;
	}
	
	
	public List<Review> findByRestaurant(String restaurantId) {
		String sql = "select * from restaurant_reviews where restaurantID=?";
		List<Review> results = null;
		RowMapper<Review> rowMapper = new ReviewRowMapper();
		try {
			results = jdbcTemplate.query(sql, rowMapper, restaurantId);		
		} catch (Exception ex) {
			results = new ArrayList<Review>();
		}
		return results;	
	}
	
	public List<Review> findByUser(String userId) {
		String sql = "select * from restaurant_reviews where userID=?";
		List<Review> results = null;
		RowMapper<Review> rowMapper = new ReviewRowMapper();
		try {
			results = jdbcTemplate.query(sql, rowMapper, userId);		
		} catch (Exception ex) {
			results = new ArrayList<Review>();
		}
		return results;	
	}
	

}