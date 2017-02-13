<%-- 
    Document   : salesOrderPage
    Created on : Feb 20, 2016, 10:03:16 PM
    Author     : Pranay
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="tlds/customtag.tld" prefix="custom" %>
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
        <custom:DisplayRecords fileName="${requestScope.FileName}"></custom:DisplayRecords>
                </c:when>
                <c:when test="${requestScope.insertDatabase.equals(insertDatabase)}">
                Number of Records inserted = <c:out value="${requestScope.result}"></c:out>
            </c:when>
        </c:choose> 
        
    </body>
</html>
