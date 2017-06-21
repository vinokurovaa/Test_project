<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login page</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/loginpage.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    <spring:url value="/signUp" var="url"></spring:url>
</head>
<body>
<nav class="navbar navbar-default navbar-inverse" role="navigation" >
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-left">
                <li>
                    <a href="?locale=en"> <img src="${pageContext.request.contextPath}/img/en.png"/> </a>
                </li>
                <li>
                    <a href="?locale=de"> <img src="${pageContext.request.contextPath}/img/de.png"/> </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href=""  role="button" data-toggle="modal" data-target="#signUpModal"> Sign up </a> </li>
                <!-- Modal -->
                <div class="modal fade" id="signUpModal" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                           <form:form action="${url}" method="post" modelAttribute="newUser" >
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="fa fa-times"></i></button>
                                <h4 class="modal-title">Ready to Join? Create a New Account</h4>
                            </div>
                            <div class="modal-body" id="email">
                                <div class="form-group">
                                    <label for="email">Email Address</label>
                                    <input type="text" class="form-control" required="" name="email" value="">
                                    <span class="help-block">Your email address is  used to log in.</span>
                                </div>
                                <div class="row">
                                    <div class="col-md-6" id="firstName">
                                        <label for="firstName">First Name</label>
                                        <input type="text" class="form-control" required="" name="firstName" value="">
                                        <span class="help-block">Your first name.</span>
                                    </div>
                                    <div class="col-md-6" id="lastName">
                                        <label for="lastName">Last name</label>
                                        <input type="text" class="form-control" required="" name="lastName" value="">
                                        <span class="help-block">Your last name.</span>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6" id="login">
                                        <label for="login">Login</label>
                                        <input type="text" class="form-control" required="" name="login" value="">
                                        <span class="help-block">Your login is also used to log in.</span>
                                    </div>
                                    <div class="col-md-6" id="password">
                                        <label for="password">Password</label>
                                        <input type="password" class="form-control" required="" name="password" value="">
                                        <span class="help-block">Your password is always used to log in.</span>
                                    </div>
                                    <div class="col-md-7">
                                        <form:select path="userRole" items="${roles}" multiple="true" itemValue="id" itemLabel="role" class="form-control input-sm" />
                                    </div>
                                </div>
                            </div>
                                <div class="form-actions">
                                    <input type="hidden" name="isEmpty" value="">
                                    <button type="input" name="submit" value="newAccount" class="btn btn-success btn-icon"><i class="fa fa-check"></i> Create My Account</button>
                                    <button type="button" class="btn btn-default btn-icon" data-dismiss="modal"><i class="fa fa-times-circle"></i> Cancel</button>
                                </div>
                            </div>
                           </form:form>
                        </div>
                    </div>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Sign in</b> <span class="caret"></span></a>
                    <ul id="login-dp" class="dropdown-menu">
                        <li>
                            <div class="row">
                                <div class="col-md-12">
                                    Login via
                                    <div class="social-buttons">
                                        <a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i> Facebook</a>
                                        <a href="#" class="btn btn-tw"><i class="fa fa-twitter"></i> Twitter</a>
                                    </div>
                                    or
                                    <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
                                        <div class="form-group">
                                            <label class="sr-only" for="exampleInputEmail2">Email address</label>
                                            <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email address" required>
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="exampleInputPassword2">Password</label>
                                            <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>
                                            <div class="help-block text-right"><a href="">Forget the password ?</a></div>
                                        </div>
                                        <div class="form-group">
                                            <button type="submit" class="btn btn-primary btn-block">Sign in</button>
                                        </div>
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox"> keep me logged-in
                                            </label>
                                        </div>
                                    </form>
                                </div>
                                <div class="bottom text-center">
                                    New here ? <a href="#"><b>Join Us</b></a>
                                </div>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="container">
    <a href="#" {pageContext.request.contextPath} ></a>
</div>
</body>
</html>