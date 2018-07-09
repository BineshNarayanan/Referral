package com.referral.api.persistence.user;

import com.referral.api.model.AppUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ISearchAppUserRepository extends PagingAndSortingRepository<AppUser,String> {
}
