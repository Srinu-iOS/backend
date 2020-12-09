package com.library.management.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private Long bookId;

    private String bookName;

    private String bookImage;

    private String bookDescription;

    private String bookCategory;

    private Long lendUserId;

    private Long userId;

    private boolean lendStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorId")
    Author author;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisherId")
    Publisher publisher;
}
