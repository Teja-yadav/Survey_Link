package com.edutech.progressive.service.impl;

<<<<<<< HEAD
=======
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
import com.edutech.progressive.dao.ProductDAO;
import com.edutech.progressive.entity.Product;
import com.edutech.progressive.service.ProductService;

<<<<<<< HEAD
import java.sql.SQLException;
import java.util.List;

public class ProductServiceImplJdbc implements ProductService {

    private ProductDAO productDAO;

    public ProductServiceImplJdbc(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        return productDAO.getAllProducts();
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        return productDAO.getProductById(productId);
    }

    @Override
    public int addProduct(Product product) throws SQLException {
        return productDAO.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        productDAO.deleteProduct(productId);
    }
}
=======
// public class ProductServiceImplJdbc implements ProductService  {

//     private ProductDAO productDAO;

//     @Autowired
// public ProductServiceImplJdbc(ProductDAO productDAO) {
//         this.productDAO = productDAO;
//     }

//     public ProductServiceImplJdbc() {
// }

//     @Override
//     public List<Product> getAllProducts() {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
//         return productDAO.getAllProducts();
//     }

  
//     @Override
//     public Product getProductById(int productId) {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method 'getProductById'");
//         return productDAO.getProductById(productId);
//     }

//     @Override
//     public int addProduct(Product product) {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
//         try {
//             return productDAO.addProduct(product);
//         } catch (SQLException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         }
//         return -1;
//     }

//     @Override
//     public void updateProduct(Product product) {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
//         productDAO.updateProduct(product);
        
        
//     }

//     @Override
//     public void deleteProduct(int productId) {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
//         productDAO.deleteProduct(productId);
//     }

// }
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
