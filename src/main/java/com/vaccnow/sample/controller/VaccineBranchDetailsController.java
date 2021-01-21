package com.vaccnow.sample.controller;

import com.vaccnow.sample.dao.model.VaccineBranches;
import com.vaccnow.sample.services.VaccineBranchServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/vaccination/")
@Api(value = "Vaccination Branch Details")
public class VaccineBranchDetailsController {
    Logger log = LoggerFactory.getLogger(VaccineBranchDetailsController.class);
    final String NOT_FOUND_ERROR = "{\n"+"\"Error\": \"Record not found\"}";

    @Autowired
    VaccineBranchServices  vaccineBranchServices;

    //http://localhost:8080/swagger-ui.html#/

    @RequestMapping(value = "populate/branches",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    @ApiOperation(value ="To populate dummy data for testing")
    public String prePopulateBranches() {
        vaccineBranchServices.insertBranches();
        log.info("Data Populated");
        return "Done";
    }

    @RequestMapping(value = "all/branches",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @ApiOperation(value ="Get List of all vaccination branches")
    public ResponseEntity<List<String>> getAllVaccinationBranches() {
        log.info("Request received for get all branches");
        List<VaccineBranches> vaccineBranches = vaccineBranchServices.getAllBranches();
        ArrayList<String> branchNamelist = new ArrayList<>();
        //list.add(vaccineBranches.ge)
        if(vaccineBranches.isEmpty()){
            return new ResponseEntity(NOT_FOUND_ERROR,HttpStatus.NOT_FOUND);
        }else{
            vaccineBranches.stream().forEach(vaccinationBranch -> branchNamelist.add(vaccinationBranch.getBranchName()));
        }
        return ResponseEntity.ok(branchNamelist);
    }

    @RequestMapping(value = "available/branches",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @ApiOperation(value ="Get a list of all available vaccines and time slots per branch")
    public ResponseEntity<List<VaccineBranches>> getAvailableVaccinationPerBranches() {
        log.info("Request received for get all branches");
        List<VaccineBranches> vaccineBranches = vaccineBranchServices.getAllBranches();
        if(vaccineBranches.isEmpty()){
            return new ResponseEntity(NOT_FOUND_ERROR,HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(vaccineBranches);
    }
}
