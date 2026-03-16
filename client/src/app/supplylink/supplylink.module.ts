import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { SupplyLinkRoutingModule } from './supplylink-routing.module';
import { SupplierComponent } from './components/supplier/supplier.component';
import { WarehouseComponent } from './components/warehouse/warehouse.component';
import { ProductComponent } from './components/product/product.component';


@NgModule({
  declarations: [
    SupplierComponent,
    WarehouseComponent,
    ProductComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule,
    SupplyLinkRoutingModule
  ]
})
export class SupplyLinkModule {}
