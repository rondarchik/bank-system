<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/welcome-admin.css">
<div id="templatemo_main">
<div id="content">
    <div id="home" class="section">
        <div id="home_about" class="box">
            <br>
            <h2>Welcome, admin !!!</h2>
        </div>
    </div>
</div>
<c:choose>
    <c:when test="${empty actions}">
        There are no actions in system yet!!!
    </c:when>
    <c:otherwise>
        <h2>Actions:</h2>
        <table border="2">
            <tr class="table-header">
                <td class="id">Id</td>
                <td>Action</td>
                <td>Date</td>
            </tr>
            <c:forEach var="action" items="${actions}">
                <tr>
                    <td>${action.id}</td>
                    <td>${action.logText}</td>
                    <td>${action.date}</td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>