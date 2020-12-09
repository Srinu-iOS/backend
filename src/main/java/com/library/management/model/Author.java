package com.library.management.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorId")
    private Long authorId;

    private String authorName;

    private String authorAddress;

    private String authorDetails;

}
