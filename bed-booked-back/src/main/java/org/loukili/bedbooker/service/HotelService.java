package org.loukili.bedbooker.service;

import org.loukili.bedbooker.entity.Hotel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    List<Hotel> getAll();

    Hotel save(Hotel hotel);
    Optional<Hotel> getHotelById(Long id);
}
