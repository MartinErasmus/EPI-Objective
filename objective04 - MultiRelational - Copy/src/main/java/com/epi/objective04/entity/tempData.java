package com.epi.objective04.entity;
import javax.persistence.*;
import java.util.Date;

@Entity

public class tempData {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int Id;

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
    private int homeNumber;
    private String streetName;
    private String poBox;
    
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
    public int getHomeNumber() {
        return homeNumber;
    }
    public String getStreetName() {
        return streetName;
    }
    public String getPoBox() {
        return poBox;
    }

    private String locationType;
    private int buildingNumber;
    private String work_streetName;
    private String work_poBox;

    public String getLocationType() {
        return locationType;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public String getWork_streetName() {
        return work_streetName;
    }

    public String getWork_poBox() {
        return work_poBox;
    }

    public tempData() {
    }
    
}
