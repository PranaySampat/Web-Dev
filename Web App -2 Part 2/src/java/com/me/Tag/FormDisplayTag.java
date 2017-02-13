/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.Tag;

import com.me.DAO.CsvDao;
import com.me.pojo.SalesOrder;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import org.relique.jdbc.csv.CsvConnection;

/**
 *
 * @author Pranay
 */
public class FormDisplayTag extends SimpleTagSupport {

    String fileName;
    private CsvDao csvUploadDAO = new CsvDao();

    /**public FormDisplayTag(CsvDao csvUploadDAO) {
        this.csvUploadDAO = csvUploadDAO;
    }*/

    public void setfileName(String name) {
        this.fileName = name;
    }

    @Override
    public void doTag() throws JspException, IOException {
        try {
            List<SalesOrder> salesOrderList = csvUploadDAO.getSalesOrderDetail();
            JspWriter out = getJspContext().getOut();
            out.println(" <form action=\"insert.htm\" method=\"post\">\n"
                    + "                <table border=\"1\">\n"
                    + "                    <tr>\n"
                    + "                        <th>SalesOrderID</th>\n"
                    + "                        <th>RevisionNumber</th>\n"
                    + "                        <th>OrderDate</th>\n"
                    + "                        <th>DueDate</th>\n"
                    + "                        <th>ShipDate</th>\n"
                    + "                        <th>Status</th>\n"
                    + "                        <th>OnlineOrderFlag</th>\n"
                    + "                        <th>SalesOrderNumber</th>\n"
                    + "                        <th>PurchaseOrderNumber</th>\n"
                    + "                        <th>AccountNumber</th>\n"
                    + "                        <th>CustomerID</th>\n"
                    + "                        <th>SalesPersonID</th>\n"
                    + "                        <th>TerritoryID</th>\n"
                    + "                        <th>BillAddressID</th>\n"
                    + "                        <th>ShipToAddressID</th>\n"
                    + "                        <th>ShipMethodID</th>\n"
                    + "                        <th>CreditCardID</th>\n"
                    + "                        <th>CreditCardApprovalCode</th>\n"
                    + "                        <th>CurrencyRateID</th>\n"
                    + "                        <th>SubTotal</th>\n"
                    + "                        <th>TaxAmt</th>\n"
                    + "                        <th>Freight</th>\n"
                    + "                        <th>TotalDue</th>\n"
                    + "                        <th>Comment</th>\n"
                    + "                        <th>ModifiedDate</th>\n");
            for (SalesOrder sales : salesOrderList) {
                out.println(
                        "                        <tr>\n"
                        + "                            <td>" + sales.getSalesOrderID() + "</td>\n"
                        + "                            <td>" + sales.getRevisionNumber() + "</td>\n"
                        + "                            <td>" + sales.getOrderDate() + "</td>\n"
                        + "                            <td>" + sales.getDueDate() + "</td>\n"
                        + "                            <td>" + sales.getShippedDate() + "</td>\n"
                        + "                            <td>" + sales.getStatus() + "</td>\n"
                        + "                            <td>" + sales.getOnlineOrderFlag() + "</td>\n"
                        + "                            <td>" + sales.getSalesOrderNumber() + "</td>\n"
                        + "                            <td>" + sales.getPurchaseOrder() + "</td>\n"
                        + "                            <td>" + sales.getAccountNumber() + "</td>\n"
                        + "                            <td>" + sales.getCustomerID() + "</td>\n"
                        + "                            <td>" + sales.getSalesPersonID() + "</td>\n"
                        + "                            <td>" + sales.getTerritoryID() + "</td>\n"
                        + "                            <td>" + sales.getBillAddressID() + "</td>\n"
                        + "                            <td>" + sales.getShipAddressID() + "</td>\n"
                        + "                            <td>" + sales.getShipMethodID() + "</td>\n"
                        + "                            <td>" + sales.getCreditCardID() + "</td>\n"
                        + "                            <td>" + sales.getCreditCardApprovalCode() + "</td>\n"
                        + "                            <td>" + sales.getCurrencyRateID() + "</td>\n"
                        + "                            <td>" + sales.getSubTotal() + "</td>\n"
                        + "                            <td>" + sales.getTaxAmount() + "</td>\n"
                        + "                            <td>" + sales.getFrieghtCharges() + "</td>\n"
                        + "                            <td>" + sales.getTotalDue() + "</td>\n"
                        + "                            <td>" + sales.getComment() + "</td>\n"
                        + "                            <td>" + sales.getModifiedDate() + "</td>\n"
                        + "                           \n"
                        + "                            \n"
                        + "                            \n"
                        + "\n"
                        + "                        </tr>\n");
            }

            out.println("</table>\n"
                    + "                <input type =\"submit\" name=\"InsertDatabase\">\n"
                    + "                <input type=\"hidden\" name=\"action\" value=\"insertDatabase\">\n"
                    + "                </form>"
            );
            
            out.close();
        } catch (SQLException ex) {
            Logger.getLogger(FormDisplayTag.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FormDisplayTag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
