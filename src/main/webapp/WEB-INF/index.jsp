<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Waste Recycle</title>
    <style type="text/css">
        .divForm {
            position: relative;
            width: 200px;
            height: 200px;

            text-align: center;
            top: 50%;
            left: 50%;
            margin-top: -200px;
            margin-left: -150px;

            transform: scale(1.5);
        }

        .c1 {
            color: darkgreen;
            position: absolute;

        }

        * {
            font-family: Georgia,Times,Times New Roman,serif;
            background-color: #bdd7bd;
        }



    </style>


</head>

<body>
    <h1 align="center">Recycle 'in' Victoria</h1>

    <br>
    <br>
    <br>


    <h2 align="center" class="c1">RIV helps in providing help to the residents of Victoria in sorting your wastes. Recycling the used
    household waste helps in making better choices thus improving environmentally sustainable Victoria</h2>

    <div align="center" class="divForm">
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
        <h5>* Enter your address in this format eg:(Oakleigh 3166)</h5>
    </div>


</body>
</html>



