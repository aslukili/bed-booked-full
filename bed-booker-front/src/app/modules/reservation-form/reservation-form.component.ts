import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ReservationDto } from 'src/app/models/dtos/ReservationDto';
import { Reservation } from 'src/app/models/Reservation';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.css']
})
export class ReservationFormComponent implements OnInit, OnDestroy {

  formGroup: FormGroup | undefined;
  // instead of defining a subscription for each method, we declare an array of subs
  private subscriptions: Subscription[] = [];


  // convert the keys from FilteredRole to values

  constructor(
    private formBuilder: FormBuilder,
    private reservationService: ReservationService,
    private router: Router,
    private route: ActivatedRoute
  ) {

  }
 
  ngOnInit(): void {
    // if there is already a sigged in  user the redirect to profile
    this.formGroup = this.formBuilder.group(
      {
        checkInDate: [undefined, Validators.required],
        checkOutDate: [undefined, Validators.required],
        roomId: [undefined],
      }
    )
  }

  onFormSubmit():void {
    // validate the form
    if(!this.formGroup?.valid){
      return;
    }

    const id = Number(this.route.snapshot.paramMap.get('id'));
    // TODO add room id from url to formGroup.roomId
    this.formGroup.controls['roomId'].setValue(id);
    console.log(this.formGroup.value);
    this.onReserve(this.formGroup.value)
  }

  public onReserve(reservation: ReservationDto): void {
    this.subscriptions.push(
      this.reservationService.reserve(reservation).subscribe({
        next: (response: Reservation) => {
          console.log("reserved");
          console.log(response)
          this.router.navigateByUrl('profile');
        },
        error: (httpErrorResponse: HttpErrorResponse) => {
          console.log("an error happened!");
          console.log(httpErrorResponse);
        }
      })
    )
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

}
