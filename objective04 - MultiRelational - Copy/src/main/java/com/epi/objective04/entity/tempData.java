package com.epi.objective04.entity;
import javax.persistence.*;
import java.util.Date;


public class tempData {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int Id;

    public int getId() {
        return Id;
    }

    public String getSurname() {
        return surname;
    }

    public String getNationality() {
        return nationality;
    }

    public String getId_number() {
        return id_number;
    }
    private  String name;

    private String surname;

    private String nationality;

    private String id_number;

    public String getEmail() {
        return email;
    }

    private String email;

    private Date dob;

    public Date getDob() {
        return dob;
    }

    private String position;
    private String salary;
    private String currency;
    private String dwellingType;
    private String poBox;

    private String city;
    private String province;
    private String country;
    private String address;

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getWork_city() {
        return work_city;
    }

    public String getWork_province() {
        return work_province;
    }

    public String getWork_country() {
        return work_country;
    }

    public String getWork_address() {
        return work_address;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
    public String getSalary() {
        return salary;
    }
    public String getCurrency() {
        return currency;
    }
    public String getDwellingType() {
        return dwellingType;
    }
    public String getPoBox() {
        return poBox;
    }

    private String locationType;
    private String work_poBox;
    private String work_city;
    private String work_province;
    private String work_country;
    private String work_address;
    public String getLocationType() {
        return locationType;
    }


    public String getWork_poBox() {
        return work_poBox;
    }

    public tempData() {
    }
    
}
