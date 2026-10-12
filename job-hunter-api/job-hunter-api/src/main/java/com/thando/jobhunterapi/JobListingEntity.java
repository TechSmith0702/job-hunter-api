package com.thando.jobhunterapi;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "job_listings")
public class JobListingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String company;
    private String location;
    private BigDecimal salary;
    private String techStack;
    private LocalDate datePosted;

    //Default No-Arg Constructor required by JPA/Hibernate
    public JobListingEntity() {}

    public JobListingEntity(String title, String company, String location,
                            BigDecimal salary, String techStack,
                            LocalDate datePosted){
        this.title = title;
        this.company = company;
        this.location = location;
        this.salary = salary;
        this.techStack = techStack;
        this.datePosted = datePosted;
    }

    //Getters and Setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public String getTitle(){ return title; }
    public void setTitle(String title){ this.title = title; }

    public String getCompany(){ return company; }
    public void setCompany(String company){ this.company = company; }

    public String getLocation(){ return location; }
    public void setLocation(String location){ this.location = location; }

    public BigDecimal getSalary(){ return salary; }
    public void setSalary(BigDecimal salary){ this.salary = salary; }

    public String getTechStack(){ return techStack; }
    public void setTechStack(String techStack){ this.techStack = techStack; }

    public LocalDate getDatePosted(){ return datePosted; }
    public void setDatePosted(LocalDate datePosted){ this.datePosted = datePosted; }



}
