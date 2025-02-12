package com.unicorn.lifesub.mysub.infra.controller;

import com.unicorn.lifesub.common.dto.ApiResponse;
import com.unicorn.lifesub.mysub.biz.dto.SubDetailResponse;
import com.unicorn.lifesub.mysub.biz.usecase.in.CancelSubscriptionUseCase;
import com.unicorn.lifesub.mysub.biz.usecase.in.SubscribeUseCase;
import com.unicorn.lifesub.mysub.biz.usecase.in.SubscriptionDetailUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "구독 서비스 API", description = "구독 서비스 관련 API")
@RestController
@RequestMapping("/api/mysub/services")
@RequiredArgsConstructor
public class ServiceController {
    private final SubscriptionDetailUseCase subscriptionDetailUseCase;
    private final SubscribeUseCase subscribeUseCase;
    private final CancelSubscriptionUseCase cancelSubscriptionUseCase;

    @Operation(summary = "구독 서비스 상세 조회")
    @GetMapping("/{subscriptionId}")
    public ResponseEntity<ApiResponse<SubDetailResponse>> getSubscriptionDetail(
            @PathVariable Long subscriptionId) {
        return ResponseEntity.ok(ApiResponse.success(
            subscriptionDetailUseCase.getSubscriptionDetail(subscriptionId)));
    }

    @Operation(summary = "구독 신청")
    @PostMapping("/{subscriptionId}/subscribe")
    public ResponseEntity<ApiResponse<Void>> subscribe(
            @PathVariable Long subscriptionId,
            @RequestParam String userId) {
        subscribeUseCase.subscribe(subscriptionId, userId);
        return ResponseEntity.ok(ApiResponse.success(null));
    }

    @Operation(summary = "구독 취소")
    @DeleteMapping("/{subscriptionId}")
    public ResponseEntity<ApiResponse<Void>> cancel(
            @PathVariable Long subscriptionId) {
        cancelSubscriptionUseCase.cancel(subscriptionId);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
