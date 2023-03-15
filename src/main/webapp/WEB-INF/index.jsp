<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Waste Recycle</title>
    <style type="text/css">
        .divForm {
            position: absolute;
            width: 200px;
            height: 200px;

            border: 1px solid red;
            text-align: center;
            top: 50%;
            left: 50%;
            margin-top: -200px;
            margin-left: -150px;
        }

        .c1 {
            border: 5px solid green;
            background-color: green;
        }
    </style>
</head>

<body>
    <h1 align="center">Recycle 'in' Victoria</h1>

    <h2 align="center" class="c1">RIV helps in providing help to the residents of Victoria in sorting your wastes. Recycling the used
    household waste helps in making better choinces thus improving environmentally sustainable Victoria</h2>

    <div class="divForm">
        <form method="get" action="lga">

            <label>Address</label> &nbsp;
            <label>
                <input value="Address Postcode" type="text" name="address"/>
            </label> &nbsp;

<%--            <label>Postcode</label> &nbsp;--%>
<%--            <label>--%>
<%--                <input type="text" name="postcode" />--%>
<%--            </label> &nbsp;--%>


            <input type="submit" value="Search" />
        </form>
    </div>

</body>
</html>



