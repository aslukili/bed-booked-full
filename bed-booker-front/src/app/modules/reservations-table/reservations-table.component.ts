import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Reservation } from 'src/app/models/Reservation';
import { ReservationService } from 'src/app/services/reservation.service';



@Component({
  selector: 'app-reservations-table',
  templateUrl: './reservations-table.component.html',
  styleUrls: ['./reservations-table.component.css']
})
export class ReservationsTableComponent implements OnInit {

  reservations: Reservation[] = [];

  constructor(
    private reservationService: ReservationService,
    private route: ActivatedRoute
  ) {}


  ngOnInit(): void {
    this.getUserReservations()
  }

  dataSource: Reservation[] = [];

  getUserReservations() {
    this.reservationService.getReservationsOfUser().subscribe({
      next: (reservationsResponse) => {
        this.reservations = reservationsResponse;
        console.log(this.reservations);
        this.dataSource = this.reservations;  
      }, 
      error: (error) => {
        console.log("error");
        console.error(error);
      }
    })
  }


  displayedColumns: string[] = ['Check in', 'Check out', 'Total price', 'Status', 'Actions'];
}
