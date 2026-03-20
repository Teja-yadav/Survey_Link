package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Shipment;
<<<<<<< HEAD
import com.edutech.progressive.service.impl.ShipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

=======
import com.edutech.progressive.service.ShipmentService;
// import com.edutech.progressive.service.impl.ShipmentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
@RestController
@RequestMapping("/shipment")
public class ShipmentController {

<<<<<<< HEAD
    @Autowired
    ShipmentServiceImpl shipmentService;

    @GetMapping
    public ResponseEntity<List<Shipment>> getAllShipments() throws SQLException {
        List<Shipment> shipments = shipmentService.getAllShipments();
        return new ResponseEntity<>(shipments, HttpStatus.OK);
=======

    private final ShipmentService shipmentService;

    

    @Autowired
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @GetMapping
    public ResponseEntity<List<Shipment>> getAllShipments() {
        return ResponseEntity.status(200).body(shipmentService.getAllShipments());
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
    }

    @GetMapping("/{shipmentId}")
    public ResponseEntity<Shipment> getShipmentById(@PathVariable int shipmentId) {
<<<<<<< HEAD
        try {
            Shipment shipment = shipmentService.getShipmentById(shipmentId);
            if (shipment != null) {
                return new ResponseEntity<>(shipment, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
=======
        Shipment s = shipmentService.getShipmentById(shipmentId);
        if(s == null) return ResponseEntity.status(404).build();
        return ResponseEntity.status(200).body(s);
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
    }

    @PostMapping
    public ResponseEntity<Integer> addShipment(@RequestBody Shipment shipment) {
<<<<<<< HEAD
        try {
            int shipmentId = shipmentService.addShipment(shipment);
            return new ResponseEntity<>(shipmentId, HttpStatus.CREATED);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{shipmentId}")
    public ResponseEntity<Void> updateShipment(@PathVariable int shipmentId, @RequestBody Shipment shipment) {
        try {
            shipment.setShipmentId(shipmentId);
            shipmentService.updateShipment(shipment);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
=======
        return ResponseEntity.status(201).body(shipmentService.addShipment(shipment));
    }


    @PutMapping("/{shipmentId}")
    public ResponseEntity<Void> updateShipment(@PathVariable int shipmentId,@RequestBody Shipment shipment) {
        Shipment s = shipmentService.getShipmentById(shipmentId);
        if(s == null) return ResponseEntity.noContent().build(); 
        s.setShipmentId(shipmentId);
        shipmentService.updateShipment(shipment);
        return ResponseEntity.status(200).body(null);
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
    }

    @DeleteMapping("/{shipmentId}")
    public ResponseEntity<Void> deleteShipment(@PathVariable int shipmentId) {
<<<<<<< HEAD
        try {
            shipmentService.deleteShipment(shipmentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
=======
        Shipment s = shipmentService.getShipmentById(shipmentId);
        if(s == null) return ResponseEntity.noContent().build(); 
        shipmentService.deleteShipment(shipmentId);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleException(RuntimeException e){
        return ResponseEntity.status(500).body(null);
    }
}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
