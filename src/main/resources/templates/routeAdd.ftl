<#import "spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .tableAdd input{
            align-self: center;
            align-items: center;
            width: 25%;
            height: calc(1.5em + 0.75rem + 2px);
            padding: 0.375rem 0.75rem;
            font-size: 1rem;
            font-weight: 400;
            line-height: 1.5;
            color: #495057;
            background-color: #fff;
            border: 1px solid #ced4da;
            border-radius: 0.25rem;
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
            transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
            animation: 50ms;
        }
        .tableAdd input:hover{
            box-shadow: 0 0px 0px 0 rgba(0,0,0,0.24), 0 0px 0px 0 rgba(0,0,0,0.19);
            animation: 50ms;
        }
        .tableAdd select{
            align-self: center;
            align-items: center;
            width: 27%;
            height: calc(1.5em + 0.75rem + 2px);
            padding: 0.375rem 0.75rem;
            font-size: 1rem;
            font-weight: 400;
            line-height: 1.5;
            color: #495057;
            background-color: #fff;
            border: 1px solid #ced4da;
            border-radius: 0.25rem;
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
            transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
            animation: 50ms;
        }
        .tableAdd select:hover{
            box-shadow: 0 0px 0px 0 rgba(0,0,0,0.24), 0 0px 0px 0 rgba(0,0,0,0.19);
            animation: 50ms;
        }
    </style>
</head>
<body>

<div align="center">
        <legend>Add student</legend>
        <form name="route" action="" method="POST" class="tableAdd">
            З міста<br><@spring.formSingleSelect "routeForm.fromCity", cities, ""/>
            <br>
            До міста<br><@spring.formSingleSelect "routeForm.toCity", cities, ""/>
            <br>
            Автобус<br><@spring.formSingleSelect "routeForm.bus", buses, ""/>
            <br>
            Дата відправки<br><@spring.formInput "routeForm.dateDeparture" "required" "date"/>
            <br>
            Час відправки<br><@spring.formInput "routeForm.timeDeparture" "required" "time"/>
            <br>
            Дата прибуття<br><@spring.formInput "routeForm.dateOfArrival" "required" "date"/>
            <br>
            Час прибуття<br><@spring.formInput "routeForm.timeOfArrival" "required" "time"/>
            <br>
            Ціна<br><@spring.formInput "routeForm.price" "min=1" "number"/>
            <br>
            <br>
            <p align="center" style="color:#ff0000; font-size: 20px">${message}<p>
            <input type="submit" value="ОК"/>
        </form>
</div>
</body>
</html>