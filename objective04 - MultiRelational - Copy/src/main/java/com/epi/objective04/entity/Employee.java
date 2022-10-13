package com.epi.objective04.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Employee implements Serializable {
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id

   // @GeneratedValue(strategy=GenerationType.AUTO, generator = "employee_id_Sequence")
   // @SequenceGenerator(name = "employee_id_Sequence", sequenceName = "employee_id_Sequence",allocationSize = 1)
    private long id;

//    public void setId(long id) {
//        this.id = id;
//    }

    private  String name;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    private String surname;

    private String nationality;

    private String id_number;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    private Date dob;

    public Job_Info getJob_info() {
        return job_info;
    }

    public void setJob_info(Job_Info job_info) {
        this.job_info = job_info;
    }

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "jb_id")
    @JsonManagedReference
    private Job_Info job_info;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "homeAddress_id")
    @JsonManagedReference
    private Home_Address homeAddress_id;

    public com.epi.objective04.entity.Work_Address getWork_Address() {
        return Work_Address;
    }

    public void setWork_Address(com.epi.objective04.entity.Work_Address work_Address) {
        Work_Address = work_Address;
    }

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "workAddress_id")
    @JsonManagedReference
    private Work_Address Work_Address;



    public Home_Address getHomeAddress_id() {
        return homeAddress_id;
    }

    public void setHomeAddress_id(Home_Address homeAddress_id) {
        this.homeAddress_id = homeAddress_id;
    }

    public Employee() {

    }
}
