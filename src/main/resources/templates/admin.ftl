<!DOCTYPE html>
<html lang="en">
<style>


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
        background-color: #CC9900;

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
        padding: 25rem 0;
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
        padding: 25rem 0;
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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body style="background-color: black">
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="/home" style="color: #ffffff; font-weight: bold;">H9 PEOPLE</a><button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">Menu<i class="fas fa-bars"></i></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link js-scroll-trigger"  id="show" style="color: #ffffff; font-weight: bold;">Меню</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="/logout" style="color: #ffffff; font-weight: bold;">Вийти</a></li>

            </ul>
        </div>
    </div>
</nav>

<header class="masthead">
    <div class="container d-flex h-100 align-items-center">
        <div class="mx-auto text-center">
            <h1 class="mx-auto my-0 text-uppercase">H9 PEOPLE</h1>
        </div>
    </div>
</header>






<div id="nav" class="navigation" style="opacity: 80%">
    <div class="navigation__inner" >
                        <div class="navigation__inner" style="margin-top: 30%">
                        <a href="/web/bus/list"><button class="buttMenu">АВТОБУСИ</button></a>
                        <br>
                        <a href="/web/comfortClass/list"><button class="buttMenu">КЛАСИ КОМФОРТУ</button></a>
                        <br>
                        <a href="/web/passangerClass/list"><button class="buttMenu">КЛАСИ МІСТКОСТІ ПАСАЖИРІВ</button></a>
                        <br>
                        <a href="/web/overallLength/list"><button class="buttMenu">КЛАСИ ГАБАРИТНОЇ ДОВЖИНИ</button></a>
                        <br>
                        <a href="/web/driver/list"><button class="buttMenu">ВОДІЇ</button></a>
                        <br>
                        <a href="/web/user/list"><button class="buttMenu">КОРИСТУВАЧІ</button></a>
                        <br>
                        <a href="/web/city/list"><button class="buttMenu">МІСТА</button></a>
                        <br>
                        <a href="/web/route/list"><button class="buttMenu">МАРШРУТИ</button></a>
                        <br>
                        <a href="/web/news/list"><button class="buttMenu">НОВИНИ</button></a>
                        <br>
                        <a href="/support/list"><button class="buttMenu">ПІДТРИМКА</button></a>
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
</body>
</html>