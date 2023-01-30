package org.loukili.bedbooker.repository;


import org.loukili.bedbooker.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
  List<Reservation> findReservationsByUserEmail(String userEmail);
}
