package com.netcracker.crm.entity.controllerEntity;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    public static final int CONST_ONE = 1;
    private List<CartItem> listCartItem;

    public Cart() {
        listCartItem = new ArrayList<>();
    }

    public Boolean add(int id) {

        for (int i = 0; i < listCartItem.size(); ++i) {
            if (listCartItem.get(i).getProduct().getId() == id) {
                listCartItem.get(i).setNumber(listCartItem.get(i).getNumber() + 1);
                return true;
            }
        }
        CartItem cartItem = new CartItem();
        cartItem.setProduct(new ProductList().find(id));
        cartItem.setNumber(CONST_ONE);
        listCartItem.add(cartItem);
        return false;
    }

    public Boolean delete(int id) {

        for (int i = 0; i < listCartItem.size(); ++i) {
            if (listCartItem.get(i).getProduct().getId() == id) {
                if (listCartItem.get(i).getNumber() != 1) {
                    listCartItem.get(i).setNumber(listCartItem.get(i).getNumber() - 1);
                    return true;
                } else {
                    listCartItem.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public int getTotal() {

        int res = 0;
        for (int i = 0; i < listCartItem.size(); ++i)
            res += listCartItem.get(i).getProduct().getPrice() * listCartItem.get(i).getNumber();
        return res;
    }

    public List<CartItem> getListCartItem() {
        return listCartItem;
    }

    public void setListCartItem(List<CartItem> listCartItem) {
        this.listCartItem = listCartItem;
    }

}
