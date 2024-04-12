package edu.lawrence.restaurant.interfaces;

import edu.lawrence.restaurant.core.User;
import edu.lawrence.restaurant.core.UserDAO;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    private UserDAO dao;
    
    public UserController(UserDAO dao) {
        this.dao = dao;
    }

    @PostMapping("/login")
    public ResponseEntity<String> checkLogin(@RequestBody User user) {
        User result = dao.findByNameAndPassword(user.getName(), user.getPassword());
        if (result == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user name or password");
        }
        return ResponseEntity.ok().body(result.getKey());
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody User user) {
    	if (user.getName() == null || user.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty user name or password");
        }
        if (user.getName().isBlank() || user.getPassword().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty user name or password");
        }

        String key = dao.save(user);
        if (key.equals("Duplicate")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User with this name already exists");
        } else if (key.equals("Error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Can not generate key");
        }
        return ResponseEntity.ok().body(key);
    }
}
