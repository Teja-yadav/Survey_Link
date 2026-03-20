package com.edutech.progressive.dao;

import com.edutech.progressive.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
<<<<<<< HEAD
    int addProduct(Product accounts) throws SQLException;
    Product getProductById(int productId) throws SQLException;
    void updateProduct(Product product) throws SQLException;
    void deleteProduct(int productId) throws SQLException;
    List<Product> getAllProducts() throws SQLException;
=======
    int addProduct(Product product) throws SQLException;
    Product getProductById(int productId);
    void updateProduct(Product product);
    void deleteProduct(int productId);
    List<Product> getAllProducts();
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}