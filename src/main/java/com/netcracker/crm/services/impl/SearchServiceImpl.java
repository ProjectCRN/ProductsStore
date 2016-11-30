package com.netcracker.crm.services.impl;

import com.netcracker.crm.entity.serviceEntity.SearchAttributes;
import com.netcracker.crm.services.ISearchService;
import org.springframework.stereotype.Service;

/**
 * Created by Ксения on 29.11.2016.
 */
@Service("searchService")
public class SearchServiceImpl implements ISearchService {

    private SearchAttributes searchAttributes;

    public SearchServiceImpl() {
        if (searchAttributes == null)
            searchAttributes = new SearchAttributes();
    }

    public SearchAttributes getSearchAttributes1() {
        return searchAttributes;
    }

    public void setSearchAttributes(SearchAttributes searchAttributes) {
        this.searchAttributes = searchAttributes;
    }

    @Override
    public String getSearchRes() {
        return searchAttributes.getTypeId() + " | " + searchAttributes.getAttribute() + " | " + searchAttributes.getOperators() + " | " + searchAttributes.getValues();
    }

    @Override
    public void parseSearchAttributes() {
        SearchAttributes searchAttr = this.getSearchAttributes();
        String list1 = "";
        String list2 = "";
        String list3 = "";
        int typeId = 8;

        switch (searchAttr.getType()) {
            case "Telephone":
                typeId = 8;
                break;
            case "Tablet":
                typeId = 9;
                break;
        }


        if (!searchAttr.getName().equals("")) {
            if (!list1.equals("")) {
                list1 += ",";
                list2 += ",";
                list3 += ",";
            }
            list1 += "entityName";
            list2 += "like";
            list3 += searchAttr.getName();
        }

        if (!searchAttr.getMinPrice().equals("")) {
            if (!list1.equals("")) {
                list1 += ",";
                list2 += ",";
                list3 += ",";
            }
            if (typeId == 8)
                list1 += "20";
            else list1 += "37";
            list2 += ">";
            list3 += searchAttr.getMinPrice() + ".0";
        }

        if (!searchAttr.getMaxPrice().equals("")) {
            if (!list1.equals("")) {
                list1 += ",";
                list2 += ",";
                list3 += ",";
            }
            if (typeId == 8)
                list1 += "20";
            else list1 += "37";
            list2 += "<";
            list3 += searchAttr.getMaxPrice() + ".0";
        }

        if (!searchAttr.getMinCapacity().equals("")) {
            if (!list1.equals("")) {
                list1 += ",";
                list2 += ",";
                list3 += ",";
            }
            if (typeId == 8)
                list1 += "24";
            else list1 += "41";
            list2 += ">";
            list3 += searchAttr.getMinCapacity();
        }

        if (!searchAttr.getMaxCapacity().equals("")) {
            if (!list1.equals("")) {
                list1 += ",";
                list2 += ",";
                list3 += ",";
            }
            if (typeId == 8)
                list1 += "24";
            else list1 += "41";
            list2 += "<";
            list3 += searchAttr.getMaxCapacity();
        }

        if (!searchAttr.getMinBattery().equals("")) {
            if (!list1.equals("")) {
                list1 += ",";
                list2 += ",";
                list3 += ",";
            }
            if (typeId == 8)
                list1 += "31";
            else list1 += "48";
            list2 += ">";
            list3 += searchAttr.getMinBattery();
        }

        if (!searchAttr.getMaxBattery().equals("")) {
            if (!list1.equals("")) {
                list1 += ",";
                list2 += ",";
                list3 += ",";
            }
            if (typeId == 8)
                list1 += "31";
            else list1 += "48";
            list2 += "<";
            list3 += searchAttr.getMaxBattery();
        }
        searchAttr.setTypeId(typeId);
        searchAttr.setAttribute(list1);
        searchAttr.setOperators(list2);
        searchAttr.setValues(list3);
    }

    @Override
    public void validate(SearchAttributes searchAttr) {
        String buf;
        if (!searchAttr.getMinPrice().matches("^[0-9]+$")) searchAttr.setMinPrice("");
        if (!searchAttr.getMaxPrice().matches("^[0-9]+$")) searchAttr.setMaxPrice("");
        if (!searchAttr.getMinCapacity().matches("^[0-9]+$")) searchAttr.setMinCapacity("");
        if (!searchAttr.getMaxCapacity().matches("^[0-9]+$")) searchAttr.setMaxCapacity("");
        if (!searchAttr.getMinBattery().matches("^[0-9]+$")) searchAttr.setMinBattery("");
        if (!searchAttr.getMaxBattery().matches("^[0-9]+$")) searchAttr.setMaxBattery("");
        if (!searchAttr.getName().matches("^[a-zA-Z0-9 ]+$")) searchAttr.setName("");

        if (!searchAttr.getMinPrice().equals("") && !searchAttr.getMaxPrice().equals(""))
            if (Integer.parseInt(searchAttr.getMinPrice()) > Integer.parseInt(searchAttr.getMaxPrice())) {
                buf = searchAttr.getMinPrice();
                searchAttr.setMinPrice(searchAttr.getMaxPrice());
                searchAttr.setMaxPrice(buf);
            }
        if (!searchAttr.getMinCapacity().equals("") && !searchAttr.getMaxCapacity().equals(""))
            if (Integer.parseInt(searchAttr.getMinCapacity()) > Integer.parseInt(searchAttr.getMaxCapacity())) {
                buf = searchAttr.getMinCapacity();
                searchAttr.setMinCapacity(searchAttr.getMaxCapacity());
                searchAttr.setMaxCapacity(buf);
            }

        if (!searchAttr.getMinBattery().equals("") && !searchAttr.getMaxBattery().equals(""))
            if (Integer.parseInt(searchAttr.getMinBattery()) > Integer.parseInt(searchAttr.getMaxBattery())) {
                buf = searchAttr.getMinBattery();
                searchAttr.setMinBattery(searchAttr.getMaxBattery());
                searchAttr.setMaxBattery(buf);
            }
        this.setSearchAttributes(searchAttr);


    }

    @Override
    public void setSearchAttributes() {

    }

    @Override
    public SearchAttributes getSearchAttributes() {
        return searchAttributes;
    }
}
