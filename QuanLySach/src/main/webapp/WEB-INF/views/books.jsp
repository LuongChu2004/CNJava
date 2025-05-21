<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách sách</title>
</head>
<body>
<h2>Danh sách các sách</h2>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>
        <th>Tác giả</th>
        <th>Trạng thái</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>
                <c:choose>
                    <c:when test="${book.available}">
                        Có sẵn
                    </c:when>
                    <c:otherwise>
                        Đã mượn
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:if test="${book.available}">
                    <form method="post" action="/borrow">
                        <input type="hidden" name="bookId" value="${book.id}" />
                        <input type="hidden" name="userId" value="1" /> <!-- userId giả lập -->
                        <button type="submit">Mượn</button>
                    </form>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>

<br/>
<a href="/books/add">Thêm sách mới</a>
</body>
</html>
