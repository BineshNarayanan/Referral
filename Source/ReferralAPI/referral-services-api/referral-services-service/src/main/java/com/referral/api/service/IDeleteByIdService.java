package com.referral.api.service;

public interface IDeleteByIdService<ToBeDeleted> {

    ToBeDeleted delete(final ToBeDeleted toBeDeleted);
}
