package com.edutech.progressive.controller;

<<<<<<< HEAD
import com.edutech.progressive.entity.Product;
import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.exception.NoWarehouseFoundForSupplierException;
import com.edutech.progressive.exception.SupplierDoesNotExistException;
import com.edutech.progressive.service.impl.WarehouseServiceImplJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
=======
import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.exception.NoWarehouseFoundForSupplierException;
import com.edutech.progressive.service.WarehouseService;
import com.edutech.progressive.service.impl.WarehouseServiceImplJpa;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

// import java.util.List;


// @RestController
// @RequestMapping("warehouse")
// public class WarehouseController {

//     public ResponseEntity<List<Warehouse>> getAllWarehouses() {
//         return null;
//     }

//     public ResponseEntity<Warehouse> getWarehouseById(int warehouseId) {
//         return null;
//     }

//     public ResponseEntity<Integer> addWarehouse(Warehouse warehouse) {
//         return null;
//     }

//     public ResponseEntity<Void> updateWarehouse(int warehouseId, Warehouse warehouse) {
//         return null;
//     }

//     public ResponseEntity<Void> deleteWarehouse(int warehouseId) {
//         return null;
//     }


//     public ResponseEntity<List<Warehouse>> getWarehousesBySupplier(int supplierId) {
//         return null;
//     }
// }


// package com.supplylink.controller;

// import com.supplylink.entity.Warehouse;
// import com.supplylink.service.WarehouseService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

<<<<<<< HEAD
    @Autowired
    WarehouseServiceImplJpa warehouseServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses() throws SQLException {
        List<Warehouse> warehouses = warehouseServiceImplJpa.getAllWarehouses();
        return new ResponseEntity<>(warehouses, HttpStatus.OK);
    }

    @GetMapping("/{warehouseId}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable int warehouseId) {
        try {
            Warehouse warehouse = warehouseServiceImplJpa.getWarehouseById(warehouseId);
            if (warehouse != null) {
                return new ResponseEntity<>(warehouse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Integer> addWarehouse(@RequestBody Warehouse warehouse) {
        try {
            int warehouseId = warehouseServiceImplJpa.addWarehouse(warehouse);
            return new ResponseEntity<>(warehouseId, HttpStatus.CREATED);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{warehouseId}")
    public ResponseEntity<Void> updateWarehouse(@PathVariable int warehouseId, @RequestBody Warehouse warehouse) {
        try {
            warehouse.setWarehouseId(warehouseId);
            warehouseServiceImplJpa.updateWarehouse(warehouse);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{warehouseId}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable int warehouseId) {
        try {
            warehouseServiceImplJpa.deleteWarehouse(warehouseId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<?> getWarehousesBySupplier(@PathVariable int supplierId) throws SQLException {
        try {
            List<Warehouse> warehouses = warehouseServiceImplJpa.getWarehouseBySupplier(supplierId);
            return new ResponseEntity<>(warehouses, HttpStatus.OK);
        } catch (NoWarehouseFoundForSupplierException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Return a generic error message for any other exceptions
            return new ResponseEntity<>("An unexpected error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
=======
    private final WarehouseServiceImplJpa warehouseServiceJpa;

    @Autowired
    public WarehouseController(WarehouseServiceImplJpa warehouseServiceJpa) {
        this.warehouseServiceJpa = warehouseServiceJpa;
    }


    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        return ResponseEntity.status(200).body(warehouseServiceJpa.getAllWarehouses());
    }


    @GetMapping("/{warehouseId}")
        @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable int warehouseId) {
        Warehouse w = warehouseServiceJpa.getWarehouseById(warehouseId);
        if (w == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(w);
    }

    @PostMapping
    // @PreAuthorize("hasAuthority('USER')")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<Integer> addWarehouse(@RequestBody Warehouse warehouse) {
        // if(warehouse.getSupplier()== null) return ResponseEntity.status(404).build();
        int id = warehouseServiceJpa.addWarehouse(warehouse);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }


    @PutMapping("/{warehouseId}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Void> updateWarehouse(@PathVariable int warehouseId, @RequestBody Warehouse warehouse) {
        warehouse.setWarehouseId(warehouseId);
        warehouseServiceJpa.updateWarehouse(warehouse);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{warehouseId}")
   
    // @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable int warehouseId) {
        warehouseServiceJpa.deleteWarehouse(warehouseId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/supplier/{supplierId}")

    public ResponseEntity<List<Warehouse>> getWarehousesBySupplier(@PathVariable int supplierId)  {
        List<Warehouse> list;
        try {
            list = warehouseServiceJpa.getWarehouseBySupplier(supplierId);
            return ResponseEntity.status(200).body(list);
        } catch (NoWarehouseFoundForSupplierException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            return ResponseEntity.status(404).build();
        }
        // return ResponseEntity.noContent().build();
        // return ResponseEntity.ok(list);
    }

    // @ExceptionHandler(RuntimeException.class)
    // public ResponseEntity<String> handleException(RuntimeException e){
    //     return ResponseEntity.status(500).body(e.toString());
    // }
}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
