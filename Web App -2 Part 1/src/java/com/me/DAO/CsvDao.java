/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.DAO;

import com.me.pojo.SalesOrder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pranay
 */
public class CsvDao {

    Connection conn;
    Connection conn1;
    Statement statement;
    ResultSet rs;
    PreparedStatement ps;

    public List<SalesOrder> getSalesOrderDetail() throws SQLException, ParseException {
        try {
            List<SalesOrder> salesOrders = new ArrayList<SalesOrder>();
            String filepath = "C:\\Users\\Pranay\\Desktop\\WebTool_ImportantMaterial";
            try {
                Class.forName("org.relique.jdbc.csv.CsvDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CsvDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn = DriverManager.getConnection("jdbc:relique:csv:" + filepath);

            statement = conn.createStatement();
            rs = statement.executeQuery("select * from SalesOrder");
            while (rs.next()) {
                SalesOrder salesOrder = new SalesOrder();
                salesOrder.setSalesOrderID(Long.parseLong(rs.getString("SalesOrderID")));
                salesOrder.setRevisionNumber(Integer.parseInt(rs.getString("RevisionNumber")));

                DateFormat df = new SimpleDateFormat("d-M-YYYY");

                salesOrder.setOrderDate(rs.getString("OrderDate"));
                Date dueDate = new Date();

                salesOrder.setDueDate(rs.getString("DueDate"));
                Date shipDate = new Date();

                salesOrder.setShippedDate(rs.getString("ShipDate"));
                salesOrder.setStatus(Integer.parseInt(rs.getString("Status")));
                salesOrder.setOnlineOrderFlag(Integer.parseInt(rs.getString("OnlineOrderFlag")));
                salesOrder.setSalesOrderNumber(rs.getString("SalesOrderNumber"));
                salesOrder.setPurchaseOrder(rs.getString("PurchaseOrderNumber"));
                salesOrder.setAccountNumber(rs.getString("AccountNumber"));
                salesOrder.setCustomerID(Long.parseLong(rs.getString("CustomerID")));
                salesOrder.setSalesPersonID(Integer.parseInt(rs.getString("SalesPersonID")));
                salesOrder.setTerritoryID(Integer.parseInt(rs.getString("TerritoryID")));
                salesOrder.setBillAddressID(Integer.parseInt(rs.getString("BillToAddressID")));
                salesOrder.setShipAddressID(Integer.parseInt(rs.getString("ShipToAddressID")));
                salesOrder.setShipMethodID(Integer.parseInt(rs.getString("ShipMethodID")));
                salesOrder.setCreditCardID(rs.getString("CreditCardID"));
                salesOrder.setCreditCardApprovalCode(rs.getString("CreditCardApprovalCode"));
                salesOrder.setCurrencyRateID(rs.getString("CurrencyRateID"));
                salesOrder.setSubTotal(Float.parseFloat(rs.getString("SubTotal")));
                salesOrder.setTaxAmount(Float.parseFloat(rs.getString("TaxAmt")));
                salesOrder.setFrieghtCharges(Float.parseFloat(rs.getString("Freight")));
                salesOrder.setTotalDue(Float.parseFloat(rs.getString("TotalDue")));
                salesOrder.setComment(rs.getString("Comment"));
                salesOrder.setModifiedDate(rs.getString("ModifiedDate"));
                salesOrders.add(salesOrder);

            }

            conn.close();
            statement.close();
            rs.close();

            /*
             QueryRunner runner = new QueryRunner();
             ResultSetHandler<List<SalesOrder>> resultSetHandler = new BeanListHandler<SalesOrder>(SalesOrder.class);
             String q = "SELECT * FROM SalesOrder";
             salesOrders = runner.query(conn, q, resultSetHandler);
             */
            return salesOrders;
        } finally {

        }

    }

    public int result(List<SalesOrder> salesOrderList) throws SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String dburl = "jdbc:mysql://localhost:3306/salesorder";
        String dbuser = "root";
        String dbpassword = "jewel@123";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CsvDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn1 = DriverManager.getConnection(dburl, dbuser, dbpassword);
        } catch (SQLException ex) {
            Logger.getLogger(CsvDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        int count = 0;
        ps = conn1.prepareStatement("Insert into sales(salesOrderID,revisionNumber,orderDate,dueDate,shippedDate,status_flag,onlineOrderFlag,salesOrderNumber,purchaseOrder,accountNumber,customerID,salesPersonID,territoryID,billAddressID,shipAddressID,shipMethodID,creditCardApprovalCode,currencyRateID,subTotal,taxAmount,frieghtCharges,totalDue,comment_sales,modified_date,creditCardID) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        for (SalesOrder salesOrder : salesOrderList) {
            ps.setLong(1, salesOrder.getSalesOrderID());
            ps.setInt(2, salesOrder.getRevisionNumber());
            ps.setString(3, salesOrder.getOrderDate());
            ps.setString(4, salesOrder.getDueDate());
            ps.setString(5, salesOrder.getShippedDate());
            ps.setInt(6, salesOrder.getStatus());
            ps.setInt(7, salesOrder.getOnlineOrderFlag());
            ps.setString(8, salesOrder.getSalesOrderNumber());
            ps.setString(9, salesOrder.getPurchaseOrder());
            ps.setString(10, salesOrder.getAccountNumber());
            ps.setLong(11, salesOrder.getCustomerID());
            ps.setInt(12, salesOrder.getSalesPersonID());
            ps.setInt(13, salesOrder.getTerritoryID());
            ps.setInt(14, salesOrder.getBillAddressID());
            ps.setInt(15, salesOrder.getShipAddressID());
            ps.setInt(16, salesOrder.getShipMethodID());
            ps.setString(17, salesOrder.getCreditCardApprovalCode());
            ps.setString(18, salesOrder.getCurrencyRateID());
            ps.setFloat(19, salesOrder.getSubTotal());
            ps.setFloat(20, salesOrder.getTaxAmount());
            ps.setFloat(21, salesOrder.getFrieghtCharges());
            ps.setFloat(22, salesOrder.getTotalDue());
            ps.setString(23, salesOrder.getComment());
            ps.setString(24, salesOrder.getModifiedDate());
            ps.setString(25, salesOrder.getCreditCardID());
            ps.executeUpdate();
            count++;
        }

        conn1.close();
        ps.close();
        return count;
    }

}
