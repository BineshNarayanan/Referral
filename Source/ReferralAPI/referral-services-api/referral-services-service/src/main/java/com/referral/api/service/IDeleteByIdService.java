package com.referral.api.service;

public interface IDeleteByIdService<ToBeDeleted,Id> {

    ToBeDeleted delete(Id id);
}
