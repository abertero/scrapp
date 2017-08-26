<%@include file="general/taglibs.jspf" %>
<html>
<%@include file="general/header.jspf" %>
<body>

<c:if test="${first}">
  <%@include file="main-modal.jspf" %>
</c:if>

<div class="container">
  <header>
    <h1><a href="${ctx}/main"><img src="${ctx}/static/images/main-image.png"
                                   alt="<spring:message code="main.title"/>"></a>&nbsp;<spring:message
        code="main.title"/>
    </h1>
  </header>

  <%@include file="main-onemi-banner.jspf" %>

  <%@include file="main-add-info.jspf" %>
  <br>
  <%@include file="main-map.jspf" %>

  <%@include file="main-official-info.jspf" %>

  <br>

  <%@include file="main-unofficial-info.jspf" %>

  <%@include file="main-emergency-numbers.jspf" %>

</div>

</body>
</html>