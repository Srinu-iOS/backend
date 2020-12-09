package com.library.management.dto.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaginationResponseDTO {
    @JsonProperty("total_records")
    private long totalRecords;

    @JsonProperty("page")
    private Integer page;

    @JsonProperty("size")
    private Integer size;

    @JsonProperty("data")
    private Object data;


    public static PaginationResponseDTO setPagination(long totalRecords, Integer currentPage,
                                                      Integer size, Object data) {
        PaginationResponseDTO dto = new PaginationResponseDTO();
        dto.totalRecords = totalRecords;
        dto.page = currentPage;
        dto.size = size;
        dto.setData(data);
        return dto;
    }
}
