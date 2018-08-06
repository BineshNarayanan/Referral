package com.referral.api.service.impl.user;

import com.referral.api.dto.AppUserDTO;
import com.referral.api.model.AppUser;
import com.referral.api.persistence.user.IAppUserRepository;
import com.referral.api.service.IAddService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddServiceImpl implements IAddService<AppUserDTO> {

    private IAppUserRepository repository;

    @Autowired
    public UserAddServiceImpl(IAppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public AppUserDTO save(AppUserDTO appUserDTO) {
        ModelMapper mapper = new ModelMapper();
        AppUser map = mapper.map(appUserDTO, AppUser.class);
        AppUser savedUser = repository.save(map);
        AppUserDTO savedDTO = mapper.map(savedUser, AppUserDTO.class);
        return savedDTO;
    }
}
