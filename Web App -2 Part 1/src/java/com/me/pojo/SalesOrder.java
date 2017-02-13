/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.pojo;

/**
 *
 * @author Pranay
 */
public class SalesOrder {

    private long salesOrderID;
    private int revisionNumber;
    private String orderDate;
    private String dueDate;
    private String shippedDate;
    private int status;
    private int onlineOrderFlag;
    private String salesOrderNumber;
    private String purchaseOrder;
    private String accountNumber;
    private long customerID;
    private int salesPersonID;
    private int territoryID;
    private int billAddressID;
    private int shipAddressID;
    private int shipMethodID;
    private String creditCardApprovalCode;
    private String currencyRateID;
    private float subTotal;
    private float taxAmount;
    private float frieghtCharges;
    private float totalDue;
    private String comment;
    private String modifiedDate;
    private String creditCardID;

    public long getSalesOrderID() {
        return salesOrderID;
    }

    public void setSalesOrderID(long salesOrderID) {
        this.salesOrderID = salesOrderID;
    }

    public int getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(int revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOnlineOrderFlag() {
        return onlineOrderFlag;
    }

    public void setOnlineOrderFlag(int onlineOrderFlag) {
        this.onlineOrderFlag = onlineOrderFlag;
    }

    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public String getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public int getSalesPersonID() {
        return salesPersonID;
    }

    public void setSalesPersonID(int salesPersonID) {
        this.salesPersonID = salesPersonID;
    }

    public int getTerritoryID() {
        return territoryID;
    }

    public void setTerritoryID(int territoryID) {
        this.territoryID = territoryID;
    }

    public int getBillAddressID() {
        return billAddressID;
    }

    public void setBillAddressID(int billAddressID) {
        this.billAddressID = billAddressID;
    }

    public int getShipAddressID() {
        return shipAddressID;
    }

    public void setShipAddressID(int shipAddressID) {
        this.shipAddressID = shipAddressID;
    }

    public int getShipMethodID() {
        return shipMethodID;
    }

    public void setShipMethodID(int shipMethodID) {
        this.shipMethodID = shipMethodID;
    }

    public String getCreditCardApprovalCode() {
        return creditCardApprovalCode;
    }

    public void setCreditCardApprovalCode(String creditCardApprovalCode) {
        this.creditCardApprovalCode = creditCardApprovalCode;
    }

    public String getCurrencyRateID() {
        return currencyRateID;
    }

    public void setCurrencyRateID(String currencyRateID) {
        this.currencyRateID = currencyRateID;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(float taxAmount) {
        this.taxAmount = taxAmount;
    }

    public float getFrieghtCharges() {
        return frieghtCharges;
    }

    public void setFrieghtCharges(float frieghtCharges) {
        this.frieghtCharges = frieghtCharges;
    }

    public float getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(float totalDue) {
        this.totalDue = totalDue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreditCardID() {
        return creditCardID;
    }

    public void setCreditCardID(String creditCardID) {
        this.creditCardID = creditCardID;
    }

}
