package com.referral.api.controller.user;

import com.referral.api.dto.AppUserDTO;
import com.referral.api.response.ApiResponse;
import com.referral.api.service.IDeleteByIdService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDeleteController {

    IDeleteByIdService<AppUserDTO,String> service;

    @Autowired
    public UserDeleteController(IDeleteByIdService<AppUserDTO,String> service) {
        this.service = service;
    }

    @ApiOperation(value="Deletes a User",tags = "User Maintenance APIs")
    @DeleteMapping("v1/user/{userId}")
    public ResponseEntity<ApiResponse<AppUserDTO>> deleteById(@PathVariable String userId){
        AppUserDTO delete = service.delete(userId);
        return new ResponseEntity<>(new ApiResponse<>(delete), HttpStatus.OK);
    }
}
