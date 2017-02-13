<%-- 
    Document   : Result
    Created on : Feb 11, 2016, 2:13:34 AM
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
    <body style="background-color: royalblue">
        <h1>Result Page</h1>
        <h3><c:out value="${noOfRecords}"></c:out> book has been inserted successfully</h3>
        <a href="index.htm">Click here to go back to main page</a>
    </body>
</html>
