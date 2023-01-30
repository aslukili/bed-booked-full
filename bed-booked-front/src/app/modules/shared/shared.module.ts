import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './layout/header/header.component';
import { FooterComponent } from './layout/footer/footer.component';
import { MatMenuModule } from '@angular/material/menu';
import { RouterModule } from '@angular/router';
import { SideBarComponent } from './layout/side-bar/side-bar.component';
import { AwaitingConfirmedPipe } from './pipes/awaiting-confirmed.pipe';


const components = [
  HeaderComponent,
  FooterComponent,
  SideBarComponent,
  AwaitingConfirmedPipe
]


@NgModule({
  declarations: [...components, AwaitingConfirmedPipe],
  imports: [
    CommonModule,
    MatMenuModule,
    RouterModule
  ],
  exports: [...components]
})
export class SharedModule { }
