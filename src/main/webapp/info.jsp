<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/19
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
aa
${user}
${user.openid}<br>
${user.nickname}<br>
${user.sex}<br>
${user.province}<br>
${user.city}<br>
${user.country}<br>
<img src="${user.headimgurl}">
</body>
</html>
