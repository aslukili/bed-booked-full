import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatCardModule } from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon'



import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './modules/home/home.component';
import { ProfileComponent } from './modules/profile/profile.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthModule } from './modules/auth/auth.module';
import { AuthenticationGuard } from './guards/authentication.guard';
import { AuthenticationInterceptor } from './interceptors/authentication.interceptor';
import { SharedModule } from "./modules/shared/shared.module";
import { HotelsComponent } from './modules/hotels/hotels.component';
import { HotelDetailsComponent } from './modules/hotel-details/hotel-details.component';
import { RoomsTableComponent } from './modules/rooms-table/rooms-table.component';
import { ReservationFormComponent } from './modules/reservation-form/reservation-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { ReservationsTableComponent } from './modules/reservations-table/reservations-table.component';
import { MatButtonModule } from '@angular/material/button';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatMenuModule} from '@angular/material/menu';
import { RouterModule } from '@angular/router';
import { DashboardComponent } from './modules/admin/dashboard/dashboard.component';
import { UsersComponent } from './modules/admin/users/users.component';
import {MatPaginatorModule} from '@angular/material/paginator';

import { SideBarComponent } from './modules/shared/layout/side-bar/side-bar.component';
import { AwaitingConfirmedPipe } from './modules/shared/pipes/awaiting-confirmed.pipe';




@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        ProfileComponent,
        HotelsComponent,
        HotelDetailsComponent,
        RoomsTableComponent,
        ReservationFormComponent,
        ReservationsTableComponent,
        DashboardComponent,
        UsersComponent,
    ],
    providers: [
        { provide: HTTP_INTERCEPTORS, useClass: AuthenticationInterceptor, multi: true }
    ],
    bootstrap: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MatCardModule,
        HttpClientModule,
        AuthModule,
        SharedModule,
        MatTableModule,
        MatIconModule,
        ReactiveFormsModule,
        MatInputModule,
        MatButtonModule,
        MatDatepickerModule,
        MatNativeDateModule,
        MatMenuModule,
        RouterModule,
        MatPaginatorModule
    ]
})
export class AppModule { }
