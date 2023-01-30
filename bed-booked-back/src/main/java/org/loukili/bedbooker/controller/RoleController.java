package org.loukili.bedbooker.controller;


import org.loukili.bedbooker.entity.Role;
import org.loukili.bedbooker.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.endpoint}/roles")
public class RoleController {
  private final RoleService roleService;

  @Autowired
  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }


  @GetMapping
  public  ResponseEntity<List<Role>> getRoles(){
    return new ResponseEntity<>(roleService.getRoles(), HttpStatus.OK);
  }
  @PostMapping("")
  public ResponseEntity<Role> addRole(@RequestBody Role role){
    return new ResponseEntity<>(roleService.save(role), HttpStatus.OK);
  }


}
