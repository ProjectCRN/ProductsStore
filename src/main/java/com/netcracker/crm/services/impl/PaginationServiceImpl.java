package com.netcracker.crm.services.impl;

import com.netcracker.crm.services.IPaginationService;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;


public class PaginationServiceImpl implements IPaginationService {

    private int NumPerPage = 2;
    private int pageNum;

    @Override
    public List<Pair<String, String>> getPageNums(int num, int now) {
        List<Pair<String, String>> pageNums = new ArrayList<>();
        for (int i = 0; i < num; ++i)
            if (i == now - 1)
                pageNums.add(new Pair<>(Integer.toString(i + 1), "activePage"));
            else pageNums.add(new Pair<>(Integer.toString(i + 1), "nonActivePage"));
        return pageNums;
    }


    @Override
    public void setNumPerPage(int numPerPage) {
        NumPerPage = numPerPage;
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
        if (itemNum % NumPerPage == 0)
            return itemNum / NumPerPage;
        return itemNum / NumPerPage + 1;
    }

    @Override
    public int getNumPerPage() {
        return NumPerPage;
    }
}
