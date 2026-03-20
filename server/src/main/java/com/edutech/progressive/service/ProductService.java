package com.edutech.progressive.service;

import com.edutech.progressive.entity.Product;

<<<<<<< HEAD
import java.sql.SQLException;
=======
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
import java.util.List;

public interface ProductService {

<<<<<<< HEAD
    List<Product> getAllProducts() throws SQLException;

    Product getProductById(int productId) throws SQLException;

    int addProduct(Product Product) throws SQLException;

    void updateProduct(Product Product) throws SQLException;

    void deleteProduct(int productId) throws SQLException;

    //Do not implement these methods in ProductServiceImplJdbc.java class
    default List<Product> getAllProductByWarehouse(int warehouseId) throws SQLException {
        return null;
    }
}
=======
    List<Product> getAllProducts();

    Product getProductById(int productId);

    int addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int productId);

    //Do not implement these methods in ProductServiceImplJdbc.java class
    default List<Product> getAllProductByWarehouse(int warehouseId) {
        return null;
    }
}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
