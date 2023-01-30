import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './modules/admin/dashboard/dashboard.component';
import { LoginComponent } from './modules/auth/login/login.component';
import { RegisterComponent } from './modules/auth/register/register.component';
import { HomeComponent } from './modules/home/home.component';
import { HotelDetailsComponent } from './modules/hotel-details/hotel-details.component';
import { ProfileComponent } from './modules/profile/profile.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'profile',
    component: ProfileComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  { path: 'hotels/:id', component: HotelDetailsComponent},
  { path: 'admin/dashboard', component: DashboardComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
