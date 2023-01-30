import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{
  user: User | undefined;

  constructor(private userService: UserService){}


  ngOnInit(): void {
    this.userService.getLoggedInUser().subscribe({
      next: (user) => {
        console.log("sucess!");
        console.log(user);
        this.user = user;
      }, 
      error: (error) => {
        console.log("error");
        console.error(error);
      }
    });
  }



}
