package com.vaccnow.sample.dao.services;

import com.vaccnow.sample.controller.ClientAppointmentController;
import com.vaccnow.sample.dao.model.ClientAppointmentDetails;
import com.vaccnow.sample.dao.repository.ClientAppointmentDetailsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientAppointmentServicesDao {
    Logger log = LoggerFactory.getLogger(ClientAppointmentServicesDao.class);

    @Autowired
    ClientAppointmentDetailsRepo clientAppointmentDetailsRepo;

    public void saveClientAppointmentData(ClientAppointmentDetails clientAppointmentDetails){
        clientAppointmentDetailsRepo.save(clientAppointmentDetails);

    }
}
