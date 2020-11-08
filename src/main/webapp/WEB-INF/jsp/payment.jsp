

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
                
      <form action="payment-form" class="form-reset"method="post">
          <input type="hidden" name="email"value="${email}">
                    <div class="col-sm-8">
               <div class = "col-sm-4">
               <label>Enter customer email</label>
               </div>
               <div class = "col-sm-4">
               <input type="email" id="customer-email" class="form-control"name = "customer-email" required >
               </div>
               </div><br/><br/><br/>
               <div class="col-sm-8">
                <div class = "col-sm-4">
               <label>Enter payment amount</label>
               </div>
               <div class = "col-sm-4">
                <input type="number" id="amount" class="form-control"name = "amount" required >
               </div>
               </div><br/><br/><br/>
                <button class="btn btn-primary btn-block" type="submit">Make Payment</button>
                
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

