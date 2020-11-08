

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
					<%-- 	<c:if test="${not empty cardDetails}">
							<h3 style="align-self: center">Your saved credit and debit
								cards</h3>
							<form action="payWithExistingCard" method="post" id="">
								<table class="table highlight bordered"
									style="margin-bottom: 0;">
									<tr>
										<th width="5%">Select</th>
										<th width="16%">Card Type</th>
										<th width="10%">Brand</th>
										<th width="40%">Card Details</th>
										<th width="30%">Expiry</th>
										<!--  <th width="1%"></th> -->

									</tr>

									<c:forEach var="listValue" items="${cardDetails}"
										varStatus="count">

										<tr id="hideTable${listValue.cardId}">
											<td width="6%">
												<input type="radio" id="" name="cardId" value="${listValue.cardId}" />
												<input type="radio" id="test${count.index}"
												name="paymentMethodId" value="${listValue.cardId}"
												onclick="showRadioBtnValue('${count.index}')" /> <label
												for="test${count.index}"></label>
											</td>
											<td width="16%"><img class="img img-responsive"
												style="width: 40px; height: 32px;" alt="visa"
												src="http://icons.iconarchive.com/icons/designbolts/credit-card-payment/128/Visa-icon.png">
											</td>
											<td width="10%">${listValue.brand}</td>
											<td width="40%">**** **** **** ${listValue.last4digit}</td>
											<td width="30%">${ listValue.expMonth } / ${ listValue.expYear }</td>
											<td width="1%"><button type="button"
													onclick="deleteCard('${listValue.cardId}')">
													<i class="fa fa-trash" aria-hidden="true"></i>
												</button></td>
										</tr>




									</c:forEach>
								</table>
								<br>
								<center>

									<button type="button" class="btn waves-effect company-color">
										Pay GBP
										<fmt:formatNumber type="number" minFractionDigits="2"
											maxFractionDigits="2" value="${payAmount}" />

									</button>

								</center>
							</form>
						</c:if> --%>



						<div class="card">
							<c:if test="${not empty cardDetails}">

								<center>
									<h3>Pay with new card</h3>
								</center>
							</c:if>

							<form action="payWithNewCard" method="post" id="payment-form">

								<span id="stripe-error"></span>
								<div id="payment-request-button"></div>


								<div id="card-element"></div>

								
								<div style="margin: 0 auto; max-width: 400px; box-sizing: border-box; padding: 0 5px">
									<div>
										<br /> <input type="checkbox" id="remember" name="remember"
											type="checkbox" /> <label for="remember"><span>Remember
										</span></label>
									</div>

									<br>
									<div class="form-group">
										<center>
											<button type="button" id="paymentId"
												class="btn btn-primary btn-block">
												Pay GBP
												<fmt:formatNumber type="number" minFractionDigits="2"
													maxFractionDigits="2" value="20" />


											</button>
										</center>
									</div>
									</div>
							</form>
						</div>

					</div>
				</div>
				<!-- /.row -->

			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->



	</div>
	<!-- /#wrapper -->


<script src="${pageContext.request.contextPath}/js/payment.js"></script>

</body>
</html>

