<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/client/client-account-page.css">
<html>
<head>
    <title>Client Account Page</title>
</head>
<body>
<div>
    <h2>Your credits:</h2>
    <div class="div-2">
        <c:choose>
            <c:when test="${empty credits}">
                You don't have any credit. Please, feel free to create it.
            </c:when>
            <c:otherwise>
                <table border="2">
                    <tr class="table-header">
                        <td class="id">Id</td>
                        <td>remaining months</td>
                    </tr>
                    <c:forEach var="credit" items="${credits}">
                        <tr>
                            <td>${credit.id}</td>
                            <td>${credit.remainingMonths}</td>
                        </tr>
                    </c:forEach>
                </table>

            </c:otherwise>
        </c:choose>
    </div>


</div>
</body>
</html>
