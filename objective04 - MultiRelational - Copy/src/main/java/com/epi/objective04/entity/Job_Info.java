package com.epi.objective04.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table (name = "job_info")

public class Job_Info {
    public void setId(long id) {
        this.id = id;
    }

    @Id
   // @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "jb_id_Sequence")
    //@SequenceGenerator(name = "jb_id_Sequence", sequenceName = "jb_id_Sequence",allocationSize = 1)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Job_Info() {

    }

    public Job_Info(long id, String position, String salary, String currency) {
        this.id = id;
        this.position = position;
        this.salary = salary;
        this.currency = currency;
    }

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private String salary;

    @Column(name = "currency")
    private String currency;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "job_info")
    @JsonBackReference
    private Employee employee;
}
