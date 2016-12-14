package com.netcracker.crm.services;

import javafx.util.Pair;

import java.util.List;


public interface IPaginationService {
    List<Pair<String, String>> getPageNums(int num, int now);

    int getPageNum();

    void setPageNum(int pageNum);

    int calcPageNum(int itemNum);

    int getNumPerPage();

    void setNumPerPage(int numPerPage);
}
