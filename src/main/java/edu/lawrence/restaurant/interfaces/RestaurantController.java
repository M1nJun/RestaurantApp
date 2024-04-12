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

import edu.lawrence.restaurant.core.Restaurant;
import edu.lawrence.restaurant.core.RestaurantDAO;


@RestController
@RequestMapping("/restaurants")
@CrossOrigin(origins = "*")
public class RestaurantController {
	private RestaurantDAO dao;

    public RestaurantController(RestaurantDAO dao) {
        this.dao = dao;
    }
    
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Restaurant restaurant) {
		String key = dao.save(restaurant);
        if (key.equals("Error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Can not generate key");
        }
        return ResponseEntity.ok().body(key);
	}
    
	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> findById(@PathVariable String id) {
		Restaurant result = dao.findById(id);
		return ResponseEntity.ok().body(result);
	}

}

