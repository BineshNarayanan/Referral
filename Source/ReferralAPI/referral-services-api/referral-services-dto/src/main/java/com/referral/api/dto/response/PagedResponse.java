package com.referral.api.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class PagedResponse<Data> extends ApiResponse<List<Data>> {

    private Long totalElements;
    private int totalPages;

    public PagedResponse(List<Data> data, Long totalElements, int totalPages){
        this.setPayload(data);
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }
}
