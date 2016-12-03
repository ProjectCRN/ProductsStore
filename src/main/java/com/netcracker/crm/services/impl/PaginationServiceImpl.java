package com.netcracker.crm.services.impl;

import com.netcracker.crm.services.IPaginationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ксения on 03.12.2016.
 */
public class PaginationServiceImpl implements IPaginationService {
    @Override
    public List<String> getPageNums(int num) {
        List<String> pageNums = new ArrayList<>();
        for(int i=0;i<num;++i)
            pageNums.add(Integer.toString(i+1));
        return pageNums;
    }
}