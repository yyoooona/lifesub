package com.unicorn.lifesub.recommend.repository.jpa;

import com.unicorn.lifesub.recommend.repository.entity.RecommendedCategoryEntity;
import com.unicorn.lifesub.recommend.repository.entity.SpendingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RecommendRepository extends JpaRepository<RecommendedCategoryEntity, Long> {
    Optional<RecommendedCategoryEntity> findBySpendingCategory(String category);

    @Query("SELECT s FROM SpendingEntity s WHERE s.userId = :userId AND s.spendingDate >= :startDate")
    List<SpendingEntity> findSpendingsByUserIdAndDateAfter(@Param("userId") String userId, 
                                                          @Param("startDate") LocalDate startDate);
}
