<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<style type="text/css">
button:hover{
transition: All 1s;
transform: scale(1.1);
}
</style>
</head>
<body>

<div style=" width:100%;height:800px ;background-image:url('check.jpg'); background-repeat:no-repeat;background-size:cover;">

<% String s=(String)request.getAttribute("name"); %>
<p align="center"><br>
<button type="button" class="btn btn-outline-danger"><h3>Welcome <%=" "+s%></h3></button>

<div style=" margin:10%;display:flex;justify-content:center;align-items:center ;">



<form action="MyServlet" method="post">
<p>
<button type="submit" class="btn btn-info" name="withdrawAmount" value="withdrawAmount" ><strong>WITHDRAW AMOUNT</strong></button>
<p>
<button type="submit" class="btn btn-success" name="checkBalance" value="checkBalance"><strong> CHECK BALANCE</strong></button>
<p>
<button type="submit" class="btn btn-danger"name="transferAmount"value="transferAmount"><strong>TRANSFER AMOUNT</strong></button>
<p>
<button type="submit" class="btn btn-warning"name="transactionHistory"value="transactionHistory"><strong> TRANSACTION HISTORY</strong></button>
<p>
<button type="submit" class="btn btn-primary" name="exit" value="exit"><STRONG>EXIT</STRONG></button>

</form>

</div>
</div>
</body>
</html>