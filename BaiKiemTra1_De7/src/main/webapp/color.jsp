<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chọn màu nền</title>
    <style>
        body {
            background-color: <c:out value="${sessionScope.color}" default="white"/>;
        }
    </style>
</head>
<body>
    <h2>Chọn màu nền:</h2>
    <form method="post" action="ColorServlet">
        <select name="color">
            <option value="white">White</option>
            <option value="red">Red</option>
            <option value="blue">Blue</option>
            <option value="green">Green</option>
        </select>
        <input type="submit" value="Chọn">
    </form>

    <c:if test="${not empty sessionScope.color}">
        <p>Màu nền hiện tại: <strong>${sessionScope.color}</strong></p>
    </c:if>
</body>
</html>
