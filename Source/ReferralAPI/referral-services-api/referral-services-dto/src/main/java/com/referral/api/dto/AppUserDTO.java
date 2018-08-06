package com.referral.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Blob profilePic;

    public AppUserDTO(String id) {
        super(id);
    }

    public AppUserDTO(AppUserDTO userDTO){
        setVariables(userDTO);
    }

    public AppUserDTO(AppUserDTO userDTO, String id){
        this.id = id;
        setVariables(userDTO);
    }

    private void setVariables(AppUserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.middleName = userDTO.getMiddleName();
        this.lastName = userDTO.getLastName();
        this.email = userDTO.getEmail();
        this.userName = userDTO.getUserName();
        this.password = userDTO.getPassword();
        this.createdBy = userDTO.getCreatedBy();
        this.updatedBy = userDTO.getUpdatedBy();
    }
}
