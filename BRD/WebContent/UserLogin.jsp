<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

<style>
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


.container {
    padding: 16px;
}

span.pass {
    float: right;
    padding-top: 16px;
}


@media screen and (max-width: 300px) {
    span.pass {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>

</head>

<body>
<center>

<form action="UserController" method="post">
 <h1> Welcome To The Login Page</h1>
  <div class="container">
    <label for="user"><b>User name</b></label>
    <input type="text" placeholder="Enter Username" name="user" required>

    <label for="pass "><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="pass" required>
        
    <button type="submit" name="hello" value="Submit">Submit</button>
   
  </div>

</form>
</center>
</body>
</html>
