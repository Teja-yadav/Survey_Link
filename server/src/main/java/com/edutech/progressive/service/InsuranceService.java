package com.edutech.progressive.service;

import com.edutech.progressive.entity.Insurance;

<<<<<<< HEAD
import java.sql.SQLException;
=======
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
import java.util.List;

public interface InsuranceService {

<<<<<<< HEAD
    List<Insurance> getAllInsurances() throws SQLException;

    int addInsurance(Insurance insurance) throws SQLException;

    Insurance getInsuranceById(int insuranceId) throws SQLException;

    void updateInsurance(Insurance insurance) throws SQLException;

    void deleteInsurance(int insuranceId) throws SQLException;
}
=======
    List<Insurance> getAllInsurances();

    int addInsurance(Insurance insurance);

    Insurance getInsuranceById(int insuranceId);

    void updateInsurance(Insurance insurance);

    void deleteInsurance(int insuranceId);
}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
