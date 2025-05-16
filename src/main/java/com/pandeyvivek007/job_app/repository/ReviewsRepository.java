package com.pandeyvivek007.job_app.repository;

import com.pandeyvivek007.job_app.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ReviewsRepository extends JpaRepository<Review, Long> {
    // Custom query methods can be defined here if needed

}
