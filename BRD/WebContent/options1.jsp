<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Navigation Bar</title>
<% 
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

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

<!--  <form action="CustController" method="get">
<h1>Choose Option:</h1>
<input type="radio" name="button" value="insert"/>Insert
<input type="radio" name="button" value="update"/>Update
<input type="radio" name="button" value="delete" />Delete
<input type="radio" name="button" value="retrieve"/>Retrieve
<input type="radio" name="button" value="ViewAll"/> ViewAll
<input type="submit" name="button" value="LogOut"/><br>
<br>
<input type="submit" value="Submit"/>
</form> -->

</body>
</html>