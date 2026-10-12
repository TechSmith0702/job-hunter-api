package com.thando.jobhunterapi;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }


    public List<JobListing> searchJobs(String location, BigDecimal minSalary){
        List<JobListingEntity> entities;

        if ((location != null && !location.isBlank()) && minSalary != null) {
            entities = jobRepository.findByLocationIgnoreCaseAndSalaryGreaterThanEqual(
                    location.trim(), minSalary);
        } else if (location != null && !location.isBlank()) {
            entities = jobRepository.findByLocationIgnoreCase(location.trim());
        } else if (minSalary != null) {
            entities = jobRepository.findBySalaryGreaterThanEqual(minSalary);
        } else {
            entities = jobRepository.findAll();
        }

        return entities.stream()
                .map(e -> new JobListing(e.getId(), e.getTitle(), e.getCompany(), e.getLocation(),
                        e.getSalary(), e.getTechStack(), e.getDatePosted())).toList();
    }

    public JobListing getJobById(Long id){
        JobListingEntity entity = jobRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Job listing not found with ID " + id));

        return new JobListing(entity.getId(), entity.getTitle(), entity.getCompany(),
                entity.getLocation(), entity.getSalary(), entity.getTechStack(), entity.getDatePosted());
    }

    public JobListing createJob(JobListing newJob){
        JobListingEntity entity = new JobListingEntity(
                newJob.title(),
                newJob.company(),
                newJob.location(),
                newJob.salary(),
                newJob.techStack(),
                newJob.datePosted() != null ? newJob.datePosted() : LocalDate.now()
        );

        JobListingEntity saved = jobRepository.save(entity);
        return new JobListing(saved.getId(), saved.getTitle(), saved.getCompany(), saved.getLocation(),
                saved.getSalary(), saved.getTechStack(), saved.getDatePosted());
    }

    public boolean deleteJob(Long id) {
        if (jobRepository.existsById(id)){
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
