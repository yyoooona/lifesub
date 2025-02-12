package com.unicorn.lifesub.mysub.infra.repository;

import com.unicorn.lifesub.mysub.infra.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, String> {
}
