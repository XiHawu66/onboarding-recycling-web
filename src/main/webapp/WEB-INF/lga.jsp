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
</head>
<body>
    <div align="center">
        <h2>LGA Recycling Information</h2>
        <h3>
            <a href="${pageContext.request.contextPath}/home">Home</a>
        </h3>
        <h3>You are located in ${lga.lga_name}</h3>
        <table width="600" border="1" cellpadding="5">
            <tr>
                <th>Recycling Bin:${lga.recycle_bin}</th>
            </tr>
            <tr>
                <th width="400">Item Name</th>
                <th width="200">Item Image</th>
            </tr>
            <c:forEach items="${lga.recyclingProducts}" var="recyclingProduct">
                <tr>
                    <td>${recyclingProduct.product}</td>
                    <td><img src = "images/${recyclingProduct.image_small}"></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/productpoint?pid=${recyclingProduct.product_id}">Detail</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div align="center">
        <table width="600" border="1" cellpadding="5">
            <tr>
                <th>Rubbish Bin:${lga.rubbish_bin}</th>
            </tr>
            <tr>
                <th width="400">Item Name</th>
                <th width="200">Item Image</th>
            </tr>
            <c:forEach items="${lga.nonRecyclingProducts}" var="nonRecyclingProduct">
                <tr>
                    <td>${nonRecyclingProduct.product}</td>
                    <td><img src = "images/${nonRecyclingProduct.image_small}"></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
