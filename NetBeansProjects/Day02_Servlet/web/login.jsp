<%-- 
    Document   : login
    Created on : Jan 10, 2019, 1:50:27 PM
    Author     : mickw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>login Page</h1>
        <form action="LoginController" method="POST">
            Username: <input type ="text" name="txtUsername"/>
            </br>
            Password: <input type="password" name="txtPassword" />
            </br>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
