package com.edutech.progressive.service.impl;

<<<<<<< HEAD

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.exception.SupplierAlreadyExistsException;
import com.edutech.progressive.exception.SupplierDoesNotExistException;
import com.edutech.progressive.repository.ProductRepository;
import com.edutech.progressive.repository.ShipmentRepository;
import com.edutech.progressive.repository.SupplierRepository;
import com.edutech.progressive.repository.WarehouseRepository;
import com.edutech.progressive.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
public class SupplierServiceImplJpa implements SupplierService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ShipmentRepository shipmentRepository;

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImplJpa(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> getAllSuppliers() throws SQLException {
        return supplierRepository.findAll();
    }

    @Override
    public int addSupplier(Supplier supplier) throws SupplierAlreadyExistsException {
        Supplier oldUser = supplierRepository.findByUsername(supplier.getUsername());
        if (oldUser != null) {
            throw new SupplierAlreadyExistsException("User name Is Unavailable: " + supplier.getUsername());
        }
        Supplier existingEmail = supplierRepository.findByEmail(supplier.getEmail());
        if (existingEmail != null) {
            throw new SupplierAlreadyExistsException("User with the given email address already exists: " + supplier.getEmail());
        }
        supplier.setPassword(passwordEncoder.encode(supplier.getPassword()));
        return supplierRepository.save(supplier).getSupplierId();
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() throws SQLException {
        List<Supplier> sortedSuppliers = supplierRepository.findAll();
        Collections.sort(sortedSuppliers);
        return sortedSuppliers;
    }

    @Override
    public void updateSupplier(Supplier supplier) throws SupplierAlreadyExistsException {
        if (!supplier.getRole().isBlank()) {
            Supplier oldUser = supplierRepository.findByUsername(supplier.getUsername());
           if (oldUser != null && oldUser.getSupplierId() != supplier.getSupplierId()) {
                throw new SupplierAlreadyExistsException("User name Is Unavailable: " + supplier.getUsername());
            }
            if (!oldUser.getPassword().equals(supplier.getPassword())) {
                supplier.setPassword(passwordEncoder.encode(supplier.getPassword()));
            }
            supplierRepository.save(supplier);
        }
    }

    @Override
    @Transactional
    public void deleteSupplier(int supplierId) throws SQLException {
        shipmentRepository.deleteBySupplierId(supplierId);
        productRepository.deleteBySupplierId(supplierId);
        warehouseRepository.deleteBySupplierId(supplierId);
        supplierRepository.deleteBySupplierId(supplierId);
    }

    @Override
    public Supplier getSupplierById(int supplierId) throws SupplierDoesNotExistException {
        Supplier supplier = supplierRepository.findBySupplierId(supplierId);
        if (supplier != null) {
            return supplierRepository.findBySupplierId(supplierId);
        }
        throw new SupplierDoesNotExistException("Supplier with the given supplierId does not exists");
    }
}
=======
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
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
