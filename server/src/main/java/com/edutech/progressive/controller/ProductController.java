package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Product;
<<<<<<< HEAD
import com.edutech.progressive.exception.InsufficientCapacityException;
import com.edutech.progressive.exception.SupplierDoesNotExistException;
import com.edutech.progressive.service.impl.ProductServiceImplJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImplJpa productServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() throws SQLException {
        List<Product> products = productServiceImplJpa.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
=======
import com.edutech.progressive.service.impl.ProductServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/product")

public class ProductController {

    private final ProductServiceImplJpa productServiceImplJpa;
    @Autowired
    public ProductController(ProductServiceImplJpa productServiceImplJpa) {
        this.productServiceImplJpa = productServiceImplJpa;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.status(200).body(productServiceImplJpa.getAllProducts());
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
<<<<<<< HEAD
        try {
            Product product = productServiceImplJpa.getProductById(productId);
            if (product != null) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        try {
            int productId = productServiceImplJpa.addProduct(product);
            return new ResponseEntity<>(productId, HttpStatus.CREATED);
        } catch (InsufficientCapacityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Return a generic error message for any other exceptions
            return new ResponseEntity<>("An unexpected error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable int productId, @RequestBody Product product) {
        try {
            product.setProductId(productId);
            productServiceImplJpa.updateProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
        try {
            productServiceImplJpa.deleteProduct(productId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/warehouse/{warehouseId}")
    public ResponseEntity<List<Product>> getAllProductByWarehouse(@PathVariable int warehouseId) throws SQLException {
        List<Product> products = productServiceImplJpa.getAllProductByWarehouse(warehouseId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
=======
        return ResponseEntity.status(200).body(productServiceImplJpa.getProductById(productId));
    }

    @PostMapping
    // @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<Integer> addProduct(@RequestBody Product product) {
        return ResponseEntity.status(201).body(productServiceImplJpa.addProduct(product));
    }

   @PutMapping("/{productId}")
//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<Void> updateProduct(@PathVariable int productId, @RequestBody Product product) {
        Product p  = productServiceImplJpa.getProductById(productId);
        productServiceImplJpa.updateProduct(p);
        return ResponseEntity.status(204).body(null);
    }

    @DeleteMapping("/{productId}")
    // @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
        // Product  p = productServiceImplJpa.getProductById(productId);

        // productServiceImplJpa.deleteProduct(p.getWarehouse().getWarehouseId());
        productServiceImplJpa.deleteProduct(productId);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/warehouse/{warehouseId}")
    
    public ResponseEntity<List<Product>> getAllProductByWarehouse(@PathVariable int warehouseId) {
        return ResponseEntity.status(200).body(productServiceImplJpa.getAllProductByWarehouse(warehouseId));
    }
}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
