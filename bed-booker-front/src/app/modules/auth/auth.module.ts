import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SharedModule } from '../shared/shared.module';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatRadioModule } from '@angular/material/radio'
const components = [
  LoginComponent,
  RegisterComponent
]

@NgModule({
  declarations: [...components],
  imports: [
    CommonModule,
    SharedModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatRadioModule
  ],
  exports: [
    ...components
  ]
})
export class AuthModule { }
