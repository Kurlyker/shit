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
        .tableAdd input:invalid{
            box-shadow: 0 12px 16px 0 rgba(248, 106, 99, 0.24), 0 17px 50px 0 rgb(255, 118, 103);
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

<div>

        <p align="center" style="font-size: 40px">Add student</p>
        <form name="bus" action="" method="POST" class="tableAdd" align="center">
            Номер<br><@spring.formInput "busForm.number" "pattern=[A-Za-z]{2}[0-9]{4}[A-Za-z]{2} required" "text"/>
            <br>
            Модель<br><@spring.formInput "busForm.model" "required" "text"/>
            <br>
            Колір<br><@spring.formInput "busForm.color" "required" "text"/>
            <br>
            Водій<br><@spring.formSingleSelect "busForm.driver", drivers, ""/>
            <br>
            Клас кількості пасажирів<br><@spring.formSingleSelect "busForm.passangerClass", passangerClasses, ""/>
            <br>
            Клас комфорту<br><@spring.formSingleSelect "busForm.comfortClass", comfortClases, ""/>
            <br>
            Клас габаритів<br><@spring.formSingleSelect "busForm.overallLength", overallLengths, ""/>
            <br>
            Місця<br><@spring.formInput "busForm.numberOfSeat" "min=1" "number"/>
            <br>
            <br>
            <input type="submit" value="ОК"/>

        </form>
</div>

</body>
</html>