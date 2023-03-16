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

    <style type="text/css">
        .div1 {
            border: none;
        }

        .div2 {
            width: 100%;
            border: none;
        }

        .tableLeft {
            border: none;
            width: 700px;
            float: left;
        }

        .tableRight {
            border: none;
            width: 700px;
            float: right;
        }

        .home {
            position: absolute;
            top: 10px;
            left: 10px;
        }

    </style>
</head>
<body>
<%--    <div align="center" class="home">--%>
<%--        <h4>--%>
<%--            <a href="${pageContext.request.contextPath}/home">Home</a>--%>
<%--        </h4>--%>
<%--    </div>--%>
    <div class="home">
        <h4>
            <a href="${pageContext.request.contextPath}/home"><img src = "images/home.jpg" width="50px" height="50px"></a>
        </h4>
    </div>

    <div align="center" class="div1">
        <h2>LGA Recycling Information</h2>

        <h3>You are located in ${lga.lga_name}</h3>

        <h4>Click images below to get more information</h4>
    </div>

    <div align="center" class="tableLeft">
        <h3>Recycling Bin:${lga.recycle_bin}</h3>
        <h4>Recycling Items</h4>

        <table width="600" border="0" cellpadding="0">
            <c:forEach items="${lga.recyclingProducts}" var="recyclingProduct">
                <tr>
                    <td>${recyclingProduct.product}</td>
                    <td><a href="${pageContext.request.contextPath}/productpoint?pid=${recyclingProduct.product_id}"><img src = "images/${recyclingProduct.image_small}" width="100px" height="100px"></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div align="center" class="tableRight">
        <h3>Rubbish Bin:${lga.rubbish_bin}</h3>
        <h4>Rubbish Items</h4>

        <table width="600" border="0" cellpadding="0">
            <c:forEach items="${lga.nonRecyclingProducts}" var="nonRecyclingProduct">
                <tr>
                    <td>${nonRecyclingProduct.product}</td>
                    <td><img src = "images/${nonRecyclingProduct.image_small}" width="100px" height="100px"></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
