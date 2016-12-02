package com.netcracker.crm.services;

import com.netcracker.crm.entity.serviceEntity.SearchAttributes;

/**
 * Created by Ксения on 29.11.2016.
 */
public interface ISearchService {
    void parseSearchAttributes(SearchAttributes searchAttr);
    void validate(SearchAttributes searchAttr);
}
