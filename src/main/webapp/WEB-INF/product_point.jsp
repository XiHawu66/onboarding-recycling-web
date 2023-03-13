<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EdwardElric
  Date: 3/13/2023
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Product Point Information</title>
    </head>
    <body>
    <div align="center">
        <h2>${product.product} Recycling Detail</h2>
        <h3>
            <a href="${pageContext.request.contextPath}/home">Home</a>
        </h3>
        <img src = "images/${product.image}">
        <h3>Instructions for ${product.product}</h3>
        <table width="600" border="1" cellpadding="5">
            <tr>
                <th width="150">Instruction sequence</th>
                <th width="450">Instruction</th>
            </tr>
<%--            <c:forEach items="${productInstructions}" var="productInstruction">--%>
<%--                <tr>--%>
<%--                    <td>${productInstruction.sequence}</td>--%>
<%--                    <td>${productInstruction.productPoint}</td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
            <tr>
                <td>${productInstruction.sequence}</td>
                <td>${productInstruction.productPoint}</td>
            </tr>
        </table>
    </div>
<%--    <div align="center">--%>
<%--        <table width="600" border="1" cellpadding="5">--%>
<%--            <tr>--%>
<%--                <th>Notes for ${product.product}</th>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th width="150">Note sequence</th>--%>
<%--                <th width="450">Note</th>--%>
<%--            </tr>--%>
<%--            <c:forEach items="${productNotes}" var="productNote">--%>
<%--                <tr>--%>
<%--                    <td>${productNote.sequence}</td>--%>
<%--                    <td>${productNote.productPoint}</td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </table>--%>
<%--    </div>--%>
    </body>
</html>