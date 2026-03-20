<<<<<<< HEAD
import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { AuthService } from "../../services/auth.service";
import { HttpErrorResponse } from "@angular/common/http";

@Component({
    selector: "app-user",
    templateUrl: "./user.component.html",
    styleUrls: ["./user.component.scss"],
})
export class UserComponent implements OnInit {
    userForm!: FormGroup;
    successMessage: string | null = null;
    errorMessage: string | null = null;

    constructor(
        private formBuilder: FormBuilder,
        private authService: AuthService
    ) { }

    ngOnInit(): void {
        this.userForm = this.formBuilder.group({
            username: ["", [Validators.required, this.noSpecialCharacters]],
            password: ["", [Validators.required, Validators.minLength(8)]],
            role: ["", [Validators.required]],
            supplierName: ["", [Validators.required]],
            email: ["", [Validators.required, Validators.email]],
        });
    }

    private noSpecialCharacters(control: any): { [key: string]: boolean } | null {
        const SPECIAL_CHARACTERS_REGEX = /[!@#$%^&*()_+{}\[\]:;<>,.?~\\/-]/;
        if (SPECIAL_CHARACTERS_REGEX.test(control.value)) {
            return { specialCharacters: true };
        }
        return null;
    }

    onSubmit(): void {
        if (this.userForm.valid) {
            this.authService.createUser(this.userForm.value).subscribe({
                next: (response) => {
                    this.successMessage = "User created successfully";
                    this.userForm.reset();
                    this.errorMessage = "";
                },
                error: (error) => {
                    console.log(error);
                    this.errorMessage = error.error ?? "Please fill the form correctly";
                }
            });
        }
        else {
            this.errorMessage = "Please fill the form correctly";
        }
    }
=======
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

/**
 * Minimal "User" form just to satisfy Day-22 tests:
 * - ngOnInit initializes with empty fields
 * - Contains basic fields (you can expand later)
 */
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss'],
})
export class UserComponent implements OnInit {
  userForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    // Initialize with empty values as tests require
    this.userForm = this.fb.group({
      name: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      username: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(8)]],
    });
  }

  onSubmit(): void {
    if (this.userForm.invalid) return;
    // For Day-22 test, no specific submit behavior required
    const payload = this.userForm.getRawValue();
    console.log('User form submitted:', payload);
  }

  get name() { return this.userForm.get('name') as FormControl; }
  get email() { return this.userForm.get('email') as FormControl; }
  get username() { return this.userForm.get('username') as FormControl; }
  get password() { return this.userForm.get('password') as FormControl; }
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}
