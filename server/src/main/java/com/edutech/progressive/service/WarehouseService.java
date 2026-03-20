package com.edutech.progressive.service;

import com.edutech.progressive.entity.Warehouse;
<<<<<<< HEAD

import java.sql.SQLException;
import java.util.List;

public interface WarehouseService {
    List<Warehouse> getAllWarehouses() throws SQLException;

    int addWarehouse(Warehouse warehouse) throws SQLException;

    List<Warehouse> getWarehousesSortedByCapacity() throws SQLException;
=======
import com.edutech.progressive.exception.NoWarehouseFoundForSupplierException;

import java.util.List;

public interface WarehouseService {
    List<Warehouse> getAllWarehouses();

    int addWarehouse(Warehouse warehouse);

    List<Warehouse> getWarehousesSortedByCapacity();
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e

    default public void emptyArrayList() {
    }

    //Do not implement these methods in WarehouseServiceImplArraylist.java class
<<<<<<< HEAD
    default void updateWarehouse(Warehouse warehouse) throws SQLException {
    }

    default void deleteWarehouse(int warehouseId) throws SQLException {
    }

    default Warehouse getWarehouseById(int warehouseId) throws SQLException {
=======
    default void updateWarehouse(Warehouse warehouse) {
    }

    default void deleteWarehouse(int warehouseId) {
    }

    default Warehouse getWarehouseById(int warehouseId) {
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
        return null;
    }

    //Do not implement these methods in WarehouseServiceImplArraylist.java and WarehouseServiceImplJdbc.java class
<<<<<<< HEAD
    default List<Warehouse> getWarehouseBySupplier(int supplierId) throws SQLException {
        return null;
    }
}
=======
    default List<Warehouse> getWarehouseBySupplier(int supplierId) throws NoWarehouseFoundForSupplierException {
        return null;
    }
}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
