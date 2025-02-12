package com.unicorn.lifesub.mysub.biz.service;

import com.unicorn.lifesub.mysub.biz.domain.MySubscription;
import com.unicorn.lifesub.mysub.biz.dto.MySubResponse;
import com.unicorn.lifesub.mysub.biz.dto.TotalFeeResponse;
import com.unicorn.lifesub.mysub.biz.usecase.in.MySubscriptionsUseCase;
import com.unicorn.lifesub.mysub.biz.usecase.in.TotalFeeUseCase;
import com.unicorn.lifesub.mysub.biz.usecase.out.MySubscriptionReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MySubscriptionService implements TotalFeeUseCase, MySubscriptionsUseCase {
    private final MySubscriptionReader mySubscriptionReader;

    @Override
    @Transactional(readOnly = true)
    public TotalFeeResponse getTotalFee(String userId) {
        List<MySubscription> subscriptions = mySubscriptionReader.findByUserId(userId);
        long totalFee = subscriptions.stream()
                .mapToLong(MySubscription::getPrice)
                .sum();

        return TotalFeeResponse.builder()
                .totalFee(totalFee)
                .feeLevel(calculateFeeLevel(totalFee))
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MySubResponse> getMySubscriptions(String userId) {
        return mySubscriptionReader.findByUserId(userId).stream()
                .map(subscription -> MySubResponse.builder()
                        .serviceName(subscription.getSubscription().getName())
                        .logoUrl(subscription.getSubscription().getLogoUrl())
                        .build())
                .collect(Collectors.toList());
    }

    private String calculateFeeLevel(long totalFee) {
        if (totalFee < 100000) return "구독을 좋아하는 사람";
        if (totalFee < 200000) return "구독 수집자";
        return "구독 사치왕";
    }
}
