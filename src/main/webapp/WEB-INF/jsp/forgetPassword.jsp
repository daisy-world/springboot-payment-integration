<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <title> Forget Password</title>
</head>
<body>
    

    <div id="forgetPass-forms">

        <div class="container-fluid1">
        <form action="resetPassword" class="form-reset"method="post">
          <input type="hidden" name="email"value="${email}">
                <input type="email" name="emailId" id="resetEmail" class="form-control" placeholder="Email address" value="${email}" disabled style="background-color: #c0c0c0;"><br/>
                 <input type="password" id="user-pass" class="form-control"name = "password" placeholder="Password" required ><br/>
                <input type="password" id="user-repeatpass" class="form-control" name = "newPassword"placeholder="Repeat Password" required><br/>
                
                <button class="btn btn-primary btn-block" type="submit">Reset Password</button>
                <a href="#" id="cancel_signup1"><i class="fas fa-angle-left"></i> Back</a>
                
            </form>
    </div>
    </div>
  
     <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/js/login.js"></script>
    </body>
    </html>