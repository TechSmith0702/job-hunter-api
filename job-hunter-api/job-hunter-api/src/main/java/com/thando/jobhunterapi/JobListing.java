package com.thando.jobhunterapi;

import java.math.BigDecimal;
import java.time.LocalDate;

public record JobListing(
        Long id,
        String title,
        String company,
        String location,
        BigDecimal salary,
        String techStack,
        LocalDate datePosted
) {}
