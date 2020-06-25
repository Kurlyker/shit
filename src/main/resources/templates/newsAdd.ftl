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
        .tableAdd textarea:invalid{
            box-shadow: 0 12px 16px 0 rgba(248, 106, 99, 0.24), 0 17px 50px 0 rgb(255, 118, 103);
            animation: 50ms;
        }
        .tableAdd textarea{
            width: 400px;
            height: 200px;
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
        <legend>Створення новини</legend>
        <form name="city" action="" method="POST" class="tableAdd">
            Url фото<br><@spring.formInput "newsForm.photoUrl" "required" "url"/>
            <br>
            Назва<br><@spring.formInput "newsForm.name" "required" "text"/>
            <br>
            <p>Короткий текст</p>
            <@spring.formTextarea "newsForm.minText" "maxlength=180 required"/>
            <br>
            <p>Повний текст</p>
            <@spring.formTextarea "newsForm.allText" "required"/>
            <br>
            <br>
            <input type="submit" value="ОК"/>
        </form>
</div>

</body>
</html>