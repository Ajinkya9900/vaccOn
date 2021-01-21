package com.vaccnow.sample.controller;

import com.vaccnow.sample.dao.model.VaccinationReport;
import com.vaccnow.sample.dao.model.VaccineBranches;
import com.vaccnow.sample.services.VaccineReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping(value = "/vaccination/report")
@Api(value = "Vaccination Branch Details")
public class VaccinationReportController {
    Logger log = LoggerFactory.getLogger(VaccinationReportController.class);

    @Autowired
    VaccineReportService vaccineReportService;

    @RequestMapping(value = "/branche/{branchname}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @ApiOperation(value ="Get List of all vaccination per branches")
    public ResponseEntity<List<VaccinationReport>> getAllVaccinationBranches(@PathVariable String branchname) {
        log.info("Request received for getting vaccination report for branch "+branchname);

        return ResponseEntity.ok(vaccineReportService.getAppliedVaccinationReport(branchname));
    }
    @RequestMapping(value = "/date/{date}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @ApiOperation(value ="Get List of all vaccination details as per date")
    public ResponseEntity<List<VaccinationReport>> getAllVaccinationByDate(@PathVariable String date) {
        log.info("Request received for getting vaccination report for branch "+date);

        return ResponseEntity.ok(vaccineReportService.getPerDayReport(date));
    }
}
