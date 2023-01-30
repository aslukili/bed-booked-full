package org.loukili.bedbooker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
  @SequenceGenerator(name = "role_seq")
  @Column(name = "id", nullable = false)
  private Long id;

  @OneToMany(mappedBy = "role")
  private List<User> users = new ArrayList<>();

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @JsonIgnore
  public List<User> getUsers() {
    return users;
  }

  @JsonProperty
  public void setUsers(List<User> users) {
    this.users = users;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
