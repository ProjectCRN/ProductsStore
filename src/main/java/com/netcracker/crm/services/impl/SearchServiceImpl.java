package com.netcracker.crm.services.impl;

import com.netcracker.crm.entity.enums.EntityType;
import com.netcracker.crm.entity.enums.PhoneAtribute;
import com.netcracker.crm.entity.enums.TabletAtribute;
import com.netcracker.crm.entity.serviceEntity.SearchAttributes;
import com.netcracker.crm.services.ISearchService;
import org.springframework.stereotype.Service;


@Service
public class SearchServiceImpl implements ISearchService {

    public SearchServiceImpl() {
    }

    @Override
    public void parseSearchAttributes(SearchAttributes searchAttr) {
        String list1 = "";
        String list2 = "";
        String list3 = "";
        int typeId = 9;

        switch (searchAttr.getType()) {
            case "telephone":
                typeId = EntityType.Telephone.getTypeId();
                break;
            case "tablet":
                typeId = EntityType.Tablet.getTypeId();
                break;
        }


        /*if (!searchAttr.getName().equals("")) {
            if (!list1.equals("")) {
                list1 += ",";
                list2 += ",";
                list3 += ",";
            }
            list1 += "entityName";
            list2 += "like";
            list3 += searchAttr.getName();
        }*/

        if (!searchAttr.getMinPrice().equals("")) {
            if (!list1.equals("")) {
                list1 += ",";
                list2 += ",";
                list3 += ",";
            }
            if (typeId == EntityType.Telephone.getTypeId())
                list1 += PhoneAtribute.Price.getAtributeId();
            else list1 += TabletAtribute.Price.getAtributeId();
            list2 += ">=";
            list3 += searchAttr.getMinPrice();
        }

        if (!searchAttr.getMaxPrice().equals("")) {
            if (!list1.equals("")) {
                list1 += ",";
                list2 += ",";
                list3 += ",";
            }
            if (typeId == EntityType.Telephone.getTypeId())
                list1 += PhoneAtribute.Price.getAtributeId();
            else list1 += TabletAtribute.Price.getAtributeId();
            list2 += "<=";
            list3 += searchAttr.getMaxPrice();
        }

        if (!searchAttr.getMinCapacity().equals("")) {
            if (!list1.equals("")) {
                list1 += ",";
                list2 += ",";
                list3 += ",";
            }
            if (typeId == EntityType.Telephone.getTypeId())
                list1 += PhoneAtribute.Capacity.getAtributeId();
            else list1 += TabletAtribute.Capacity.getAtributeId();
            list2 += ">=";
            list3 += searchAttr.getMinCapacity();
        }

        if (!searchAttr.getMaxCapacity().equals("")) {
            if (!list1.equals("")) {
                list1 += ",";
                list2 += ",";
                list3 += ",";
            }
            if (typeId == EntityType.Telephone.getTypeId())
                list1 += PhoneAtribute.Capacity.getAtributeId();
            else list1 += TabletAtribute.Capacity.getAtributeId();
            list2 += "<=";
            list3 += searchAttr.getMaxCapacity();
        }

        if (!searchAttr.getMinBattery().equals("")) {
            if (!list1.equals("")) {
                list1 += ",";
                list2 += ",";
                list3 += ",";
            }
            if (typeId == EntityType.Telephone.getTypeId())
                list1 += PhoneAtribute.Battery.getAtributeId();
            else list1 += TabletAtribute.Battery.getAtributeId();
            list2 += ">=";
            list3 += searchAttr.getMinBattery();
        }

        if (!searchAttr.getMaxBattery().equals("")) {
            if (!list1.equals("")) {
                list1 += ",";
                list2 += ",";
                list3 += ",";
            }
            if (typeId == EntityType.Telephone.getTypeId())
                list1 += PhoneAtribute.Battery.getAtributeId();
            else list1 += TabletAtribute.Battery.getAtributeId();
            list2 += "<=";
            list3 += searchAttr.getMaxBattery();
        }
        if (searchAttr.getName().equals("A-Z"))
            searchAttr.setSortBy(true);
        else searchAttr.setSortBy(false);

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
        if ((!searchAttr.getNumPerPage().matches("^[0-9]+$")) ||
                Integer.parseInt(searchAttr.getNumPerPage()) == 0) searchAttr.setNumPerPage("2");
        // if (!searchAttr.getName().matches("^[a-zA-Z0-9 ]+$")) searchAttr.setName("");

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

    }

}
