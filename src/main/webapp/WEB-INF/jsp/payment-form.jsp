
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">

<!------ Include the above in your HEAD tag ---------->
</head>

<body>



	<div id="wrapper">
		<jsp:include page="navbar.jsp" />

		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row" id="main">
					<div class="col-sm-12 col-md-12 well" id="content">

						<div class="card">
							<center>
								<h3>Pay with new card</h3>
							</center>
							<form action="" method="" id="payment-form">
					<%--  <input type="hidden" id="customer-email" class="form-control"name = "customer-email" value = "${customerEmail}" >
				  <input type="hidden" id="user-email" class="form-control"name = "user-email"  value = "${userEmail}">
				  <input type="hidden" id="amount" class="form-control"name = "amount" value = "${amount}" >
					 --%> 
				  <input type="hidden" id="secretId" class="form-control"name = "secretId" value = "${clientSecret}" >

								<span id="stripe-error"></span>

								<div id="card-element"></div>


								<div
									style="margin: 0 auto; max-width: 400px; box-sizing: border-box; padding: 0 5px">
									<div style ="margin-left: -335px;">
										<br /> <input type="checkbox" id="remember" name="remember"
											type="checkbox" /> <label for="remember"><span>Remember
										</span></label>
									</div>

									<br>
								
								</div>
									<div class="form-group">
											<button type="button" id="paymentId"
												class="btn btn-primary btn-block" onclick="payWithNewCard()">
												Pay INR
												<fmt:formatNumber type="number" minFractionDigits="2"
													maxFractionDigits="2" value="${amount}" />


											</button>
									</div>
							</form>
						</div>
						
						<div id = "result"></div>

					</div>
					 <div class="col-sm-12 col-md-12 well" id="content">
					 <form action="" method="" id="existing-payment-form">
					   <input type="hidden" id="customerEmail" class="form-control"name = "customerEmail"  value = "${customerEmail}">
				  <input type="hidden" id="amount" class="form-control"name = "amount" value = "${amount}" >
						<center>
							<h2>Your saved credit and debit cards</h2>
						</center>
						   <table class="table highlight bordered" id = "">
                          <tr>
							  <th width="5%">
							  	Select
							  </th>
							  <th width="16%">
							  Card Type
							  </th>
							  <th width="10%">Brand</th>
							  <th width="40%">last 4 digit</th>
							  <th width="30%">Expiry</th>							  
							</tr>	
								
					<c:forEach var="listValue" items="${cards}" varStatus="count">
					<tr>
							  <td width="6%">
							  	<input type="radio" id="paymentMethodId" name="paymentMethodId" value="${listValue.cardId}" />
      							<label for="${count.index}"></label>
							  </td>
							
							  <td width="10%">${listValue.brand}</td>
							  <td width="40%">**** **** **** ${listValue.last4digit}</td>
							  <td width="30%"> ${ listValue.expMonth } / ${ listValue.expYear }</td>
					  <td width="1%"><button type = "button"onclick="deleteCard('${listValue.cardId}')"><i class="fa fa-trash" aria-hidden="true"></i></button></td>
 						 </tr>   <br/>                   																									
                        </c:forEach>
                        
                        </table>
                        
                         <button type="button" class="btn btn-primary btn-block" id = "" onclick= "payWithExistingCard()">Pay INR 
							   		<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${amount}" />
							   
							   </button>
							   </form>
					</div> 

				</div>
				<!-- /.row -->

			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->



	</div>
	<!-- /#wrapper -->

	<script type="text/javascript" src="https://js.stripe.com/v3/"></script>
	<script src="${pageContext.request.contextPath}/js/payment.js"></script>

</body>
</html>


