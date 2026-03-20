import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
<<<<<<< HEAD
import { NavBarComponent } from './navbar/navbar.component';
import { AuthModule } from '../auth/auth.module';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    NavBarComponent 
  ],
  imports: [
    CommonModule,
    AuthModule,
    RouterModule
  ],
  exports: [
    NavBarComponent
  ]
=======
import { RouterModule } from '@angular/router';
import { NavBarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [NavBarComponent],
  imports: [CommonModule, RouterModule],
  exports: [NavBarComponent]
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
})
export class SharedModule {}