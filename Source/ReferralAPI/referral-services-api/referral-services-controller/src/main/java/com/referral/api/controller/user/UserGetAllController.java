package com.referral.api.controller.user;

import com.referral.api.dto.AppUserDTO;
import com.referral.api.response.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserGetAllController {

    @ApiOperation(value="Gets all Users",tags = "User Maintenance APIs")
    @GetMapping("/v1/users")
    public ResponseEntity<ApiResponse<List<AppUserDTO>>> findAll(){
        return new ResponseEntity<>(new ApiResponse<>(),HttpStatus.OK);
    }
}
