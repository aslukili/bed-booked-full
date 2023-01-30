package org.loukili.bedbooker.service;


import org.loukili.bedbooker.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
  List<User> getUsers();

  User add(User user);

  Optional<User> getUserById(Long id);

  Optional<User> getUserByEmail(String email);
}
