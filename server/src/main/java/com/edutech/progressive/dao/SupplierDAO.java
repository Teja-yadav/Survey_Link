package com.edutech.progressive.dao;

import com.edutech.progressive.entity.Supplier;

import java.sql.SQLException;
import java.util.List;

public interface SupplierDAO {
    int addSupplier(Supplier supplier) throws SQLException;
    Supplier getSupplierById(int supplierId) throws SQLException;
    void updateSupplier(Supplier supplier) throws SQLException;
<<<<<<< HEAD
    void deleteSupplier(int supplierId) throws SQLException;
    List<Supplier> getAllSuppliers() throws SQLException;
}
=======
    void deleteSupplier(int supplierId) throws SQLException ;
    List<Supplier> getAllSuppliers() throws SQLException;
}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
