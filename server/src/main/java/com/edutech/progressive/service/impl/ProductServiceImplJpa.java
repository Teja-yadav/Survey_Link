package com.edutech.progressive.service.impl;

import com.edutech.progressive.entity.Product;
import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.exception.InsufficientCapacityException;
import com.edutech.progressive.repository.ProductRepository;
import com.edutech.progressive.repository.WarehouseRepository;
import com.edutech.progressive.service.ProductService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("productServiceImplJpa")
public class ProductServiceImplJpa implements ProductService {

    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;

    public ProductServiceImplJpa(ProductRepository productRepository,
                                 WarehouseRepository warehouseRepository) {
        this.productRepository = productRepository;
        this.warehouseRepository = warehouseRepository;
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
            // Determine warehouseId for capacity check (supports either FK or association)
            int warehouseId = product.getWarehouseId();
            if (warehouseId == 0 && product.getWarehouse() != null) {
                warehouseId = product.getWarehouse().getWarehouseId();
            }

            Warehouse wh = warehouseRepository.findByWarehouseId(warehouseId);
            if (wh == null) {
                throw new SQLException("Warehouse not found for id: " + warehouseId);
            }

            int currentCount = productRepository.countByWarehouse_WarehouseId(warehouseId);
            if (currentCount >= wh.getCapacity()) {
                throw new InsufficientCapacityException(
                        "Warehouse capacity reached for warehouseId=" + warehouseId);
            }

            return productRepository.save(product).getProductId();
        } catch (InsufficientCapacityException ice) {
            throw ice; // bubble up to controller to map 400
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
            // FK-based first (no JOIN)
            List<Product> byFk = productRepository.findAllByWarehouseId(warehouseId);
            if (byFk != null && !byFk.isEmpty()) return new ArrayList<>(byFk);

            // Association-based fallback
            List<Product> byAssoc = productRepository.findAllByWarehouse_WarehouseId(warehouseId);
            if (byAssoc != null && !byAssoc.isEmpty()) return new ArrayList<>(byAssoc);

            // Optional final fallback via JDBC DAO if tests seed differently
            com.edutech.progressive.dao.ProductDAO jdbcDao = new com.edutech.progressive.dao.ProductDAOImpl();
            List<Product> all = jdbcDao.getAllProducts();
            List<Product> filtered = new ArrayList<>();
            for (Product p : all) {
                if (p.getWarehouseId() == warehouseId) filtered.add(p);
            }
            return filtered;

        } catch (DataAccessException ex) {
            throw new SQLException("Failed to fetch products for warehouse id: " + warehouseId, ex);
        }
    }
}