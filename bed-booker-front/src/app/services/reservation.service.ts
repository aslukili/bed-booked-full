import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environment/environment';
import { ReservationDto } from '../models/dtos/ReservationDto';
import { Reservation } from '../models/Reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  

  private readonly apiUrl = environment.apiUrl;

  constructor(
    private http: HttpClient
  ) { }

  public reserve(reservation: ReservationDto): Observable<Reservation> {
    return this.http.post<Reservation>(`${this.apiUrl}/reservations`, reservation);
  }

  public getReservationsOfUser(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(`${this.apiUrl}/reservations/user`);
  }
}
