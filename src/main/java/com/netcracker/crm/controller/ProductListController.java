package com.netcracker.crm.controller;

import com.netcracker.crm.entity.controllerEntity.SearchAttributes;
import com.netcracker.crm.entity.controllerEntity.controllerService.CartService;
import com.netcracker.crm.entity.controllerEntity.controllerService.ProductService;
import com.netcracker.crm.entity.controllerEntity.controllerService.SearchService;
import com.netcracker.crm.services.IProductService;
import com.netcracker.crm.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.netcracker.crm.entity.serviceEntity.Product;

import java.util.List;

/**
 * Created by Ксения on 22.11.2016.
 */

@Controller
public class ProductListController {

    ApplicationContext context =
            new ClassPathXmlApplicationContext(new String[]{"SpringModule.xml"});
    private static final String PRODUCTS = "products";
    private static final String ITEM = "item";
    private static CartService cart;
    //private static ProductService productService;
    private static SearchService search;


    IProductService productService = (IProductService) context.getBean("productService");

    @Autowired
    public void start(){
        cart = new CartService();
       // productService = new ProductService();
        search = new SearchService();
    }
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String products(ModelMap model) {

        List<Product> productList = productService.getByUserAndType(-2,8);

        model.addAttribute("productList", productList);
        //model.addAttribute("productList", productService.getListProduct());
        model.addAttribute("types",search.getTypes());
        model.addAttribute("currType",search.getSearchAttributes().getType());
        model.addAttribute("searchAttr", search.getSearchAttributes());
        return PRODUCTS;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String searchProducts(SearchAttributes searchAttr, ModelMap model) {
        search.validate(searchAttr);
        model.addAttribute("productList", productService.getList(8,"","",""));
        //model.addAttribute("productList", productService.getListProduct());
        model.addAttribute("types",search.getTypes());
        model.addAttribute("currType",search.getSearchAttributes().getType());
        model.addAttribute("searchAttr", search.getSearchAttributes());
        model.addAttribute("SearchRes", search.getSearchRes());
        return PRODUCTS;
    }

    @RequestMapping(value = "/addProduct/{id}", method = RequestMethod.GET)
    public String addProduct(@PathVariable String id, ModelMap model) {
        cart.add(Integer.parseInt(id));
        return "redirect:/"+PRODUCTS;

    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public String item(@PathVariable String id, ModelMap model) {
        model.addAttribute("item",productService.getById(Integer.parseInt(id)));
        //model.addAttribute("item",productService.find(Integer.parseInt(id)));
        return ITEM;
    }

}
