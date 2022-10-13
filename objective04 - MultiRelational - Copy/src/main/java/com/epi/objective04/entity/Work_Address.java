package com.epi.objective04.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "Work_address")
public class Work_Address {
    @Id
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "work_id_Sequence")
   // @SequenceGenerator(name = "work_id_Sequence", sequenceName = "work_id_Sequence",allocationSize = 1)
    private long id;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Work_Address() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Work_Address(String locationType, String city, String province, String country, String address, String poBox, Employee employee) {
        this.locationType = locationType;
        this.city = city;
        this.province = province;
        this.country = country;
        this.address = address;
        this.poBox = poBox;
        this.employee = employee;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    private String locationType;
    private String city;
    private String province;
    private String country;
    private String address;
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
