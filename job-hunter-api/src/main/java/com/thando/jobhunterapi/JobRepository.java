package com.thando.jobhunterapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobListingEntity, Long> {

    //Derived Query Methods provided automatically by Spring Data JPA!
    List<JobListingEntity> findByLocationIgnoreCase(String location);

    List<JobListingEntity> findBySalaryGreaterThanEqual(BigDecimal minSalary);

    List<JobListingEntity> findByLocationIgnoreCaseAndSalaryGreaterThanEqual(
            String location, BigDecimal minSalary);
}
