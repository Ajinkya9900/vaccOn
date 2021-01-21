package com.vaccnow.sample.services.impl;

import com.vaccnow.sample.controller.ClientAppointmentController;
import com.vaccnow.sample.dao.model.VaccineBranches;
import com.vaccnow.sample.dao.services.VaccineBranchServicesDao;
import com.vaccnow.sample.services.VaccineBranchServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineBranchServicesImpl implements VaccineBranchServices {
    Logger log = LoggerFactory.getLogger(VaccineBranchServicesImpl.class);

    @Autowired
    VaccineBranchServicesDao vaccineBranchServicesDao;

    @Override
    public void insertBranches() {
        int min = 00;
        int hr = 10;
        for (int i=1;i<4;i++) {
            VaccineBranches vaccineBranches = new VaccineBranches();
            //vaccineBranches.setId(1+i);
            vaccineBranches.setBranchName("Nagpur-"+i);
            vaccineBranches.setNumberOfAvailableVaccine(5+i);
            vaccineBranches.setTimeSlot(hr+"."+min+" "+hr+"."+(min+15)+" "+hr+"."+(min+30));
            vaccineBranchServicesDao.insertBranches(vaccineBranches);
            hr+=1;
            min +=15;
        }

    }

    @Override
    public List<VaccineBranches> getAllBranches() {
        return vaccineBranchServicesDao.getAllBranches();
    }
}
