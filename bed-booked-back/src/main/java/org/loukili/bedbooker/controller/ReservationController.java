package org.loukili.bedbooker.controller;


import org.loukili.bedbooker.dtos.ReservationDto;
import org.loukili.bedbooker.entity.Reservation;
import org.loukili.bedbooker.entity.Room;
import org.loukili.bedbooker.entity.User;
import org.loukili.bedbooker.service.ReservationService;
import org.loukili.bedbooker.service.RoomService;
import org.loukili.bedbooker.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("${api.endpoint}/reservations")
public class ReservationController {
  private final ReservationService reservationService;
  private final RoomService roomService;
  private final UserService userService;

  public ReservationController(ReservationService reservationService, RoomService roomService, UserService userService) {
    this.reservationService = reservationService;
    this.roomService = roomService;
    this.userService = userService;
  }

  @GetMapping("")
  public ResponseEntity<List<Reservation>> getReservations(){
    return new ResponseEntity<>(reservationService.getReservations(), HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<Reservation> reserve(@RequestBody ReservationDto reservationRequest, @AuthenticationPrincipal User user){
    Reservation reservation = new Reservation();
    reservation.setCheckInDate(Date.valueOf(reservationRequest.getCheckInDate()));
    reservation.setCheckOutDate(Date.valueOf(reservationRequest.getCheckOutDate()));
    System.out.println("here");
    reservation.setRoom(roomService.getRoomById((long) reservationRequest.getRoomId()).orElseThrow());
    reservation.setUser(this.userService.getUserByEmail(user.getUsername()).orElseThrow());
    System.out.println("here");
    return new ResponseEntity<>(reservationService.reserve(reservation), HttpStatus.OK);
  }

  @GetMapping("/user")
  public ResponseEntity<List<Reservation>> getRoomsByHotelId(@AuthenticationPrincipal User user){
    String userEmail = user.getUsername();
    return new ResponseEntity<>(reservationService.getReservationsByUserEmail(userEmail), HttpStatus.OK);
  }
}
