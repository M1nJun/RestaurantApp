package edu.lawrence.restaurant.core;

import java.sql.SQLException;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;

public class ResponseRowMapper implements RowMapper<Response>{

	@Override
	public Response mapRow(ResultSet row, int rowNum) throws SQLException {
		Response r = new Response();
		r.setReviewId(row.getInt("reviewID"));
		r.setUserId(row.getString("userID"));
		r.setComment(row.getString("comment"));
		return r;
	}
}
