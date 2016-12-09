package com.netcracker.crm.entity.controllerEntity;

/**
 * Created by Ксения on 09.12.2016.
 */
public class CartQuantity {
    String quantity;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void validate()
    {
        if(!quantity.matches("^[ 0-9]+$")) quantity="";
        else if(Integer.parseInt(quantity)==0) quantity="";
    }
}
