<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thêm sách</title>
</head>
<body>
<h2>Thêm sách</h2>
<form method="post" action="/books/add">
    Tên sách: <input type="text" name="title" required /><br/>
    Tác giả: <input type="text" name="author" required /><br/>
    Có sẵn để mượn? <input type="checkbox" name="available" checked /><br/>
    <input type="submit" value="Thêm sách" />
</form>

<c:if test="${not empty message}">
    <p style="color: green;">${message}</p>
</c:if>

<a href="/books">Quay lại danh sách sách</a>
</body>
</html>
