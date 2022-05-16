<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client bank page</title>
</head>
<body>
<div>
    <c:choose>
        <c:when test="${isClientBankCorrectForSalaryProject}">
            <h1>correct</h1>
        </c:when>
        <c:otherwise>
            <h1>Registration of your Salary Project is impossible.
                Please, feel free to choose another bank for that purpose.</h1>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
