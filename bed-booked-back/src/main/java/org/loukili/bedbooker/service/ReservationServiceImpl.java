package org.loukili.bedbooker.service;


import org.loukili.bedbooker.entity.Reservation;
import org.loukili.bedbooker.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ReservationServiceImpl implements ReservationService{

  private final ReservationRepository reservationRepository;
  private final RoomService roomService;
  private final UserService userService;

  @Autowired
  public ReservationServiceImpl(ReservationRepository reservationRepository, RoomService roomService, UserService userService) {
    this.reservationRepository = reservationRepository;
    this.roomService = roomService;
    this.userService = userService;
  }

  @Override
  public List<Reservation> getReservations() {
    return reservationRepository.findAll();
  }

  @Transactional
  @Override
  public Reservation reserve(Reservation reservation) {
    // calculate the total price:
    reservation.setPrice(getDifferenceDays(reservation.getCheckInDate(), reservation.getCheckOutDate()) * reservation.getRoom().getPrice());
    return reservationRepository.save(reservation);
  }


  @Transactional
  @Override
  public List<Reservation> getReservationsByUserEmail(String userEmail) {
    return reservationRepository.findReservationsByUserEmail(userEmail);
  }


  // calculate the days between checkin and checkout days
  public static long getDifferenceDays(Date d1, Date d2) {
    long diff = d2.getTime() - d1.getTime();
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
  }
}
