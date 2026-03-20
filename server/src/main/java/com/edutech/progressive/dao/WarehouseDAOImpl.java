<<<<<<< HEAD
package com.edutech.progressive.dao;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WarehouseDAOImpl implements WarehouseDAO {

    @Override
    public int addWarehouse(Warehouse warehouse) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        int generatedID = -1;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "INSERT INTO warehouse (supplier_id, warehouse_name, location, capacity) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setInt(1, warehouse.getSupplier().getSupplierId());
            statement.setString(2, warehouse.getWarehouseName());
            statement.setString(3, warehouse.getLocation());
            statement.setDouble(4, warehouse.getCapacity());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                generatedID = resultSet.getInt(1);
                warehouse.setWarehouseId(generatedID);
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
    public Warehouse getWarehouseById(int warehouseId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT * FROM warehouse WHERE warehouse_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, warehouseId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int supplierId = resultSet.getInt("supplier_id");
                String warehouseName = resultSet.getString("warehouse_name");
                String location = resultSet.getString("location");
                int capacity = resultSet.getInt("capacity");
                return new Warehouse(warehouseId, supplierId, warehouseName, location, capacity);
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
    public void updateWarehouse(Warehouse warehouse) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "UPDATE warehouse SET supplier_id =?, warehouse_name =?, location =?, capacity =? WHERE warehouse_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, warehouse.getSupplier().getSupplierId());
            statement.setString(2, warehouse.getWarehouseName());
            statement.setString(3, warehouse.getLocation());
            statement.setInt(4, warehouse.getCapacity());
            statement.setInt(5, warehouse.getWarehouseId());
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
    public void deleteWarehouse(int warehouseId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "DELETE FROM warehouse WHERE warehouse_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, warehouseId);
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
    public List<Warehouse> getAllWarehouse() throws SQLException {
        List<Warehouse> warehouses = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT * FROM warehouse";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int warehouseId = resultSet.getInt("warehouse_id");
                int supplierId = resultSet.getInt("supplier_id");
                String warehouseName = resultSet.getString("warehouse_name");
                String location = resultSet.getString("location");
                int capacity = resultSet.getInt("capacity");
                warehouses.add(new Warehouse(warehouseId, supplierId, warehouseName, location, capacity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Rethrow the exception
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return warehouses;
    }
}
=======
// package com.edutech.progressive.dao;

// import java.sql.*;
// import java.util.ArrayList;

// import java.util.List;

// import org.springframework.stereotype.Repository;

// import com.edutech.progressive.config.DatabaseConnectionManager;
// import com.edutech.progressive.entity.Warehouse;


// @Repository
// public class WarehouseDAOImpl implements WarehouseDAO{

//     Connection c;

//     final String sqlInsert = "Insert into warehouse(supplier_id, warehouse_name, location, capacity) values(?,?,?,?)";
//     final String sqlSelect = "Select * from warehouse";
//     final String sqlSelectById = "Select * from warehouse where warehouse_id=?";
//     final String sqlUpdate = "Update warehouse set supplier_id=?, warehouse_name=?, location=?, capacity=? where warehouse_id=?";
//     final String sqlDelete = "Delete from warehouse where warehouse_id=?";


//     public WarehouseDAOImpl() throws SQLException {
//         this.c = DatabaseConnectionManager.getConnection();
//     }

//     public WarehouseDAOImpl(Connection c) {
//         this.c = c;
//     }

//     @Override
//     public int addWarehouse(Warehouse warehouse) throws SQLException {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method 'addWarehouse'");
//             PreparedStatement ps = c.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
//             ps.setInt(1, warehouse.getSupplierId());
//             ps.setString(2, warehouse.getWarehouseName());
//             ps.setString(3, warehouse.getLocation());
//             ps.setInt(4, warehouse.getCapacity());

//             ps.executeUpdate();
//             ResultSet rs = ps.getGeneratedKeys();
//             if(rs.next()){
//                 warehouse.setWarehouseId(rs.getInt(1));
//                 return rs.getInt(1);
//             }
//             return -1;
//     }

//     @Override
//     public Warehouse getWarehouseById(int warehouseId) {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method 'getWarehouseById'");
//                 try{
//             PreparedStatement ps = c.prepareStatement(sqlSelectById);
//             ps.setInt(1, warehouseId);
//             ResultSet rs= ps.executeQuery();
//             if(rs.next()){
//                 // return new Warehouse(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5));
//             }
//         }
//         catch(SQLException e){
//             e.printStackTrace();
//         }
//         return null;
//     }

//     @Override
//     public void updateWarehouse(Warehouse warehouse) {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method 'updateWarehouse'");
//         try{
//             PreparedStatement ps = c.prepareStatement(sqlUpdate, Statement.RETURN_GENERATED_KEYS);
//             ps.setInt(1, warehouse.getSupplierId());
//             ps.setString(2, warehouse.getWarehouseName());
//             ps.setString(3, warehouse.getLocation());
//             ps.setInt(4, warehouse.getCapacity());
//             ps.setInt(5, warehouse.getWarehouseId());

//             ps.executeUpdate();
//         }
//         catch(SQLException e){
//             e.printStackTrace();
//         }
//     }

//     @Override
//     public void deleteWarehouse(int warehouseId) {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method 'deleteWarehouse'");
//         try {
//             PreparedStatement ps = c.prepareStatement(sqlDelete);
//             ps.setInt(1, warehouseId);
//             ps.executeUpdate();
//         } catch (Exception e) {
//             // TODO: handle exception
//             e.printStackTrace();
//         }
//     }

//     @Override
//     public List<Warehouse> getAllWarehouse() {
//         List<Warehouse> list = new ArrayList<>();
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method 'getAllWarehouse'");
//             try (PreparedStatement ps = c.prepareStatement(sqlSelect)){
//             // ps.setInt(1, productId);
//             ResultSet rs= ps.executeQuery();
//             while(rs.next()){
//                 Warehouse p = new Warehouse(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5));
//                 list.add(p);
//             }
//             // System.out.println("Capacities (top 3): " + list.stream()
//             //                     .map(Warehouse::getCapacity)
//             //                     .limit(3));

//             // list.sort(Comparator.comparing(Warehouse::getCapacity).reversed());
            
//             return list;
//         } catch (Exception e) {
//             // TODO: handle exception
//             e.printStackTrace();
//         }
//         return list;
//     }

    

// }
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
