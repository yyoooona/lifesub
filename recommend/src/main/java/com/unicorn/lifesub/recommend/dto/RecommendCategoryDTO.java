package com.unicorn.lifesub.recommend.dto;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@Builder
public class RecommendCategoryDTO {
    private String categoryName;
    private String imagePath;
    private LocalDate baseDate;
}
