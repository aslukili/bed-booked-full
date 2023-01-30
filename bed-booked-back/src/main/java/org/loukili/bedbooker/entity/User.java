package org.loukili.bedbooker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
  @SequenceGenerator(name = "user_seq")
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @ManyToOne(optional = false)
  @JoinColumn(name = "role_id", nullable = false)
  private Role role;

  @OneToMany(mappedBy = "user")
  private List<Reservation> reservations = new ArrayList<>();

  @OneToMany(mappedBy = "user")
  private List<Hotel> hotels = new ArrayList<>();


  @JsonIgnore
  public List<Reservation> getReservations() {
    return reservations;
  }

  @JsonProperty
  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @JsonIgnore
  public List<Hotel> getHotels() {
    return hotels;
  }


  @JsonProperty
  public void setHotels(List<Hotel> hotels) {
    this.hotels = hotels;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
