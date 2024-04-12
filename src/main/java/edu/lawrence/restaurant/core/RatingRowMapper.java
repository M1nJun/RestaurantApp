package edu.lawrence.restaurant.core;

import java.sql.SQLException;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;


public class RatingRowMapper implements RowMapper<Rating>{
	
	public Rating mapRow(ResultSet row, int rowNum) throws SQLException {
		Rating r = new Rating();
		r.setRestaurantID(row.getString("restaurantID"));
		r.setAvgQuality(row.getInt("avg_quality"));
		r.setAvgAmbiance(row.getInt("avg_ambiance"));
		r.setAvgPrice(row.getInt("avg_price"));
		r.setCount(row.getInt("count"));
		return r;
	}

}
