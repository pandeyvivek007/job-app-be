package com.pandeyvivek007.job_app.controller;

import com.pandeyvivek007.job_app.entity.Company;
import com.pandeyvivek007.job_app.entity.Review;
import com.pandeyvivek007.job_app.service.CompanyService;
import com.pandeyvivek007.job_app.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/company/{companyId}/reviews")
    public ResponseEntity<List<Review>> getReviewsByCompanyId(@PathVariable Long companyId) {
        return ResponseEntity.ok(reviewsService.getAllReviewsByCompanyId(companyId));
    }

    @PostMapping("/company/{companyId}/reviews")
    public ResponseEntity<Void> saveReview(@PathVariable Long companyId, @RequestBody Review review) {
        reviewsService.saveReview(companyId, review);
        return ResponseEntity.ok().build();
    }

    @GetMapping("company/{companyId}/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return ResponseEntity.ok(reviewsService.getReviewById(companyId, reviewId));
    }

    @PutMapping("company/{companyId}/reviews/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review) {
        return ResponseEntity.ok(reviewsService.updateReview(companyId, reviewId, review));

    }

    @DeleteMapping("company/{companyId}/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return ResponseEntity.ok(reviewsService.deleteReview(companyId, reviewId));
    }
}
