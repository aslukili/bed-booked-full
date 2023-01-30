package org.loukili.bedbooker.controller;


import org.loukili.bedbooker.entity.User;
import org.loukili.bedbooker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${api.endpoint}/users")
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("")
  public ResponseEntity<List<User>> getUsers(){
    return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<User> addUser(@RequestBody User user){
    return new ResponseEntity<>(userService.add(user), HttpStatus.OK);
  }
}
