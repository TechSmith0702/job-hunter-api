package com.thando.jobhunterapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
public class HomeController {

    private final JobService jobService;

    public HomeController(JobService jobService){
        this.jobService = jobService;
    }


    @GetMapping("/")
    public String welcome() {
        return "Welcome to the Job Hunter API! Tracking Gauteng tech opportunities coming soon";
    }

    @GetMapping("/api/jobs/search")
    public List<JobListing> searchJobs(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) BigDecimal minSalary){
        return jobService.searchJobs(location, minSalary);
    }

    @GetMapping("api/jobs/{id}")
    public JobListing getJobById(@PathVariable Long id){
        return jobService.getJobById(id);
    }

    @PostMapping("/api/jobs")
    @ResponseStatus(HttpStatus.CREATED) // Returns 201 Created HTTP status
    public JobListing createJob(@RequestBody JobListing newJob){
        return jobService.createJob(newJob);
    }

    @DeleteMapping("/api/jobs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 No content on success
    public void deleteJob(@PathVariable Long id){
         boolean deleted = jobService.deleteJob(id);
         if (!deleted){
             throw new org.springframework.web.server.ResponseStatusException(HttpStatus.NOT_FOUND,
                     "Cannot delete. Job listing not found with ID " + id);
         }
    }


}
