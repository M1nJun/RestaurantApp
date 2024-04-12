package edu.lawrence.restaurant.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String save(Restaurant restaurant) {
		// Have MySQL generate a unique id
		String idSQL = "select uuid()";
		String key = null;
		try {
			key = jdbcTemplate.queryForObject(idSQL, String.class);
		} catch (Exception ex) {
			key = "Error";
		}
		if (key.equals("Error"))
			return key;

		String insertSQL = "insert into restaurant_restaurant(restaurantID,name,address,type) values (?, ?, ?, ?)";
		jdbcTemplate.update(insertSQL, key, restaurant.getName(), restaurant.getAddress(), restaurant.getType());

		return key;
	}
	
	public Restaurant findById(String id) {
		String sql = "select * from restaurant_restaurant where restaurantID=?";
		Restaurant result = null;
		RowMapper<Restaurant> rowMapper = new RestaurantRowMapper();
		try {
			result = jdbcTemplate.queryForObject(sql, rowMapper, id);
		} catch (Exception ex) {
		}

		return result;
	}
}
