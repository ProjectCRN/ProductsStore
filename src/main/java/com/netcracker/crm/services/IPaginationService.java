package com.netcracker.crm.services;

import javafx.util.Pair;

import java.util.List;

/**
 * Created by Ксения on 03.12.2016.
 */
public interface IPaginationService {
    List<Pair> getPageNums(int num, int now);
    int getPageNum();
    void setPageNum(int pageNum);
    int calcPageNum(int itemNum);
    int getNumPerPage();
    void setNumPerPage(int numPerPage);
}
