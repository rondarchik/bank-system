<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/manager/welcome-manager.css">
<div id="templatemo_main">
    <div id="content">
        <div id="home" class="section">
            <div id="home_about" class="box">
                <br>
                <h2>Welcome, manager !!!</h2>
            </div>
        </div>
    </div>
    <c:choose>
        <c:when test="${empty nonActiveClients}">
            Non Active Clients: all clients are active
        </c:when>
        <c:otherwise>
            <h2>Non active clients:</h2>
            <table border="2">
                <tr class="table-header">
                    <td class="id">Id</td>
                    <td>Login</td>
                    <td>Active</td>
                    <td>Action</td>
                </tr>
                <c:forEach var="client" items="${nonActiveClients}">
                    <tr>
                        <td>${client.id}</td>
                        <td>${client.login}</td>
                        <td><c:choose>
                            <c:when test="${client.active}">
                                Yes
                            </c:when>
                            <c:otherwise>
                                No
                            </c:otherwise>
                        </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${!student.active}">
                                    <input type="button" value="Activate"
                                           onclick="location.href='<c:url value="/manager_v1/${client.id}/activate" />'"
                                           class="get-button colorTwo">
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>

    <h2>Unapproved credits:</h2>
    <div class="div-2">
        <c:choose>
            <c:when test="${empty credits}">
                There are no unapproved credits.
            </c:when>
            <c:otherwise>
                <table border="2">
                    <tr class="table-header">
                        <td class="id">Id</td>
                        <td>accountId</td>
                        <td>percent</td>
                        <td>approved</td>
                        <td>amount</td>
                        <td>remainingMonths</td>
                        <td>startDate</td>
                        <td>action</td>
                    </tr>
                    <c:forEach var="credit" items="${credits}">
                        <tr>
                            <td>${credit.id}</td>
                            <td>${credit.clientAccount.id}</td>
                            <td>${credit.percent}</td>
                            <td>${credit.approved}</td>
                            <td>${credit.amount}</td>
                            <td>${credit.remainingMonths}</td>
                            <td>${credit.startDate}</td>
                            <td>
                                <input type="button" value="Approve"
                                       onclick="location.href='<c:url value="/manager_v1/credit/${credit.id}/approve" />'"
                                       class="get-button colorTwo">
                            </td>
                        </tr>
                    </c:forEach>
                </table>

            </c:otherwise>
        </c:choose>
    </div>

    <h2>Unapproved installments:</h2>
    <div class="div-2">
        <c:choose>
            <c:when test="${empty installments}">
                There are no unapproved installments.
            </c:when>
            <c:otherwise>
                <table border="2">
                    <tr class="table-header">
                        <td class="id">Id</td>
                        <td>accountId</td>
                        <td>approved</td>
                        <td>amount</td>
                        <td>remainingMonths</td>
                        <td>startDate</td>
                        <td>action</td>
                    </tr>
                    <c:forEach var="installment" items="${installments}">
                        <tr>
                            <td>${installment.id}</td>
                            <td>${installment.clientAccount.id}</td>
                            <td>${installment.approved}</td>
                            <td>${installment.amount}</td>
                            <td>${installment.remainingMonths}</td>
                            <td>${installment.startDate}</td>
                            <td>
                                <input type="button" value="Approve"
                                       onclick="location.href='<c:url value="/manager_v1/installment/${installment.id}/approve" />'"
                                       class="get-button colorTwo">
                            </td>
                        </tr>
                    </c:forEach>
                </table>

            </c:otherwise>
        </c:choose>
    </div>


</div>
