<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/client/client-bank-page.css">
<html>
<head>
    <title>Client bank page</title>
</head>
<body>
<div>
    <c:choose>
        <c:when test="${isClientBankCorrectForSalaryProject}">
            <div>
                <c:choose>
                    <c:when test="${isSalaryProjectRequestExist}">
                        <div class="div-1">You are in Salary Project already. Your project - ${salaryProject.name}.
                        </div>
                        <c:if test="${!isSpecApproved}">
                            <div class="div-1">Now just wait for SPECIALIST's filling your documents.</div>
                        </c:if>
                        <c:if test="${!isOperatorApproved}">
                            <div class="div-1">OPERATOR must approve your request after SPECIALIST's filling your
                                documents.
                            </div>
                        </c:if>
                        <c:if test="${isOperatorApproved && isSpecApproved}">
                            <div class="div-1">Your Salary Project is working!!!! Your Salary
                                is ${salaryProjectRequestDto.salary}</div>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <div class="div-1">You are still NOT in Salary Project yet. Your possible salary project
                            - ${salaryProject.name}.
                            <br>
                            click to send Request -> <form:form method="get"
                                                                action="/salaryProject/${salaryProjectRequestDto.salaryProjectId}/client/${salaryProjectRequestDto.clientId}">
                                <div class="input-form">
                                    <input type="submit" value="Send Request"/>
                                </div>
                            </form:form>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:when>
        <c:otherwise>
            <div class="div-1">Registration of your Salary Project is impossible.
                Please, feel free to choose another bank for that purpose.
            </div>
        </c:otherwise>
    </c:choose>

    <div class="div-2">
        <c:choose>
            <c:when test="${empty clientAccounts}">
                You don't have any account. Please, feel fre to create it.
            </c:when>
            <c:otherwise>
                <h2>Your accounts:</h2>
                <table border="2">
                    <tr class="table-header">
                        <td class="id">Id</td>
                        <td>Bank Name</td>
                        <td>Balance</td>
                        <td>CurrencyType</td>
                        <td>freeze/unfreeze</td>
                        <td>block/unblock</td>
                    </tr>
                    <c:forEach var="clientAccount" items="${clientAccounts}">
                        <tr>
                            <td>${clientAccount.id}</td>
                            <td>${clientAccount.bank.name}</td>
                            <td>${clientAccount.balance}</td>
                            <td>${clientAccount.currencyType}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${clientAccount.frozen}">
                                        <input type="button" value="Unfreeze"
                                               onclick="location.href='<c:url value="/client/${clientAccount.id}/unfreeze" />'"
                                               class="get-button colorTwo">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="button" value="Freeze"
                                               onclick="location.href='<c:url value="/client/${clientAccount.id}/freeze" />'"
                                               class="get-button colorTwo">
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${clientAccount.blocked}">
                                        <input type="button" value="Unblock"
                                               onclick="location.href='<c:url value="/client/${clientAccount.id}/unblock" />'"
                                               class="get-button colorTwo">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="button" value="Block"
                                               onclick="location.href='<c:url value="/client/${clientAccount.id}/block" />'"
                                               class="get-button colorTwo">
                                    </c:otherwise>
                                </c:choose>
                            </td>


                        </tr>
                    </c:forEach>
                </table>

            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
