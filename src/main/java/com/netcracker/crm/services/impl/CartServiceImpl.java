package com.netcracker.crm.services.impl;


import com.netcracker.crm.dao.impl.EntityDaoImpl;
import com.netcracker.crm.entity.serviceEntity.Cart;
import com.netcracker.crm.entity.serviceEntity.CartItem;
import com.netcracker.crm.entity.serviceEntity.Product;
import com.netcracker.crm.services.AbstractService;
import com.netcracker.crm.services.ICartService;
import com.netcracker.crm.services.IProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nastya on 11/22/2016.
 */
@Service
public class CartServiceImpl extends AbstractService<Cart> implements ICartService {

    private Cart cart;

    @Override
    public int add(Cart abstractEntity) {
        this.cart=abstractEntity;
        return 0;
    }


    @Override
    public Cart getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {
        cart.deleteCartItem(findById(id));
    }

    @Override
    public void addProduct(int productId) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"SpringModule.xml"});
        IProductService productService = (ProductServiceImpl) context.getBean("productService");
        Product product = productService.getById(productId);
        CartItem cartItem=new CartItem(product,1);
        cart.addCartItem(cartItem);
    }

    @Override
    public Cart getCart() {
        return cart;
    }

    @Override
    public void changeQuantity(int productId, int quantity) {
        CartItem cartItem=findById(productId);
        int indexOfCartItem=cart.getCartItems().indexOf(cartItem);
        cartItem.setQuantity(quantity);
        cart.updateCartItem(indexOfCartItem,cartItem);
    }


    public CartItem findById(int id){
        CartItem cartItem = null;
        for(CartItem item : cart.getCartItems()){
            if ((item.getProduct().getId())==id) {
                cartItem = new CartItem(item.getProduct(), item.getQuantity());
                break;
            }
        }
        return cartItem;
    }


    public void setEntityDao(EntityDaoImpl entityDao) {
    }
}
