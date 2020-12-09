package com.library.management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

    private String name;

    private String mobileNumber;

    private String emailId;

    @JsonIgnore
    private String password;

    private Integer userType;

    private Boolean status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDt")
    Date createdDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedDt")
    Date updatedDt;
}
