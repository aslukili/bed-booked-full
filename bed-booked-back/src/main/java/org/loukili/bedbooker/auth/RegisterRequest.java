package org.loukili.bedbooker.auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.loukili.bedbooker.entity.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private int roleId;
}
