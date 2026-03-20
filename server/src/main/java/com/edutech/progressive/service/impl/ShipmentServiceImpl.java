package com.edutech.progressive.service.impl;

<<<<<<< HEAD
import com.edutech.progressive.entity.Shipment;
import com.edutech.progressive.repository.InsuranceRepository;
import com.edutech.progressive.repository.ShipmentRepository;
import com.edutech.progressive.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    ShipmentRepository shipmentRepository;

    @Autowired
    InsuranceRepository insuranceRepository;

    @Override
    public List<Shipment> getAllShipments() throws SQLException {
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.edutech.progressive.entity.Product;
import com.edutech.progressive.entity.Shipment;
// import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.repository.ShipmentRepository;
import com.edutech.progressive.service.ShipmentService;

@Service
public class ShipmentServiceImpl implements ShipmentService  {


    private final ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public List<Shipment> getAllShipments() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAllShipments'");
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
        return shipmentRepository.findAll();
    }

    @Override
<<<<<<< HEAD
    public Shipment getShipmentById(int shipmentId) throws SQLException {
        return shipmentRepository.findByShipmentId(shipmentId);
    }

    @Override
    public int addShipment(Shipment shipment) throws SQLException {
        return shipmentRepository.save(shipment).getShipmentId();
    }

    @Override
    public void updateShipment(Shipment shipment) throws SQLException {
        shipmentRepository.save(shipment);
    }

    @Override
    public void deleteShipment(int shipmentId) throws SQLException {
        insuranceRepository.deleteByShipmentId(shipmentId);
        shipmentRepository.deleteById(shipmentId);
    }
=======
    public Shipment getShipmentById(int shipmentId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getShipmentById'");
        return shipmentRepository.findById(shipmentId).orElse(null);
    }

    @Override
    public int addShipment(Shipment shipment) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'addShipment'");
        Shipment s = shipmentRepository.save(shipment);
        return s != null ? s.getShipmentId() : -1;
    }


    @Override
    public void updateShipment( Shipment shipment) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'updateShipment'");
        Shipment oldShipment = shipmentRepository.findById(shipment.getShipmentId()).orElse(null);
        if(oldShipment==null) return;
        oldShipment.setDestinationLocation(shipment.getDestinationLocation());
        oldShipment.setExpectedDeliveryDate(shipment.getExpectedDeliveryDate());
        oldShipment.setShipmentDate(shipment.getShipmentDate());
        oldShipment.setSourceLocation(shipment.getSourceLocation());
        oldShipment.setStatus(shipment.getStatus());
        oldShipment.setWarehouse(shipment.getWarehouse());
        oldShipment.setSourceLocation(shipment.getSourceLocation());

        shipmentRepository.save(oldShipment);
        
    }

    @Override
    public void deleteShipment(int shipmentId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'deleteShipment'");
        // shipmentRepository.deleteById(shipmentId);
        // Warehouse w = shipmentRepository.findByShipmentId(shipmentId).getWarehouse();
        // Product p = shipmentRepository.findByShipmentId(shipmentId).getProduct();
        // shipmentRepository.deleteByProduct_ProductId(p.getProductId());
        // shipmentRepository.deleteByWarehouse_WarehouseId(p.getProductId());
        // shipmentRepository.deleteByWarehouse_Supplier_SupplierId(p.getWarehouse().getSupplier().getSupplierId());

        shipmentRepository.deleteById(shipmentId);
        
    }

    
    


>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}