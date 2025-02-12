package com.unicorn.lifesub.recommend.controller;

import com.unicorn.lifesub.common.dto.ApiResponse;
import com.unicorn.lifesub.recommend.dto.RecommendCategoryDTO;
import com.unicorn.lifesub.recommend.service.RecommendService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "구독추천 API", description = "구독추천 관련 API")
@RestController
@RequestMapping("/api/recommend")
@RequiredArgsConstructor
public class RecommendController {
    private final RecommendService recommendService;

    @Operation(summary = "추천 카테고리 조회", 
              description = "사용자의 지출 패턴을 분석하여 추천 구독 카테고리를 제공합니다.")
    @GetMapping("/categories")
    public ResponseEntity<ApiResponse<RecommendCategoryDTO>> getRecommendedCategory(
            @RequestParam String userId) {
        RecommendCategoryDTO response = recommendService.getRecommendedCategory(userId);
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
