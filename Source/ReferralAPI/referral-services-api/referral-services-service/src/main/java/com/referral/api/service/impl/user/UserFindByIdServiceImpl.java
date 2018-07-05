package com.referral.api.service.impl.user;

import com.referral.api.dto.AppUserDTO;
import com.referral.api.model.AppUser;
import com.referral.api.persistence.user.IAppUserRepository;
import com.referral.api.service.IFindByIdService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserFindByIdServiceImpl implements IFindByIdService<AppUserDTO,String> {

    private IAppUserRepository repository;

    @Autowired
    public UserFindByIdServiceImpl(IAppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public AppUserDTO findById(String id) {
        Optional<AppUser> byId = repository.findById(id);
        if(byId.isPresent()){
            ModelMapper mapper = new ModelMapper();
            AppUserDTO appUser = mapper.map(byId.get(), AppUserDTO.class);
            return appUser;
        }
        return AppUserDTO.EMPTY_USER_DTO;
    }
}
