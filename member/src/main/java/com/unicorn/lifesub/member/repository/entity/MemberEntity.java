package com.unicorn.lifesub.member.repository.entity;

import com.unicorn.lifesub.common.entity.BaseTimeEntity;
import com.unicorn.lifesub.member.domain.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor
public class MemberEntity extends BaseTimeEntity {
    @Id
    private String userId;
    
    private String userName;
    private String password;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "member_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();

    @Builder
    public MemberEntity(String userId, String userName, String password, Set<String> roles) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public Member toDomain() {
        return Member.builder()
                .userId(userId)
                .userName(userName)
                .password(password)
                .roles(roles)
                .build();
    }

    public static MemberEntity fromDomain(Member member) {
        return MemberEntity.builder()
                .userId(member.getUserId())
                .userName(member.getUserName())
                .password(member.getPassword())
                .roles(member.getRoles())
                .build();
    }
}
