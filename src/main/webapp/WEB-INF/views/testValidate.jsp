

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Sign Up</title>
    <style type="text/css">
        span.error{
            color: red;
        }
    </style>
</head>
<body>
    <h1>Sigh Up</h1>

    <form:form method="post" action="valid" modelAttribute="userForm">
        <table>
            <tr>
                <td>Email</td>
                <td><form:input path="email"/></td>
                <td><span class="error"><form:errors path="email"/> </span> </td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="submit"></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
