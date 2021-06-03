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

<div style= "  width:100%;height:700px ; background:url('https://previews.123rf.com/images/maxkabakov/maxkabakov1508/maxkabakov150802528/44327400-money-concept-pixelated-blue-text-atm-on-digital-wall-background-with-currency.jpg'); background-repeat:no-repeat;background-size:cover; display:flex;justify-content:center;align-items:center;"   > 
<div >
<% String s=(String)request.getAttribute("name");

if(s==null)
{
%>
<script type="text/javascript">
alert("invalid pin");
</script>
<form action="MyServlet" method="post">

<div class="input-group mb-3">
  <input type="text" class="form-control" placeholder="Enter the pin" aria-label="Recipient's username" aria-describedby="basic-addon2" name="pin">
  <span ><button type="submit" class="btn btn-danger">Enter </button></span>
</div>
</form>
<% } 
else
{%>
	<form action="MyServlet" method="post">

	<div class="input-group mb-3">
	  <input type="text" class="form-control" placeholder="Enter the pin" aria-label="Recipient's username" aria-describedby="basic-addon2" name="pin">
	  <span ><button type="submit" class="btn btn-danger">Enter </button></span>
	</div>
	</form>
<% }%>




</div>
</div>
</body>
</html>