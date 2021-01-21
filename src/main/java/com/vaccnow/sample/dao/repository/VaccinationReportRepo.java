package com.vaccnow.sample.dao.repository;

import com.vaccnow.sample.dao.model.VaccinationReport;
import com.vaccnow.sample.dao.model.VaccineBranches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationReportRepo extends JpaRepository<VaccinationReport, Long> {
}
