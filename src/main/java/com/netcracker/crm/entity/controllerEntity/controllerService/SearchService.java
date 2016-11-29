package com.netcracker.crm.entity.controllerEntity.controllerService;

import com.netcracker.crm.entity.controllerEntity.SearchAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ксения on 25.11.2016.
 */
public class SearchService {
    private static SearchAttributes searchAttributes;
    private static List<String> types;
    private static int typeId;
    private static String list1;
    private static String list2;
    private static String list3;


    public SearchService() {
        if(searchAttributes == null)
            searchAttributes = new SearchAttributes();
        if(types == null)
        {
            types = new ArrayList<String>();
            types.add("Telephone");
            types.add("Tablet");
            types.add("Smart Watch");
            typeId = 8;
            list1 = "";
            list2 = "";
            list3 = "";
        }
    }

    public static int getTypeId() {
        return typeId;
    }

    public static void setTypeId(int typeId) {
        SearchService.typeId = typeId;
    }

    public static String getList1() {
        return list1;
    }

    public static void setList1(String list1) {
        SearchService.list1 = list1;
    }

    public static String getList2() {
        return list2;
    }

    public static void setList2(String list2) {
        SearchService.list2 = list2;
    }

    public static String getList3() {
        return list3;
    }

    public static void setList3(String list3) {
        SearchService.list3 = list3;
    }

    public static SearchAttributes getSearchAttributes() {
        return searchAttributes;
    }

    public static void setSearchAttributes(SearchAttributes searchAttributes) {
        SearchService.searchAttributes = searchAttributes;
    }

    public void validate(SearchAttributes searchAttr){
        String buf;
        if (!searchAttr.getMinPrice().matches("^[0-9]+$")) searchAttr.setMinPrice("");
        if (!searchAttr.getMaxPrice().matches("^[0-9]+$")) searchAttr.setMaxPrice("");
        if (!searchAttr.getMinSize().matches("^[0-9]+$")) searchAttr.setMinSize("");
        if (!searchAttr.getMaxSize().matches("^[0-9]+$")) searchAttr.setMaxSize("");
        if (!searchAttr.getMinRam().matches("^[0-9]+$")) searchAttr.setMinRam("");
        if (!searchAttr.getMaxRam().matches("^[0-9]+$")) searchAttr.setMaxRam("");
        if (!searchAttr.getName().matches("^[a-zA-Z0-9 ]+$")) searchAttr.setName("");

        if(!searchAttr.getMinPrice().equals("") && !searchAttr.getMaxPrice().equals(""))
            if(Integer.parseInt(searchAttr.getMinPrice())>Integer.parseInt(searchAttr.getMaxPrice()))
            {
                buf = searchAttr.getMinPrice();
                searchAttr.setMinPrice(searchAttr.getMaxPrice());
                searchAttr.setMaxPrice(buf);
            }
        if(!searchAttr.getMinSize().equals("") && !searchAttr.getMaxSize().equals(""))
            if(Integer.parseInt(searchAttr.getMinSize())>Integer.parseInt(searchAttr.getMaxSize()))
            {
                buf = searchAttr.getMinSize();
                searchAttr.setMinSize(searchAttr.getMaxSize());
                searchAttr.setMaxSize(buf);
            }

        if(!searchAttr.getMinRam().equals("") && !searchAttr.getMaxRam().equals(""))
            if(Integer.parseInt(searchAttr.getMinRam())>Integer.parseInt(searchAttr.getMaxRam()))
            {
                buf = searchAttr.getMinRam();
                searchAttr.setMinRam(searchAttr.getMaxRam());
                searchAttr.setMaxRam(buf);
            }
        this.setSearchAttributes(searchAttr);

    }

    public static List<String> getTypes() {
        return types;
    }

    public static void setTypes(List<String> types) {
        SearchService.types = types;
    }

    public void parseSearchAttributes()
    {
        SearchAttributes searchAttr = this.getSearchAttributes();
        list1 = "";
        list2 = "";
        list3 = "";
        typeId = 8;

        switch (searchAttr.getType())
        {
            case "Telephone": typeId = 8; break;
            case "Tablet": typeId = 9; break;
            case "Smart Watch": typeId = 10; break;
        }


        if(!searchAttr.getName().equals(""))
        {
            if(!list1.equals("")) {
                list1 += ", ";
                list2 += ", ";
                list3 += ", ";
            }
            list1 += "entityName";
            list2 += "like";
            list3 += searchAttr.getName();
        }

        if(!searchAttr.getMinPrice().equals(""))
        {
            if(!list1.equals("")) {
                list1 += ", ";
                list2 += ", ";
                list3 += ", ";
            }
            list1 += "price";
            list2 += ">";
            list3 += searchAttr.getMinPrice();
        }

        if(!searchAttr.getMaxPrice().equals(""))
        {
            if(!list1.equals("")) {
                list1 += ", ";
                list2 += ", ";
                list3 += ", ";
            }
            list1 += "price";
            list2 += "<";
            list3 += searchAttr.getMaxPrice();
        }

        if(!searchAttr.getMinSize().equals(""))
        {
            if(!list1.equals("")) {
                list1 += ", ";
                list2 += ", ";
                list3 += ", ";
            }
            list1 += "displayInch";
            list2 += ">";
            list3 += searchAttr.getMinSize();
        }

        if(!searchAttr.getMaxSize().equals(""))
        {
            if(!list1.equals("")) {
                list1 += ", ";
                list2 += ", ";
                list3 += ", ";
            }
            list1 += "displayInch";
            list2 += "<";
            list3 += searchAttr.getMaxSize();
        }

        if(!searchAttr.getMinRam().equals(""))
        {
            if(!list1.equals("")) {
                list1 += ", ";
                list2 += ", ";
                list3 += ", ";
            }
            list1 += "capaciyGB";
            list2 += ">";
            list3 += searchAttr.getMinRam();
        }

        if(!searchAttr.getMaxRam().equals(""))
        {
            if(!list1.equals("")) {
                list1 += ", ";
                list2 += ", ";
                list3 += ", ";
            }
            list1 += "capaciyGB";
            list2 += "<";
            list3 += searchAttr.getMaxRam();
        }
    }
    public String getSearchRes()
    {
        return typeId+" | "+list1+" | "+list2+" | "+list3;
    }

    public String getSearchAttr()
    {
        if(this.getSearchAttributes() == null)
            return "empty(";
        return this.getSearchAttributes().toString();
    }
}
