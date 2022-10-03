package com.epi.objective04.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "work_address")
public class Work_Address {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "work_id_Sequence")
    @SequenceGenerator(name = "work_id_Sequence", sequenceName = "work_id_Sequence",allocationSize = 1)
    private long id;

    public Work_Address(String dwellingType, int buildingNumber, String streetName, String poBox) {
        this.locationType = dwellingType;
        this.buildingNumber = buildingNumber;
        this.streetName = streetName;
        this.poBox = poBox;
    }

    public Work_Address() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPoBox() {
        return poBox;
    }

    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }



    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    private String locationType;
    private int buildingNumber;
    private String streetName;
    private String poBox;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "Work_Address")
    @JsonBackReference
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
