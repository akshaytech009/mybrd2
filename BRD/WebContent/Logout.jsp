<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout page</title>
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
</style>


</head>
<body>

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
<h2>Are you sure you want to log out?</h2>
<input type="submit" name="button1" value="logout" >
</center>
</form>
</body>
</html>