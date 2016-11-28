package com.netcracker.crm.services.parser;

import com.google.common.collect.BiMap;
import com.netcracker.crm.services.parser.exception.NoSuchIdXMLException;
import com.netcracker.crm.services.parser.exception.NoSuchTagXMLException;

/**
 * Created by egor on 27.11.2016.
 */
public abstract class AbstractTag {
    protected BiMap<String, Integer> tags;

    public int getIdByName(String name) throws NoSuchTagXMLException {
        int id;
        try {
            id = tags.get(name);
        } catch (RuntimeException e){
            throw new NoSuchTagXMLException(e.getMessage());
        }
        return id;
    }
    public String getNameById(int id) throws NoSuchIdXMLException {
        String name;
        try{
            name = tags.inverse().get(id);
        } catch (RuntimeException e){
            throw new NoSuchIdXMLException(e.getMessage());
        }
        return name;
    }
    public boolean isCorrectId(int id){
        return tags.containsValue(id);
    }

}
