<%@include file="general/taglibs.jspf" %>
<html>
<%@include file="general/header.jspf" %>
<body>

<c:if test="${first}">
  <%@include file="main-modal.jspf" %>
</c:if>

<div class="container">
  <%@include file="general/log.jspf" %>
  <header>
    <h1><a href="${ctx}/main"><img src="${ctx}/static/images/main-image.png"
                                   alt="<spring:message code="main.title"/>"></a>&nbsp;<spring:message
        code="main.title"/>
    </h1>
  </header>

  <c:if test="${user!=null}">
    <div style="float: right; max-width: 100px;">
      <a href="javascript:alertar();"><img src="${ctx}/static/images/alert.png"
                                           alt="<spring:message code="main.button.alert"/>"
                                           style="width: 100%"></a>
    </div>
  </c:if>
  <div class="alert alert-success" id="alertSuccess" role="alert" style="display: none;"><spring:message
      code="main.alert.success"/></div>
  <div class="alert alert-danger" id="alertError" role="alert" style="display: none;"><spring:message
      code="main.alert.error"/></div>

  <%@include file="main-onemi-banner.jspf" %>

  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#uploadModal"><spring:message
      code="main.addInfo"/></button>
  <br>
  <%@include file="main-map.jspf" %>

  <%@include file="main-add-info.jspf" %>

  <%@include file="main-official-info.jspf" %>

  <br>

  <%@include file="main-emergency-numbers.jspf" %>

  <%@include file="main-unofficial-info.jspf" %>

  <%@include file="main-in-case-of-emergency.jspf" %>

  <c:if test="${user != null}">
    <%@include file="main-contacts.jspf" %>
  </c:if>

</div>
<script type="text/javascript">
  function alertar() {
    $.ajax({
      url: "${ctx}/contacts/alert",
      method: "get",
      success: function (res) {
        if (res) {
          $("#alertSuccess").show().delay(10000).hide(400);
        } else {
          $("#alertError").show().delay(10000).hide(400);
        }
      }
    });
  }
</script>

</body>
</html>