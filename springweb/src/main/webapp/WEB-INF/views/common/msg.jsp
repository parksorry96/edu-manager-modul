<%--
  Created by IntelliJ IDEA.
  User: parkjisong
  Date: 25. 6. 13.
  Time: 오후 5:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<script>
  alert("${msg}");
  location.replace("${pageContext.request.contextPath}${loc}");
</script>
</body>
</html>
