package com.edutech.progressive.dao;

<<<<<<< HEAD
=======
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Supplier;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {
=======

@Repository
public class SupplierDAOImpl implements SupplierDAO{

    private Connection c;

    final String sqlInsert = "Insert into supplier(supplier_name, email, username, password, phone, address, role) values(?,?,?,?,?,?,?)";
    final String sqlSelect = "Select * from supplier";
    final String sqlSelectById = "Select * from supplier where supplier_id=?";
    final String sqlUpdate = "Update supplier set supplier_name=?, email=?, username=?, password=?, phone=?, address=?, role=? where supplier_id=?";
    final String sqlDelete = "Delete from supplier where supplier_id=?";


    

    public SupplierDAOImpl() throws SQLException {
        this.c = DatabaseConnectionManager.getConnection();
    }



    public SupplierDAOImpl(Connection c) {
        this.c = c;
    }

>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e


    @Override
    public int addSupplier(Supplier supplier) throws SQLException {
<<<<<<< HEAD
        Connection connection = null;
        PreparedStatement statement = null;
        int generatedID = -1;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "INSERT INTO supplier (supplier_name, email, phone, username, password, address, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, supplier.getSupplierName());
            statement.setString(2, supplier.getEmail());
            statement.setString(3, supplier.getPhone());
            statement.setString(4, supplier.getUsername());
            statement.setString(5, supplier.getPassword());
            statement.setString(6, supplier.getAddress());
            statement.setString(7, supplier.getRole());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                generatedID = resultSet.getInt(1);
                supplier.setSupplierId(generatedID);
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
    public Supplier getSupplierById(int supplierId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT * FROM supplier WHERE supplier_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, supplierId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String supplierName = resultSet.getString("supplier_name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String address = resultSet.getString("address");
                String role = resultSet.getString("role");
                return new Supplier(supplierId, supplierName, email, phone, username, password, address, role);
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
    public void updateSupplier(Supplier supplier) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "UPDATE supplier SET supplier_name =?, email =?, phone =?, username =?, password =?, address =?, role =? WHERE supplier_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, supplier.getSupplierName());
            statement.setString(2, supplier.getEmail());
            statement.setString(3, supplier.getPhone());
            statement.setString(4, supplier.getUsername());
            statement.setString(5, supplier.getPassword());
            statement.setString(6, supplier.getAddress());
            statement.setString(7, supplier.getRole());
            statement.setInt(8, supplier.getSupplierId());
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
    public void deleteSupplier(int supplierId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "DELETE FROM supplier WHERE supplier_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, supplierId);
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
    public List<Supplier> getAllSuppliers() throws SQLException {
        List<Supplier> suppliers = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT * FROM supplier";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int supplierId = resultSet.getInt("supplier_id");
                String supplierName = resultSet.getString("supplier_name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String address = resultSet.getString("address");
                String role = resultSet.getString("role");
                suppliers.add(new Supplier(supplierId, supplierName, email, phone, username, password, address, role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Rethrow the exception
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return suppliers;
    }
}

=======
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'addSupplier'");
        PreparedStatement ps = c.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, supplier.getSupplierName());
            ps.setString(2, supplier.getEmail());
            ps.setString(3, supplier.getUsername());
            ps.setString(4, supplier.getPassword());
            ps.setString(5, supplier.getPhone());
            ps.setString(6, supplier.getAddress());
            ps.setString(7, supplier.getRole());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                supplier.setSupplierId(rs.getInt(1));
                return rs.getInt(1);
            }
        return -1;
    }



    @Override
    public Supplier getSupplierById(int supplierId) throws SQLException {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getSupplierById'");
        PreparedStatement ps = c.prepareStatement(sqlSelectById);
            ps.setInt(1, supplierId);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                return new Supplier(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
            }
        return null;
    }



    @Override
    public void updateSupplier(Supplier supplier) throws SQLException {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'updateSupplier'");
        PreparedStatement ps = c.prepareStatement(sqlUpdate, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, supplier.getSupplierName());
            ps.setString(2, supplier.getEmail());
            ps.setString(3, supplier.getUsername());
            ps.setString(4, supplier.getPassword());
            ps.setString(5, supplier.getPhone());
            ps.setString(6, supplier.getAddress());
            ps.setString(7, supplier.getRole());
            ps.setInt(8, supplier.getSupplierId());
            ps.executeUpdate();

            // return (ps.executeUpdate()>0)? supplier.getSupplierId():-1;
    }



    @Override
    public void deleteSupplier(int supplierId) throws SQLException {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'deleteSupplier'");
        PreparedStatement ps = c.prepareStatement(sqlDelete);
            ps.setInt(1, supplierId);
            ps.executeUpdate();
    }



    @Override
    public List<Supplier> getAllSuppliers() throws SQLException {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAllSuppliers'");
        List<Supplier> list = new ArrayList<>();
        PreparedStatement ps = c.prepareStatement(sqlSelect);
            // ps.setInt(1, productId);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Supplier p = new Supplier(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                list.add(p);
            }
        return list;
    }

    

    



}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
