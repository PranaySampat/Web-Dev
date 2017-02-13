<%-- 
    Document   : salesOrderPage
    Created on : Feb 20, 2016, 10:03:16 PM
    Author     : Pranay
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>File Upload</h1>
        
        <c:choose>
            <c:when test="${requestScope.display.equals(display)}">
                <form action="fileupload.htm" method="post">
                    Please enter your file name:<input type="text" name="FileName">
                    <input type="submit" name="submit" value="submit">
                    <input type="hidden" name="action" value="upload">
                    
                </form>
            </c:when>
            <c:when test="${requestScope.upload.equals(upload)}">
                <form action="insert.htm" method="post">
                <table border="1">
                    <tr>
                        <th>SalesOrderID</th>
                        <th>RevisionNumber</th>
                        <th>OrderDate</th>
                        <th>DueDate</th>
                        <th>ShipDate</th>
                        <th>Status</th>
                        <th>OnlineOrderFlag</th>
                        <th>SalesOrderNumber</th>
                        <th>PurchaseOrderNumber</th>
                        <th>AccountNumber</th>
                        <th>CustomerID</th>
                        <th>SalesPersonID</th>
                        <th>TerritoryID</th>
                        <th>BillAddressID</th>
                        <th>ShipToAddressID</th>
                        <th>ShipMethodID</th>
                        <th>CreditCardID</th>
                        <th>CreditCardApprovalCode</th>
                        <th>CurrencyRateID</th>
                        <th>SubTotal</th>
                        <th>TaxAmt</th>
                        <th>Freight</th>
                        <th>TotalDue</th>
                        <th>Comment</th>
                        <th>ModifiedDate</th>

                        <c:forEach items="${requestScope.list}" var="sales">
                        <tr>
                            <td> ${sales.salesOrderID}</td>
                            <td> ${sales.revisionNumber}</td>
                            <td> ${sales.orderDate}</td>
                            <td> ${sales.dueDate}</td>
                            <td> ${sales.shippedDate}</td>
                            <td> ${sales.status}</td>
                            <td> ${sales.onlineOrderFlag}</td>
                            <td> ${sales.salesOrderNumber}</td>
                            <td> ${sales.purchaseOrder}</td>
                            <td> ${sales.accountNumber}</td>
                            <td> ${sales.customerID}</td>
                            <td> ${sales.salesPersonID}</td>
                            <td> ${sales.territoryID}</td>
                            <td> ${sales.billAddressID}</td>
                            <td> ${sales.shipAddressID}</td>
                            <td> ${sales.shipMethodID}</td>
                            <td> ${sales.creditCardID}</td>
                            <td> ${sales.creditCardApprovalCode}</td>
                            <td> ${sales.currencyRateID}</td>
                            <td> ${sales.subTotal}</td>
                            <td> ${sales.taxAmount}</td>
                            <td>${sales.frieghtCharges}</td>
                            <td> ${sales.totalDue}</td>
                            <td> ${sales.comment}</td>
                            <td> ${sales.modifiedDate}</td>
                           
                            
                            

                        </tr>
                    </c:forEach>
                </table>
                <input type ="submit" name="InsertDatabase">
                <input type="hidden" name="action" value="insertDatabase">
                </form>
            </c:when>
            <c:when test="${requestScope.insertDatabase.equals(insertDatabase)}">
                Number of Records inserted = <c:out value="${requestScope.result}"></c:out>
            </c:when>
        </c:choose> 
        
    </body>
</html>
