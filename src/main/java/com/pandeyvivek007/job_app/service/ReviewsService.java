package com.pandeyvivek007.job_app.service;

import com.pandeyvivek007.job_app.entity.Company;
import com.pandeyvivek007.job_app.entity.Review;
import com.pandeyvivek007.job_app.repository.CompanyRepository;
import com.pandeyvivek007.job_app.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;

    @Autowired
    private CompanyService companyService;


    public List<Review> getAllReviewsByCompanyId(Long companyId) {
        Company company = companyService.getCompanyById(companyId);
        if(company!=null) {
            return company.getReviews();
        } else {
            return null;
        }
    }

    public void saveReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company!=null) {
            company.getReviews().add(review);
            review.setCompany(company);
            reviewsRepository.save(review);
        }

    }

    public Review getReviewById(Long companyId, Long reviewId) {
        Company company = companyService.getCompanyById(companyId);
        if(company!=null) {
            List<Review> reviews = company.getReviews();
            for (Review review : reviews) {
                if (review.getId().equals(reviewId)) {
                    return review;
                }
            }
        }
        return null;
    }

    public Review updateReview(Long companyId, Long reviewId, Review review) {

        Company company = companyService.getCompanyById(companyId);
        Review updateReview = null;
        if(company!=null){

            for(int i=0;i<company.getReviews().size();i++){
                if(company.getReviews().get(i).getId().equals(reviewId)){
                    updateReview = company.getReviews().get(i);
                    break;
                }
            }
            if(updateReview!=null){
                updateReview.setContent(review.getContent());
                updateReview.setRating(review.getRating());
                reviewsRepository.save(updateReview);
            }

        }
        return updateReview;
    }

    public String deleteReview(Long companyId, Long reviewId) {

        Company company = companyService.getCompanyById(companyId);
        if(company!=null){
            List<Review> reviews = company.getReviews();
            for (int i = 0; i < reviews.size(); i++) {
                if (reviews.get(i).getId().equals(reviewId)) {
                    reviews.remove(i);
                    companyService.saveCompany(company);
                    return "Review deleted successfully";
                }
            }
        }
        return "Review not found";
    }
}
