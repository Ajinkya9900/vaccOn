package com.vaccnow.sample.services;

import com.vaccnow.sample.dao.model.VaccinationReport;

import java.util.List;

public interface VaccineReportService {

    List<VaccinationReport> getAppliedVaccinationReport(String branchName);

    List<VaccinationReport> getPerDayReport(String date);
}
