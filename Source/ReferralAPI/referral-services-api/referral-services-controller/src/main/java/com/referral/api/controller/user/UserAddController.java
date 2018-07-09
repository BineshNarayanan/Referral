package com.referral.api.controller.user;

import com.referral.api.dto.AppUserDTO;
import com.referral.api.dto.response.ApiResponse;
import com.referral.api.service.IAddService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAddController {

    private IAddService<AppUserDTO> service;

    @Autowired
    public UserAddController(IAddService<AppUserDTO> service) {
        this.service = service;
    }

    @ApiOperation(value="Adds a User",tags = "User Management APIs")
    @PostMapping("/v1/user")
    public ResponseEntity<ApiResponse<AppUserDTO>> addUser(@RequestBody final AppUserDTO appUser){
        AppUserDTO save = service.save(appUser);
        return new ResponseEntity<>(new ApiResponse<>(save), HttpStatus.CREATED);
    }
}
