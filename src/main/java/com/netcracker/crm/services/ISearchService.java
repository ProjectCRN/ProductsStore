package com.netcracker.crm.services;

import com.netcracker.crm.entity.serviceEntity.SearchAttributes;

/**
 * Created by Ксения on 29.11.2016.
 */
public interface ISearchService {
    String getSearchRes();
    void parseSearchAttributes();
    void validate(SearchAttributes searchAttr);
    void setSearchAttributes();
    SearchAttributes getSearchAttributes();
}
