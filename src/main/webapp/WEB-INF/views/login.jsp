<%@include file="general/taglibs.jspf" %>
<html>
<%@include file="general/header.jspf" %>
<body>

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
    <button type="button" class="btn btn-default"><spring:message code="login.form.createAccount"/></button>
  </form>
</div>

</body>
</html>