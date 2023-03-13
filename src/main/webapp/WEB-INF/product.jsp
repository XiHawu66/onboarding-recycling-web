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
    <title>Product Information</title>
</head>
<body>
    <div align="center">
        <table width="600" border="1" cellpadding="5">
            <tr>
                <th>Recycling</th>
            </tr>
            <tr>
                <th width="400">Product Name</th>
                <th width="200">Product Img</th>
            </tr>
            <c:forEach items="${recyclingProducts}" var="recyclingProduct">
                <tr>
                    <td>${recyclingProduct.product}</td>
                    <td>${recyclingProduct.image_small}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/product/detail?pid=${recyclingProduct.product_id}">Detail</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div align="center" >
        <table width="600" border="1" cellpadding="5">
            <tr>
                <th>Non-Recycling</th>
            </tr>
            <tr>
                <th width="400">Product Name</th>
                <th width="200">Product Img</th>
            </tr>
            <c:forEach items="${nonRecyclingProducts}" var="nonRecyclingProduct">
                <tr>
                    <td>${nonRecyclingProduct.product}</td>
                    <td>${nonRecyclingProduct.image_small}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/product/detail?pid=${nonRecyclingProduct.product_id}">Detail</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
