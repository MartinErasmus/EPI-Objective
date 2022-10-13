package com.epi.objective04.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "home_address")
public class Home_Address {

    @Id
   // @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "home_id_Sequence")
    //@SequenceGenerator(name = "home_id_Sequence", sequenceName = "home_id_Sequence",allocationSize = 1)
    private long id;




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

    public String getPoBox() {
        return poBox;
    }

    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }

    private String dwellingType;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String city;
    private String province;
    private String country;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    private String poBox;

    public Home_Address(String dwellingType, String city, String province, String country, String address, String poBox, Employee employee) {
        this.dwellingType = dwellingType;
        this.city = city;
        this.province = province;
        this.country = country;
        this.address = address;
        this.poBox = poBox;
        this.employee = employee;
    }

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
