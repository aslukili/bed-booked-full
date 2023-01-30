import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environment/environment';
import { Hotel } from '../models/Hotel';

@Injectable({
  providedIn: 'root'
})
export class HotelService {
  

  private readonly apiUrl = environment.apiUrl

  constructor(
    private http: HttpClient
  ) { }

  getHotels(): Observable<Hotel[]> {
    return this.http.get<Hotel[]>(`${this.apiUrl}/hotels`);
  }

  getHotel(id: number): Observable<Hotel> {
    return this.http.get<Hotel>(`${this.apiUrl}/hotels/${id}`);
  }
}
