import { Component, OnInit } from '@angular/core';
import { Route, Router, RouterLink } from '@angular/router';
import { Hotel } from 'src/app/models/Hotel';
import { HotelService } from 'src/app/services/hotel.service';

@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.css']
})
export class HotelsComponent implements OnInit {

  hotels: Hotel[] = []

  constructor(
    private router: Router,
    private hotelService: HotelService
  ) {}

  ngOnInit(): void {
    this.hotelService.getHotels().subscribe({
      next: (hotelsResponse) => {
        this.hotels = hotelsResponse;
        console.log(this.hotels);
      }, 
      error: (error) => {
        console.log("error");
        console.error(error);
      }
    })
  }

  showHotelInfo(hotelId: number): void {
    this.router.navigateByUrl(`/hotels/${hotelId}`)
  }
}
