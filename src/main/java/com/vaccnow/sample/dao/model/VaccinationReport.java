package com.vaccnow.sample.dao.model;

import javax.persistence.*;

@Entity
@Table
@SequenceGenerator(name = "vaccinationReport",initialValue = 1)
public class VaccinationReport {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String date;

    @Column
    private String branchName;

    @Column
    private int noOfAppliedVaccine;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getNoOfAppliedVaccine() {
        return noOfAppliedVaccine;
    }

    public void setNoOfAppliedVaccine(int noOfAppliedVaccine) {
        this.noOfAppliedVaccine = noOfAppliedVaccine;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
