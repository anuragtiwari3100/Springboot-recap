package com.tiwari.JournalApplication.controller;

import com.tiwari.JournalApplication.entity.User;
import com.tiwari.JournalApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser(){
       return userService.getAll();
    }

     @PostMapping
    public void  createUser(@RequestBody User user){
          userService.saveEntery(user);
    }

    @PutMapping("/{userName}")
    public ResponseEntity<?>  updateUser(@RequestBody User user,@PathVariable String userName){
     User userInDb = userService.findByUserName(userName);
     if(userInDb != null){
         userInDb.setUserName(user.getUserName());
         userInDb.setPassword(user.getPassword());
         userService.saveEntery(userInDb);
     }
      return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @DeleteMapping("/user")
//    public ResponseEntity<T> delecteById(){
//
//    }

}
