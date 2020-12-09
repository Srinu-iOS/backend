package com.library.management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LendBooksDTO {
    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("bookId")
    private Long bookId;
}
