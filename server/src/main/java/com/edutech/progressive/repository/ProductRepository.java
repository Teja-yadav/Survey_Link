package com.edutech.progressive.repository;

<<<<<<< HEAD
import com.edutech.progressive.entity.Product;
=======
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByProductId(@Param("productId") int productId);

    List<Product> findAllByWarehouse_WarehouseId(@Param("warehouseId") int warehouseId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Product p WHERE p.warehouse.warehouseId = :warehouseId")
    void deleteByWarehouseId(@Param("warehouseId") int warehouseId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Product p WHERE p.warehouse.warehouseId in (Select w.warehouseId from Warehouse w where w.supplier.supplierId = :supplierId)")
    void deleteBySupplierId(@Param("supplierId") int supplierId);

    int countByWarehouse_WarehouseId(Integer warehouseId);
}
=======
import com.edutech.progressive.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

    @Query("Select p from Product p where p.productId = :productId")
    Product findByProductId(@Param("productId") int productId);


    List<Product> findAllByWarehouse_WarehouseId(@Param("warehouseId") int warehouseId);
    
    @Modifying
    @Transactional
        @EntityGraph(attributePaths = "warehouse")
    void deleteByWarehouse_WarehouseId(@Param("warehouseId")int warehouseId);

    @Modifying
    @Transactional
        @EntityGraph(attributePaths = "supplier")
    void deleteByWarehouse_Supplier_SupplierId(@Param("supplierId") int supplierId);
}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
