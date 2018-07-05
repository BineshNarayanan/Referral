package com.referral.api.service.impl.user;

import com.referral.api.dto.AppUserDTO;
import com.referral.api.model.AppUser;
import com.referral.api.persistence.user.IAppUserRepository;
import com.referral.api.service.IDeleteByIdService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDeleteByIdService implements IDeleteByIdService<AppUserDTO, String> {

    private IAppUserRepository repository;

    @Autowired
    public UserDeleteByIdService(IAppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public AppUserDTO delete(String id) {
        Optional<AppUser> byId = repository.findById(id);
        if(byId.isPresent()){
            AppUser appUser = byId.get();
            appUser.setIsDeleted(Boolean.TRUE);
            AppUser save = repository.save(appUser);
            ModelMapper mapper = new ModelMapper();
            AppUserDTO appUserDTO = mapper.map(save, AppUserDTO.class);
            return appUserDTO;
        }
        return AppUserDTO.EMPTY_USER_DTO;
    }
}
