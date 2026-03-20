<<<<<<< HEAD
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-logout',
    templateUrl: './logout.component.html',
    styleUrls: ['./logout.component.scss']
})
export class LogoutComponent implements OnInit {

    constructor(private router: Router) { }

    ngOnInit(): void {
    }

    logout(): void {
        localStorage.removeItem('token')
        this.router.navigate(["/auth"]);
    }

}
=======
import { Component } from '@angular/core';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css'],
})
export class LogoutComponent {
  logout(): void {
    localStorage.removeItem('token');
    console.log('Logged out');
  }
}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
