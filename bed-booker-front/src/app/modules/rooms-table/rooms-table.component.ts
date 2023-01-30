import { animate, state, style, transition, trigger } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { ActivatedRoute } from '@angular/router';
import { Room } from 'src/app/models/Room';
import { RoomService } from 'src/app/services/room.service';

// export interface PeriodicElement {
//   name: string;
//   position: number;
//   weight: number;
//   symbol: string;
//   description: string;
// }

@Component({
  selector: 'app-rooms-table',
  templateUrl: './rooms-table.component.html',
  styleUrls: ['./rooms-table.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class RoomsTableComponent implements OnInit{

  rooms: Room[] = [];

  constructor(
    private roomService: RoomService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.getRooms();
  }

  dataSource: Room[] = [];

  getRooms() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.roomService.getRoomsByHotelId(id, this.pageEvent?.pageIndex, this.pageEvent?.pageSize).subscribe({
      next: (roomsResponse) => {
        this.rooms = roomsResponse;
        console.log(this.rooms);
        this.dataSource = this.rooms;  

      }, 
      error: (error) => {
        console.log("error");
        console.error(error);
      }
    })
  }
  columnsToDisplay = ['reference', 'roomType', 'capacity', 'price'];
  columnsToDisplayWithExpand = [...this.columnsToDisplay, 'expand'];
  expandedElement!: Room;

  pageSize = 5;
  pageSizeOptions: number[] = [2, 5, 10, 25, 100];
  totalLength = 100;
  pageEvent: PageEvent = { pageIndex: 0, pageSize: 5, length: 100};

  onChangedTable(event: PageEvent) {
    this.pageEvent = event;
    this.getRooms();
  }
}
