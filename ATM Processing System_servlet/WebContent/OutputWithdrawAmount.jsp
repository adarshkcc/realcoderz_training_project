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
<div style=" width:100%;height:700px; background-image:url( ' https://previews.123rf.com/images/winnievinzence/winnievinzence1910/winnievinzence191000010/132940102-abstract-blurred-and-defocused-of-atm-machine-for-withdraw-or-deposit-cash-money-at-bank-office-back.jpg' ); background-repeat:no-repeat;background-size:cover;">

<% double amountWithdrawn=(double)request.getAttribute("amount"); %>
<% double remainingBalance=(double)request.getAttribute("newBalance"); %>
<p align="center"><br>
<button type="button" class="btn btn-info"><h4>Amount Withdrawn :<%=" "+amountWithdrawn%>Rs</h4></button>
</p>
<p align="center"><br>
<button type="button" class="btn btn-info"><h4>Remaining Balance :<%=" "+remainingBalance%>Rs</h4></button>
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