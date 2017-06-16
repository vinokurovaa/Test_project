<%--
  Created by IntelliJ IDEA.
  User: anvi0616
  Date: 6/16/2017
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType = "text/html; charset = UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring_1" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>gghgh/></title>
</head>

<body>
<!--<h2>${message}</h2>-->
<spring:message code="lable.language"/> : <a href="?MyLocale=en"><spring:message code="lable.english"/></a> | <a href="?MyLocale=de"><spring:message code="lable.german"/></a>

<h2><spring:message code="lable.title"/></h2>



</body>
</html>