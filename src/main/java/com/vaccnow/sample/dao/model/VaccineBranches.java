package com.vaccnow.sample.dao.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table
@SequenceGenerator(name = "test",initialValue = 1)
public class VaccineBranches {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String branchName;

    @Column
    private int numberOfAvailableVaccine;

    @Column
    private String timeSlot;

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

    public int getNumberOfAvailableVaccine() {
        return numberOfAvailableVaccine;
    }

    public void setNumberOfAvailableVaccine(int numberOfAvailableVaccine) {
        this.numberOfAvailableVaccine = numberOfAvailableVaccine;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
}
