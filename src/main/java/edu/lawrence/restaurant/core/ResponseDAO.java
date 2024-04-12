package edu.lawrence.restaurant.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ResponseDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String save(Response response) {	
        String insertSQL = "insert into restaurant_response(reviewID, userID, comment) values (?, ?, ?)";
        jdbcTemplate.update(insertSQL, response.getReviewId(), response.getUserId(), response.getComment());
        String query = "select last_insert_id()";
        String result = jdbcTemplate.queryForObject(query, String.class);
        return result;
	}
	
	public Response findByReview(int id) {
		String sql = "select * from restaurant_response where reviewID=?";
		Response result = null;
		RowMapper<Response> rowMapper = new ResponseRowMapper();
		try {
			result = jdbcTemplate.queryForObject(sql, rowMapper, id);
		} catch (Exception ex) {
			System.out.print("could not find the response by id");
		}
		return result;
	}
	
	public List<Response> findByUser(String id) {
		String sql = "select * from restaurant_response where userID=?";
		List<Response> result = null;
		RowMapper<Response> rowMapper = new ResponseRowMapper();
		try {
			result = jdbcTemplate.query(sql, rowMapper, id);
		} catch (Exception ex) {
			System.out.print("could not find the response by id");
		}
		return result;
	}

}

