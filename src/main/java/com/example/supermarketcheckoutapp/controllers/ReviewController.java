package com.example.supermarketcheckoutapp.controllers;

import com.example.supermarketcheckoutapp.domains.Reviews;
import com.example.supermarketcheckoutapp.services.ReviewServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewServices reviewServices;

    @PostMapping("")
    public String saveReview(@RequestBody Reviews reviews){
        return reviewServices.saveReview(reviews);
    }

    @GetMapping("")
    public List<Reviews> getReviews(){
        return reviewServices.getReviews();
    }
}
