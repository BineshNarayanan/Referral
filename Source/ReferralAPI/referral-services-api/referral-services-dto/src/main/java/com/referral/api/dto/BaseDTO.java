package com.referral.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public abstract class BaseDTO implements Serializable{
    protected String id;
    protected String createdBy;
    protected String updatedBy;
    protected Date createdDate;
    protected Date updatedDate;
    protected Boolean isDeleted;

    public BaseDTO(String id) {
        this.id = id;
    }
}
