<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retrieve Page</title>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
if(session.getAttribute("user")==null)
	{
	   response.sendRedirect("UserLogin.jsp");
	}
	%>


<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #6e4a6f;
}

li {
    float: left;
    border-right:1px solid #bbb;
}

li:last-child {
    border-right: none;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #511765;
}

.active {
    background-color: #9e26c7;
}

body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 10px 0;
    display: inline-block;
    border: 2px solid #ccc;
    box-sizing: border-box;
}


button {
    background-color: #6e4a6f;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}
</style>


</head>
<body>
<% 
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
if(session.getAttribute("user")==null)
	{
	   response.sendRedirect("UserLogin.jsp");
	}
	%>

 <form action="CustController" method="get">
<ul>
  <li><a class="active" href="entry1.jsp" >Insert</a></li>
  <li><a href="Update1.jsp" >Update</a></li>
  <li><a href="delete.jsp" >Delete</a></li>
  <li><a href="Retrieve1.jsp" >Retrieve</a></li>
   <li><a href="CustController?button=ViewAll" >ViewAll</a></li>
    <li style="float:right"><a href="Logout.jsp">Logout</a></li>
</ul>
</form>



<form action="CustController" method="post">
<center>
 <h1> Welcome To The Retrieve Page</h1>
  <div class="container">
    <label for="code"><b>Enter the customer code to retrieve data</b></label>
    <input type="text" placeholder="Enter Code" name="code" required>

    <button type="submit" name="button1" value="Retrieve" >Submit</button>
  
  </div>
</center>
</form>








<!-- <center>
<form action="CustController" method="post">
<h2> Enter the customer code to retrieve data </h2>
<input type="text" name="code"/><br>
<input type="submit" name="button1" value="Retrieve"/>
</form>


</center> -->

</body>
</html>

































<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="CustController" method="post">
<h2> Enter the customer code to retrieve data </h2>
<input type="text" name="code"/><br>
<input type="submit" name="button1" value="Retrieve"/>
</form>


</center>

</body>
</html> -->