package com.vaccnow.sample.services.impl;

import com.vaccnow.sample.dao.model.VaccinationReport;
import com.vaccnow.sample.dao.services.VaccinationReportDao;
import com.vaccnow.sample.error.BadRequestException;
import com.vaccnow.sample.services.VaccineReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VaccineReportServiceImpl implements VaccineReportService {

    @Autowired
    VaccinationReportDao vaccinationReportDao;

    @Override
    public List<VaccinationReport> getAppliedVaccinationReport(String branchName) {

        List<VaccinationReport> vaccinationReports = vaccinationReportDao.getRecord();

        List<VaccinationReport> finalList = vaccinationReports.stream().filter(l ->l.getBranchName().equalsIgnoreCase(branchName)).collect(Collectors.toList());
        if(finalList.isEmpty()){
            throw new BadRequestException("404","No record found");
        }
        return finalList;
    }

    @Override
    public List<VaccinationReport> getPerDayReport(String date) {
        List<VaccinationReport> vaccinationReports = vaccinationReportDao.getRecord();

        List<VaccinationReport> finalList = vaccinationReports.stream().filter(l ->l.getDate().equalsIgnoreCase(date)).collect(Collectors.toList());
        if(finalList.isEmpty()){
            throw new BadRequestException("404","No record found");
        }
        return finalList;
    }

    public VaccinationReport getRecord(String date, String branch){
        List<VaccinationReport> vaccinationReports = vaccinationReportDao.getRecord();

        if(!vaccinationReports.isEmpty()){
            Optional<VaccinationReport> vaccinationReport = vaccinationReports.stream().filter(report -> (report.getDate().equalsIgnoreCase(date)&& report.getBranchName().equalsIgnoreCase(branch))).findFirst();
       if(vaccinationReport.isPresent()){
           return vaccinationReport.get();
       }

        }
        return null;
    }
}
