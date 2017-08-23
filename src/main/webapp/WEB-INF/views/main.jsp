<%@include file="general/taglibs.jspf" %>
<html>
<%@include file="general/header.jspf" %>
<body>

<h1><spring:message code="main.title"/></h1>

<c:if test="${first}">
  <%@include file="main-modal.jspf" %>
</c:if>
</body>
</html>