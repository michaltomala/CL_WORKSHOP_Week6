<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Darek bądź miłosierny</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <style>
        input, select{
            display: block;
            margin:15px 0;
            width: 100%;
        }
    </style>
</head>
<body>


    <form:form method="post"
               action="${formAction}"
               modelAttribute="author"
               cssClass="container col-2" >

        <form:hidden path="id" />

        <form:input path="title" placeholder="tytuł" cssClass="form-input"/>
        <form:errors path="title" cssClass="alert alert-danger" element="div" />

        <form:input path="tweetText" placeholder="tweetek" cssClass="form-input"/>
        <form:errors path="tweetText" cssClass="alert alert-danger" element="div" />

        <form:input path="date" placeholder="Data" cssClass="form-input"/>
        <form:errors path="date" cssClass="alert alert-danger" element="div" />

        <form:select path="user" cssClass="form-input">
            <form:option value="0" disabled="true" selected="true">Wybierz właściciela Tweeta</form:option>
            <form:options  items="${userList}"
                           itemValue="id"/>
        </form:select>

        <input type="submit"  class="btn btn-success">
    </form:form>

</body>
</html>
