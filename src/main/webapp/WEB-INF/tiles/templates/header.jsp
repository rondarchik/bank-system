<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<link href="<c:url value="/resources/css/templates.css" />" rel="stylesheet">
<div class="header">

    <div class="inlineHead">
        <h3>Bank System</h3>
    </div>

    <div class="inlineHead logout-button">
        <form:form action="/logout" method="post">
            <input type="submit" value="X" class="logout-style">
        </form:form>
    </div>
</div>