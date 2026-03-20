package com.edutech.progressive.service.impl;

<<<<<<< HEAD
import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class SupplierServiceImplArraylist implements SupplierService {

    private static List<Supplier> supplierList = new ArrayList<>();

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierList;
=======
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.SupplierService;


@Service("supplierServiceArraylist")
public class SupplierServiceImplArraylist implements SupplierService  {

    private List<Supplier> suppliers = new ArrayList<>();

    @Autowired
    public SupplierServiceImplArraylist() {
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAllSuppliers'");
        return suppliers;
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
    }

    @Override
    public int addSupplier(Supplier supplier) {
<<<<<<< HEAD
        supplierList.add(supplier);
        return supplierList.size();
=======
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'addSupplier'");
        suppliers.add(supplier);
        return suppliers.size();
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() {
<<<<<<< HEAD
        List<Supplier> sortedSupplier = supplierList;
        sortedSupplier.sort(Comparator.comparing(Supplier::getSupplierName)); // Sort by supplier name
        return sortedSupplier;
    }

    @Override
    public void emptyArrayList() {
        supplierList = new ArrayList<>();
    }
=======
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAllSuppliersSortedByName'");
        Collections.sort(suppliers);
        return suppliers;
    }

    

>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}