package rest;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class userRestController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long userId) {
        if (userId == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (this.userService.getById(userId) == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(this.userService.getById(userId), HttpStatus.OK);
    }

    /*
       @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
       public ResponseEntity<User> saveUser(User user)
       {
           if (user == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
           this.userService.save(user);
           return new ResponseEntity<>(HttpStatus.OK);
       }

       @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
       public ResponseEntity<User> deleteUser(@PathVariable("id")Long userId)
       {
           User user= this.userService.getById(userId);
           if (user == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
           this.userService.delete(userId);
           return new ResponseEntity<>(HttpStatus.OK);
       }
   */
    @GetMapping(path = "/users/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = this.userService.getAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
