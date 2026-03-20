import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
<<<<<<< HEAD

@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.scss']
})
export class NavBarComponent implements OnInit {
    role!: string | null;

    constructor(private router: Router) { }

    ngOnInit(): void {
        console.log(localStorage.getItem("role"));
        this.role = localStorage.getItem("role");
    }

    logout(): void {
        localStorage.removeItem('token')
        this.router.navigate(["/auth"]);
    }

=======
import { AuthService } from '../../auth/services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavBarComponent implements OnInit {
  role: string | null = null;

  constructor(private router: Router, private auth: AuthService) {}

  ngOnInit(): void {
    this.role = this.auth.getRole();
  }

  logout(): void {
    this.auth.logout();
    this.role = null;
    // Optional: navigate to login route if you have it
    // this.router.navigate(['/login']);
  }
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}
