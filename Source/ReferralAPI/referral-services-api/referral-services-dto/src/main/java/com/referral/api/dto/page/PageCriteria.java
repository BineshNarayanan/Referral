package com.referral.api.dto.page;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class PageCriteria {
    private int number;
    private int size = 25;
    private Sort.Direction sort = Sort.Direction.DESC;
    private String sortBy = "createdDate";
}
