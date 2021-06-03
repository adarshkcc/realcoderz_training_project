<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body >


<div style= "  width:100%;height:700px ; background:url('https://previews.123rf.com/images/giggsy25/giggsy251704/giggsy25170400148/76560706-cctv-security-camera-on-blurred-background-of-atm-machine-for-withdraw-or-deposit-cash-money-securit.jpg'); background-repeat:no-repeat;background-size:cover; display:flex;justify-content:center;align-items:center;"   > 
<div >



<div class="input-group mb-3">
<form action="MyServlet" method="post">
<input type="text" class="form-control" placeholder="Enter the Account No." aria-label="Recipient's username" aria-describedby="basic-addon2" name="accountNumber">
<br> <input type="text" class="form-control" placeholder="Enter the Amount" aria-label="Recipient's username" aria-describedby="basic-addon2" name="transferAmount">
 <br> 
 <div class="spinner-border text-danger" role="status">
  <span class="visually-hidden"></span>
</div>
 <span ><button type="submit" class="btn btn-info"><b><i>Click Me</i> </b></button></span>
<div class="spinner-border text-danger" role="status">
  <span class="visually-hidden"></span>
</div>
</form>
</div>



</div>
</div>


</body>


</body>
</html>