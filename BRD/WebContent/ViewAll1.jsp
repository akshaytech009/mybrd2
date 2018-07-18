<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>

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

 

table, th, td 
{
	width: 100%; 
    background-color: #f1f1c1;
    border: 1px solid black;
}

</style>
<title>View All Data</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setHeader("Expires", "0");
/* CustService cs=new CustService();
List<Customer> list =cs.ViewAll(); */  
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


<table id="example" class="table table-hover" >
<thead>
<tr>
<th scope="col">Customer Code:</th>
<th scope="col">Customer Name</th>
<th scope="col">Address Line 1</th>
<th scope="col">Address Line2</th>
<th scope="col">Pincode</th>
<th scope="col">Email</th>
<th scope="col">Contact</th>
<th scope="col">Contact Person</th>
<th scope="col">Record Status</th>
<th scope="col">Flag</th>
<th scope="col">Create Date</th>
<th scope="col">Created By</th>
<th scope="col">Modified Date</th>
<th scope="col">Modified By</th>
<th scope="col">Authorized Date</th>
<th scope="col">Authorized By</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="cust"> 
<tr>
<td>${fn:escapeXml(cust.code)}</td>
<td>${fn:escapeXml(cust.name)}</td>
<td>${fn:escapeXml(cust.address1)}</td>
<td>${fn:escapeXml(cust.address2)}</td>
<td>${fn:escapeXml(cust.pincode)}</td>
<td>${fn:escapeXml(cust.email)}</td>
<td>${fn:escapeXml(cust.contact)}</td>
<td>${fn:escapeXml(cust.pcp)}</td>
<td>${fn:escapeXml(cust.record)}</td>
<td>${fn:escapeXml(cust.flag)}</td>
<td>${fn:escapeXml(cust.createDate)}</td>
<td>${fn:escapeXml(cust.createdBy)}</td>
<td>${fn:escapeXml(cust.modifiedDate)}</td>
<td>${fn:escapeXml(cust.modifiedBy)}</td>
<td>${fn:escapeXml(cust.authorizedDate)}</td>
<td>${fn:escapeXml(cust.authorizedBy)}</td>
</tr>
</c:forEach>
</tbody>
</table>
<!-- <h3><a href="Viewall.jsp"><b>Return To Home</b></a></h3> -->
</body>
<script src="https://code.jquery.com/jquery-1.12.4.js" type="text/javascript"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js" type="text/javascript"></script>

<script>
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>
</html>