<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>User: </title>
</head>
<body>
    <ul>
    <c:forEach items="${users}" var="user">
        <li>
            <c:out value="${user}" />
        </li>
    </c:forEach>
    </ul>

    <a href="<spring:url value="/user_create.html" />">SOMETHING</a>
</body>
</html>

