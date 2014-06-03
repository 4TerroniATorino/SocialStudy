<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" type="text/css" href="css/calendar.css" />
<link rel="stylesheet" type="text/css" href="css/custom_2.css" />
<script src="js/modernizr.custom.63321.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.calendario.js"></script>
<script type="text/javascript">

    $(function() {
        var codropsEvents = {
            <c:forEach var="incontro" items="${incontri}">
                '<fmt:formatDate pattern="MM-dd-yyyy" value="${incontro.data}" />':
                '${incontro.argomento}|${incontro.gruppo.id}|${incontro.gruppo.nome}|${incontro.location.id}|${incontro.location.descrizione}'
            </c:forEach>
        };

        var transEndEventNames = {
            'WebkitTransition': 'webkitTransitionEnd',
            'MozTransition': 'transitionend',
            'OTransition': 'oTransitionEnd',
            'msTransition': 'MSTransitionEnd',
            'transition': 'transitionend'
        },
        transEndEventName = transEndEventNames[ Modernizr.prefixed('transition') ],
                $wrapper = $('#custom-inner'),
                $calendar = $('#calendar'),
                cal = $calendar.calendario({
                    onDayClick: function($el, $contentEl, dateProperties) {

                        if ($contentEl.length > 0) {
                            showEvents($contentEl, dateProperties);
                        }

                    },
                    caldata: codropsEvents,
                    displayWeekAbbr: true
                }),
                $month = $('#custom-month').html(cal.getMonthName()),
                $year = $('#custom-year').html(cal.getYear());

        $('#custom-next').on('click', function() {
            cal.gotoNextMonth(updateMonthYear);
        });
        $('#custom-prev').on('click', function() {
            cal.gotoPreviousMonth(updateMonthYear);
        });

        function updateMonthYear() {
            $month.html(cal.getMonthName());
            $year.html(cal.getYear());
        }

        // just an example..
        function showEvents($contentEl, dateProperties) {

            hideEvents();

            var $events = $('<div id="custom-content-reveal" class="custom-content-reveal"><h4>Events for ' + dateProperties.monthname + ' ' + dateProperties.day + ', ' + dateProperties.year + '</h4></div>'),
                $close = $('<span class="custom-content-close"></span>').on('click', hideEvents);

            $events.append($contentEl.html(), $close).insertAfter($wrapper);

            setTimeout(function() {
                $events.css('top', '0%');
            }, 25);

        }
        function hideEvents() {

            var $events = $('#custom-content-reveal');
            if ($events.length > 0) {

                $events.css('top', '100%');
                Modernizr.csstransitions ? $events.on(transEndEventName, function() {
                    $(this).remove();
                }) : $events.remove();

            }

        }

    });
</script>

<div class="jumbotron">
    <div class="container">

        <div class="row">


            <!-- bottoni per l'interazione -->
            <div class="col-sm-2">
                <%
                    if (request.getAttribute("incontro") != null) {
                        out.print("incontro");
                        //<c:out value="${person.nome} ${person.cognome}"/c:out>;
                    } else if (request.getAttribute("incontri") != null) {
                        out.print("lista incontri");
                    }
                %>


                <form method="post" action ="Meetings">
                    <input type="hidden" name="op" value="modMeeting">
                    <input type="submit" class="btn btn-primary btn-lg" value="Modifica">
                </form>
                <form method="post" action ="Meetings">
                    <input type="hidden" name="id" value="${incontro.id}%>">
                    <input type="hidden" name="op" value="delMeeting">
                    <input type="submit" class="btn btn-primary btn-lg" value="Cancella">
                </form>
            </div>


            <!-- calendario -->
            <div class="col-sm-6">
                <section class="main">
                    <div class="custom-calendar-wrap">
                        <div id="custom-inner" class="custom-inner">
                            <div class="custom-header clearfix">
                                <nav>
                                    <span id="custom-prev" class="custom-prev"></span>
                                    <span id="custom-next" class="custom-next"></span>
                                </nav>
                                <h2 id="custom-month" class="custom-month"></h2>
                                <h3 id="custom-year" class="custom-year"></h3>
                            </div>
                            <div id="calendar" class="fc-calendar-container"></div>
                        </div>
                    </div>
                </section>

            </div>




            <!-- info sull'incontro selezionato nel calendario -->
            <div class="col-sm-4">
                ...
            </div>



        </div>

        <h2>Incontro</h2>

    </div>
</div>


