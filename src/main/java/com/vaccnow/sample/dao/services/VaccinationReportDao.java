package com.vaccnow.sample.dao.services;

import com.vaccnow.sample.dao.model.VaccinationReport;
import com.vaccnow.sample.dao.repository.VaccinationReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VaccinationReportDao {

    @Autowired
    VaccinationReportRepo vaccinationReportRepo;

    public void insertRecord(VaccinationReport vaccinationReport){
        vaccinationReportRepo.save(vaccinationReport);

    }
    public List<VaccinationReport> getRecord(){
        return vaccinationReportRepo.findAll();
    }
}
