<<<<<<< HEAD
import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { SupplyLinkRoutingModule } from "./supplylink-routing.module";
import { ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { RouterModule } from "@angular/router";
import { ProductComponent } from "./components/product/product.component";
import { SupplierComponent } from "./components/supplier/supplier.component";
import { WarehouseComponent } from "./components/warehouse/warehouse.component";
import { DashboardComponent } from "./components/dashboard/dashboard.component";
import { SharedModule } from "../shared/shared.module";
import { SupplierEditComponent } from "./components/supplieredit/supplieredit.component";
import { WarehouseEditComponent } from "./components/warehouseedit/warehouseedit.component";

@NgModule({
  declarations: [
    ProductComponent,
    SupplierComponent,
    WarehouseComponent,
    DashboardComponent,
    SupplierEditComponent,
    WarehouseEditComponent
  ],
  imports: [
    CommonModule,
    SupplyLinkRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule,
    SharedModule
  ],
  exports: [

  ]
})
export class SupplyLinkModule { }
=======
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';

import { SharedModule } from '../shared/shared.module';


import { DashboardComponent } from './components/dashboard/dashboard.component';
import { SupplierComponent } from './components/supplier/supplier.component';
import { WarehouseComponent } from './components/warehouse/warehouse.component';
import { ProductComponent } from './components/product/product.component';

const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent },
  { path: 'supplier', component: SupplierComponent },
  { path: 'warehouse', component: WarehouseComponent },
  { path: 'product', component: ProductComponent }, // ensure ProductComponent exists; otherwise remove
];

@NgModule({
  declarations: [
    SupplierComponent,
    WarehouseComponent,
    ProductComponent,
    DashboardComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    SharedModule,
    RouterModule.forChild(routes)
  ]
})
export class SupplyLinkModule {}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
