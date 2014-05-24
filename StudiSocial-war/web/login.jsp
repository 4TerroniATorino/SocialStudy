<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
    <head>
        <title>Login</title>
        <meta name="description" content="">
        <jsp:include page="includes.jsp"></jsp:include>
        <link rel="stylesheet" href="css/typica-login.css">
        <link rel="stylesheet" href="css/social-login-buttons.css">
    </head>
    <body>

        <div class="container">

            <div id="login-wraper">
                <form class="form login-form">
                    <h1>Social Study</h1><br>
                    <p><em>Il network intelligente per la tua università</em><p><br><br>
                    <div>
                        <a href="https://studisocial.appspot.com/auth/facebook" class='btn fb reverse'>
                            Accedi <span>con facebook</span>
                        </a>
                        <a href="https://studisocial.appspot.com/auth/google" class='btn gp reverse'>
                            Accedi <span>con google+</span>
                        </a>
                    </div>

                </form>
            </div>

        </div>


        <!-- Le javascript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/backstretch.min.js"></script>
        <script>
            jQuery(document).ready(function($) {

                $.backstretch([
                    "img/login/bg1.png",
                    "img/login/bg2.png"
                ], {duration: 3000, fade: 750});

            });
        </script>

        <div class="backstretch" style="left: 0px; top: 0px; overflow: hidden; margin: 0px; padding: 0px; height: 725px; width: 1440px; z-index: -999999; position: fixed;">
            <img src="img/login/bg1.png" style="position: absolute; margin: 0px; padding: 0px; border: none; width: 1440px; height: 809.6046852122987px; max-width: none; z-index: -999999; left: 0px; top: -67.30234260614935px;">
        </div>
    </body>
</html>