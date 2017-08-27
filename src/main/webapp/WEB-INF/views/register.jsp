<%@include file="general/taglibs.jspf" %>
<html>
<%@include file="general/header.jspf" %>
<body>

<h1><spring:message code="register.title"/></h1>

<div class="col-xs-12 col-md-6 col-lg-4">
  <form action="${ctx}/login/create" method="post" id="register">
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
      <label for="userId"><spring:message code="register.form.userId"/></label>
      <input type="text" class="form-control" id="userId" name="userId" maxlength="12"
             placeholder="<spring:message code="register.form.userId.placeholder"/>">
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

<script type="application/javascript">
  $(function () {
    $("form#register").validate({
      rules: {
        name: "required",
        lastName: "required",
        userId: "required",
        password: "required",
        repeatPassword: "required",
        birthday: "required"
      },
      messages: {
        name: "<spring:message code="register.validate.name"/>",
        lastName: "<spring:message code="register.validate.lastName"/>",
        userId: "<spring:message code="register.validate.userId"/>",
        password: "<spring:message code="register.validate.password"/>",
        repeatPassword: "<spring:message code="register.validate.repeatPassword"/>",
        birthday: "<spring:message code="register.validate.birthday"/>"
      }
    });
  });
</script>

</body>
</html>