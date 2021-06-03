<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<div style=" width:100%;height:800px; background-image:url( 'check.jpg' ); background-repeat:no-repeat;background-size:cover;">

<% double balance=(double)request.getAttribute("amount"); %>

<br><br><br><br><br><br><br><br><br>
<p align="center">
<button type="button" class="btn btn-info"><h4>Your Account Balance is :<%=" "+balance%>Rs</h4></button>
</p>

<div style=" margin:10%;display:flex;justify-content:center;align-items:center;">





<form action="MyServlet" method="post">
<p>
<button type="submit" class="btn btn-danger" name="continue" value="continue"><strong>CONTINUE</strong></button>

<button type="submit" class="btn btn-success" name="exit" value="exit"><strong> EXIT</strong></button>

</p>
</form>
</div>
</div>
</body>
</html>