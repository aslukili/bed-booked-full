package org.loukili.bedbooker.service;

import org.loukili.bedbooker.entity.Role;
import org.loukili.bedbooker.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RoleServiceImpl implements RoleService{

  private final RoleRepository roleRepository;

  @Autowired
  public RoleServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }


  @Override
  public Role save(Role role) {
    return roleRepository.save(role);
  }

  @Override
  public List<Role> getRoles() {
    return roleRepository.findAll();
  }

  @Override
  public Optional<Role> getRoleById(Long id) {
    return roleRepository.findRoleById(id);
  }
}
