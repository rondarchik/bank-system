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

    <c:if test="${!notApproved}">
        <div class="div-1">There are NO unapproved credits or installments.</div>
    </c:if>

    <c:if test="${notApproved}">
        <div class="div-1">There are unapproved credits or installments.</div>
    </c:if>

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
                        <td>accountId</td>
                        <td>percent</td>
                        <td>approved</td>
                        <td>amount</td>
                        <td>remainingMonths</td>
                        <td>startDate</td>
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
                        </tr>
                    </c:forEach>
                </table>

            </c:otherwise>
        </c:choose>
    </div>

    <h2>Your installments:</h2>
    <div class="div-2">
        <c:choose>
            <c:when test="${empty installments}">
                You don't have any installment. Please, feel free to create it.
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
                    </tr>
                    <c:forEach var="installment" items="${installments}">
                        <tr>
                            <td>${installment.id}</td>
                            <td>${installment.clientAccount.id}</td>
                            <td>${installment.approved}</td>
                            <td>${installment.amount}</td>
                            <td>${installment.remainingMonths}</td>
                            <td>${installment.startDate}</td>
                        </tr>
                    </c:forEach>
                </table>

            </c:otherwise>
        </c:choose>
    </div>

    <h1>Credit Request creation:</h1>
    <div class="div-4">
        <div class="form">
            <form:form method="post" modelAttribute="newCredit" action="/clientAccount/${clientAccountId}/createCredit">
                <div class="input-form">
                    <label for="percent">Percent: </label>
                    <form:input path="percent" id="percent" placeholder="percent"/>
                    <form:errors path="percent"/>
                </div>

                <div class="input-form">
                    <label for="amount">Amount: </label>
                    <form:input path="amount" id="amount" placeholder="Amount"/>
                    <form:errors path="amount"/>
                </div>

                <div class="input-form">
                    <label for="durationInMonths">Duration in months: </label>
                    <form:select path="durationInMonths">
                        <form:options items="${DurationInMonths.values()}"/>
                    </form:select>
                    <form:errors path="durationInMonths"/>
                </div>

                <div class="input-form">
                    <input type="submit" value="Submit"/>
                </div>
            </form:form>
        </div>
    </div>

    <h1>Installment Request creation:</h1>
    <div class="div-4">
        <div class="form">
            <form:form method="post" modelAttribute="newInstallment" action="/clientAccount/${clientAccountId}/createInstallment">
                <div class="input-form">
                    <label for="amount">Amount: </label>
                    <form:input path="amount" id="amount" placeholder="Amount"/>
                    <form:errors path="amount"/>
                </div>

                <div class="input-form">
                    <label for="durationInMonths">Duration in months: </label>
                    <form:select path="durationInMonths">
                        <form:options items="${DurationInMonths.values()}"/>
                    </form:select>
                    <form:errors path="durationInMonths"/>
                </div>

                <div class="input-form">
                    <input type="submit" value="Submit"/>
                </div>
            </form:form>
        </div>
    </div>

    <br>
</div>
</body>
</html>
