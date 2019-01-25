<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Darek bądź wyrozumiały</title>
</head>
<body>

    <h1>User: ${user.firstName} | ${user.lastName}}</h1>
    <h2>All your Tweets:</h2>

    <ul>
        <c:forEach items="${tweets}" var="tweet">
            <li>
                <h3>${tweet.title}</h3>
                <p>${tweet.tweetText}</p>
            </li>
        </c:forEach>
    </ul>

</body>
</html>
