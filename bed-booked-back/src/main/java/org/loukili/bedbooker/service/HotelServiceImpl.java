package org.loukili.bedbooker.service;


import org.loukili.bedbooker.entity.Hotel;
import org.loukili.bedbooker.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService{

  private final HotelRepository hotelRepository;
  private final UserService userService;

  @Autowired
  public HotelServiceImpl(HotelRepository hotelRepository, UserService userService) {
    this.hotelRepository = hotelRepository;
    this.userService = userService;
  }

  @Override
  public List<Hotel> getAll() {
    return hotelRepository.findAll();
  }

  @Override
  public Hotel save(Hotel hotel) {
    // get user by id for now and change it later to get it from auth token
    // we expect the user object with only the id
    hotel.setUser(userService.getUserById(hotel.getUser().getId()).orElseThrow());
    return hotelRepository.save(hotel);
  }

  @Transactional
  @Override
  public Optional<Hotel> getHotelById(Long id) {
    return hotelRepository.findHotelById(id);
  }
}
