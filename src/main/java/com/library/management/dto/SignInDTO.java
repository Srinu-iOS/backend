package com.library.management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SignInDTO {
    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;
}
