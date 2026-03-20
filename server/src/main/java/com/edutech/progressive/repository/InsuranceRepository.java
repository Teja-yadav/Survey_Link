package com.edutech.progressive.repository;

<<<<<<< HEAD
import com.edutech.progressive.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {

    Insurance findByInsuranceId(int insuranceId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Insurance ins WHERE ins.shipment.shipmentId = :shipmentId")
    void deleteByShipmentId(@Param("shipmentId") int shipmentId);
}
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.progressive.entity.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
    Insurance findByInsuranceId(int insuranceId);
    void deleteByShipment_ShipmentId(int shipmentid);
}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
