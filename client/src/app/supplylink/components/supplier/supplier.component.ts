import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
import { Supplier } from '../../types/Supplier';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { of } from 'rxjs';
import { SupplyLinkService } from '../../services/supplylink.service';
import { HttpErrorResponse } from '@angular/common/http';
=======
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { BehaviorSubject, Observable } from 'rxjs';
import { SupplyLinkService } from '../../services/supplylink.service';
import { Supplier } from '../../types/Supplier';

>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e

@Component({
  selector: 'app-supplier',
  templateUrl: './supplier.component.html',
<<<<<<< HEAD
  styleUrls: ['./supplier.component.scss'],
})
export class SupplierComponent implements OnInit {
  successMessage: string | null = null;
  errorMessage: string | null = null;
  supplierForm!: FormGroup;
  supplier: Supplier | null = null;

  constructor(
    private formBuilder: FormBuilder,
    private supplyLinkService: SupplyLinkService
  ) {}

  ngOnInit(): void {
    this.supplierForm = this.formBuilder.group({
      supplierName: ["", [Validators.required]],
      email: ["", [Validators.required, Validators.email]],
      phone: [""],
      address: [""],
      username: ["", [Validators.required, this.noSpecialCharacters]],
      password: ["", [Validators.required, Validators.minLength(8)]],
      role: ["", [Validators.required]]
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
    if (this.supplierForm.valid) {
      this.supplyLinkService.addSupplier(this.supplierForm.value).subscribe({
        next: (response) => {
          this.supplier = response;
          this.successMessage = 'Supplier created successfully';
          this.errorMessage = null;
          this.supplierForm.reset();
        },
        error: (error) => this.handleError(error)
      });
    } else {
      this.errorMessage = 'Please fill out all required fields correctly.';
      this.successMessage = null;
    }
  }

  private handleError(error: HttpErrorResponse): void {
    if (error.error instanceof ErrorEvent) {
      this.errorMessage = `Client-side error: ${error.error.message}`;
    } else {
      this.errorMessage = `Server-side error: ${error.status} ${error.message}`;
      if (error.status === 400) {
        this.errorMessage = 'Bad request. Please check your input.';
      }
    }
    this.successMessage = null;
    console.error('An error occurred:', this.errorMessage);
  }

}
=======
  styleUrls: ['./supplier.component.scss']
})
export class SupplierComponent implements OnInit {
  supplierForm!: FormGroup;

  private successSubject = new BehaviorSubject<string | null>(null);
  private errorSubject = new BehaviorSubject<string | null>(null);
  success$: Observable<string | null> = this.successSubject.asObservable();
  error$: Observable<string | null> = this.errorSubject.asObservable();

  constructor(private fb: FormBuilder, private api: SupplyLinkService) {}

  ngOnInit(): void {
    this.supplierForm = this.fb.group({
      supplierName: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      phone: [''],
      address: [''],
      username: ['', [Validators.required, this.noSpecialCharacters()]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      role: ['', [Validators.required]]
    });

    this.supplierForm.valueChanges.subscribe(() => {
      this.successSubject.next(null);
      this.errorSubject.next(null);
    });
  }

  noSpecialCharacters() {
    const pattern = /^[A-Za-z0-9_]+$/;
    return (control: FormControl) => {
      const value = control?.value ?? '';
      return pattern.test(value) ? null : { specialChars: true };
    };
  }

  onSubmit(): void {
    if (this.supplierForm.invalid) {
      this.errorSubject.next('Please fix the highlighted errors and try again.');
      return;
    }
    const payload = this.supplierForm.getRawValue() as Supplier;
    this.api.addSupplier(payload).subscribe({
      next: () => this.successSubject.next('Supplier created successfully!'),
      error: (err) => {
        console.error(err);
        this.errorSubject.next('Failed to create supplier.');
      }
    });
  }

  get supplierName() { return this.supplierForm.get('supplierName') as FormControl; }
  get email() { return this.supplierForm.get('email') as FormControl; }
  get username() { return this.supplierForm.get('username') as FormControl; }
  get password() { return this.supplierForm.get('password') as FormControl; }
  get role() { return this.supplierForm.get('role') as FormControl; }
}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
