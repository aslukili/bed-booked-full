package org.loukili.bedbooker.auth;




import lombok.RequiredArgsConstructor;
import org.loukili.bedbooker.config.JwtService;
import org.loukili.bedbooker.entity.Role;
import org.loukili.bedbooker.entity.User;
import org.loukili.bedbooker.repository.UserRepository;
import org.loukili.bedbooker.service.RoleService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final RoleService roleService;
  private final AuthenticationManager authenticationManager;


  public AuthenticationResponse register(RegisterRequest request) {
    User user = User.builder()
      .firstName(request.getFirstName())
      .lastName(request.getLastName())
      .email(request.getEmail())
      .password(passwordEncoder.encode(request.getPassword()))
      .role(roleService.getRoleById((long) request.getRoleId()).orElseThrow())
      .build();
    userRepository.save(user);


    String jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
      .token(jwtToken)
      .build();
  }

  public AuthenticationResponse login(AuthenticationRequest request) {
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        request.getEmail(),
        request.getPassword()
      )
    );

    User user = userRepository.findByEmail(request.getEmail()).orElseThrow();


    String jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
      .token(jwtToken)
      .build();
  }
}
