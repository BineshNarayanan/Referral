package com.referral.api.persistence.user;

import com.referral.api.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepository extends CrudRepository<AppUser, String> {
}
