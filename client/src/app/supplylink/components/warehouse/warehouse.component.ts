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
  selector: 'app-warehouse',
  templateUrl: './warehouse.component.html',
  styleUrls: ['./warehouse.component.scss']
})
export class WarehouseComponent implements OnInit {
  warehouseForm!: FormGroup;

  private successSubject = new BehaviorSubject<string | null>(null);
  private errorSubject = new BehaviorSubject<string | null>(null);
  success$: Observable<string | null> = this.successSubject.asObservable();
  error$: Observable<string | null> = this.errorSubject.asObservable();

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.warehouseForm = this.fb.group({
      // The Day-21 tests already passed for supplierId, keep > 0 using min(1)
      supplierId: ['', [Validators.required, Validators.min(1)]],

      warehouseName: ['', [Validators.required]],
      location: [''],

      // 🔧 IMPORTANT: Use built-in Validators.min(0) so error key is 'min'
      capacity: ['', [Validators.required, Validators.min(0)]],
    });

    this.warehouseForm.valueChanges.subscribe(() => {
      this.successSubject.next(null);
      this.errorSubject.next(null);
    });
  }

  // (Optional) If you still need custom validators elsewhere, keep these.
  // supplierId must be > 0 (we already use Validators.min(1) above)
  positiveNumberValidator(): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      const num = Number(control.value);
      return Number.isFinite(num) && num > 0 ? null : { positive: true };
    };
  }

  // Simulate backend duplicate name check
  private simulateBackend(payload: any): Promise<void> {
    return new Promise((resolve, reject) => {
      if ((payload.warehouseName || '').toLowerCase() === 'duplicate') {
        reject(new Error('Warehouse name already exists.'));
      } else {
        resolve();
      }
    });
  }

  onSubmit(): void {
    if (this.warehouseForm.invalid) {
      this.errorSubject.next('Please fix the highlighted errors and try again.');
      return;
    }

    const payload = this.warehouseForm.getRawValue();

    this.simulateBackend(payload)
      .then(() => {
        this.successSubject.next('Warehouse created successfully!');
        this.errorSubject.next(null);
      })
      .catch((err: Error) => {
        this.errorSubject.next(err.message || 'Something went wrong.');
        this.successSubject.next(null);
      });
  }

  // Getters
  get supplierId()    { return this.warehouseForm.get('supplierId') as FormControl; }
  get warehouseName() { return this.warehouseForm.get('warehouseName') as FormControl; }
  get location()      { return this.warehouseForm.get('location') as FormControl; }
  get capacity()      { return this.warehouseForm.get('capacity') as FormControl; }
}