<<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/operator/welcome-operator.css">
<div id="templatemo_main">
    <div id="content">
        <div id="home" class="section">
            <div id="home_about" class="box">
                <br>
                <h2>Welcome, operator !!!</h2>
            </div>
        </div>
    </div>
    <h2>Not Approved Salary Project Requests:</h2>
    <table border="2">
        <tr class="table-header">
            <td class="id">Id</td>
            <td>clientId</td>
            <td>Approve</td>
        </tr>
        <c:forEach var="salaryProjectRequest" items="${salaryProjectRequests}">
            <tr>
                <td>${salaryProjectRequest.id}</td>
                <td>${salaryProjectRequest.clientId}</td>
                <td>
                    <input type="button" value="Activate"
                           onclick="location.href='<c:url value="/operator/submitSalaryProjectRequest/${salaryProjectRequest.id}"/>'"
                           class="get-button colorTwo">
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
