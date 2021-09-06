package com.math.DHJmath.domain.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cateId;

    @Column(columnDefinition = "varchar2(300)", nullable = false)
    private String cateName;

    @Builder
    public Category(String cateName) {
        this.cateName = cateName;
    }
}
