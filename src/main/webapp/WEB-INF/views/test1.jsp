
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/loginpage.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <spring:url value="/test1" var="url"></spring:url>
        <style>
        .error {
            color: #ff0000;
            font-style: italic;
        }

        .table-bordered > tbody > tr > td,
        .table-bordered > tbody > tr > th {
            border: none;
            background: none;
        }

        form fieldset {
            padding: 20px;
        }

        div.control-group {
            margin-bottom: 20px;
        }

        div.control-group label.control-label {
            width: 300px;
            font-weight: bold;
            text-align: left
        }

        div.control-group div.controls {
            width: 400px;
        }

        div.controls span {
            color: red;
            font-size: 1em;
        }

        div.personalbut {
            margin: 15px;
        }

        div.personal {
            border-bottom: 1px solid #e5e5e5;
            margin: 15px;
        }
        .btn-group, .btn-group-vertical {
            position: relative;
            vertical-align: middle;
            box-shadow: 2px 2px 5px rgba(129, 129, 129, 0.43);
        }
        .btn-group>.btn:first-child:not(:last-child):not(.dropdown-toggle) {
            border-top-right-radius: 4px;
            border-bottom-right-radius: 4px;
        }
    </style>
</head>
<body>
        <button class="btn btn-danger btn-mini" data-toggle="modal" data-target="#newuser">
            add user
        </button>
    <div class="model fade" id="newuser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form:form method="post" role="form" class="form-horizontal" id="registForm" action="${url}" commandName="user">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">times</button>
                        <h4 class="modal-title" id="myModalLabel"> Modify user</h4>
                    </div>
                        <div class="modal-body">
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary">Save changes</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                </form:form>
                </div>
        </div>
    </div>
</body>
</html>
