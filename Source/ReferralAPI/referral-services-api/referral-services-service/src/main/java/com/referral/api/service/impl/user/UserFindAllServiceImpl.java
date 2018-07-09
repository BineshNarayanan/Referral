package com.referral.api.service.impl.user;

import com.referral.api.dto.AppUserDTO;
import com.referral.api.dto.page.PageCriteria;
import com.referral.api.dto.response.PagedResponse;
import com.referral.api.model.AppUser;
import com.referral.api.persistence.user.ISearchAppUserRepository;
import com.referral.api.service.IFindAllService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFindAllServiceImpl implements IFindAllService<AppUserDTO> {

    private ISearchAppUserRepository repository;

    @Autowired
    public UserFindAllServiceImpl(ISearchAppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public PagedResponse<AppUserDTO> findAll(PageCriteria pageCriteria) {
        Sort sort = Sort.by(pageCriteria.getSort(), pageCriteria.getSortBy());
        PageRequest pageRequest = PageRequest.of(pageCriteria.getNumber(), pageCriteria.getSize(), sort);
        Page<AppUser> page = repository.findAll(pageRequest);
        List<AppUser> appUsers = page.getContent();
        List<AppUserDTO> appUserDTOS = appUsers
            .parallelStream()
            .map(appUser -> toDTO(appUser)).collect(Collectors.toList());
        PagedResponse<AppUserDTO> pagedResponse = new PagedResponse<>(appUserDTOS, page.getTotalElements(), page.getTotalPages());
        return pagedResponse;
    }

    private AppUserDTO toDTO(AppUser appUser) {
        return new ModelMapper().map(appUser, AppUserDTO.class);
    }

}
