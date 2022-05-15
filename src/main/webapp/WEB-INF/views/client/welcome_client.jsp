<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/client/welcome-client.css">
<div id="templatemo_main">
    <div id="content">
        <div id="home" class="section">
            <div id="home_about" class="box">
                <br>
                <h2>Welcome, ${client.name} ${client.surname}</h2>
                <br>
                <h3>You are client of:</h3>
            </div>

            <table border="2">
                <tr class="table-header">
                    <td>Name</td>
                    <td>Open</td>
                </tr>
                <c:forEach var="bank" items="${banks}">
                    <tr>
                        <td>${bank.name}</td>
                        <td>
                            <input type="button" value="Open"
                                   onclick="location.href='<c:url value="/client/${client.id}/banks/${bank.id}" />'"
                                   class="get-button colorTwo">
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </div>
</div>
