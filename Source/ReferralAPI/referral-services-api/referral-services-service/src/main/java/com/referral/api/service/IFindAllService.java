package com.referral.api.service;

import com.referral.api.dto.page.PageCriteria;
import com.referral.api.dto.response.PagedResponse;

public interface IFindAllService<DataToBeSearched> {

    PagedResponse<DataToBeSearched> findAll(final PageCriteria pageCriteria);
}
