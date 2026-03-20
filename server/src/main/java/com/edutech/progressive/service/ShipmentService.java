package com.edutech.progressive.service;

import com.edutech.progressive.entity.Shipment;

<<<<<<< HEAD
import java.sql.SQLException;
import java.util.List;

public interface ShipmentService {
    List<Shipment> getAllShipments() throws SQLException;

    Shipment getShipmentById(int shipmentId) throws SQLException;

    int addShipment(Shipment shipment) throws SQLException;

    void updateShipment(Shipment shipment) throws SQLException;

    void deleteShipment(int shipmentId) throws SQLException;

}
=======
import java.util.List;

// import org.springframework.stereotype.Service;



public interface ShipmentService {
    List<Shipment> getAllShipments();

    Shipment getShipmentById(int shipmentId);

    int addShipment(Shipment shipment);

     void updateShipment(Shipment shipment);

    void deleteShipment(int shipmentId);

    // void updateShipment(int shipId, Shipment shipment);

}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
