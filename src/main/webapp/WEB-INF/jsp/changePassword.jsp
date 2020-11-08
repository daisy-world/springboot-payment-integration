

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

<!------ Include the above in your HEAD tag ---------->
</head>

<body>



<div id="wrapper">
   <jsp:include page="navbar.jsp"/>

    <div id="page-wrapper">
        <div class="container-fluid">
            <!-- Page Heading -->
            <div class="row" id="main" >
                <div class="col-sm-10 col-md-10 well" id="content">
               <form action = "resetPassword" method = "post">
               <div class="col-sm-10">
               <div class = "col-sm-5">
               <label>Enter your email</label>
               </div>
               <div class = "col-sm-5">
               <input type="email" id="user-email" class="form-control"name = "email" placeholder="Email address" required >
               </div>
               </div><br/><br/><br/>
               <div class="col-sm-10">
                <div class = "col-sm-5">
               <label>Enter your current password</label>
               </div>
               <div class = "col-sm-5">
                <input type="password" id="user-pass" class="form-control"name = "password" placeholder="Current Password" required >
               </div>
               </div><br/><br/><br/>
               <div class="col-sm-10">
                  <div class = "col-sm-5">
               <label>Enter your new password</label>
               </div>
               <div class = "col-sm-5">
                <input type="password" id="user-repeatpass" class="form-control" name = "newPassword"placeholder="New Password" required>
               </div>
               </div><br/><br/><br/>
                <div class = "col-sm-11">
               <center>
            <button class="btn btn-primary" type="submit">Change Password</button>
              </center>
              </div>
               </form>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
</div><!-- /#wrapper -->



</body>
</html>

