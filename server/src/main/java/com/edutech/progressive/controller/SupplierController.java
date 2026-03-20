package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Supplier;
<<<<<<< HEAD
import com.edutech.progressive.exception.SupplierAlreadyExistsException;
import com.edutech.progressive.exception.SupplierDoesNotExistException;
import com.edutech.progressive.service.impl.SupplierServiceImplArraylist;
import com.edutech.progressive.service.impl.SupplierServiceImplJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


=======
import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.exception.NoWarehouseFoundForSupplierException;
import com.edutech.progressive.exception.SupplierAlreadyExistsException;
import com.edutech.progressive.exception.SupplierDoesNotExistException;
import com.edutech.progressive.service.SupplierService;
import com.edutech.progressive.service.impl.SupplierServiceImplArraylist;
import com.edutech.progressive.service.impl.SupplierServiceImplJdbc;
import com.edutech.progressive.service.impl.SupplierServiceImplJpa;
import com.edutech.progressive.service.impl.WarehouseServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;

// import java.util.List;

// @RestController
// @RequestMapping("/shipper")
// public class SupplierController {

//     public ResponseEntity<List<Supplier>> getAllSuppliers() {
//         return null;
//     }

//     public ResponseEntity<Supplier> getSupplierById(int supplierId) {
//         return null;
//     }

//     public ResponseEntity<Integer> addSupplier(Supplier supplier) {
//         return null;
//     }

//     public ResponseEntity<Void> updateSupplier(Supplier supplier) {
//         return null;
//     }

//     public ResponseEntity<Void> deleteSupplier(int supplierId) {
//         return null;
//     }

//     public ResponseEntity<List<Supplier>> getAllSuppliersFromArrayList() {
//         return null;
//     }

//     public ResponseEntity<Integer> addSupplierToArrayList(Supplier supplier) {
//         return null;
//     }

//     public ResponseEntity<List<Supplier>> getAllSuppliersSortedByNameFromArrayList() {
//         return null;
//     }
// }

// package com.supplylink.controller;

// import com.supplylink.entity.Supplier;
// import com.supplylink.service.SupplierService;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

// import java.sql.SQLException;
import java.util.List;

>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
@RestController
@RequestMapping("/supplier")
public class SupplierController {

<<<<<<< HEAD
    @Autowired
    SupplierServiceImplArraylist supplierServiceImplArraylist;

    @Autowired
    SupplierServiceImplJpa supplierServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() throws SQLException {
        List<Supplier> suppliers = supplierServiceImplJpa.getAllSuppliers();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/{supplierId}")
    public ResponseEntity<?> getSupplierById(@PathVariable int supplierId) throws SQLException {
        try {
            Supplier supplier = supplierServiceImplJpa.getSupplierById(supplierId);
                return new ResponseEntity<>(supplier, HttpStatus.OK);
        } catch (SupplierDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Return a generic error message for any other exceptions
            return new ResponseEntity<>("An unexpected error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> addSupplier(@RequestBody Supplier supplier) {
        try {
            int supplierId = supplierServiceImplJpa.addSupplier(supplier);
            return new ResponseEntity<>(supplierId, HttpStatus.CREATED);
        } catch (SupplierAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{supplierId}")
    public ResponseEntity<?> updateSupplier(@PathVariable int supplierId, @RequestBody Supplier supplier) {
        try {
            supplier.setSupplierId(supplierId);
            supplierServiceImplJpa.updateSupplier(supplier);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SupplierAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{supplierId}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable int supplierId) {
        try {
            supplierServiceImplJpa.deleteSupplier(supplierId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Supplier>> getAllSuppliersFromArrayList() {
        List<Supplier> suppliers = supplierServiceImplArraylist.getAllSuppliers();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Integer> addSupplierToArrayList(@RequestBody Supplier supplier) {
        int listSize = supplierServiceImplArraylist.addSupplier(supplier);
        return new ResponseEntity<>(listSize, HttpStatus.CREATED);
    }

    @GetMapping("/fromArrayList/all")
    public ResponseEntity<List<Supplier>> getAllSuppliersSortedByNameFromArrayList() {
        List<Supplier> supplierList = supplierServiceImplArraylist.getAllSuppliersSortedByName();
        return new ResponseEntity<>(supplierList, HttpStatus.OK);
    }
=======
    private final SupplierServiceImplJpa supplierServiceJpa;
    private final SupplierService supplierServiceArraylist;

    private final WarehouseServiceImplJpa warehouseServiceJpa;


    

@Autowired
    public SupplierController(SupplierServiceImplJpa supplierServiceJpa, SupplierService supplierServiceArraylist, WarehouseServiceImplJpa warehouseServiceImplJpa) {
        this.supplierServiceJpa = supplierServiceJpa;
        this.supplierServiceArraylist = supplierServiceArraylist;
        this.warehouseServiceJpa = warehouseServiceImplJpa;
    }


    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> list = supplierServiceJpa.getAllSuppliers();
        return ResponseEntity.ok(list);
    }


    @GetMapping("/{supplierId}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int supplierId) throws SupplierDoesNotExistException {
        Supplier supplier = supplierServiceJpa.getSupplierById(supplierId);

        return ResponseEntity.ok(supplier);
    }


    @PostMapping
    // @Secured({ "ROLE_ADMIN"})
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Integer> addSupplier(@RequestBody Supplier supplier) {
        int id;
        try {
            id = supplierServiceJpa.addSupplier(supplier);
            ResponseEntity.status(201).body(id);
        } catch (SupplierAlreadyExistsException e) {
            // TODO Auto-generated catch block
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            // e.printStackTrace();
        }
        // return ResponseEntity.status(201).body(supplierServiceJpa.addSupplier(supplier));
        return ResponseEntity.status(201).build();
    }




    
    @PutMapping("/{supplierId}")
// @Secured({ "ROLE_ADMIN"})
        // @PreAuthorize("hasAnyRole('ADMIN')")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> updateSupplier(@PathVariable int supplierId,
                                               @RequestBody Supplier supplier) {
        try {

            supplierServiceJpa.updateSupplier(supplierId, supplier);
            return ResponseEntity.ok().build();
        } catch (SupplierDoesNotExistException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (SupplierAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }



    
    @DeleteMapping("/{supplierId}")
// @Secured({ "ROLE_ADMIN"})
    // @PreAuthorize("hasAnyRole('ADMIN')")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteSupplier(@PathVariable int supplierId) throws SupplierDoesNotExistException {
        if(supplierServiceJpa.getSupplierById(supplierId)== null) return ResponseEntity.status(404).build();
        supplierServiceJpa.deleteSupplier(supplierId);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Supplier>> getAllSuppliersFromArrayList() {
        List<Supplier> list = supplierServiceArraylist.getAllSuppliers();
        return ResponseEntity.ok(list);
    }


    @PostMapping("/toArrayList")
    public ResponseEntity<Integer> addSupplierToArrayList(@RequestBody Supplier supplier) throws SupplierAlreadyExistsException {
        int size = supplierServiceArraylist.addSupplier(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(size);
    }


    @GetMapping("/fromArrayList/all")
    public ResponseEntity<List<Supplier>> getAllSuppliersSortedByNameFromArrayList() {
        List<Supplier> list = supplierServiceArraylist.getAllSuppliersSortedByName();
        return ResponseEntity.ok(list);
    }



    @GetMapping("/warehouse")
    
    public ResponseEntity<List<Warehouse>> getAllWarehouse(){
        return ResponseEntity.status(200).body(warehouseServiceJpa.getAllWarehouses());
    }

    @GetMapping("/{supplierId}/warehouse")
    public ResponseEntity<List<Warehouse>> getWarehousesBySupplier(@PathVariable int supplierId) throws NoWarehouseFoundForSupplierException {
        List<Warehouse> list = warehouseServiceJpa.getWarehouseBySupplier(supplierId);
        return ResponseEntity.status(200).body(list);
    }

    // @ExceptionHandler(RuntimeException.class)
    // public ResponseEntity<?> handleEx(RuntimeException e){
    //     return ResponseEntity.status(500).body(e.getMessage());
    // }


>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}