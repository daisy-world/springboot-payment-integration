

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
                <div class="col-sm-12 col-md-12 well" id="content">
                
                <p class="">
               <button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#addUserModal"><i class="fas fa-user-plus ml-2"> Add User </i></button> 
               </p>
                  <table class="table table-striped">
    <thead>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Role</th>
        <th>Status</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    
     <c:forEach items="${users}" var="item">
     
       <tr>
        <td>${item.first_name}</td>
        <td>${item.last_name}</td>
        <td>${item.email}</td>
        <td>${item.role}</td>
        <td>Active</td>
        <td>
        <span><i class="fa fa-edit"></i></span>
        <span><i class="fa fa-trash"></i></span>
        </td>
      </tr>
     </c:forEach>
    
    </tbody>
  </table>
                </div>
            </div>
            <!-- /.row -->
                <!-- add user modal -->
<div id="addUserModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add User</h4>
      </div>
      <div class="modal-body">
      <form action="addUser" class="form-signup" method="post">
      
       <input type="text" id="first-name" class="form-control" name = "firstName" placeholder="First name" required>
        <input type="text" id="last-name" class="form-control" name = "lastName" placeholder="Last name" required>
        <input type="email" id="user-email" class="form-control"name = "userEmail" placeholder="Email address" required >
        <input type="password" id="user-pass" class="form-control"name = "userPass" placeholder="Password" required >
         <input type="password" id="user-repeatpass" class="form-control" name = "userConfirmPass"placeholder="Repeat Password" required>

       <button class="btn btn-primary" type="submit"> Submit</button>
       </form>
    
      </div>
                 
    </div>

  </div>
</div>

    <!-- end of add user modal -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
    


</div><!-- /#wrapper -->





</body>
</html>

