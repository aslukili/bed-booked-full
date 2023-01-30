package org.loukili.bedbooker.service;

import org.loukili.bedbooker.entity.User;
import org.loukili.bedbooker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  @Override
  public User add(User user) {
    return userRepository.save(user);
  }

  @Override
  public Optional<User> getUserById(Long id) {
    return userRepository.findUserById(id);
  }

  @Override
  public Optional<User> getUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }


}
