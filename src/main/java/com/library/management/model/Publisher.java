package com.library.management.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisherId")
    private Long publisherId;

    private String publisherName;

    private String publisherAddress;

    private String publisherDate;
}
