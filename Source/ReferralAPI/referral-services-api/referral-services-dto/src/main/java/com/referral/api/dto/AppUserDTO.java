package com.referral.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppUserDTO extends BaseDTO{

    public static final AppUserDTO EMPTY_USER_DTO = new AppUserDTO();

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private Blob profilePic;

    public AppUserDTO(String id) {
        super(id);
    }
}
