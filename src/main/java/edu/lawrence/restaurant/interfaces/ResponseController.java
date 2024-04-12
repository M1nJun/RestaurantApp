package edu.lawrence.restaurant.interfaces;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.lawrence.restaurant.core.Response;
import edu.lawrence.restaurant.core.ResponseDAO;

@RestController
@RequestMapping("/responses")
@CrossOrigin(origins = "*")
public class ResponseController {
	private ResponseDAO dao;
	
	public ResponseController(ResponseDAO dao) {
		this.dao = dao;
	}
	
	@PostMapping 
	public ResponseEntity<String> save(@RequestBody Response response){
		String key = dao.save(response);
		if (key.equals("Error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Can not generate key");
        }
        return ResponseEntity.ok().body(key);	
	}
	
	//what is this used for
	@GetMapping("/{id}")
	public ResponseEntity<Response> findById(@PathVariable int id) {
		Response result = dao.findByReview(id);
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Response>> findByUser(@PathVariable String id) {
		List<Response> result = dao.findByUser(id);
		return ResponseEntity.ok().body(result);
	}
	
}
