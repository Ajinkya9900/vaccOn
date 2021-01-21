package com.vaccnow.sample.dao.repository;

import com.vaccnow.sample.dao.model.ClientAppointmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientAppointmentDetailsRepo extends JpaRepository<ClientAppointmentDetails, Long> {
}
