import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
<<<<<<< HEAD
import { LoginComponent } from "./components/login/login.component";
import { UserComponent } from "./components/user/user.component";

const routes: Routes = [
  { path: "", component: LoginComponent },
  { path: "login", component: LoginComponent },
  { path: "add-user", component: UserComponent },
];
=======

const routes: Routes = [];
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
<<<<<<< HEAD
export class AuthRoutingModule { }
=======
export class AuthRoutingModule {}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
