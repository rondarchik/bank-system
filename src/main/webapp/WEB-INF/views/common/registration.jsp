<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/registration.css">
</head>
<body>

<div class="input-form">
        <input type="button" value="Go back!" onclick="history.back()">
</div>

<div class="form">
    <form:form method="post" modelAttribute="user" action="registration">
        <h1>Client registration:</h1>
        <div class="input-form">
            <form:input path="login" id="login" placeholder="Login"/>
            <form:errors path="login"/>
        </div>

        <div class="input-form">
            <form:input path="password" id="password" placeholder="Password"/>
            <form:errors path="password"/>
        </div>

        <div class="input-form">
            <form:input path="surname" id="surname" placeholder="Surname"/>
            <form:errors path="surname"/>
        </div>

        <div class="input-form">
            <form:input path="name" id="name" placeholder="Name"/>
            <form:errors path="name"/>
        </div>

        <div class="input-form">
            <form:input path="lastname" id="lastname" placeholder="Lastname"/>
            <form:errors path="lastname"/>
        </div>

        <div class="input-form">
            <form:input path="passportId" id="passportId" placeholder="Passport id"/>
            <form:errors path="passportId"/>
        </div>

        <div class="input-form">
            <form:input path="identityNumber" id="identityNumber" placeholder="Identity Number"/>
            <form:errors path="identityNumber"/>
        </div>

        <div class="input-form">
            <form:input path="telephoneNumber" id="telephoneNumber" placeholder="Telephone Number"/>
            <form:errors path="telephoneNumber"/>
        </div>

        <div class="input-form">
            <form:input path="email" id="email" placeholder="Email"/>
            <form:errors path="email"/>
        </div>

        <div class="input-form">
            <label for="company">Company: </label>
            <form:select path="company">
                <form:options items="${companies}"/>
            </form:select>
            <form:errors path="company"/>
        </div>

        <div class="input-form">
            <label for="bank">Bank: </label>
            <form:select path="bank">
                <form:options items="${banks}"/>
            </form:select>
            <form:errors path="bank"/>
        </div>
        <div class="input-form">
            <input type="submit" value="Submit"/>
        </div>

        <div class="error">
            <c:if test="${userExists!=null}">
                ${userExists}
            </c:if>
        </div>

        <div class="error">
            <c:if test="${successRegistration!=null}">
                ${successRegistration}
            </c:if>
        </div>

    </form:form>
</div>
</body>
</html>