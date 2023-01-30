package org.loukili.bedbooker.controller;

import org.loukili.bedbooker.entity.User;
import org.loukili.bedbooker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("${api.endpoint}/")
public class ProfileController {
  private final UserService userService;

  @Autowired
  public ProfileController(UserService userService) {
    this.userService = userService;
  }
  @GetMapping("/profile")
  public ResponseEntity<Optional<User>> profile(@AuthenticationPrincipal User user){
    String userEmail = user.getUsername();
    // TODO get user by email (the email is extracted form the jwt token which comes in the header of request)
    return new ResponseEntity<>(this.userService.getUserByEmail(userEmail), HttpStatus.OK) ;
  }
}
