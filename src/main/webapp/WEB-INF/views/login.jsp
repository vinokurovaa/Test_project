<%--
  Created by IntelliJ IDEA.
  User: anvi0616
  Date: 6/19/2017
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login page</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>
<body>
<div id="mainWrapper">
    <div class="login-container">
        <div class="login-card">
            <div class="login-form">
                <c:url var="loginUrl" value="/login" />
                <form action="${loginUrl}" method="post" class="form-horizontal">
                    <c:if test="${param.error != null}">
                        <div class="alert alert-danger">
                            <p>Invalid username and password.</p>
                        </div>
                    </c:if>
                    <c:if test="${param.logout != null}">
                        <div class="alert alert-success">
                            <p>You have been logged out successfully.</p>
                        </div>
                    </c:if>
                    <spring:message code="lable.language"/> : <a href="?MyLocale=en"> <img src="${pageContext.request.contextPath}/img/en.png"/> </a> | <a href="?MyLocale=de"><img src="${pageContext.request.contextPath}/img/de.png"></a>
                    <div class="input-group input-sm">
                        <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                        <input type="text" class="form-control" id="username" name="ssoId" placeholder="<spring:message code="lable.enterUserName" />" required oninvalid="this.setCustomValidity('<spring:message code="lable.validationMassageRequired"/>')" oninput="this.setCustomValidity('')">
                    </div>
                    <div class="input-group input-sm">
                        <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="<spring:message code="lable.enterPassword" />" required>
                    </div>
                    <div class="input-group input-sm">
                        <div class="checkbox">
                            <label><input type="checkbox" id="rememberme" name="remember-me"> <spring:message code="lable.rememberMe" /></label>
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

                    <div class="form-actions">
                        <input type="submit"
                               class="btn btn-block btn-primary btn-default" value="<spring:message code="lable.logIn" />">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
