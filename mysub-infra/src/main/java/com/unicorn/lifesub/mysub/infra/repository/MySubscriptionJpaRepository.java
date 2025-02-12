package com.unicorn.lifesub.mysub.infra.repository;

import com.unicorn.lifesub.mysub.infra.entity.MySubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MySubscriptionJpaRepository extends JpaRepository<MySubscriptionEntity, Long> {
    List<MySubscriptionEntity> findByUserId(String userId);
}
