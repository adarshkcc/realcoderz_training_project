<%@ page language="java"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<style type="text/css">
td{border:1px solid black;}
</style>
</head>
<body>
<div style=" width:100%;height:700px; background-image:url( ' https://previews.123rf.com/images/winnievinzence/winnievinzence1910/winnievinzence191000010/132940102-abstract-blurred-and-defocused-of-atm-machine-for-withdraw-or-deposit-cash-money-at-bank-office-back.jpg' ); background-repeat:no-repeat;background-size:cover;">

<% ArrayList<Double> amountWithdrawn=(ArrayList<Double>)request.getAttribute("WithdrawalList"); 
ArrayList<Double> remainingBalance=(ArrayList<Double>)request.getAttribute("remainingBalanceList"); 
ArrayList<Character> characterList=(ArrayList<Character>)request.getAttribute("characterList");

if(amountWithdrawn.isEmpty())
{
	%>
	<p align="center"><br><br><br><br><br>
<button type="button" class="btn btn-info"><h3><strong>YOU HAVE NOT DONE ANY TRANSACTION</strong></h3></button>
</p>
<% 
}
else
{
	//Itetrator<Double> itr=amountWithdrawn.iterator();
	//Itetrator<Double> itr=amountWithdrawn.iterator();
	%>
	<p align="center"><br>
	<table align="center" style="width:50%"; border:1px solid black;>
<% 	for(int i=0;i<amountWithdrawn.size();i++)
	{
		%>
		
          <% if(characterList.get(i)=='w') 
          {%>
		
		<tr>
		<td><b><i>Amount Withdrawn</i></b></td><td><%=amountWithdrawn.get(i) %>Rs</td>
		</tr>
		<tr>
		<td><b><i>Remaining Balance</i></b></td><td><%=remainingBalance.get(i) %>Rs</td>
		</tr>
		
		
	<% 
          }
          else
          {%>
        	  <tr>
      		<td><b><i>Amount Transfered</i></b></td><td><%=amountWithdrawn.get(i) %>Rs</td>
      		</tr>
      		<tr>
      		<td><b><i>Remaining Balance</i></b></td><td><%=remainingBalance.get(i) %>Rs</td>
      		</tr>
      		
         <% }
          }%></table></p>
<% }
%>



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