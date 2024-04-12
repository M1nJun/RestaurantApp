package edu.lawrence.restaurant.interfaces;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.lawrence.restaurant.core.Rating;
import edu.lawrence.restaurant.core.RatingDAO;

@RestController
@RequestMapping("/ratings")
@CrossOrigin(origins = "*")
public class RatingController {
	private RatingDAO dao;
	
	public RatingController(RatingDAO dao) {
		this.dao = dao;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Rating> findByID(@PathVariable String id) {
		Rating result = dao.findByRestaurant(id);
		return ResponseEntity.ok().body(result);
	}
	
}
