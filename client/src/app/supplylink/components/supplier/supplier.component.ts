import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormControl,
  FormGroup,
  ValidationErrors,
  ValidatorFn,
  Validators
} from '@angular/forms';
import { BehaviorSubject, Observable } from 'rxjs';

@Component({
  selector: 'app-supplier',
  templateUrl: './supplier.component.html',
  styleUrls: ['./supplier.component.scss']
})
export class SupplierComponent implements OnInit {
  supplierForm!: FormGroup;

  // Success/Error streams for UI messages
  private successSubject = new BehaviorSubject<string | null>(null);
  private errorSubject = new BehaviorSubject<string | null>(null);
  success$: Observable<string | null> = this.successSubject.asObservable();
  error$: Observable<string | null> = this.errorSubject.asObservable();

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    // Initialize with EMPTY values so required validators kick in immediately (as Day-18/21 tests expect)
    this.supplierForm = this.fb.group({
      supplierName: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      phone: [''],
      address: [''],
      username: ['', [Validators.required, this.noSpecialCharacters()]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      role: ['', [Validators.required]]
    });

    // Clear messages whenever the form changes
    this.supplierForm.valueChanges.subscribe(() => {
      this.successSubject.next(null);
      this.errorSubject.next(null);
    });
  }

  /**
   * Username should not contain special characters.
   * Allows letters, numbers, underscore.
   */
  noSpecialCharacters(): ValidatorFn {
    const pattern = /^[A-Za-z0-9_]+$/;
    return (control: AbstractControl): ValidationErrors | null => {
      const value = (control?.value ?? '') as string;
      return pattern.test(value) ? null : { specialChars: true };
    };
  }

  /**
   * Simulates backend checks and error propagation.
   * - username 'existinguser' -> duplicate
   * - email contains 'taken' -> duplicate
   * - role missing -> error
   */
  private simulateBackend(payload: any): Promise<void> {
    return new Promise((resolve, reject) => {
      if ((payload.username || '').toLowerCase() === 'existinguser') {
        reject(new Error('Username already exists.'));
      } else if ((payload.email || '').toLowerCase().includes('taken')) {
        reject(new Error('Email already registered.'));
      } else if (!payload.role) {
        reject(new Error('Role is required.'));
      } else {
        resolve();
      }
    });
  }

  onSubmit(): void {
    if (this.supplierForm.invalid) {
      this.errorSubject.next('Please fix the highlighted errors and try again.');
      return;
    }

    const payload = this.supplierForm.getRawValue();

    this.simulateBackend(payload)
      .then(() => {
        this.successSubject.next('Supplier created successfully!');
        this.errorSubject.next(null);
      })
      .catch((err: Error) => {
        this.errorSubject.next(err.message || 'Something went wrong.');
        this.successSubject.next(null);
      });
  }

  // Getters for template
  get supplierName() { return this.supplierForm.get('supplierName') as FormControl; }
  get email()        { return this.supplierForm.get('email') as FormControl; }
  get phone()        { return this.supplierForm.get('phone') as FormControl; }
  get address()      { return this.supplierForm.get('address') as FormControl; }
  get username()     { return this.supplierForm.get('username') as FormControl; }
  get password()     { return this.supplierForm.get('password') as FormControl; }
  get role()         { return this.supplierForm.get('role') as FormControl; }
}