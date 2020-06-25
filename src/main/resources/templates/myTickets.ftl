<#import "spring.ftl" as spring>
<!DOCTYPE HTML>
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate="default">

<style>
    html{
        overflow-y: auto;
        overflow-x: hidden;
    }

    .butt {
        color: #fff !important;
        text-transform: uppercase;
        text-decoration: none;
        background: #CC9900;
        padding: 10px;
        border-radius: 5px;
        display: inline-block;
        border: none;
        transition: all 0.4s ease 0s;
        align: center;
    }

    .butt:hover {
        background: #000000;
        letter-spacing: 1px;
        -webkit-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
        -moz-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
        box-shadow: 5px 5px  rgba(0,0,0,0.57);
        transition: all 0.4s ease 0s;
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
        background-color:  #CC9900;
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
        background: linear-gradient(to bottom, rgba(0, 0, 0, 0.3) 0%, rgba(0, 0, 0, 0.7) 75%, #000000 100%), url("https://img1.goodfon.ru/wallpaper/nbig/a/cb/avtobus-igrushka-makro-fon.jpg");
        background-position: center;
        background-repeat: no-repeat;
        background-attachment: scroll;
        background-size: cover;
        margin-top: -10%;
    }
    @media screen and (max-width: 1366px) {
        html { overflow:  auto; }
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

    .shadow{
        box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
    }

    @media print
    {
        .print-hidden {
            display: none;
        }
        a {
            display: none;
        }
    }
</style>

<head>
    <title>My tickets</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="/home" style="color: #000000; font-weight: bold;">H9 PEOPLE</a><button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">Menu<i class="fas fa-bars"></i></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link js-scroll-trigger"  id="show" style="color: #000000; font-weight: bold;">Меню</a></li>
                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="/logout" style="color: #000000; font-weight: bold;">Вийти</a></li>

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
<div layout:fragment="content" align="center" style="margin-top: 5%">
    <h3>ЗАБРОНЬОВАНІ КВИТКИ</h3>

            <#list tickets as ticket>
                <div  id="${ticket.id}" >
                <table style="width: 80%"  class="shadow"  align="center">
                <thead class="thead-light" style="width: 500px; background-color: #e9ecef" >
                <tr>
                    <th style="margin-left: 10px"><p style="font-size: 25px">${ticket.route.fromCity.name}</p><br>ДАТА ВІДПРАВКИ<br>${ticket.route.dateDeparture}<br><p style="font-size: 25px">${ticket.route.timeDeparture}</p></th>
                    <th><img src="https://www.shareicon.net/data/512x512/2015/11/08/669019_arrows_512x512.png" style="width: 100px; opacity: 70%"><br><br></th>
                    <th><p style="font-size: 25px">${ticket.route.toCity.name}</p><br> ДАТА ПРИБУТТЯ<br>${ticket.route.dateOfArrival}<br><p style="font-size: 25px">${ticket.route.timeOfArrival}</p></th>
                    <th>АВТОБУС:<br>НОМЕР: ${ticket.route.bus.number}<br><br>МОДЕЛЬ: ${ticket.route.bus.model}<br><br>КОЛІР: ${ticket.route.bus.color}<br><br>ВОДІЙ: ${ticket.route.bus.driver.surname} ${ticket.route.bus.driver.name} ${ticket.route.bus.driver.byFather}<br></th>
                    <th style="vertical-align: middle;">НОМЕР БІЛЕТУ<br>${ticket.id}<br></th>
                    <th style="font-size: 25px; vertical-align: middle;">${ticket.route.price}₴‎</th>
                    <th class="noPrint"><button style="background-color:  rgba(255, 255, 255, 0.5); border-color:  rgba(255, 255, 255, 0.5);font-size: 25px;" onclick="printTicket('${ticket.id}')">🖨</button></th>
                    <br>
                </tr>
                </thead>
                </table>
                </div>
                <script>
                    function printTicket(ticketId) {
                        var printContents = document.getElementById(ticketId).innerHTML;
                        var originalContents = document.body.innerHTML;
                        document.body.innerHTML = printContents;
                        window.print();
                        document.body.innerHTML = originalContents;
                       }
                </script>
            </#list>
        </table>
    </div>
</div>

</body>
</html>
