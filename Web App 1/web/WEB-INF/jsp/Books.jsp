<%-- 
    Document   : Books
    Created on : Feb 10, 2016, 9:17:11 PM
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
    <body style="background-color: yellowgreen">
        <h1>Enter the book details</h1>
         <form action="addBooks.htm" method="post">
           
             <c:forEach begin="1" step="1" varStatus="loop" end="${requestScope.numberBooks}">
           
                ISBN-NO<input type="text" name="isbn">
                Book Title<input type="text" name="title">
                Authors<input type="text" name="authors">
                Price$<input type="text" name="Price"><br><br>
        </c:forEach>
                <input type="submit" name="AddBooks">
                <input type="hidden" name="action" value="post">
         </form>
    </body>
</html>
