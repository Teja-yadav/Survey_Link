package com.edutech.progressive.service.impl;

<<<<<<< HEAD
import com.edutech.progressive.entity.Insurance;
import com.edutech.progressive.repository.InsuranceRepository;
import com.edutech.progressive.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    InsuranceRepository insuranceRepository;

    @Override
    public List<Insurance> getAllInsurances() throws SQLException {
        return insuranceRepository.findAll();
    }

    @Override
    public int addInsurance(Insurance insurance) throws SQLException {
        return insuranceRepository.save(insurance).getInsuranceId();
    }

    @Override
    public Insurance getInsuranceById(int insuranceId) throws SQLException {
        return insuranceRepository.findByInsuranceId(insuranceId);
    }

    @Override
    public void updateInsurance(Insurance insurance) throws SQLException {
        insuranceRepository.save(insurance);
    }

    @Override
    public void deleteInsurance(int insuranceId) throws SQLException {
        insuranceRepository.deleteById(insuranceId);
    }
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Insurance;
import com.edutech.progressive.repository.InsuranceRepository;
import com.edutech.progressive.service.InsuranceService;

@Service
public class InsuranceServiceImpl implements InsuranceService  {


    private final InsuranceRepository insuranceRepo;

    @Autowired
    public InsuranceServiceImpl(InsuranceRepository insuranceRepo) {
        this.insuranceRepo = insuranceRepo;
    }

    @Override
    public List<Insurance> getAllInsurances() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAllInsurances'");
        return insuranceRepo.findAll();
    }

    @Override
    public int addInsurance(Insurance insurance) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'addInsurance'");
        Insurance a = insuranceRepo.save(insurance);
        return a != null ? a.getInsuranceId() : -1;
    }

    @Override
    public Insurance getInsuranceById(int insuranceId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getInsuranceById'");
        return insuranceRepo.findById(insuranceId).orElse(null);
    }

    @Override
    public void updateInsurance(Insurance insurance) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'updateInsurance'");
        Insurance old = insuranceRepo.findById(insurance.getInsuranceId()).orElse(null);
        old.setInsuranceCoverageAmount(insurance.getInsuranceCoverageAmount());
        old.setShipment(insurance.getShipment());
        old.setInsuranceProvider(insurance.getInsuranceProvider());
        insuranceRepo.save(old);

    }

    @Override
    public void deleteInsurance(int insuranceId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'deleteInsurance'");
        insuranceRepo.deleteById(insuranceId);
    }


    
    
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
}