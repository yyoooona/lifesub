package com.unicorn.lifesub.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // Common
    INVALID_INPUT_VALUE(400, "Invalid input value"),
    INTERNAL_SERVER_ERROR(500, "Internal server error"),
    
    // Member
    MEMBER_NOT_FOUND(404, "Member not found"),
    INVALID_CREDENTIALS(401, "Invalid credentials"),
    TOKEN_EXPIRED(401, "Token expired"),
    SIGNATURE_VERIFICATION_EXCEPTION(20, "서명 검증 실패"),
    ALGORITHM_MISMATCH_EXCEPTION(30, "알고리즘 불일치"),
    INVALID_CLAIM_EXCEPTION(40, "유효하지 않은 클레임"),

    // Subscription
    SUBSCRIPTION_NOT_FOUND(404, "Subscription not found"),
    ALREADY_SUBSCRIBED(400, "Already subscribed to this service"),
    
    // Recommend
    NO_SPENDING_DATA(404, "No spending data found"),

    // UnDefined
    UNDIFINED_ERROR(0, "정의되지 않은 에러");

    private final int status;
    private final String message;
}
