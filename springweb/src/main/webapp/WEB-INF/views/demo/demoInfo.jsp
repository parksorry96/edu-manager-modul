<%--
  Created by IntelliJ IDEA.
  User: parkjisong
  Date: 25. 6. 13.
  Time: 오전 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
<jsp:param name="title" value="파라미터데이터확인"/>
</jsp:include>

<section id="content">
  <h3>관리자 : ${sessionScope.manager}</h3>
  <table class="table" id="tbl-dev">
    <tr>
      <th scope="col">이름</th>
      <td>${demo.devName}</td>
      <td>${requestScope.demo.devName}</td>
    <tr>
    <tr>
      <th>나이</th>
      <td>${demo.devAge}</td>
    </tr>
    <tr>
      <th>성별</th>
      <td>${demo.devGender}</td>
    </tr>
    <tr>
      <th>이메일</th>
      <td>${demo.devEmail}</td>
    </tr>
    <tr>
      <th>개발가능언어</th>
      <td>
        <ul>
          <c:forEach var="l" items="${demo.devLang}">
            <li>${l}</li>
          </c:forEach>
        </ul>
      </td>
    </tr>
  </table>

</section>>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
