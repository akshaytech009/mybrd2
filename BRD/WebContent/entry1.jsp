<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User Page</title>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
if(session.getAttribute("user")==null)
	{
	   response.sendRedirect("UserLogin.jsp");
	}
	%>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

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


.h1{
		text-align: center;
		font-family: Arial Black;
	}
	.custom-container{
		width: 600px;
		background-color: #6e4a6f; 
		padding: 20px;
		margin-top: 100px;
		border-style: solid;
    	border-width: 5px;
    	border-radius: 10px;
    	border-color:black;
    	text-shadow: 3px 3px 2px rgba(122, 122, 122, 0.5);
    	color: White;
    	Background-color: #3498DB;
	} 
</style>

<script type = 'text/javascript'>

	function chkfrm(){
		
		var code = document.addform.code.value;
		var name = document.addform.name.value;
		var address1 = document.addform.address1.value;
		var pincode = document.addform.pincode.value;
		var email = document.addform.email.value;
		var pcp = document.addform.pcp.value;
		var contact=document.addform.contact.value;
		var name_regex = /^[a-zA-Z0-9\\s]+/;
		var email_regex = /^(.+)@(.+)$/;
		var pincode_regex = /^[0-9]/;
		
		if(code.length > 0){
			if(name.length > 0 && name.match(name_regex)){
				if(address1.length > 0){
					if(pincode.length == 6 && pincode.match(pincode_regex)){
						if(email.length > 0 && email.match(email_regex)){
							if(pcp.length > 0){
								if(contact.length==10){
								  return true;
							}
								else
									{
									alert("Contact Number invalid");
									return false;
									}
									}
							else
							{
								alert("Primary contact person cannot be blank");
								return false;
							}
						}
						else{
							alert("Please enter valid email");
							return false;
						}
					}
					else{
						alert("Please enter valid pincode");
						return false;
					}
				}
				else{
					alert("Address1 cannot be blank");
					return false;
				}
			}
			else{
				alert("Please enter valid Name");
				return false;
			}
		}
		else{
			alert("Customer Code cannot be blank");
			return false;
		}
	}
	
</script>
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
	
	
	
	<div class ="container">
	<div class="row">
	<div class="col-md-6 col-md-offset-3">
	<div class="custom-container">
	<h1 class= "h1">Enter Details</h1>
	
	<form name="addform" method = "post" action = "CustController" onsubmit ="return chkfrm();">
	
  	<div class="form-group">
    	<label for="exampleInputEmail1">Customer Code</label>
    	<input type="text" class="form-control" id="exampleInputEmail1" placeholder="Customer Code" name = "code">
  	</div>
  	<div class="form-group">
    	<label for="exampleInputEmail1">Name</label>
    	<input type="text" class="form-control" id="exampleInputEmail1" placeholder="Name" name = "name">
  	</div>
  	<div class="form-group">
  		<label for="comment">Address1</label>
  		<textarea class="form-control" rows="5" id="comment" name = "address1"></textarea>
	</div>
  	<div class="form-group">
  		<label for="comment">Address2</label>
  		<textarea class="form-control" rows="5" id="comment" name = "address2"></textarea>
	</div>
  	<div class="form-group">
    	<label for="exampleInputEmail1">Pin Code</label>
    	<input type="text" class="form-control" id="exampleInputEmail1" placeholder="Pin Code" name = "pincode">
  	</div>
  	<div class="form-group">
    	<label for="exampleInputEmail1">Email</label>
    	<input type="text" class="form-control" id="exampleInputEmail1" placeholder="Email" name = "email">
  	</div>
  	<div class="form-group">
    	<label for="exampleInputEmail1">Contact</label>
  		<input type="text" class="form-control" id="exampleInputEmail1" placeholder="Contact" name = "contact">
  	</div>
  	<div class="form-group">
    	<label for="exampleInputEmail1">Primary Contact Person</label>
    	<input type="text" class="form-control" id="exampleInputEmail1" placeholder="Primary Contact Person" name = "pcp">
  	</div>
  	<select name="dropdown" style="color: #000000;">
  			<option value="A">Active</option>
  			<option value="I">Inactive</option>
		</select><br><br>
  	
  	<div style="text-align:center">
	<input name = "button1" type="submit" class="btn btn-success" value = "insert"/>
	</div>
	
	</form>
	</div>
	</div>
	</div>
	</div>
	<script   src="undefined/jquery-3.1.1.min.js"   integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="   crossorigin="anonymous"></script> 

	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</body>
</html>

