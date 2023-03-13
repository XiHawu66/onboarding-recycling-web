<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EdwardElric
  Date: 3/10/2023
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Local Government Area Information</title>
    <a href="${pageContext.request.contextPath}/product?id=1">Click here to Product</a>
</head>
<body>
    <div align="center">
        <h1>"Local Government Area":   ${lga.lga_name}</h1>
        <h1>"Recycle bin colour"   :   ${lga.recycle_bin}</h1>
        <h1>"Rubbish bin colour"   :   ${lga.rubbish_bin}</h1>
    </div>

</body>
</html>
