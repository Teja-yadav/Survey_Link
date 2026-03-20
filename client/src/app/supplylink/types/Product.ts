<<<<<<< HEAD
import { Warehouse } from "./Warehouse";

export class Product {
    productId: number;
    warehouse: Warehouse;
    productName: string;
    productDescription: string;
    quantity: number;
    price: number;

    constructor(
        productId: number,
        warehouse: Warehouse,
        productName: string,
        productDescription: string,
        quantity: number,
        price: number
    ) {
        this.productId = productId;
        this.warehouse = warehouse;
        this.productName = productName;
        this.productDescription = productDescription;
        this.quantity = quantity;
        this.price = price;
    }

}

=======
import { Warehouse } from './Warehouse';

export class Product {
  productId: number;
  warehouse: Warehouse;
  productName: string;
  productDescription: string;
  quantity: number;
  price: number;

  constructor(
    productId: number,
    warehouse: Warehouse,
    productName: string,
    productDescription: string,
    quantity: number,
    price: number
  ) {
    this.productId = productId;
    this.warehouse = warehouse;
    this.productName = productName;
    this.productDescription = productDescription;
    this.quantity = quantity;
    this.price = price;
  }
}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
