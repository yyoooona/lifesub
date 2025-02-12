package com.unicorn.lifesub.mysub.infra.entity;

import com.unicorn.lifesub.common.entity.BaseTimeEntity;
import com.unicorn.lifesub.mysub.biz.domain.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "categories")
@Getter
@NoArgsConstructor
public class CategoryEntity extends BaseTimeEntity {
    @Id
    private String categoryId;
    private String name;

    @Builder
    public CategoryEntity(String categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Category toDomain() {
        return Category.builder()
                .categoryId(categoryId)
                .name(name)
                .build();
    }
}
