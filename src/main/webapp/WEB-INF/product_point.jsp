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

        <style type="text/css">
            .home {
                position: relative;
                top: 0px;
                left: 10px;

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
                top: 40px;
            }

            * {
                font-family: Georgia,Times,Times New Roman,serif;
                background-color: #bdd7bd;
            }

        </style>
    </head>
    <body>

    <div class="home">
        <h4 >
            <a href="javascript:history.back(-1)"><img src = "images/home.jpg" width="40px" height="40px"></a>
        </h4>
    </div>

    <div align="center">
        <h2>${product.product} Recycling Detail</h2>



        <img src = "images/${product.image}" width="300px" height="300px">
    </div>
    <div align="center" class="tableLeft">
        <h3>Instructions</h3>
        <table width="600" border="0" cellpadding="0">
<%--            <tr>--%>
<%--                <th width="150">Instruction sequence</th>--%>
<%--                <th width="450">Instruction</th>--%>
<%--            </tr>--%>
            <c:forEach items="${productInstructions}" var="productInstruction">
                <tr>
                    <td width="100">${productInstruction.sequence}</td>
                    <td width="500">${productInstruction.productPoint}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div align="center" class="tableRight">
        <h3>Notes</h3>
        <table width="600" border="0" cellpadding="0">
<%--            <tr>--%>
<%--                <th width="150">Note sequence</th>--%>
<%--                <th width="450">Note</th>--%>
<%--            </tr>--%>
            <c:forEach items="${productNotes}" var="productNote">
                <tr>
                    <td width="100">${productNote.sequence}</td>
                    <td width="500">${productNote.productPoint}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </body>
</html>