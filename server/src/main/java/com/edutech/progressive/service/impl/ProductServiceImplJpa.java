package com.edutech.progressive.service.impl;

<<<<<<< HEAD
import com.edutech.progressive.entity.Product;
import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.exception.InsufficientCapacityException;
import com.edutech.progressive.repository.ProductRepository;
import com.edutech.progressive.repository.ShipmentRepository;
import com.edutech.progressive.repository.WarehouseRepository;
import com.edutech.progressive.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductServiceImplJpa implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    ShipmentRepository shipmentRepository;

    @Autowired
    public ProductServiceImplJpa(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        return productRepository.findByProductId(productId);
    }

    @Override
    public int addProduct(Product product) throws InsufficientCapacityException {
        Warehouse warehouse = warehouseRepository.findByWarehouseId(product.getWarehouse().getWarehouseId());
        int productCount = productRepository.countByWarehouse_WarehouseId(warehouse.getWarehouseId());
        if (warehouse.getCapacity() == productCount) {
            throw new InsufficientCapacityException(
                    "Warehouse with ID " + warehouse.getWarehouseId() + " has reached its maximum capacity of " + warehouse.getCapacity() + " products."
            );
        }
        return productRepository.save(product).getProductId();
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        productRepository.save(product).getProductId();
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        shipmentRepository.deleteByProductId(productId);
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> getAllProductByWarehouse(int warehouseId) throws SQLException {
        return productRepository.findAllByWarehouse_WarehouseId(warehouseId);
    }
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Product;
import com.edutech.progressive.repository.ProductRepository;
import com.edutech.progressive.service.ProductService;

@Service
public class ProductServiceImplJpa   implements ProductService{

    private final ProductRepository productRepo;

    @Autowired
    public ProductServiceImplJpa(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    // @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
        return productRepo.findAll();
    }

    @Override
    // @PreAuthorize("hasAnyRole('USER','ADMIN')")
    // @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public Product getProductById(int productId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getProductById'");
        return productRepo.findByProductId(productId);
    }

    @Override
    // @PreAuthorize("hasAnyRole('USER','ADMIN')")
    // @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public int addProduct(Product product) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
        Product p = productRepo.save(product);
        return  p != null ? p.getProductId() :-1;
    }

    @Override
    // @PreAuthorize("hasAnyRole('USER','ADMIN')")
    // @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public void updateProduct(Product product) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
        Product oldProduct = productRepo.findByProductId(product.getProductId());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setProductDescription(product.getProductDescription());
        oldProduct.setProductName(product.getProductName());
        oldProduct.setQuantity(product.getQuantity());
        oldProduct.setWarehouse(product.getWarehouse());

        productRepo.save(oldProduct);
    }

    @Override
    // @PreAuthorize("hasAnyRole('USER','ADMIN')")
    // @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public void deleteProduct(int productId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
        productRepo.deleteById(productId);
    }
    
    // @PreAuthorize("hasAnyRole('USER','ADMIN')")
    // @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public  List<Product> getAllProductByWarehouse(int warehouseId) {
        // return null;
        return productRepo.findAllByWarehouse_WarehouseId(warehouseId);
    }

>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}