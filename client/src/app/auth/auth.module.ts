import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { AuthRoutingModule } from "./auth-routing.module";
import { ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
<<<<<<< HEAD
import { RouterModule } from "@angular/router";
import { LoginComponent } from "./components/login/login.component";
import { LogoutComponent } from "./components/logout/logout.component";
import { UserComponent } from "./components/user/user.component";

@NgModule({
  declarations: [
    LoginComponent,
    LogoutComponent,
    UserComponent
  ],
=======

@NgModule({
  declarations: [],
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
  imports: [
    CommonModule,
    AuthRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
<<<<<<< HEAD
    RouterModule
  ],
  exports: [
    LogoutComponent
=======
  ],
  exports: [
    
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
  ]
})
export class AuthModule {}
