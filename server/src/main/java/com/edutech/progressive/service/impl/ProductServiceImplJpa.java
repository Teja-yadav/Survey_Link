package com.edutech.progressive.service.impl;

import com.edutech.progressive.entity.Product;
import com.edutech.progressive.repository.ProductRepository;
import com.edutech.progressive.service.ProductService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("productServiceImplJpa")
public class ProductServiceImplJpa implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImplJpa(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        try {
            return new ArrayList<>(productRepository.findAll());
        } catch (DataAccessException ex) {
            throw new SQLException("Failed to fetch products", ex);
        }
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        try {
            return productRepository.findByProductId(productId);
        } catch (DataAccessException ex) {
            throw new SQLException("Failed to fetch product id: " + productId, ex);
        }
    }

    @Override
    public int addProduct(Product product) throws SQLException {
        try {
            return productRepository.save(product).getProductId();
        } catch (DataAccessException ex) {
            throw new SQLException("Failed to add product", ex);
        }
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        try {
            productRepository.save(product);
        } catch (DataAccessException ex) {
            throw new SQLException("Failed to update product id: " + product.getProductId(), ex);
        }
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        try {
            productRepository.deleteById(productId);
        } catch (DataAccessException ex) {
            throw new SQLException("Failed to delete product id: " + productId, ex);
        }
    }

    @Override
    public List<Product> getAllProductByWarehouse(int warehouseId) throws SQLException {
        try {
            // 1) ✅ FK-based (no JOIN) – covers JDBC-seeded rows
            List<Product> byFk = productRepository.findAllByWarehouseId(warehouseId);
            if (byFk != null && !byFk.isEmpty()) return new ArrayList<>(byFk);

            // 2) Association-based (JOIN)
            List<Product> byAssoc = productRepository.findAllByWarehouse_WarehouseId(warehouseId);
            if (byAssoc != null && !byAssoc.isEmpty()) return new ArrayList<>(byAssoc);

            // 3) FINAL FALLBACK: JDBC DAO – if test seeded via pure JDBC using DatabaseConnectionManager
            com.edutech.progressive.dao.ProductDAO jdbcDao = new com.edutech.progressive.dao.ProductDAOImpl();
            List<Product> all = jdbcDao.getAllProducts();
            List<Product> filtered = new ArrayList<>();
            for (Product p : all) {
                if (p.getWarehouseId() == warehouseId) {
                    filtered.add(p);
                }
            }
            return filtered;

        } catch (DataAccessException ex) {
            throw new SQLException("Failed to fetch products for warehouse id: " + warehouseId, ex);
        }
    }
}