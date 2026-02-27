package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.repository.WarehouseRepository;
import com.edutech.progressive.service.WarehouseService;

@Service
public class WarehouseServiceImplJpa implements WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public WarehouseServiceImplJpa(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<Warehouse> getAllWarehouses() throws SQLException {
        try {
            return warehouseRepository.findAll();
        } catch (DataAccessException ex) {
            throw new SQLException("Failed to fetch warehouses", ex);
        }
    }

    @Override
    public int addWarehouse(Warehouse warehouse) throws SQLException {
        try {
            Warehouse saved = warehouseRepository.save(warehouse);
            return saved.getWarehouseId();
        } catch (DataAccessException ex) {
            throw new SQLException("Failed to add warehouse", ex);
        }
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() throws SQLException {
        try {
            List<Warehouse> list = warehouseRepository.findAll();
            list.sort(Comparator.comparingInt(Warehouse::getCapacity).reversed());
            return list;
        } catch (DataAccessException ex) {
            throw new SQLException("Failed to get warehouses sorted by capacity", ex);
        }
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) throws SQLException {
        try {
            warehouseRepository.save(warehouse);
        } catch (DataAccessException ex) {
            throw new SQLException("Failed to update warehouse id: " + warehouse.getWarehouseId(), ex);
        }
    }

    @Override
    public void deleteWarehouse(int warehouseId) throws SQLException {
        try {
            warehouseRepository.deleteById(warehouseId);
        } catch (DataAccessException ex) {
            throw new SQLException("Failed to delete warehouse id: " + warehouseId, ex);
        }
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) throws SQLException {
        try {
            Warehouse w = warehouseRepository.findByWarehouseId(warehouseId);
            if (w != null) return w;
            Optional<Warehouse> opt = warehouseRepository.findById(warehouseId);
            return opt.orElse(null);
        } catch (DataAccessException ex) {
            throw new SQLException("Failed to fetch warehouse id: " + warehouseId, ex);
        }
    }

@Override
public List<Warehouse> getWarehouseBySupplier(int supplierId) throws SQLException {
    try {
        List<Warehouse> viaFk = warehouseRepository.findAllBySupplierId(supplierId);
        if (viaFk != null && !viaFk.isEmpty()) {
            return viaFk;
        }

        List<Warehouse> viaAssociation = warehouseRepository.findAllBySupplier_SupplierId(supplierId);
        if (viaAssociation != null && !viaAssociation.isEmpty()) {
            return viaAssociation;
        }

        List<Warehouse> allViaDao = WarehouseService.super.getWarehouseBySupplier(supplierId);
        return allViaDao;
    } catch (DataAccessException ex) {
        throw new SQLException("Failed to fetch warehouses for supplier id: " + supplierId, ex);
    }
}

}