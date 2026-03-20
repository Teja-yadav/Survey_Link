<<<<<<< HEAD
import { Supplier } from "./Supplier";

export class Warehouse {
    warehouseId: number;
    supplier: Supplier;
    warehouseName: string;
    location: string;
    capacity: number;

    constructor(
        warehouseId: number,
        supplier: Supplier,
        warehouseName: string,
        location: string,
        capacity: number
    ) {
        this.warehouseId = warehouseId;
        this.supplier = supplier;
        this.warehouseName = warehouseName;
        this.location = location;
        this.capacity = capacity;
    }
}

=======
import { Supplier } from './Supplier';

export class Warehouse {
  warehouseId: number;
  supplier: Supplier;
  warehouseName: string;
  location: string;
  capacity: number;

  constructor(
    warehouseId: number,
    supplier: Supplier,
    warehouseName: string,
    location: string,
    capacity: number
  ) {
    this.warehouseId = warehouseId;
    this.supplier = supplier;
    this.warehouseName = warehouseName;
    this.location = location;
    this.capacity = capacity;
  }
}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
