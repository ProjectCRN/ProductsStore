package com.netcracker.crm.controller;

import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.controllerEntity.form.AddProductForm;
import com.netcracker.crm.entity.controllerEntity.validator.AddProductValidator;
import com.netcracker.crm.entity.enums.EntityType;
import com.netcracker.crm.entity.serviceEntity.Product;
import com.netcracker.crm.services.IProductService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by egor on 24.10.2016.
 */
@Controller
public class AdminController{
    private static final String ADDING = "newProduct";
    private static final String NO_ROOTS = "noRoots";
    private static final String SUCCESS = "register-success";
    private User user;
    private AddProductValidator addProductValidator;
    private IProductService productService;

    @Required
    public void setAddProductValidator(AddProductValidator addProductValidator) {
        this.addProductValidator = addProductValidator;
    }

    @Required
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    @Required
    public void setUser(User user) {
        this.user = user;
    }

    @RequestMapping(value="/newProduct/{type}", method = RequestMethod.GET)
    public String newProd(@PathVariable String type, ModelMap model) {
        if(!user.isAdmin())
            return NO_ROOTS;
        model.put("prod", new AddProductForm());
        model.put("currType",type);
        return ADDING;
    }

    @RequestMapping(value="/newProduct/{type}", method = RequestMethod.POST)
    public String addNewProd(AddProductForm addProductForm, BindingResult result, @PathVariable String type, ModelMap model) {

        addProductValidator.validate(addProductForm, result);
        if (result.hasErrors()) {
            return ADDING;
        }
        if(!user.isAdmin())
            return NO_ROOTS;
        int typeid=9;
        Product prod = new Product();
        switch (type){
            case "telephone":
                typeid= EntityType.Telephone.getTypeId();
                break;
            case "tablet":
                typeid=EntityType.Tablet.getTypeId();
                break;
        }

        prod.setEntityName(addProductForm.getName());
        prod.setUserId(-2);
        prod.setPrice((double)Integer.parseInt(addProductForm.getPrice()));
        prod.setEntityTypeId(typeid);
        prod.setSummary(addProductForm.getSummary());
        prod.setFabricator(addProductForm.getFabricator());
        prod.setImageUrl(addProductForm.getImageUrl());
        prod.setValueList(addProductForm.getListValue(typeid));
        model.addAttribute("hello", "Product created");
        return SUCCESS;
    }

}
