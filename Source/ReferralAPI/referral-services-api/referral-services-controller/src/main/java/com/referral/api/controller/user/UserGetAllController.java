package com.referral.api.controller.user;

import com.referral.api.dto.AppUserDTO;
import com.referral.api.dto.page.PageCriteria;
import com.referral.api.dto.response.ApiResponse;
import com.referral.api.dto.response.PagedResponse;
import com.referral.api.service.IFindAllService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserGetAllController {

    private IFindAllService<AppUserDTO> service;

    @Autowired
    public UserGetAllController(IFindAllService<AppUserDTO> service) {
        this.service = service;
    }

    @ApiOperation(value="Gets User List. Default size is 25",tags = "User Management APIs")
    @GetMapping("/v1/users")
    public ResponseEntity<ApiResponse<List<AppUserDTO>>> findAll(final PageCriteria pageCriteria){
        PagedResponse<AppUserDTO> appUsers = service.findAll(pageCriteria);
        return new ResponseEntity<>(appUsers,HttpStatus.OK);
    }
}
