package com.vaccnow.sample.services;

import com.vaccnow.sample.dao.model.VaccineBranches;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VaccineBranchServices {

    void insertBranches();
    List<VaccineBranches> getAllBranches();
}
