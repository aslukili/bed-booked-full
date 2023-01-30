package org.loukili.bedbooker.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.sql.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
  @SequenceGenerator(name = "reservation_seq")
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "check_in_date", nullable = false)
  private Date checkInDate;

  @Column(name = "check_out_date", nullable = false)
  private Date checkOutDate;

  @Column(name = "created_at", nullable = false)
  @CreationTimestamp
  private Timestamp createdAt;

  @Column(name = "updated_at", nullable = false)
  @UpdateTimestamp
  private Timestamp updatedAt;

  @Column(name = "is_not_canceled", nullable = false)
  private Boolean isNotCanceled = true;


  @Column(name = "is_approved", nullable = false)
  private Boolean isApproved = false;

  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne(optional = false)
  @JoinColumn(name = "room_id", nullable = false)
  private Room room;

  @Column(name = "price", nullable = false)
  private Double price;

  public Boolean getIsApproved() {
    return isApproved;
  }

  public void setIsApproved(Boolean approved) {
    isApproved = approved;
  }
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Boolean getIsNotCanceled() {
    return isNotCanceled;
  }

  public void setIsNotCanceled(Boolean isNotCanceled) {
    this.isNotCanceled = isNotCanceled;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Date getCheckOutDate() {
    return checkOutDate;
  }

  public void setCheckOutDate(Date checkOutDate) {
    this.checkOutDate = checkOutDate;
  }

  public Date getCheckInDate() {
    return checkInDate;
  }

  public void setCheckInDate(Date checkInDate) {
    this.checkInDate = checkInDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
