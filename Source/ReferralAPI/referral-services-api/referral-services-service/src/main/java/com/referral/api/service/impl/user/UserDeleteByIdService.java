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
public class UserDeleteByIdService implements IDeleteByIdService<AppUserDTO> {

    private IAppUserRepository repository;

    @Autowired
    public UserDeleteByIdService(IAppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public AppUserDTO delete(final AppUserDTO toBeDeleted) {
        Optional<AppUser> byId = repository.findById(toBeDeleted.getId());
        if(byId.isPresent()){
            AppUser appUser = byId.get();
            appUser.setIsDeleted(Boolean.TRUE);
            appUser.setUpdatedBy(toBeDeleted.getUpdatedBy());
            AppUser save = repository.save(appUser);
            ModelMapper mapper = new ModelMapper();
            AppUserDTO appUserDTO = mapper.map(save, AppUserDTO.class);
            return appUserDTO;
        }
        return AppUserDTO.EMPTY_USER_DTO;
    }
}
