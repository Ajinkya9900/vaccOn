package com.vaccnow.sample.dao.repository;

import com.vaccnow.sample.dao.model.VaccineBranches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineBranchServicesRepo extends JpaRepository<VaccineBranches, Long> {
}
