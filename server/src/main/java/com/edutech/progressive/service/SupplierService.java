package com.edutech.progressive.service;


import com.edutech.progressive.entity.Supplier;
<<<<<<< HEAD

import java.sql.SQLException;
import java.util.List;

public interface SupplierService {
    List<Supplier> getAllSuppliers() throws SQLException;

    int addSupplier(Supplier supplier) throws SQLException;

    List<Supplier> getAllSuppliersSortedByName() throws SQLException;
=======
import com.edutech.progressive.exception.SupplierAlreadyExistsException;
import com.edutech.progressive.exception.SupplierDoesNotExistException;

import java.util.List;

// import org.springframework.stereotype.Service;


// @Service("supplierService")
public interface SupplierService {
    List<Supplier> getAllSuppliers();

    int addSupplier(Supplier supplier) throws SupplierAlreadyExistsException;

    List<Supplier> getAllSuppliersSortedByName();
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e

    default public void emptyArrayList() {
    }

    //Do not implement these methods in SupplierServiceImplArraylist.java class
<<<<<<< HEAD
    default void updateSupplier(Supplier supplier) throws SQLException {
    }

    default void deleteSupplier(int supplierId) throws SQLException {
    }

    default Supplier getSupplierById(int supplierId) throws SQLException {
        return null;
    }

}
=======
    default void updateSupplier(Supplier supplier) {
    }

    default void deleteSupplier(int supplierId) throws SupplierDoesNotExistException {
    }

    default Supplier getSupplierById(int supplierId) throws SupplierDoesNotExistException {
        return null;
    }

}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
