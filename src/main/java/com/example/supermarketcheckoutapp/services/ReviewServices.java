package com.example.supermarketcheckoutapp.services;

import com.example.supermarketcheckoutapp.domains.Reviews;
import com.example.supermarketcheckoutapp.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServices {

    private final ReviewRepository reviewRepository;

    public String saveReview(Reviews reviews){
        reviewRepository.save(reviews);
        return "Review Posted Successfully";
    }

    public List<Reviews> getReviews(){
        return reviewRepository.findAll();
    }

}
