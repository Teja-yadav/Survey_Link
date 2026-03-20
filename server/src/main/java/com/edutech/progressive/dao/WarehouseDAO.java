package com.edutech.progressive.dao;

import com.edutech.progressive.entity.Warehouse;

import java.sql.SQLException;
import java.util.List;

public interface WarehouseDAO {
    int addWarehouse(Warehouse warehouse) throws SQLException;
<<<<<<< HEAD
    Warehouse getWarehouseById(int warehouseId) throws SQLException;
    void updateWarehouse (Warehouse warehouse) throws SQLException;
    void deleteWarehouse (int warehouseId) throws SQLException;
    List<Warehouse> getAllWarehouse() throws SQLException;
=======
    Warehouse getWarehouseById(int warehouseId);
    void updateWarehouse (Warehouse warehouse);
    void deleteWarehouse (int warehouseId);
    List<Warehouse> getAllWarehouse();
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}