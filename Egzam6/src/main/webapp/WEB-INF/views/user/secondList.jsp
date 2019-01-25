<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Darek bądź wyrozumiały</title>
</head>
<body>

    <ul>
        <c:forEach items="${tweetsByString}" var="tweet">
            <li>
                <h3>${tweet.title}</h3>
                <p>${tweet.tweetText}</p>
            </li>
        </c:forEach>
    </ul>

</body>
</html>
