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
    </style>
</head>

<body>
    <h2 align="center">Recycling Management System</h2>

    <div class="divForm">
        <form method="get" action="search_result">

            <label>Address</label> &nbsp;
            <label>
                <input type="text" name="address" />
            </label> &nbsp;

            <label>Postcode</label> &nbsp;
            <label>
                <input type="text" name="postcode" />
            </label> &nbsp;


            <input type="submit" value="Search" />
        </form>
    </div>

</body>
</html>



