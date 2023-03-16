<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GengxinFan
  Date: 3/16/2023
  Time: 2:12 PM
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

            .title-name{
                font-size:35px;
                font-weight: 700;
                color:darkgreen;
            }
            .text-note{
                font-size:20px;
                font-weight: 300;
            }

            .tableLeft {
                border: none;
                width: 50%;
                float: left;
            }
            .content{
                border:0px solid;
                display:flex;
            }
            <%--
            .box {
                margin: 0px auto;
                background: darkgreen;
                width: 100%;
                padding: 20px;
                letter-spacing: 2;
                line-height: 2;
                text-align: justify;
                text-indent: 2em;
            }
            --%>
            .tableRight {
                border: none;
                width: 50%;
                top: 40px;
            }

            .div1 {
                border: none;
            }
            * {
                font-family: Georgia,Times,Times New Roman,serif;
                background-color: #c8dac8;
            }

        </style>
    </head>
    <body>

    <div class="home">
        <h4 >
            <%--<p> display:flex</p>--%>
            <a href="javascript:history.back(-1)"><img src = "images/home.jpg" width="40px" height="40px"></a>
            <span class="title-name" >Recycle 'in' Victoria</span>
        </h4>
    </div>

    <%--
    <div align="center" class="box">
        <h2>Recycle 'in' Victoria</h2>
    </div>
    --%>
    <div class="content">
        <div align="center" class="tableLeft">
                <img src = "images/${product.image}" width="300px" height="300px">
        </div>

        <div align="center" class="tableRight">
            <h2>${product.product} Recycling Detail</h2>

            <c:forEach items="${productInstructions}" var="productInstruction">
                <tr>
                    <td class="text-note">${productInstruction.sequence}</td>
                    <td class="text-note">${productInstruction.productPoint}</td>
                </tr>
            </c:forEach>

        </div>
    </div>




    <div align="center" class="div1">
        <h2>Did You Know?</h2>
        <table width="100%" border="0" cellpadding="0">
            <c:forEach items="${productNotes}" var="productNote">
                <tr>
                    <td class="text-note">${productNote.sequence}</td>
                    <td class="text-note">${productNote.productPoint}</td>
                </tr>
            </c:forEach>
        </table>
    </div>



    </body>
</html>