package com.vaccnow.sample.controller;

import com.vaccnow.sample.controller.model.ClientDetailsRequest;
import com.vaccnow.sample.error.BadRequestException;
import com.vaccnow.sample.services.ClientAppointmentServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@Api(value = "API's to book Appointment")
public class ClientAppointmentController {
    Logger log = LoggerFactory.getLogger(ClientAppointmentController.class);
    @Autowired
    ClientAppointmentServices clientAppointmentServices;

    @RequestMapping(value = "/vaccination/book/appointment",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @ApiOperation(value ="API to schedule appointment")
    @ApiResponses(value = {@ApiResponse(code = 202,message = "Accepted"),@ApiResponse(code = 404,message = "BadRequest")})
    public ResponseEntity getAllVaccinationBranches(@RequestBody ClientDetailsRequest clientDetailsRequest) throws Exception {
        log.info("Request received for booking appointment ");
        clientAppointmentServices.scheduleAppointment(clientDetailsRequest);
        return ResponseEntity.accepted().build();
    }
}
