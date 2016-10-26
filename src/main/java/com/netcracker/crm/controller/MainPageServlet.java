package com.netcracker.crm.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 26.10.2016.
 */
public class MainPageServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, java.io.IOException {

    }
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, java.io.IOException {


        List<String> ls= new ArrayList<String>();
        ls.add("first prod");
        ls.add("second prod");
        request.setAttribute("prods", ls);
        request.getRequestDispatcher("mainJSP.jsp").forward(request, response);

    }
}
