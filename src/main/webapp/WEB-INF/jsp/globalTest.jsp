<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>国际化</title>
</head>
<body>

下面展示的是后台获取的国际化信息：<br/>
${money}<br/>
${date}<br/>

下面展示的是视图中直接绑定的国际化信息：<br/>
<spring:message code="money"/>:<br/>
<spring:eval expression="map.money"></spring:eval><br/>

<spring:message code="date"/>:<br/>
<spring:eval expression="map.date"></spring:eval><br/>





</body>
</html>
