package com.netcracker.crm.services;

import java.util.List;

/**
 * Created by Ксения on 03.12.2016.
 */
public interface IPaginationService {
    List<String> getPageNums(int num);
    int getPageNum();
    void setPageNum(int pageNum);
    int calcPageNum(int itemNum);
    int getNumPerPage();
    void setNumPerPage(int numPerPage);
}
