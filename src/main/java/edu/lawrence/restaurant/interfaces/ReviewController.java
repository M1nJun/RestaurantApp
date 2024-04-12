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

import edu.lawrence.restaurant.core.Review;
import edu.lawrence.restaurant.core.ReviewDAO;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {
	private ReviewDAO dao;
	
	public ReviewController(ReviewDAO dao) {
		this.dao = dao;
	}
	
	@PostMapping
    public ResponseEntity<String> save(@RequestBody Review review) {
		String key = dao.save(review);
        if (key.equals("Error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Can not generate key");
        }
        return ResponseEntity.ok().body(key);
	}
	
	//this is to find review by id
	// if i wanna find review by restaurant id how would the get mapping be different
	@GetMapping("/{id}")
	public ResponseEntity<List<Review>> findByRestaurantId(@PathVariable String id) {
		List<Review> result = dao.findByRestaurant(id);
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Review>> findByUserId(@PathVariable String id) {
		List<Review> result = dao.findByUser(id);
		return ResponseEntity.ok().body(result);
	}
	
	
}
