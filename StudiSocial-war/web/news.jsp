<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
    #welcome-logo {
        width: 200px;
        height: 200px;
    }
    #news-image {
        max-width: 200px;
        max-height: 200px;
    }
</style>

<div class="container">
    <div class="jumbotron">
        <div class="row clearfix">
            <div class="col-md-3 column">
                <img id="welcome-logo" src="img/logo1024.png" alt=""/>
            </div>
            <div class="col-md-9 column">
                <h1 class="lead">Benvenuto in Social Study</h1>
                <p>
                    Social Study è il network intelligente per la tua università. E Gianvito Siciliano è invitato a 
                    scrivere un paio di righe qui su cazzi e mazzi :D
                </p>
            </div>
        </div>
    </div>
    
    <div class="jumbotron">
        <h2>Ultime notizie</h2>
        <br>
        <div class="well">
            <div class="row clearfix">
                <div class="col-md-3 column">
                    <img id="news-image" src="data/news/02.jpg" alt=""/>
                </div>
                <div class="col-md-8 column">
                    <h3>SocialStudy parteciperà ad <a href="http://www.hackunito.it/">#hackUnito!</a></h3>
                    <p>
                        Il progetto SocialStudy è stato iscritto come partecipante all'evento...
                    </p>
                </div>
            </div>
        </div>
        <div class="well">
            <div class="row clearfix">
                <div class="col-md-3 column">
                    <img id="news-image" src="data/news/01.png" alt=""/>
                </div>
                <div class="col-md-8 column">
                    <h3>Il sito di SocialStudy è online!</h3>
                    <p>
                        Il sito web del progetto SocialStudy è finalmente online grazie al servizio di hosting gratuito Openshift.
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>