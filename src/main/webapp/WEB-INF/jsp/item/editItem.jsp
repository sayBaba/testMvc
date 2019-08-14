<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/14
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>item</title>
</head>
<body>
        66666:             ${user.age}

    <form action="${pageContext.request.contextPath}/item/login" method="get">
        <input type="text" name="name"/>
        <input type="text" name="price"/>
        <input type="checkbox" name="item_id" value="001"/>
        <input type="checkbox" name="item_id" value="002"/>
        <input type="checkbox" name="item_id" value="002"/>

        <input type="submit">
    </form>

</body>
</html>
