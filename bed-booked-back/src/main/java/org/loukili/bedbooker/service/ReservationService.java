package org.loukili.bedbooker.service;

import org.loukili.bedbooker.entity.Reservation;

import java.util.List;

public interface ReservationService {
  List<Reservation> getReservations();

  Reservation reserve(Reservation reservation);

  List<Reservation> getReservationsByUserEmail(String userEmail);
}
