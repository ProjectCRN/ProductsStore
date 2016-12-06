package com.netcracker.crm.services.impl;

import com.netcracker.crm.services.IPaginationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ксения on 03.12.2016.
 */
public class PaginationServiceImpl implements IPaginationService {

    public static final int NumPerPage = 2;
    private int pageNum;

    @Override
    public List<String> getPageNums(int num) {
        List<String> pageNums = new ArrayList<>();
        for(int i=0;i<num;++i)
            pageNums.add(Integer.toString(i+1));
        return pageNums;
    }

    @Override
    public int getPageNum() {
        return pageNum;
    }

    @Override
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public int calcPageNum(int itemNum) {
        if(itemNum % NumPerPage == 0)
            return itemNum/NumPerPage;
        return itemNum/NumPerPage + 1;
    }

    @Override
    public int getNumPerPage() {
        return NumPerPage;
    }
}
