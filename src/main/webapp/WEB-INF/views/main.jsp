<%@include file="general/taglibs.jspf" %>
<html>
<%@include file="general/header.jspf" %>
<body>

<c:if test="${first}">
  <%@include file="main-modal.jspf" %>
</c:if>

<div class="container">
  <%@include file="general/log.jspf"%>
  <header>
    <h1><a href="${ctx}/main"><img src="${ctx}/static/images/main-image.png"
                                   alt="<spring:message code="main.title"/>"></a>&nbsp;<spring:message
        code="main.title"/>
    </h1>
  </header>

  <%@include file="main-onemi-banner.jspf" %>

  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#uploadModal"><spring:message
      code="main.addInfo"/></button>
  <br>
  <%@include file="main-map.jspf" %>

  <%@include file="main-add-info.jspf" %>

  <%@include file="main-official-info.jspf" %>

  <br>

  <%@include file="main-unofficial-info.jspf" %>

  <%@include file="main-emergency-numbers.jspf" %>

  <%@include file="main-in-case-of-emergency.jspf" %>

</div>

</body>
</html>