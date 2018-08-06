package com.referral.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    protected String id;

    @Column(name = "CREATED_BY")
    protected String createdBy;

    @Column(name = "UPDATED_BY")
    protected String updatedBy;

    @Column(name = "CREATED_DATE")
    protected Date createdDate;

    @Column(name = "UPDATED_DATE")
    protected Date updatedDate;

    @Column(name = "IS_DELETED")
    protected Boolean isDeleted;

    @PrePersist
    public void prePersist(){
        if(StringUtils.isEmpty(id)){
            id = UUID.randomUUID().toString();
        }
        createdDate = new Date();
    }
}
