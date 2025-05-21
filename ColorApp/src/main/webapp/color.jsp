<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chọn màu nền</title>
</head>
<body style="background-color: ${sessionScope.color};">
    <h2>Chọn màu nền cho trang:</h2>
    <form action="ColorServlet" method="post">
        <select name="color">
            <option value="white">Trắng</option>
            <option value="red">Đỏ</option>
            <option value="blue">Xanh</option>
            <option value="green">Lục</option> 
        </select>
        <input type="submit" value="Áp dụng" />
    </form>

    <c:choose>
        <c:when test="${not empty sessionScope.color}">
            <p>Bạn đã chọn màu nền: <strong>${sessionScope.color}</strong></p>
        </c:when>
        <c:otherwise>
            <p>Chưa có màu nào được chọn.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>