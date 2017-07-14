
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="/static/css/style.css" type="text/css" media="screen" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/static/js/validate.js" charset="utf-8"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="content">
        <form:form id="jform" action="/validForm" method="post" modelAttribute="userForm">
            <fieldset>
                <legend>Personal Info</legend>
                <p>
                    <label for="fullname" class="block">Full name: </label>
                    <input type="text" name="fullname" id="fullname"/>
                </p>
            </fieldset>
            <fieldset>
                <legend>Email</legend>
                <p>
                    <label for="email" class="block"><small>(mickey@mou.se)</small>:</label>
                    <input type="text" name="email" id="email"/>
                </p>
            </fieldset>
            <p>
                <button type="submit" id="send">submit</button>
            </p>
        </form:form>
    </div>
</body>
</html>
