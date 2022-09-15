<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOC TYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome</title>
    </head>
    <body>
            Name is : <%= request.getAttribute("Name") %>
            Id is :   <%= request.getAttribute("Id") %>

    </body>

    </html>