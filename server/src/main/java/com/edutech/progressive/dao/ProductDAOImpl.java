package com.edutech.progressive.dao;

<<<<<<< HEAD
import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Product;
=======
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public int addProduct(Product product) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        int generatedID = -1;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "INSERT INTO product (warehouse_id, product_name, product_description, quantity, price) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setDouble(1, product.getWarehouse().getWarehouseId());
            statement.setString(2, product.getProductName());
            statement.setString(3, product.getProductDescription());
            statement.setInt(4, product.getQuantity());
            statement.setDouble(5, product.getPrice());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                generatedID = resultSet.getInt(1);
                product.setProductId(generatedID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Rethrow the exception
        } finally {
            // Close resources in the reverse order of opening
            if (statement != null) {
                statement.close();
            }
        }
        return generatedID;
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT * FROM product WHERE product_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, productId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int warehouseId = resultSet.getInt("warehouse_id");
                String productName = resultSet.getString("product_name");
                String productDescription = resultSet.getString("product_description");
                int quantity = resultSet.getInt("quantity");
                Long price = (long) resultSet.getDouble("price");
                return new Product(productId, warehouseId, productName, productDescription, quantity, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Rethrow the exception
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "UPDATE product SET warehouse_id = ?, product_name = ?, product_description = ?, quantity =?, price =? WHERE product_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, product.getWarehouse().getWarehouseId());
            statement.setString(2, product.getProductName());
            statement.setString(3, product.getProductDescription());
            statement.setInt(4, product.getQuantity());
            statement.setDouble(5, product.getPrice());
            statement.setInt(6, product.getProductId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Rethrow the exception
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "DELETE FROM product WHERE product_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Rethrow the exception
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT * FROM product";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                int warehouseId = resultSet.getInt("warehouse_id");
                String productName = resultSet.getString("product_name");
                String productDescription = resultSet.getString("product_description");
                int quantity = resultSet.getInt("quantity");
                Long price = (long) resultSet.getDouble("price");
                products.add(new Product(productId, warehouseId, productName, productDescription, quantity, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Rethrow the exception
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return products;
    }
}
=======
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Product;


// public class ProductDAOImpl  implements ProductDAO{

//     final String sqlInsert = "Insert into product(warehouse_id, product_name, product_description, quantity, price) values(?,?,?,?,?)";
//     final String sqlSelect = "Select * from product";
//     final String sqlSelectById = "Select * from product where product_id=?";
//     final String sqlUpdate = "Update product set warehouse_id=?, product_name=?, product_description=?, quantity=?, price=? where product_id=?";
//     final String sqlDelete = "Delete from product where product_id=?";

//     private Connection c ;

    

//     public ProductDAOImpl() throws SQLException {
//         this.c = DatabaseConnectionManager.getConnection();
//     }

    

//     public ProductDAOImpl(Connection c) {
//         this.c = c;
//     }



//     @Override
//     public int addProduct(Product product) throws SQLException {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
//             PreparedStatement ps = c.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
//             ps.setInt(1, product.getWarehouseId());
//             ps.setString(2, product.getProductName());
//             ps.setString(3, product.getProductDescription());
//             ps.setInt(4, product.getQuantity());
//             ps.setLong(5, product.getPrice());
//             ps.executeUpdate();
//             ResultSet rs = ps.getGeneratedKeys();
//             if(rs.next()){
//                 product.setProductId(rs.getInt(1));
//                 return rs.getInt(1);
//             }
//         return -1;
//         }


        

//     @Override
//     public Product getProductById(int productId) {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method 'getProductById'");
//         try{
//             PreparedStatement ps = c.prepareStatement(sqlSelectById);
//             ps.setInt(1, productId);
//             ResultSet rs= ps.executeQuery();
//             if(rs.next()){
//                 return new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getLong(6));
//             }
//         }
//         catch(SQLException e){
//             e.printStackTrace();
//         }
//         return null;
//     }

//     @Override
//     public void updateProduct(Product product) {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
//         try{
//             PreparedStatement ps = c.prepareStatement(sqlUpdate, Statement.RETURN_GENERATED_KEYS);
//             ps.setInt(1, product.getWarehouseId());
//             ps.setString(2, product.getProductName());
//             ps.setString(3, product.getProductDescription());
//             ps.setInt(4, product.getQuantity());
//             ps.setLong(5, product.getPrice());
//             ps.setInt(6, product.getProductId());
//             // if(ps.executeUpdate()>0) return product;
//             ps.executeUpdate();
//         }
//         catch(SQLException e){
//             e.printStackTrace();
//         }
//         // return null;

//     }

//     @Override
//     public void deleteProduct(int productId) {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
//         try {
//             PreparedStatement ps = c.prepareStatement(sqlDelete);
//             ps.setInt(1, productId);
//             ps.executeUpdate();
//         } catch (Exception e) {
//             // TODO: handle exception
//         }
//     }

//     @Override
//     public List<Product> getAllProducts() {
//         List<Product> list = new ArrayList<>();
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
//         try {
//             PreparedStatement ps = c.prepareStatement(sqlSelect);
//             // ps.setInt(1, productId);
//             ResultSet rs= ps.executeQuery();
//             while(rs.next()){
//                 Product p = new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getLong(6));
//                 list.add(p);
//             }
//             return list;
//         } catch (Exception e) {
//             // TODO: handle exception
//             e.printStackTrace();
//         }
//         return list;
//     }

    

// }
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
