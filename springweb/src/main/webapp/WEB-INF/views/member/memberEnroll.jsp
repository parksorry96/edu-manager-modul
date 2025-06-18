<%--
  Created by IntelliJ IDEA.
  User: parkjisong
  Date: 25. 6. 12.
  Time: 오후 2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<c:set var="path" value="${pageContext.request.contextPath}"/>


  <style>
    div#enroll-container{width:400px; margin:0 auto; text-align:center;}
    div#enroll-container input, div#enroll-container select {margin-bottom:10px;}
    .errorMsg{
      color:red;
      font-size:20px;
      font-weight: bolder;
    }
  </style>
  <div id="enroll-container">
    <form:form name="memberEnrollFrm" method="post" action="${path}/enrollmemberend.do" modelAttribute="member">
      <form:input path="userId" type="text" class="form-control" placeholder="아이디 (4글자이상)" name="userId" id="userId_" />
      <form:errors path="userId" cssClass="errorMsg" />
      <form:input path="password" type="password" class="form-control" placeholder="비밀번호" name="password" id="password_" />
      <form:errors path="password" cssClass="errorMsg"/>
      <input type="password" class="form-control" placeholder="비밀번호확인" id="password2" >
      <form:input path="userName" type="text" class="form-control" placeholder="이름" name="userName" id="userName" />
      <form:errors path="userName" cssClass="errorMsg"/>
      <form:input path="age" type="number" class="form-control" placeholder="나이" name="age" id="age"/>
      <form:errors path="age" cssClass="errorMsg"/>
      <form:input path="email" type="email" class="form-control" placeholder="이메일" name="email" id="email" />
      <form:errors path="email" cssClass="errorMsg"/>
      <form:input path="phone" type="tel" class="form-control" placeholder="전화번호 (예:01012345678)" name="phone" id="phone" maxlength="11" />
      <form:input path="address" type="text" class="form-control" placeholder="주소" name="address" id="address"/>
      <form:select path="gender" class="form-control" name="gender" >
        <option value="" disabled selected>성별</option>
        <option value="M">남</option>
        <option value="F">여</option>
      </form:select>
      <div class="form-check-inline form-check">
        취미 : &nbsp;
        <form:checkbox path="hobby"  class="form-check-input" name="hobby" id="hobby0" value="운동"/><label for="hobby0" class="form-check-label">운동</label>&nbsp;
        <form:checkbox path="hobby"   class="form-check-input" name="hobby" id="hobby1" value="등산"/><label for="hobby1" class="form-check-label">등산</label>&nbsp;
        <form:checkbox path="hobby"  class="form-check-input" name="hobby" id="hobby2" value="독서"/><label for="hobby2" class="form-check-label">독서</label>&nbsp;
        <form:checkbox path="hobby"   class="form-check-input" name="hobby" id="hobby3" value="게임"/><label for="hobby3" class="form-check-label">게임</label>&nbsp;
        <form:checkbox path="hobby"   class="form-check-input" name="hobby" id="hobby4" value="여행"/><label for="hobby4" class="form-check-label">여행</label>&nbsp;
      </div>
      <br />
      <input type="submit" class="btn btn-outline-success" value="가입" >&nbsp;
      <input type="reset" class="btn btn-outline-success" value="취소">
    </form:form>
  </div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>