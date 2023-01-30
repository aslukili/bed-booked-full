import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environment/environment';
import { Room } from '../models/Room';

@Injectable({
  providedIn: 'root'
})
export class RoomService {
  
  private readonly apiUrl = environment.apiUrl


  constructor(
    private http: HttpClient
  ) { }

  getRoomsByHotelId(id: number, pageIndex: number, pageSize: number): Observable<Room[]> {
    const params = new HttpParams()
    .set('hotel_id', id.toString())
    .set('page_number', pageIndex.toString())
    .set('page_size', pageSize.toString());
  return this.http.get<Room[]>(`${this.apiUrl}/rooms/paginate`, { params });
  }
}
