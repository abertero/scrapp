<%@include file="general/taglibs.jspf" %>
<html>
<%@include file="general/header.jspf" %>
<body>
<div class="container">
  <h1><spring:message code="login.title"/></h1>

  <div class="col-xs-12 col-md-6 col-lg-4">
    <form action="${ctx}/login/log" method="post">
      <div class="form-group">
        <label for="userId"><spring:message code="login.form.userId"/></label>
        <input type="text" class="form-control" id="userId" name="userId" maxlength="12"
               placeholder="<spring:message code="login.form.userId.placeholder"/>">
      </div>
      <div class="form-group">
        <label for="password"><spring:message code="login.form.password"/></label>
        <input type="password" class="form-control" id="password" name="password"
               placeholder="<spring:message code="login.form.password.placeholder"/>">
      </div>
      <div class="checkbox">
        <label>
          <input type="checkbox" id="forgotPass" name="forgotPass"><spring:message code="login.form.forgotPass"/>
        </label>
      </div>

      <button type="submit" class="btn btn-primary"><spring:message code="login.form.submit"/></button>
      <button type="button" class="btn btn-default" onclick="location.href='${ctx}/login/register'"><spring:message
          code="login.form.createAccount"/></button>
    </form>
  </div>
  <script type="application/javascript">
    $(function () {
      $("form#login").validate({
        rules: {
          userId: "required",
          password: "required"
        },
        messages: {
          userId: "<spring:message code="login.validate.userId"/>",
          password: "<spring:message code="login.validate.password"/>"
        }
      });
    });
  </script>
</div>
</body>
</html>