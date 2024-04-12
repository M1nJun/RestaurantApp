package edu.lawrence.restaurant.core;

import java.sql.SQLException;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;

public class ReviewRowMapper implements RowMapper<Review> {

	@Override
	public Review mapRow(ResultSet row, int rowNum) throws SQLException {
		Review r = new Review();
		r.setRestaurantId(row.getString("restaurantID"));
		r.setUserId(row.getString("userID"));
		r.setPosted(row.getString("posted"));
		r.setQuality(row.getInt("quality"));
		r.setAmbiance(row.getInt("ambiance"));
		r.setPrice(row.getInt("price"));
		r.setComment(row.getString("comment"));
		return r;
	}

}