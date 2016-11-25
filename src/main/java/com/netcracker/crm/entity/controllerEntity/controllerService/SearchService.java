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

    public SearchService() {
        if(searchAttributes == null)
            searchAttributes = new SearchAttributes();
        if(types == null)
        {
            types = new ArrayList<String>();
            types.add("");
            types.add("Telephone");
            types.add("Tablet");
        }
    }

    public static SearchAttributes getSearchAttributes() {
        return searchAttributes;
    }

    public static void setSearchAttributes(SearchAttributes searchAttributes) {
        SearchService.searchAttributes = searchAttributes;
    }

    public void validate(SearchAttributes searchAttr){



        if (!searchAttr.getMinPrice().matches("^[0-9]+$")) searchAttr.setMinPrice("");
        if (!searchAttr.getMaxPrice().matches("^[0-9]+$")) searchAttr.setMaxPrice("");
        if (!searchAttr.getMinSize().matches("^[0-9]+$")) searchAttr.setMinSize("");
        if (!searchAttr.getMaxSize().matches("^[0-9]+$")) searchAttr.setMaxSize("");
        if (!searchAttr.getMinRam().matches("^[0-9]+$")) searchAttr.setMinRam("");
        if (!searchAttr.getMaxRam().matches("^[0-9]+$")) searchAttr.setMaxRam("");
        if (!searchAttr.getName().matches("^[a-zA-Z0-9 ]+$")) searchAttr.setName("");
        this.setSearchAttributes(searchAttr);

    }

    public static List<String> getTypes() {
        return types;
    }

    public static void setTypes(List<String> types) {
        SearchService.types = types;
    }

    public String getSearchRes()
    {
        SearchAttributes searchAttr = this.getSearchAttributes();
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        List<String> list3 = new ArrayList<String>();

        if(!searchAttr.getType().equals(""))
        {
            list1.add("Type");
            list2.add("like");
            list3.add(searchAttr.getType());
        }

        if(!searchAttr.getName().equals(""))
        {
            list1.add("Name");
            list2.add("like");
            list3.add(searchAttr.getName());
        }

        if(!searchAttr.getMinPrice().equals(""))
        {
            list1.add("Price");
            list2.add(">");
            list3.add(searchAttr.getMinPrice());
        }

        if(!searchAttr.getMaxPrice().equals(""))
        {
            list1.add("Price");
            list2.add("<");
            list3.add(searchAttr.getMaxPrice());
        }

        if(!searchAttr.getMinSize().equals(""))
        {
            list1.add("Size");
            list2.add(">");
            list3.add(searchAttr.getMinSize());
        }

        if(!searchAttr.getMaxSize().equals(""))
        {
            list1.add("Size");
            list2.add("<");
            list3.add(searchAttr.getMaxSize());
        }

        if(!searchAttr.getMinRam().equals(""))
        {
            list1.add("Ram");
            list2.add(">");
            list3.add(searchAttr.getMinRam());
        }

        if(!searchAttr.getMaxRam().equals(""))
        {
            list1.add("Ram");
            list2.add("<");
            list3.add(searchAttr.getMaxRam());
        }

        return list1.toString() +'\n'+ list2.toString() +'\n'+ list3.toString();
    }

    public String getSearchAttr()
    {
        if(this.getSearchAttributes() == null)
            return "empty(";
        return this.getSearchAttributes().toString();
    }
}
