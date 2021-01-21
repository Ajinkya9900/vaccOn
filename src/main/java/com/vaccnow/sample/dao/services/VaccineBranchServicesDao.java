package com.vaccnow.sample.dao.services;

import com.vaccnow.sample.controller.ClientAppointmentController;
import com.vaccnow.sample.dao.model.VaccineBranches;
import com.vaccnow.sample.dao.repository.VaccineBranchServicesRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VaccineBranchServicesDao {
    Logger log = LoggerFactory.getLogger(VaccineBranchServicesDao.class);

    @Autowired
    VaccineBranchServicesRepo vaccineBranchServicesRepo;

    public void insertBranches(VaccineBranches vaccineBranches) {
vaccineBranchServicesRepo.save(vaccineBranches);
    }


    public List<VaccineBranches> getAllBranches() {
        List<VaccineBranches> l = vaccineBranchServicesRepo.findAll();
        return l;
    }

}
