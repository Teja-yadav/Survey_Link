import { Component } from '@angular/core';
import { Warehouse } from '../../types/Warehouse';

@Component({
  selector: 'app-warehousesample',
  standalone: true,
  imports: [],
  templateUrl: './warehousesample.component.html',
  styleUrls: ['./warehousesample.component.css']
})
export class WarehouseSampleComponent {

<<<<<<< HEAD
}
=======
  warehouse: Warehouse = new Warehouse(
    1,
    "12",
    "Flamingo",
    "Nevada",
    1000
  );

}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
