import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Hotel } from 'src/app/models/Hotel';
import { HotelService } from 'src/app/services/hotel.service';

@Component({
  selector: 'app-hotel-details',
  templateUrl: './hotel-details.component.html',
  styleUrls: ['./hotel-details.component.css']
})
export class HotelDetailsComponent implements OnInit{

  hotel?: Hotel;

  constructor(
    private hotelService: HotelService,
    private route: ActivatedRoute

  ) {}

  ngOnInit(): void {
    this.getHotel();
  }

  getHotel() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.hotelService.getHotel(id)
    .subscribe({
      next: (hotelsResponse) => {
        this.hotel = hotelsResponse;
        console.log(this.hotel);
      }, 
      error: (error) => {
        console.log("error");
        console.error(error);
      }
    });
  }

}
