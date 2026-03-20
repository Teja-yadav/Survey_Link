package com.edutech.progressive.entity;

<<<<<<< HEAD
import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "warehouseId")
    private Warehouse warehouse;
    private String productName;
    private String productDescription;
    private int quantity;
    private Long price;

    public Product() {
    }

    public Product(int productId, int warehouseId, String productName, String productDescription, int quantity, Long price) {
        this.productId = productId;
        this.warehouse.setWarehouseId(warehouseId);
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="product")
public class Product {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "warehouse_id")
    // @JsonIgnore
    private Warehouse warehouse;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private Long price;
    public Product(int productId, Warehouse warehouse, String productName, String productDescription, int quantity,
            Long price) {
        this.productId = productId;
        this.warehouse = warehouse;
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
        this.productName = productName;
        this.productDescription = productDescription;
        this.quantity = quantity;
        this.price = price;
    }
<<<<<<< HEAD

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
=======
    public int getProductId() {
        return productId;
    }
    public Warehouse getWarehouse() {
        return warehouse;
    }
    public String getProductName() {
        return productName;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public int getQuantity() {
        return quantity;
    }
    public Long getPrice() {
        return price;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(Long price) {
        this.price = price;
    }
    public Product() {
    }

    

>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}