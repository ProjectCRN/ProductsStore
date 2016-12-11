package com.netcracker.crm.entity.controllerEntity;

/**
 * Created by Ксения on 11.12.2016.
 */
public class NameSearch {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void validate()
    {
        if(!name.matches("^[a-zA-Z][a-zA-Z0-9-_\\. ]{1,20}$")) name="";
    }
}
