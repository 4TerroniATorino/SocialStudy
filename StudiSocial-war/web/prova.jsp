<!DOCTYPE html>
<!-- saved from url=(0050)http://tarruda.github.io/bootstrap-datetimepicker/ -->
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Date/Time Picker for Twitter Bootstrap">
    
    <meta name="author" content="Thiago de Arruda">
    <title>Bootstrap Date/Time Picker</title>
    <!--[if lt IE 9]>
      <script src="http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.1.0/respond.min.js"></script>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css"/>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="js/vendor/bootstrap.min.js"></script>
<script src="js/moment.js" type="text/javascript"></script>
<script src="js/bootstrap-datetimepicker.js" type="text/javascript"></script>
<script src="js/locales/bootstrap-datetimepicker.it.js" type="text/javascript"></script>
  </head>

  <body>
  <div class="container">
    <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker({
                    language: 'it'
                });
            });
        </script>
    </div>
</div>