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
    </head>
    <body>
        <div class="jumbotron">
            <div class="container">
                <h1>Benvenuto in SocialStudy</h1>
                <p>Entra con:</p>
                 <p>
                    <a href="https://studisocial.appspot.com/auth/google">Google</a>
                    <a href="https://studisocial.appspot.com/auth/facebook">Facebook</a>
                </p><p><a class="btn btn-primary btn-lg">Learn more &raquo;</a></p>
            </div>
        </div>

        <hr>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
