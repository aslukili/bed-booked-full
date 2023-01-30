package org.loukili.bedbooker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_seq")
  @SequenceGenerator(name = "room_seq")
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "reference", nullable = false)
  private String reference;

  @Enumerated(EnumType.STRING)
  @Column(name = "room_type", nullable = false)
  private RoomType roomType;

  @Column(name = "price")
  private Double price;

  @Column(name = "capacity", nullable = false)
  private Integer capacity;

  @OneToMany(mappedBy = "room")
  private List<Reservation> reservations = new ArrayList<>();

  @ManyToOne(optional = false)
  @JoinColumn(name = "hotel_id", nullable = false)
  private Hotel hotel;

  @JsonIgnore
  public List<Reservation> getReservations() {
    return reservations;
  }

  @JsonProperty
  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public RoomType getRoomType() {
    return roomType;
  }

  public void setRoomType(RoomType roomType) {
    this.roomType = roomType;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public Hotel getHotel() {
    return hotel;
  }

  public void setHotel(Hotel hotel) {
    this.hotel = hotel;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
