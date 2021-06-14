<%--
  Created by IntelliJ IDEA.
  User: welcl
  Date: 2021-06-14
  Time: 오전 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <c:forEach var="item" items="${members}">
        <tr>
            <td>${item.id}</td>
            <td>${item.username}</td>
            <td>${item.age}</td>
        </tr>
    </c:forEach>
<%--위의 jstl과 같은 --%>
<%--    <%--%>
<%--        for (Member member : members) {--%>
<%--            out.write(" <tr>");--%>
<%--            out.write(" <td>" + member.getId() + "</td>");--%>
<%--            out.write(" <td>" + member.getUsername() + "</td>");--%>
<%--            out.write(" <td>" + member.getAge() + "</td>");--%>
<%--            out.write(" </tr>");--%>
<%--        }--%>
<%--    %>--%>
    </tbody>
</table>
</body>
</html>
