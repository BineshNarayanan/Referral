package com.referral.api.controller.user;

import com.referral.api.dto.AppUserDTO;
import com.referral.api.dto.response.ApiResponse;
import com.referral.api.service.IFindByIdService;
import com.referral.api.service.impl.user.UserFindByIdServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserGetByIdController {

    private IFindByIdService<AppUserDTO,String> service;

    @Autowired
    public UserGetByIdController(UserFindByIdServiceImpl service) {
        this.service = service;
    }

    @ApiOperation(value = "Gets User by Id",tags = {"User Management APIs"})
    @GetMapping("/v1/user/{userId}")
    public ResponseEntity<ApiResponse<AppUserDTO>> getUserById(@PathVariable String userId){
        AppUserDTO appUserDTO = service.findById(userId);
        return new ResponseEntity<>(new ApiResponse<>(appUserDTO), HttpStatus.OK);
    }
}
