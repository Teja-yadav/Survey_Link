package com.edutech.progressive.service.impl;

<<<<<<< HEAD
import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.exception.NoWarehouseFoundForSupplierException;
import com.edutech.progressive.repository.ProductRepository;
import com.edutech.progressive.repository.ShipmentRepository;
import com.edutech.progressive.repository.WarehouseRepository;
import com.edutech.progressive.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
public class WarehouseServiceImplJpa implements WarehouseService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ShipmentRepository shipmentRepository;

    private WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseServiceImplJpa(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<Warehouse> getAllWarehouses() throws SQLException {
        return warehouseRepository.findAll();
    }

    @Override
    public int addWarehouse(Warehouse warehouse) throws SQLException {
        return warehouseRepository.save(warehouse).getWarehouseId();
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() throws SQLException {
        List<Warehouse> sortedWarehouses = warehouseRepository.findAll();
        Collections.sort(sortedWarehouses);
        return sortedWarehouses;
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) throws SQLException {
        warehouseRepository.save(warehouse);
    }

    @Override
    public void deleteWarehouse(int warehouseId) throws SQLException {
        shipmentRepository.deleteByWarehouseId(warehouseId);
        productRepository.deleteByWarehouseId(warehouseId);
        warehouseRepository.deleteById(warehouseId);
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) throws SQLException {
        return warehouseRepository.findByWarehouseId(warehouseId);
    }

    @Override
    public List<Warehouse> getWarehouseBySupplier(int supplierId) throws NoWarehouseFoundForSupplierException {
        List<Warehouse> warehouseList = warehouseRepository.findAllBySupplier_SupplierId(supplierId);
        if (warehouseList.isEmpty()) {
            throw new NoWarehouseFoundForSupplierException("No warehouse found with the given supplier Id");
        }
        return warehouseList;
    }
=======
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edutech.progressive.entity.*;
import com.edutech.progressive.exception.NoWarehouseFoundForSupplierException;
import com.edutech.progressive.repository.ProductRepository;
import com.edutech.progressive.repository.SupplierRepository;
// import com.edutech.progressive.repository.SupplierRepository;
import com.edutech.progressive.repository.WarehouseRepository;
import com.edutech.progressive.service.WarehouseService;


@Service("warehouseServiceJpa")
@SuppressWarnings("null")
public class WarehouseServiceImplJpa implements WarehouseService  {


    private SupplierRepository supplierRepository;
    private WarehouseRepository warehouseRepository;
    private ProductRepository productRepository;
    
    
    @Autowired
    public WarehouseServiceImplJpa(WarehouseRepository warehouseRepository, ProductRepository productRepository, SupplierRepository repo) {
        this.warehouseRepository = warehouseRepository;
        this.productRepository= productRepository;
        this.supplierRepository = repo;
    }



    @Override
    public List<Warehouse> getAllWarehouses() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAllWarehouses'");
        return warehouseRepository.findAll();

    }

    @Override
    public int addWarehouse(Warehouse warehouse) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'addWarehouse'");

        
        // Supplier supplier = supplierRepository.findById(warehouse.supplierId)
        // .orElseThrow(() -> new IllegalArgumentException("Supplier not found: " + dto.supplierId));
    

        return warehouseRepository.save(warehouse)!= null ? warehouse.getWarehouseId() :-1;
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getWarehousesSortedByCapa
        // city'");
        List<Warehouse> w = warehouseRepository.findAll();
        Collections.sort(w);
        return w;
    }

    
    @Override
    @Transactional
    public void updateWarehouse(Warehouse warehouse) {
        if (warehouse == null || warehouse.getWarehouseId() == 0) return;
        Warehouse existing = warehouseRepository.findById(warehouse.getWarehouseId()).orElse(null);
        if (existing == null) return;

      
        existing.setWarehouseName(warehouse.getWarehouseName());
        existing.setLocation(warehouse.getLocation());
        existing.setCapacity(warehouse.getCapacity());
        existing.setSupplier(warehouse.getSupplier());

        
        // try {
       
        //     existing.setSupplierId(warehouse.getSupplierId());
        // } catch (NoSuchMethodError | Exception ignored) {
        
        // }

        warehouseRepository.save(existing);
    }


    
    @Override
    // @Transactional(readOnly = true)
    public List<Warehouse> getWarehouseBySupplier(int supplierId) throws NoWarehouseFoundForSupplierException {

        List<Warehouse> w = warehouseRepository.findAllBySupplier_SupplierId(supplierId);
        if(w==null || w.isEmpty()) throw new NoWarehouseFoundForSupplierException("null");
        return w;
    }

    


    public  void deleteWarehouse(int supplierId) {
        // warehouseRepository.deleteById(warehouseId);
        // List<Warehouse> warehouseBySuppliers = getWarehouseBySupplier(supplierId);
        // List<Product> warehousesForProduct = productRepository.findAllByWarehouse_WarehouseId(warehouseId);
        // productRepository.deleteByWarehouse_Supplier_SupplierId(supplierId);
        productRepository.deleteByWarehouse_WarehouseId(supplierId);
        warehouseRepository.deleteById(supplierId);
        // warehouseRepository.deleteBySupplier_SupplierId(supplierId);;
    }

    public  Warehouse getWarehouseById(int warehouseId) {
        return warehouseRepository.findById(warehouseId).orElseThrow();
    }

    //Do not implement these methods in WarehouseServiceImplArraylist.java and WarehouseServiceImplJdbc.java class
    // public void deleteWarehouse()


>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}