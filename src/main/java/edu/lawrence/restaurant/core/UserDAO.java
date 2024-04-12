package edu.lawrence.restaurant.core;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import edu.lawrence.restaurant.services.PasswordService;

@Repository
public class UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired 
    PasswordService passwordService;
    
    public User findByNameAndPassword(String name,String password) {
    	String sql = "SELECT * FROM restaurant_user WHERE username=?";
        RowMapper<User> rowMapper = new UserRowMapper();
        User result = null;
        try {
            result = jdbcTemplate.queryForObject(sql, rowMapper, name);
        } catch(Exception ex) {
            
        }
        if(result != null && passwordService.verifyHash(password, result.getPassword())) {
        	result.setPassword("Undisclosed");
        } else {
        	result = null;
        }
        return result;	
    }

	public String save(User user) {
	    // First make sure this is not a duplicate
	    String sql = "SELECT * FROM restaurant_user WHERE username=?";
	    RowMapper<User> rowMapper = new UserRowMapper();
	    User old = null;
	    try {
	        old = jdbcTemplate.queryForObject(sql, rowMapper, user.getName());
	    } catch(Exception ex) {
	
	    }
	    if(old != null)
	        return "Duplicate";
	
	    // Have MySQL generate a unique id
	    String idSQL = "select uuid()";
	    String key = null;
	    try {
	        key = jdbcTemplate.queryForObject(idSQL, String.class);
	    } catch(Exception ex) {
	        key = "Error";
	    }
	    if(key.equals("Error"))
	        return key;
	
	    String hash = passwordService.hashPassword(user.getPassword());
	    String insertSQL = "insert into restaurant_user(userID,username,password) values (?, ?, ?)";
	    jdbcTemplate.update(insertSQL,key,user.getName(),hash);
	    return key;
	}
}
