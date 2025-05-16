package com.pandeyvivek007.job_app.repository;

import com.pandeyvivek007.job_app.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    // Custom query methods can be defined here if needed
}
