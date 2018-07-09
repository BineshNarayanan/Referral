package com.referral.api.controller.user;

import com.referral.api.dto.AppUserDTO;
import com.referral.api.dto.response.ApiResponse;
import com.referral.api.service.IAddService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserEditController {

    private IAddService<AppUserDTO> service;

    @Autowired
    public UserEditController(IAddService<AppUserDTO> service) {
        this.service = service;
    }

    @ApiOperation(value="Edit a User",tags = "User Management APIs")
    @PutMapping("/v1/user/{userId}")
    public ResponseEntity<ApiResponse<AppUserDTO>> editUser(@RequestBody AppUserDTO appUser,
                                                           @PathVariable String userId){
        AppUserDTO appUserDTO = new AppUserDTO(appUser, userId);
        AppUserDTO save = service.save(appUserDTO);
        return new ResponseEntity<>(new ApiResponse<>(save), HttpStatus.OK);
    }
}