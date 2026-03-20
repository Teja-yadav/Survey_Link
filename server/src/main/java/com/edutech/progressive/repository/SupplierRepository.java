package com.edutech.progressive.repository;

<<<<<<< HEAD
import com.edutech.progressive.entity.Supplier;
=======
import java.util.Optional;

>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    void deleteBySupplierId(@Param("supplierId") int supplierId);

    Supplier findBySupplierId(@Param("supplierId") int supplierId);

    Supplier findByUsername(String username);

    Supplier findByEmail(String email);
}
=======
import com.edutech.progressive.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    
    void deleteBySupplierId(@Param("supplierId")int supplierId);

    Supplier findBySupplierId(@Param("supplierId")int supplierId);

    boolean existsByEmailIgnoreCase(@Param("email") String email);

    boolean existsByUsername(@Param("username") String username);

    boolean existsBySupplierNameIgnoreCase(@Param("supplier_name") String supplierName);

    boolean existsByEmailIgnoreCaseAndSupplierIdNot(String email, int id);

    boolean existsByUsernameIgnoreCaseAndSupplierIdNot(String username, int id);

    Optional<Supplier> findByUsername(String username);

    // Optional<Supplier> findByUserId(Integer userId);

}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
