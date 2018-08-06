package com.referral.api.service;

public interface IFindByIdService<ToBeFound,Id> {

    ToBeFound findById(Id id);
}
