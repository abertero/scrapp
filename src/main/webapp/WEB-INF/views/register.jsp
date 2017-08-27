<%@include file="general/taglibs.jspf" %>
<html>
<%@include file="general/header.jspf" %>
<body>

<h1><spring:message code="register.title"/></h1>

<div class="col-xs-12 col-md-6 col-lg-4">
  <form action="${ctx}/login/log" method="post">
    <div class="form-group">
      <label for="name"><spring:message code="register.form.name"/></label>
      <input type="text" class="form-control" id="name" name="name"
             placeholder="<spring:message code="register.form.name.placeholder"/>">
    </div>
    <div class="form-group">
      <label for="lastName"><spring:message code="register.form.lastName"/></label>
      <input type="text" class="form-control" id="lastName" name="lastName"
             placeholder="<spring:message code="register.form.lastName.placeholder"/>">
    </div>
    <div class="form-group">
      <label for="rut"><spring:message code="register.form.rut"/></label>
      <input type="text" class="form-control" id="rut" name="rut" maxlength="12"
             placeholder="<spring:message code="register.form.rut.placeholder"/>">
    </div>
    <div class="form-group">
      <label for="password"><spring:message code="register.form.password"/></label>
      <input type="password" class="form-control" id="password" name="password"
             placeholder="<spring:message code="register.form.password.placeholder"/>">
    </div>
    <div class="form-group">
      <label for="repeatPassword"><spring:message code="register.form.repeatPassword"/></label>
      <input type="password" class="form-control" id="repeatPassword" name="repeatPassword"
             placeholder="<spring:message code="register.form.repeatPassword.placeholder"/>">
    </div>
    <div class="form-group">
      <label for="birthday"><spring:message code="register.form.birthday"/></label>
      <input type="date" class="form-control" id="birthday" name="birthday"
             placeholder="<spring:message code="register.form.birthday.placeholder"/>">
    </div>

    <button type="submit" class="btn btn-primary"><spring:message code="register.form.submit"/></button>
  </form>
</div>

</body>
</html>