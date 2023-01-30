package org.loukili.bedbooker.controller;


import org.loukili.bedbooker.entity.Room;
import org.loukili.bedbooker.repository.RoomRepository;
import org.loukili.bedbooker.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.endpoint}/rooms")
public class RoomController {

  private final RoomService roomService;

  @Autowired
  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @GetMapping("")
  public ResponseEntity<List<Room>> getAll(){
    return new ResponseEntity<>(roomService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/hotel")
  public ResponseEntity<List<Room>> getRoomsByHotelId(@RequestParam(name = "hotelId") Long hotelId){
    return new ResponseEntity<>(roomService.getRoomsByHotelId(hotelId), HttpStatus.OK);
  }

  @GetMapping("/paginate")
  public ResponseEntity<List<Room>> getPaginated(@RequestParam(name = "hotel_id") Long hotel_id,@RequestParam(name = "page_number") int pageNumber, @RequestParam("page_size") int pageSize){
    return new ResponseEntity<>(roomService.getPaginatedWithHotelId(hotel_id ,pageNumber,pageSize), HttpStatus.OK);
  }



  @PostMapping("")
  public ResponseEntity<Room> save(@RequestBody Room room){
    return new ResponseEntity<>(roomService.save(room), HttpStatus.OK);
  }
}
