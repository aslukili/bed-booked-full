package org.loukili.bedbooker.controller;


import org.loukili.bedbooker.entity.Hotel;
import org.loukili.bedbooker.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${api.endpoint}/hotels")
public class HotelController {
  private final HotelService hotelService;

  @Autowired
  public HotelController(HotelService hotelService) {
    this.hotelService = hotelService;
  }


  @GetMapping("")
  public ResponseEntity<List<Hotel>> getAll(){
    return new ResponseEntity<>(hotelService.getAll(), HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
    return new ResponseEntity<>(hotelService.save(hotel), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Hotel>> getHotel(@PathVariable int id){
    return new ResponseEntity<>(hotelService.getHotelById((long) id), HttpStatus.OK);
  }
}
