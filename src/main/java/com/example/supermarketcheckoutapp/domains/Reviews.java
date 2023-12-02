package com.example.supermarketcheckoutapp.domains;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Reviews {
    @Id
    private String reviewId;
    private String reviewCategory;
    private String review;
}
