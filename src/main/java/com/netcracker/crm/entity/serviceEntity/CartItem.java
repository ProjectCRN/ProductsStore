package com.netcracker.crm.entity.serviceEntity;

import com.netcracker.crm.entity.AbstractEntity;

/**
 * Created by Nastya on 11/22/2016.
 */
public class CartItem extends AbstractEntity {
    private Product product;
    private int Quantity;

    public CartItem(Product product) {
        this.product = product;
        Quantity = 1;
    }
    public CartItem(Product product, int quantity) {
        this.product = product;
        Quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public void incQuantity() {
        Quantity++;
    }
    public void decQuantity() {
        Quantity--;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        if (Quantity != cartItem.Quantity) return false;
        return product.equals(cartItem.product);

    }

    @Override
    public int hashCode() {
        int result = product.hashCode();
        result = 31 * result + Quantity;
        return result;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product.toString() +
                ", Quantity=" + Quantity +
                '}';
    }
}
