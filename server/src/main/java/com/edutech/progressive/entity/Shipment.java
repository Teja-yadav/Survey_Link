package com.edutech.progressive.entity;

<<<<<<< HEAD
import javax.persistence.*;
import java.util.Date;

@Entity
=======
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
// import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shipment")
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private int shipmentId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="productId")
    private Product product;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="warehouseId")
=======
    @Column(name = "shipment_id")
    private int shipmentId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    @JsonIgnore
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
    private Warehouse warehouse;

    private Date shipmentDate;

    private Date expectedDeliveryDate;

    private String sourceLocation;

<<<<<<< HEAD
    private String destinationLocation;

    private String status;

    public Shipment() {
    }

    public Shipment(int shipmentId, Product product, Warehouse warehouse, Date shipmentDate, Date expectedDeliveryDate, String sourceLocation, String destinationLocation, String status) {
        this.shipmentId = shipmentId;
        this.product = product;
        this.warehouse = warehouse;
        this.shipmentDate = shipmentDate;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.sourceLocation = sourceLocation;
        this.destinationLocation = destinationLocation;
        this.status = status;
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
=======
    public String destinationLocation;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;
    public Shipment() {
    }
    // public Shipment(int shipmentId, Warehouse warehouse, Date shipmentDate, Date expectedDeliveryDate,
    //         String sourceLocation, String destinationLocation, String status) {
    //     this.shipmentId = shipmentId;
    //     this.warehouse = warehouse;
    //     this.shipmentDate = shipmentDate;
    //     this.expectedDeliveryDate = expectedDeliveryDate;
    //     this.sourceLocation = sourceLocation;
    //     this.destinationLocation = destinationLocation;
    //     this.status = status;
    // }
    public int getShipmentId() {
        return shipmentId;
    }
    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }
    public Warehouse getWarehouse() {
        return warehouse;
    }
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
    public Date getShipmentDate() {
        return shipmentDate;
    }
    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }
    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }
    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }
    public String getSourceLocation() {
        return sourceLocation;
    }
    public void setSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }
    public String getDestinationLocation() {
        return destinationLocation;
    }
    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Shipment(int shipmentId, Warehouse warehouse, Date shipmentDate, Date expectedDeliveryDate,
            String sourceLocation, String destinationLocation, String status, Product product) {
        this.shipmentId = shipmentId;
        this.warehouse = warehouse;
        this.shipmentDate = shipmentDate;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.sourceLocation = sourceLocation;
        this.destinationLocation = destinationLocation;
        this.status = status;
        this.product = product;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }


>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}