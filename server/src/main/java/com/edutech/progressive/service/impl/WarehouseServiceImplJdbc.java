package com.edutech.progressive.service.impl;

<<<<<<< HEAD
import com.edutech.progressive.dao.WarehouseDAO;
import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.service.WarehouseService;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class WarehouseServiceImplJdbc implements WarehouseService {

    private WarehouseDAO warehouseDAO;

    public WarehouseServiceImplJdbc(WarehouseDAO warehouseDAO) {
        this.warehouseDAO = warehouseDAO;
    }

    @Override
    public List<Warehouse> getAllWarehouses() throws SQLException {
        return warehouseDAO.getAllWarehouse();
    }

    @Override
    public int addWarehouse(Warehouse warehouse) throws SQLException {
        return warehouseDAO.addWarehouse(warehouse);
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() throws SQLException {
        List<Warehouse> sortedWarehouse = warehouseDAO.getAllWarehouse();
        if (sortedWarehouse != null) {
            sortedWarehouse.sort(Comparator.comparingInt(Warehouse::getCapacity)); // Sort by capacity
        }
        return sortedWarehouse;
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) throws SQLException {
        warehouseDAO.updateWarehouse(warehouse);
    }

    @Override
    public void deleteWarehouse(int warehouseId) throws SQLException {
        warehouseDAO.deleteWarehouse(warehouseId);
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) throws SQLException {
        return warehouseDAO.getWarehouseById(warehouseId);
    }
=======
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.dao.WarehouseDAO;
import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.service.WarehouseService;


// @Service("warehouseServiceJdbc")
public class WarehouseServiceImplJdbc  implements WarehouseService {


    // private WarehouseServiceImplJdbc warehouseServiceImplJdbc;
    private WarehouseDAO warehouseDAO;

    @Autowired
   public WarehouseServiceImplJdbc(WarehouseDAO warehouseDAO) {
    this.warehouseDAO = warehouseDAO;
}


    @Override
    public List<Warehouse> getAllWarehouses() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAllWarehouses'");
        return warehouseDAO.getAllWarehouse();
    }



 @Override
    public int addWarehouse(Warehouse warehouse) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationExce
        // ption("Unimplemented method 'addWarehouse'");
        try {
            return warehouseDAO.addWarehouse(warehouse);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getWarehousesSortedByCapacity'");
        List<Warehouse> w = getAllWarehouses();
        Collections.sort(w);
        return w;
    }

>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}