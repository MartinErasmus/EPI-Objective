package com.epi.objective04.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "home_address")
public class Home_Address {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "home_id_Sequence")
    @SequenceGenerator(name = "home_id_Sequence", sequenceName = "home_id_Sequence",allocationSize = 1)
    private long id;

    public Home_Address(String dwellingType, int homeNumber, String streetName, String poBox) {
        this.dwellingType = dwellingType;
        this.homeNumber = homeNumber;
        this.streetName = streetName;
        this.poBox = poBox;
    }

    public Home_Address() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDwellingType() {
        return dwellingType;
    }

    public void setDwellingType(String dwellingType) {
        this.dwellingType = dwellingType;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
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

    private String dwellingType;
    private int homeNumber;
    private String streetName;
    private String poBox;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "homeAddress_id")
    @JsonBackReference
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
