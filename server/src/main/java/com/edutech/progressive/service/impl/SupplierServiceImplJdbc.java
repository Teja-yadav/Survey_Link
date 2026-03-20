package com.edutech.progressive.service.impl;

<<<<<<< HEAD
=======
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
import com.edutech.progressive.dao.SupplierDAO;
import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.SupplierService;

<<<<<<< HEAD
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class SupplierServiceImplJdbc implements SupplierService {

    private SupplierDAO supplierDAO;

=======
// @Service("supplierServiceJdbc")
public class SupplierServiceImplJdbc  implements SupplierService{


    private SupplierDAO supplierDAO;

    @Autowired
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
    public SupplierServiceImplJdbc(SupplierDAO supplierDAO) {
        this.supplierDAO = supplierDAO;
    }

    @Override
<<<<<<< HEAD
    public List<Supplier> getAllSuppliers() throws SQLException {
        return supplierDAO.getAllSuppliers();
    }

    @Override
    public int addSupplier(Supplier supplier) throws SQLException {
        return supplierDAO.addSupplier(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() throws SQLException {
        List<Supplier> sortedSuppliers = supplierDAO.getAllSuppliers();
        if (sortedSuppliers != null) {
            sortedSuppliers.sort(Comparator.comparing(Supplier::getSupplierName)); // Sort by supplier name
        }
        return sortedSuppliers;
    }

    @Override
    public void updateSupplier(Supplier supplier) throws SQLException {
        supplierDAO.updateSupplier(supplier);
    }

    @Override
    public void deleteSupplier(int supplierId) throws SQLException {
        supplierDAO.deleteSupplier(supplierId);
    }

    @Override
    public Supplier getSupplierById(int supplierId) throws SQLException {
        return supplierDAO.getSupplierById(supplierId);
    }
=======
    public List<Supplier> getAllSuppliers() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAllSuppliers'");return
        try {
            return supplierDAO.getAllSuppliers();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addSupplier(Supplier supplier) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'addSupplier'");
        try {
            return supplierDAO.addSupplier(supplier);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() {
        List<Supplier> s = getAllSuppliers();
        Collections.sort(s);
        return s;
        // return null;
    }

    
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}