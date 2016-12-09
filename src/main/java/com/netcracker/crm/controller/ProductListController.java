package com.netcracker.crm.controller;


import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.enums.EntityType;
import com.netcracker.crm.entity.serviceEntity.Product;
import com.netcracker.crm.services.IPaginationService;
import com.netcracker.crm.services.IProductService;
import com.netcracker.crm.services.ISearchService;
import com.netcracker.crm.services.impl.PaginationServiceImpl;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.netcracker.crm.entity.serviceEntity.SearchAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Ксения on 22.11.2016.
 */

@Controller
public class ProductListController {

    private static final String PRODUCTS = "products";
    private static final String ITEM = "item";

    private IProductService productService;
    private ISearchService searchService;
    private IPaginationService paginationService;

    private SearchAttributes searchAttributes;
    private User user;

    @Required
    public void setUser(User user) {
        this.user = user;
    }

    @Required
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    @Required
    public void setSearchService(ISearchService searchService) {
        this.searchService = searchService;
    }

    @Required
    public void setPaginationService(IPaginationService paginationService) {
        this.paginationService = paginationService;
    }

    public SearchAttributes getSearchAttributes() {
        return searchAttributes;
    }

    public void setSearchAttributes(SearchAttributes searchAttributes) {
        this.searchAttributes = searchAttributes;
    }

    @RequestMapping(value = "/products/{type}", method = RequestMethod.GET)
    public String products(@PathVariable String type, ModelMap model) {

        int typeid = findTypeId(type);
        List<Product> productList = productService.getList(typeid, "", "", "",
                1, paginationService.getNumPerPage());
        if (productList == null)
            productList = new ArrayList<>();
        model.addAttribute("productList", productList);
        model.addAttribute("currType", type);
        model.addAttribute("searchAttr", new SearchAttributes());
        int pageNumber = paginationService.calcPageNum(productService.rowCounter(typeid, "", "", ""));
        paginationService.setPageNum(pageNumber);
        model.addAttribute("pages", paginationService.getPageNums(pageNumber));
        model.addAttribute("searchReq", "products/search");
        model.addAttribute("searchBtn", "search");
        model.addAttribute("role", user.getRoleId());
        return PRODUCTS;
    }

    private int findTypeId(String type){
        int typeid = 9;
        switch (type) {
            case "telephone":
                typeid = EntityType.Telephone.getTypeId();
                break;
            case "tablet":
                typeid = EntityType.Tablet.getTypeId();
                break;
        }
        return typeid;
    }

    @RequestMapping(value = "/products/{type}/page/{pageNum}", method = RequestMethod.GET)
    public String productsPages(@PathVariable String type, @PathVariable String pageNum, ModelMap model) {

        int typeid = findTypeId(type);

        List<Product> productList = productService.getList(typeid, "", "", "",
                Integer.parseInt(pageNum), paginationService.getNumPerPage());
        if (productList == null)
            productList = new ArrayList<>();
        model.addAttribute("productList", productList);
        model.addAttribute("currType", type);
        model.addAttribute("searchAttr", new SearchAttributes());
        int pageNumber = paginationService.getPageNum();
        model.addAttribute("pages", paginationService.getPageNums(pageNumber));
        model.addAttribute("searchReq", "products");
        model.addAttribute("searchBtn", "search");
        model.addAttribute("role", user.getRoleId());
        return PRODUCTS;
    }

    @RequestMapping(value = "/products/search", method = RequestMethod.GET)
    public String searchProducts(SearchAttributes searchAttr, ModelMap model) {

        searchService.validate(searchAttr);
        searchService.parseSearchAttributes(searchAttr);
        List<Product> productList = productService.getList(
                searchAttr.getTypeId(),
                searchAttr.getAttribute(),
                searchAttr.getValues(),
                searchAttr.getOperators(),
                searchAttr.getAttribute(),
                1,
                paginationService.getNumPerPage());
        if (productList == null)
            productList = new ArrayList<>();
        if (productList.isEmpty())
            model.addAttribute("emptyList", "sorry, nothing to show");
        model.addAttribute("productList", productList);
        model.addAttribute("currType", searchAttr.getType());
        model.addAttribute("searchAttr", searchAttr);
        this.setSearchAttributes(searchAttr);
        int pageNumber = paginationService.calcPageNum(productService.rowCounter(
                searchAttr.getTypeId(),
                searchAttr.getAttribute(),
                searchAttr.getValues(),
                searchAttr.getOperators()));
        paginationService.setPageNum(pageNumber);
        model.addAttribute("pages", paginationService.getPageNums(pageNumber));
        model.addAttribute("searchReq", "products/search");
        model.addAttribute("searchBtn", "search");
        model.addAttribute("role", user.getRoleId());
        return PRODUCTS;
    }

    @RequestMapping(value = "/products/search/{type}/page/{pageNum}", method = RequestMethod.GET)
    public String searchProductsPages(SearchAttributes searchAttr, @PathVariable String type, @PathVariable String pageNum, ModelMap model) {

        searchService.validate(searchAttr);
        searchService.parseSearchAttributes(searchAttr);
        SearchAttributes searchAttr2 = this.getSearchAttributes();
        int pagenum = Integer.parseInt(pageNum);
        int pageNumber = paginationService.getPageNum();
        if (!searchAttr.equals(searchAttr2)&&(searchAttr2 != null)) {
            pagenum = 1;
            pageNumber = paginationService.calcPageNum(productService.rowCounter(
                    searchAttr.getTypeId(),
                    searchAttr.getAttribute(),
                    searchAttr.getValues(),
                    searchAttr.getOperators()));
            paginationService.setPageNum(pageNumber);
        }
        List<Product> productList = productService.getList(
                searchAttr.getTypeId(),
                searchAttr.getAttribute(),
                searchAttr.getValues(),
                searchAttr.getOperators(),
                pagenum,
                paginationService.getNumPerPage());
        if (productList == null)
            productList = new ArrayList<>();
        if (productList.isEmpty())
            model.addAttribute("emptyList", "sorry, nothing to show");
        model.addAttribute("productList", productList);
        model.addAttribute("currType", searchAttr.getType());
        model.addAttribute("searchAttr", searchAttr);
        this.setSearchAttributes(searchAttr);

        model.addAttribute("pages", paginationService.getPageNums(pageNumber));
        model.addAttribute("searchReq", "products/search");
        model.addAttribute("searchBtn", "search");
        model.addAttribute("role", user.getRoleId());
        return PRODUCTS;
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public String item(@PathVariable String id, ModelMap model) {
        model.addAttribute("item", productService.getById(Integer.parseInt(id)));
        return ITEM;
    }



}
