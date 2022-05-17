<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/specialist/welcome-specialist.css">
<div id="templatemo_main">
    <div id="content">
        <div id="home" class="section">
            <div id="home_about" class="box">
                <br>
                <h2>Welcome, specialist !!!</h2>
            </div>
        </div>
    </div>
    <h2>Salary Project Requests:</h2>
    <table border="2">
        <tr class="table-header">
            <td class="id">Id</td>
            <td>Client Id</td>
            <td>Salary Project Name</td>
            <td>Salary</td>
            <td>Submit</td>
        </tr>
        <c:forEach var="salaryProjectRequest" items="${salaryProjectRequests}">
            <form:form method="post" modelAttribute="salaryProjectRequest" action="/specialist/submitSalaryProjectRequest/${salaryProjectRequest.id}">
            <tr>
                <td>${salaryProjectRequest.id}</td>
                <td>${salaryProjectRequest.clientId}</td>
                <td>${salaryProjectRequest.salaryProject.name}</td>
                <td>
                    <div class="input-form">
                        <input type="text" name="salary" value="${salaryProjectRequest.salary}"</input>
                    </div>
                </td>
                <td>
                    <div class="input-form">
                        <input type="submit" value="Submit"/>
                    </div>
                </td>
                </form:form>
            </tr>
        </c:forEach>
    </table>
</div>

