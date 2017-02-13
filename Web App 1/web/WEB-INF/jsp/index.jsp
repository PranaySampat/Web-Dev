<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
       <h1>Add Books Page</h1>
        <form action ='addBooks.htm'>
            <h3>How many books you want to add</h3>
            <input type ="text" name="noOfBooks">
            <input type ="submit" name="submit">
            <input type="hidden" name ="action" value="get">
                
        </form>
    </body>
</html>
