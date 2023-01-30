package org.loukili.bedbooker.dtos;

import java.time.LocalDate;



public class ReservationDto {
  private LocalDate checkInDate;
  private LocalDate checkOutDate;
  private int roomId;

  public ReservationDto(LocalDate checkInDate, LocalDate checkOutDate, int roomId) {
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    this.roomId = roomId;
  }

  public ReservationDto(){}

  public LocalDate getCheckInDate() {
    return checkInDate;
  }

  public void setCheckInDate(LocalDate checkInDate) {
    this.checkInDate = checkInDate;
  }

  public LocalDate getCheckOutDate() {
    return checkOutDate;
  }

  public void setCheckOutDate(LocalDate checkOutDate) {
    this.checkOutDate = checkOutDate;
  }

  public int getRoomId() {
    return roomId;
  }

  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }
}

