package edu.lawrence.restaurant.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RestaurantRowMapper implements RowMapper<Restaurant> {
	@Override
	public Restaurant mapRow(ResultSet row, int rowNum) throws SQLException {
		Restaurant r = new Restaurant();
		r.setRestaurantID(row.getString("restaurantID"));
		r.setName(row.getString("name"));
		r.setAddress(row.getString("address"));
		r.setType(row.getString("type"));
		return r;
	}
	
}
