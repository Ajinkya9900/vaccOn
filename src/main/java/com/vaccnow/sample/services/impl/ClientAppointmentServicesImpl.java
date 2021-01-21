package com.vaccnow.sample.services.impl;

import com.vaccnow.sample.controller.ClientAppointmentController;
import com.vaccnow.sample.controller.model.ClientDetailsRequest;
import com.vaccnow.sample.dao.model.ClientAppointmentDetails;
import com.vaccnow.sample.dao.model.VaccinationReport;
import com.vaccnow.sample.dao.model.VaccineBranches;
import com.vaccnow.sample.dao.services.ClientAppointmentServicesDao;
import com.vaccnow.sample.dao.services.VaccinationReportDao;
import com.vaccnow.sample.dao.services.VaccineBranchServicesDao;
import com.vaccnow.sample.error.BadRequestException;
import com.vaccnow.sample.services.ClientAppointmentServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ClientAppointmentServicesImpl implements ClientAppointmentServices {
    Logger log = LoggerFactory.getLogger(ClientAppointmentServicesImpl.class);

    final String SIMPLE_DATE_FORMATTER = "DD-MM-YYYY";

    @Autowired
    ClientAppointmentServicesDao clientAppointmentServicesDao;
    @Autowired
    VaccineBranchServicesDao vaccineBranchServicesDao;
    @Autowired
    VaccinationReportDao vaccinationReportDao;

    @Autowired
    VaccineReportServiceImpl vaccineReportService;

    @Override
    public void scheduleAppointment(ClientDetailsRequest clientDetailsRequest) {

        checkTimeSlotIsValid(clientDetailsRequest.getBranchName(),clientDetailsRequest.getTimeSlot());
        ClientAppointmentDetails clientAppointmentDetails = new ClientAppointmentDetails();
        clientAppointmentDetails.setName(clientDetailsRequest.getName());
        clientAppointmentDetails.setEmail(clientDetailsRequest.getEmail());
        clientAppointmentDetails.setPaymentMethod(clientDetailsRequest.getPaymentMethod());
        clientAppointmentDetails.setBranchName(clientDetailsRequest.getBranchName());
        clientAppointmentDetails.setTimeSlot(clientDetailsRequest.getTimeSlot());//expected is time slot has been selected from available slots only
        clientAppointmentServicesDao.saveClientAppointmentData(clientAppointmentDetails);
        log.info("<<< ClientAppointmentServicesImpl.scheduleAppointment() Appointment is confirmed");
    }

    private void checkTimeSlotIsValid(String branch,String timeSlot) {
        List<VaccineBranches> list = vaccineBranchServicesDao.getAllBranches();
        Optional<VaccineBranches> vaccineBranches =list.stream().filter(l->l.getBranchName().equalsIgnoreCase(branch)).findFirst();
        if(vaccineBranches.isPresent()) {
            VaccineBranches vaccineBranch = vaccineBranches.get();
            String availableTimeSlot = vaccineBranch.getTimeSlot();
            ArrayList listOfAvailableSlots = new ArrayList();
            String[] splitString = availableTimeSlot.split(" ");
            for(String str : splitString){
                listOfAvailableSlots.add(str);
            }
            if (!listOfAvailableSlots.contains(timeSlot)) {
                throw new BadRequestException("404", "Provided Time Slot is not available");
            }else {
                updateTimeSlotAndVaccineAvailability(vaccineBranch,availableTimeSlot,timeSlot);
                updateVaccineReport(vaccineBranch);
            }
        }else {
            throw new BadRequestException("404", "Provided Branch is inValid");
        }
    }

    private void updateTimeSlotAndVaccineAvailability(VaccineBranches vaccineBranch,String timeSlot,String requestedTimeSlot){
        timeSlot = timeSlot.replace(requestedTimeSlot,"");
        vaccineBranch.setTimeSlot(timeSlot);
        vaccineBranch.setNumberOfAvailableVaccine(vaccineBranch.getNumberOfAvailableVaccine()-1);
        vaccineBranchServicesDao.insertBranches(vaccineBranch);

    }

    private void updateVaccineReport(VaccineBranches vaccineBranch){
        VaccinationReport vaccinationReport;
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern(SIMPLE_DATE_FORMATTER));
        vaccinationReport = vaccineReportService.getRecord(date,vaccineBranch.getBranchName());
        if (vaccinationReport == null){
            vaccinationReport = new VaccinationReport();
            vaccinationReport.setNoOfAppliedVaccine(1);
            vaccinationReport.setBranchName(vaccineBranch.getBranchName());
            vaccinationReport.setDate(date);
        }else{
            vaccinationReport.setNoOfAppliedVaccine(vaccinationReport.getNoOfAppliedVaccine()+1);
        }

        vaccinationReportDao.insertRecord(vaccinationReport);
    }


}
