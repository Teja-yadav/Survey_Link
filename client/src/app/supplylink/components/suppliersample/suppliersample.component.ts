import { Component } from '@angular/core';
import { Supplier } from '../../types/Supplier';

@Component({
  selector: 'app-suppliersample',
  standalone: true,
  imports: [],
  templateUrl: './suppliersample.component.html',
<<<<<<< HEAD
  styleUrls: ['./suppliersample.component.css'] 
})
export class SupplierSampleComponent {
  supplier:Supplier = new Supplier(1, "John Wane", "johnwane@gmail.com", "9876543210", "texas", "johnwane", "July@101", "USER");
=======
  styleUrls: ['./suppliersample.component.css']
})
export class SupplierSampleComponent {

  supplier: Supplier = new Supplier(
    1,
    "John Wane",
    "johnwane@gmail.com",
    "9876543210",
    "texas",
    "johnwane",
    "July@101",
    "USER"
  );

>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}