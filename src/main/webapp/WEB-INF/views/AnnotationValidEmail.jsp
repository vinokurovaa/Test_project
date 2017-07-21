<%--
  Created by IntelliJ IDEA.
  User: anvi0616
  Date: 7/21/2017
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <style>
        body { background-color: #eee; font: helvetica; }
        #container { width: 500px; background-color: #fff;
            margin: 30px auto; padding: 30px; border-radius: 5px; }
        .green { font-weight: bold; color: green; }
        .message { margin-bottom: 10px; }
        label {width:70px; display:inline-block;}
        input { display:inline-block; margin-right: 10px; }
        form {line-height: 160%; }
        .hide { display: none; }
        .error { color: red; font-size: 0.9em; font-weight: bold; }
    </style>
</head>
<body>
    <div id="container">
        <form:form action = "validAnnotation" modelAttribute="userForValidWithAnnotation">
            <label for="emailInput"> Email</label>
            <form:input path="email" id="emailInput"/>
            <form:errors path="email" cssClass="error"/>
            <br/>
            <input type="submit" value="Submit"/>
        </form:form>
    </div>
</body>
</html>
