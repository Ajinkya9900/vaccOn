package com.vaccnow.sample.services;

import com.vaccnow.sample.controller.model.ClientDetailsRequest;

public interface ClientAppointmentServices {

    void scheduleAppointment(ClientDetailsRequest clientDetailsRequest);
}
