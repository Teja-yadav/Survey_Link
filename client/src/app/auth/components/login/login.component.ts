<<<<<<< HEAD
import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Observable, catchError, of, switchMap, tap, throwError } from "rxjs";
import { Router } from "@angular/router";
import { AuthService } from "../../services/auth.service";

@Component({
    selector: "app-login",
    templateUrl: "./login.component.html",
    styleUrls: ["./login.component.scss"],
})
export class LoginComponent implements OnInit {
    loginForm!: FormGroup;
    errorMessage: string | null = null;

    constructor(
        private formBuilder: FormBuilder,
        private authService: AuthService,
        private router: Router
    ) { }

    ngOnInit(): void {
        this.loginForm = this.formBuilder.group({
            username: ["", [Validators.required]],
            password: ["", Validators.required],

        });
    }

    onSubmit(): void {
        if (this.loginForm.valid) {
            const { username, password } = this.loginForm.value;
            this.authService.login({ username, password }).subscribe({
                next: (response) => {
                    console.log(response);
                    localStorage.setItem("token", response["token"]);
                    localStorage.setItem("role", response["roles"]);
                    localStorage.setItem("user_id", response["userId"]);
                    console.log(localStorage.getItem("role"));
                    this.router.navigate(["/supplylink"]);
                },
                error: (error) => {
                    console.log(error);
                    this.errorMessage = "Please check the username and password.";
                }
            });
        } else {
            this.errorMessage = "Please check the username and password.";
        }
    }
}
=======
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;

  constructor(private fb: FormBuilder, private authService: AuthService) {}

  ngOnInit(): void {
    // Initialize with empty fields as Day-22 tests expect
    this.loginForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }

  onSubmit(): void {
    if (this.loginForm.invalid) {
      return; // Day-22 test asserts we do NOT call service when invalid
    }
    const payload = this.loginForm.getRawValue();
    this.authService.login(payload).subscribe({
      next: () => {},
      error: () => {},
    });
  }

  // Getters (handy in template/tests)
  get username() { return this.loginForm.get('username') as FormControl; }
  get password() { return this.loginForm.get('password') as FormControl; }
}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
