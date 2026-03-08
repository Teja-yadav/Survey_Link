package com.edutech.progressive.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// import com.edutech.progressive.config.SecurityConfig;
import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.exception.SupplierAlreadyExistsException;
import com.edutech.progressive.exception.SupplierDoesNotExistException;
import com.edutech.progressive.repository.SupplierRepository;
import com.edutech.progressive.service.SupplierService;

@Service("supplierServiceJpa")
public class SupplierServiceImplJpa implements SupplierService  {

    private SupplierRepository supplierRepo;
    private PasswordEncoder encoder;
    

    @Autowired
    public SupplierServiceImplJpa(SupplierRepository supplierRepo, PasswordEncoder pe) {
        this.encoder = pe;
        this.supplierRepo = supplierRepo;
    }


    


    

    
    @Override
    @Secured({"ROLE_ADMIN"})
    public int addSupplier(Supplier supplier) throws SupplierAlreadyExistsException {
        // If client sends an id that already exists, treat as duplicate
        if (supplier.getSupplierId() != 0 &&
            supplierRepo.findById(supplier.getSupplierId()).orElse(null) != null) {
            throw new SupplierAlreadyExistsException("Supplier already exists");
        }

        // Enforce uniqueness on email / username
        boolean dup = supplierRepo.existsByEmailIgnoreCase(supplier.getEmail())
                   || supplierRepo.existsByUsername(supplier.getUsername());
        if (dup) throw new SupplierAlreadyExistsException("Supplier already exists");
        supplier.setPassword(encoder.encode(supplier.getPassword()));
        Supplier saved = supplierRepo.save(supplier);
        return saved != null ? saved.getSupplierId() : -1;
    }
    




    @Override
        
    public List<Supplier> getAllSuppliers() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAllSuppliers'");
        return supplierRepo.findAll();
    }



    


    @Override
        
    public List<Supplier> getAllSuppliersSortedByName() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAllSuppliersSortedByName'");
        List<Supplier> list = supplierRepo.findAll();
        Collections.sort(list);
        return list;
    }

    
public void updateSupplier(int id, Supplier s)
            throws SupplierAlreadyExistsException, SupplierDoesNotExistException {

        Supplier old = supplierRepo.findById(id)
                .orElseThrow(() -> new SupplierDoesNotExistException("Supplier not found: " + id));


        boolean dupEmail = supplierRepo.existsByEmailIgnoreCaseAndSupplierIdNot(s.getEmail(), id);
        boolean dupUser  = supplierRepo.existsByUsernameIgnoreCaseAndSupplierIdNot(s.getUsername(), id);
        if (dupEmail || dupUser) {
            throw new SupplierAlreadyExistsException("Supplier already exists");
        }

        old.setAddress(s.getAddress());
        old.setEmail(s.getEmail());
        old.setPassword(s.getPassword());
        old.setUsername(s.getUsername());
        old.setPhone(s.getPhone());
        old.setRole(s.getRole());
        old.setSupplierName(s.getSupplierName());
        supplierRepo.save(old);
    }


    public void deleteSupplier(int id) throws SupplierDoesNotExistException{
        Supplier s = supplierRepo.findById(id).orElseThrow();
        if(s==null) throw new SupplierDoesNotExistException("Supplier does not exists");
        supplierRepo.deleteById(id);

    }
        
    public Supplier getSupplierById(int supplierId) throws SupplierDoesNotExistException {
        Supplier s = supplierRepo.findById(supplierId).orElseThrow();
        if(s==null) throw new SupplierDoesNotExistException("Supplier does not exists");
        return supplierRepo.findById(supplierId).orElseThrow();
    }



}
