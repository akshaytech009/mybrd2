<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Choice</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
	.bs-example{
    	margin: 20px;
    }
  body
{
background:url('http://jualbeli-laptopbekas.com/wp-content/uploads/2016/12/web-designer-pune-background.jpg');
background-size:cover;
}
  
</style>

	<%-- <%@page errorPage="errorpage.jsp"  %>
	<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session.getAttribute("name")==null)
	response.sendRedirect("Login.jsp");%>
	 --%>
</head>
<body>
<div class="bs-example">
    <nav id="myNavbar" class="navbar navbar-default" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><b>Welcome ${name} <b></a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                  <!--   <li><a href="entry1.jsp">Insert</a></li>
                    <li><a href="Update1.jsp">Update</a></li>
                    <li><a href="delete.jsp">Delete</a></li>
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Retreive <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="Retreive1.jsp">Single Retreive </a></li>
                            <li><a href="ViewAll.jsp">All Retreive</a></li> -->
<!--                             <li><a href="#">Sent Items</a></li> -->
<!--                             <li class="divider"></li> -->
<!--                             <li><a href="#">Trash</a></li> -->
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Admin <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="Logout.jsp">Logout</a></li>
<!--                             <li><a href="#">Another action</a></li> -->
<!--                             <li class="divider"></li> -->
<!--                             <li><a href="#">Settings</a></li> -->
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div>
    </nav>
</div>
</body>
</html>                         