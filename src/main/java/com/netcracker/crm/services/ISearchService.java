package com.netcracker.crm.services;

import com.netcracker.crm.entity.serviceEntity.SearchAttributes;

public interface ISearchService {
    void parseSearchAttributes(SearchAttributes searchAttr);

    void validate(SearchAttributes searchAttr);
}
