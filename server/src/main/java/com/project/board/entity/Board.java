package com.project.board.entity;

import com.project.board.common.BaseEntity;
import com.project.board.type.Category;
import lombok.*;

import javax.persistence.*;

/**
 * @author Jaeyoung Bang
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;
}
