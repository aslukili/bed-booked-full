package org.loukili.bedbooker.service;

import org.loukili.bedbooker.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
  Role save(Role role);

  List<Role> getRoles();

  Optional<Role> getRoleById(Long id);
}
