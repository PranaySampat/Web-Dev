/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.CsvDao;
import com.me.pojo.SalesOrder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Pranay
 */
public class SalesOrderController extends AbstractController {

    CsvDao csvUploadDAO;

    public SalesOrderController(CsvDao csvUploadDAO) {
        this.csvUploadDAO = csvUploadDAO;
    }

    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String action = request.getParameter("action");
        ModelAndView model = new ModelAndView();
        if (action.equals("display")) {
            request.setAttribute("display", action);
            model.setViewName("salesOrderPage");

        } else if (action.equals("upload")) {
            String fileName = request.getParameter("FileName");
            request.setAttribute("FileName",fileName);
            request.setAttribute("upload", action);
            /*
            List<SalesOrder> salesOrderList = csvUploadDAO.getSalesOrderDetail();
            
            request.setAttribute("list", salesOrderList);
            model.addObject("list", salesOrderList);
                    */
            model.setViewName("salesOrderPage");
        } else if (action.equals("insertDatabase")) {
            // String fc = request.getParameter("FileName");
            List<SalesOrder> salesOrder = csvUploadDAO.getSalesOrderDetail();
            int result = csvUploadDAO.result(salesOrder);
            request.setAttribute("insertDatabase", action);
            model.addObject("result", result);
            model.setViewName("salesOrderPage");
        }

        return model;
    }

}
