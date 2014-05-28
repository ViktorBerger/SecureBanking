<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<link href="../css/signin.css" rel="stylesheet">
<script src="../js/jquery-1.11.1.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
	<% String hidden = "";
	if(request.getAttribute("show") == null) 
		hidden = "hidden";
	%>
	
	<div id="message" class="alert alert-danger alert-dismissable <%= hidden %>">
	  <button type="button" class="close" data-dismiss=alert aria-hidden="true">&times;</button>
	  <strong>Error!</strong> Invalid credentials
	</div>


<div class="col-md-4 col-md-offset-4">
    <div id="panel" class="panel panel-default">
  	<div class="panel-heading"><h3 class="panel-title"><strong>Sign in </strong></h3></div>
  		<div class="panel-body">
  		
  		
  		
		<form class="form-signin" method="POST" action="/login">
			
			<div class="input-group">
			<span class="input-group-addon glyphicon glyphicon-user"></span>
			  <input type="username" name="username" class="form-control" placeholder="Username" required autofocus /> 
			</div>
			
			<div class="input-group">
			<span class="input-group-addon glyphicon glyphicon-paperclip"></span>
			  <input type="password" name="password" class="form-control" placeholder="Password" required />
			</div>
			 
			<!-- <label class="checkbox"> <input type="checkbox" value="remember-me">
				Remember me
			</label> -->
			<button id="login" class="btn btn-md btn-primary btn-block" type="submit">Sign
				in</button> 
				
			
			
		</form>

	</div>
	</div>
	</div>
	</div>
	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
</body>


</body>
</html>