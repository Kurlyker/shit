<#import "spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml" xmlns:layout="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <style>
        html{
            overflow-y: hidden;
            overflow-x: hidden;
        }


        .margin{
            margin-top: 40px;
        }
        .form-city button {
            width: 15%;
            height: calc(1.5em + 0.75rem + 2px);
            border-radius: 5px;
            border-color: darkgrey;
            background-color: white;
            transition-duration: 0.4s;
            float: left;
            margin-left: 15px;
            margin-top: 1px;

        }

        .form-city button:hover {
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
        }

        .form-city input {
            width: 15%;
            height: calc(1.5em + 0.75rem + 2px);
            padding: 0.375rem 0.75rem;
            font-size: 1rem;
            font-weight: 400;
            line-height: 1.5;
            color: rgba(0, 0, 0, 0.91);
            background-color: #fff;
            border: 1px solid #ced4da;
            border-radius: 0.25rem;
            transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
            float: left;
            margin-left: 15px;
            margin-top: 1px;
        }
        .form-city select {
            height: calc(1.5em + 0.75rem + 2px);
            width: 15%;
            padding: 0.375rem 0.75rem;
            font-size: 1rem;
            font-weight: 400;
            line-height: 1.5;
            color: #495057;
            background-color: #fff;
            border: 1px solid #ced4da;
            border-radius: 0.25rem;
            transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
            float: left;
            margin-left: 15px;
            margin-top: 1px;
        }
        .form-city select:first-of-type {
            height: calc(1.5em + 0.75rem + 2px);
            width: 15%;
            padding: 0.375rem 0.75rem;
            font-size: 1rem;
            font-weight: 400;
            line-height: 1.5;
            color: #495057;
            background-color: #fff;
            border: 1px solid #ced4da;
            border-radius: 0.25rem;
            transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
            float: left;
            margin-left: 18%;
            margin-top: 1px;
        }

        .buttMenu {
            color: #fff !important;
            width: 100%;
            text-transform: uppercase;
            text-decoration: none;
            background: none;
            padding: 15px;
            border-radius: 5px;
            display: inline-block;
            border: none;
            transition: all 0.4s ease 0s;
        }

        .buttMenu:hover {
            background: #000000;
            letter-spacing: 1px;
            -webkit-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
            -moz-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
            box-shadow: 5px 5px  rgba(0,0,0,0.57);
            transition: all 0.4s ease 0s;
        }



        #show {
            cursor: pointer;
        }

        .navigation {
            position: fixed;
            width: 300px;
            height: 100%;
            top: 0;
            overflow-y: auto;
            overflow-x: hidden;
            opacity: 0;
            visibility: hidden;
            z-index: 99;
            -webkit-transition-delay: 300ms;
            transition-delay: 300ms;
            left: 0;
        }
        .navigation.active {
            opacity: 1;
            visibility: visible;
            -webkit-transition-delay: 0s;
            transition-delay: 0s;
        }
        .navigation.active .navigation__inner {
            background-color:  #CC9900;

            -webkit-transform: translate(0, 0);
            transform: translate(0, 0);
            -webkit-transition: background-color 0s linear 599ms, -webkit-transform 300ms linear;
            transition: background-color 0s linear 599ms, -webkit-transform 300ms linear;
            transition: transform 300ms linear, background-color 0s linear 599ms;
            transition: transform 300ms linear, background-color 0s linear 599ms, -webkit-transform 300ms linear;
        }
        .navigation.active .navigation__inner:after {
            width: 300%;
            border-radius: 50%;
            -webkit-animation: elastic 150ms ease 300.5ms both;
            animation: elastic 150ms ease 300.5ms both;
        }

        .navigation__inner {
            position: absolute;
            width: 100%;
            height: 100%;
            top: 0;
            left: 0;
            overflow: hidden;
            z-index: 999999;
            -webkit-transform: translate(-100%, 0);
            transform: translate(-100%, 0);
            -webkit-transition: background-color 0s linear 300ms, -webkit-transform 300ms linear;
            transition: background-color 0s linear 300ms, -webkit-transform 300ms linear;
            transition: transform 300ms linear, background-color 0s linear 300ms;
            transition: transform 300ms linear, background-color 0s linear 300ms, -webkit-transform 300ms linear;
        }
        .navigation__inner:after {
            content: '';
            position: absolute;
            width: 0;
            height: 100%;
            top: 0;
            right: 0;
            background-color: #CC9900;
            border-radius: 50%;
            z-index: -1;
            -webkit-transition: all 300ms linear;
            transition: all 300ms linear;
        }

        @-webkit-keyframes elastic {
            0% {
                border-radius: 50%;
            }
            45% {
                border-radius: 0;
            }
            65% {
                border-top-right-radius: 40px 50%;
                border-bottom-right-radius: 40px 50%;
            }
            80% {
                border-radius: 0;
            }
            90% {
                border-top-right-radius: 20px 50%;
                border-bottom-right-radius: 20px 50%;
            }
            100% {
                border-radius: 0;
            }
        }

        @keyframes elastic {
            0% {
                border-radius: 50%;
            }
            45% {
                border-radius: 0;
            }
            65% {
                border-top-right-radius: 40px 50%;
                border-bottom-right-radius: 40px 50%;
            }
            80% {
                border-radius: 0;
            }
            90% {
                border-top-right-radius: 20px 50%;
                border-bottom-right-radius: 20px 50%;
            }
            100% {
                border-radius: 0;
            }
        }


        .masthead {
            position: relative;
            width: 100%;
            height: auto;
            min-height: 35rem;
            padding: 30rem 0;
            margin-top: -10%;
            background: linear-gradient(to bottom, rgba(0, 0, 0, 0.3) 0%, rgba(0, 0, 0, 0.7) 75%, #000000 100%), url("https://img1.goodfon.ru/wallpaper/nbig/a/cb/avtobus-igrushka-makro-fon.jpg");
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: scroll;
            background-size: cover;
        }
        @media screen and (max-width: 1366px) {
            html { overflow:  hidden; }
            .masthead {
                position: relative;
                width: 100%;
                height: auto;
                min-height: 35rem;
                padding: 20rem 0;
                margin-top: -10%;
                background: linear-gradient(to bottom, rgba(0, 0, 0, 0.3) 0%, rgba(0, 0, 0, 0.7) 75%, #000000 100%), url("https://img1.goodfon.ru/wallpaper/nbig/a/cb/avtobus-igrushka-makro-fon.jpg");
                background-position: center;
                background-repeat: no-repeat;
                background-attachment: scroll;
                background-size: cover;
            }
        }

        .masthead h1 {
            font-size: 6.5rem;
            line-height: 6.5rem;
            letter-spacing: 0.8rem;
            font-family: "Varela Round", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
            background: linear-gradient(rgba(255, 255, 255, 0.9), rgba(255, 255, 255, 0));
            -webkit-text-fill-color: transparent;
            -webkit-background-clip: text;
            background-clip: text;
        }
    </style>



</head>
<body style="background-color: black">

<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="/home" style="color: #ffffff; font-weight: bold;">H9 PEOPLE</a><button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation" >Menu<i class="fas fa-bars"></i></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link js-scroll-trigger"  id="show" style="color: #ffffff; font-weight: bold;">Меню</a></li>
                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="/logout" style="color: #ffffff; font-weight: bold;">Вийти</a></li>

            </ul>
        </div>
    </div>
</nav>



<div id="nav" class="navigation" style="opacity: 80%">
    <div class="navigation__inner" >
        <div class="navigation__inner" style="margin-top: 50%">
            <a href="/dashboard"><button class="buttMenu">ПОШУК МАРШРУТІВ</button></a>
            <br>
            <a href="/ticket/myTickets"><button class="buttMenu">МОЇ КВИТКИ</button></a>
            <br>
            <a href="/news"><button class="buttMenu">НОВИНИ</button></a>
            <br>
            <a href="/help/create"><button class="buttMenu">ПИТАННЯ ДО ПІДТРИМКИ</button></a>
        </div>
    </div>
</div>
<script>
    var btn = document.getElementById('show');
    var nav = document.getElementById('nav');

    btn.addEventListener('click', function() {
        nav.classList.toggle('active');
    });
</script>
<br/>
<center>
<div class="masthead">
    <h1>Пошук рейсу</h1>
    <div>
        <div align="center">
        <p style="color: white; float: left; width: 15%; margin-left: 18%; white-space: nowrap; margin-bottom: 1px;" >Місто відправлення:</p>
        <p style="color: white; float: left; width: 15%; margin-left: 15px; margin-bottom: 1px;">Місто прибуття:</p>
        <p style="color: white; float: left; width: 15%; margin-left: 15px; margin-bottom: 1px;">Дата:</p>
            <br><br>
        </div>
        <div align="center">
            <form name="create" action="" method="POST" class="form-city" >
            <@spring.formSingleSelect "routeForm.fromCity", cities, ""/>
            <@spring.formSingleSelect "routeForm.toCity", cities, ""/>
            <@spring.formInput "routeForm.dateDeparture" "" "date"/>
            <a href="/find"><button type="submit">Знайти</button></a>
        </form>
        </div>
            <p style="color: red; margin-top: 50px; font-size: 30px; font-weight: bold;filter: drop-shadow(0 0 5px rgba(62,0,0,0.8));" align="center" >${message}</p>
    </div>
</div>
</center>
</body>
</html>