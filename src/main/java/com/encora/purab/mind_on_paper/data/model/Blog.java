package com.encora.purab.mind_on_paper.data.model;

import com.encora.purab.mind_on_paper.data.BaseAuditingEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blogs")
public class Blog extends BaseAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long blogId;
    String blogTitle;
    String blogDescription;

}
