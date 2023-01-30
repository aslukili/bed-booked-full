package org.loukili.bedbooker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_seq")
  @SequenceGenerator(name = "hotel_seq")
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "picture", nullable = false)
  private String picture;

  @Column(name = "city", nullable = false)
  private String city;

  @Column(name = "address")
  private String address;

  @Column(name = "is_approved")
  private Boolean isApproved = false;

  @Column(name = "rating")
  private Double rating;

  @OneToMany(mappedBy = "hotel")
  private List<Room> rooms = new ArrayList<>();

  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(name = "minimum_price")
  private Double minimumPrice;

  @Lob
  @Column(name = "description")
  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getMinimumPrice() {
    return minimumPrice;
  }

  public void setMinimumPrice(Double minimumPrice) {
    this.minimumPrice = minimumPrice;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @JsonIgnore
  public List<Room> getRooms() {
    return rooms;
  }

  @JsonProperty
  public void setRooms(List<Room> rooms) {
    this.rooms = rooms;
  }

  public Double getRating() {
    return rating;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public Boolean getIsApproved() {
    return isApproved;
  }

  public void setIsApproved(Boolean isApproved) {
    this.isApproved = isApproved;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
