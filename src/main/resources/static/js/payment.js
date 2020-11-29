

var stripe = Stripe('pk_test_51Hn61vDoYZOw3lkjjZwlLilHqgH6V6S6YPO9FOH5HvfT07JRaFUVu4Ilz8CYT1Fzslao7QZtivU00pwkLjiDvqrM00OLfrvRxk');


// Create an instance of Elements
var elements = stripe.elements();

// Custom styling can be passed to options when creating an Element.
var style = {
  base: {
	  fontSize: '16px',
	    color: '#32325d'
  },
  invalid: {
    color: '#fa755a',
    iconColor: '#fa755a'
  }
};

// Create an instance of the card Element
var card = elements.create('card');
//var card = elements.create('card', {style: style});

// Add an instance of the card Element into the `card-element` <div>
card.mount('#card-element');

var  clientSecret =  $('#secretId').val();
var remember =  $('#remember').val();
console.log(remember);

function payWithNewCard(){
	
	 stripe.handleCardPayment(
			    clientSecret, card 
			  ).then(function(result) {
				  console.log(result);
				  
				    if (result.error) {
				    	alert("your transaction is declined for this reason " + result.error.message);
				    }
		           
				    
				    else {
				    	 $.ajax({  
						 	 type: "POST",   
						     url :"http://localhost:3000/payWithNewCard",
						     data:{remember: remember,
						    	   paymentId:result.paymentIntent.id,
						    	  },
						     success : function(response) {
						    	 alert("your transaction is " +response);
						    	 },
						     error: function (response){
                               	console.log(response);
						        }
						 });
				    }
	  });			  
	
	
}

var  amount =  $('#amount').val();
var paymentMethodId =  $('#paymentMethodId').val();
var customerEmail =  $('#customerEmail').val();
	console.log(paymentMethodId);
	console.log(customerEmail);
function payWithExistingCard(){
	console.log('existing card')
  	 $.ajax({  
	 	 type: "POST",   
	     url : "http://localhost:3000/payWithExistingCard",
	     data:{amount: amount,
	    	 paymentMethodId: paymentMethodId,
	    	 customerEmail:customerEmail,
	    	  },
	     success : function(response) {
	    	 
	    	 console.log(response);
	    	 alert("your transaction is " +response);

	     },
	     error: function (response){
            	console.log(response);
	 }
  	 });
  	 }

//delete card//
function deleteCard(cardId){
	
	
    if (confirm('Are you sure you want to delete this card?')) {

	 $.ajax({  
	 	 type: "POST",   
	     url : "http://localhost:3000/deleteCard",         		
	     data:{'cardId': cardId},	    	   
	     success : function(response) {  

	    	 location.reload();						     

	  
	     },  
	     error : function(e) {  
	      alert('Error: ' + e);   
	     }  
	
  });  
	
}
}

/*payment request button */

//  Create the PaymentRequest instance 
var paymentRequest = stripe.paymentRequest({
	  country: 'IN',
	  currency: 'inr',
	  total: {
	    label: 'total amount',
	    amount: amount*100,
	  },
	  requestPayerName: true,
	  requestPayerEmail: true,
	});

console.log(paymentRequest);


//Create and mount the paymentRequestButton Element 
var elements = stripe.elements();
var prButton = elements.create('paymentRequestButton', {
	  paymentRequest: paymentRequest

	});
console.log(prButton);


// Check the availability of the Payment Request API first.
paymentRequest.canMakePayment().then(function(result) {
	  if (result) {
		  
	    prButton.mount('#payment-request-button');
	  } else {
		  
	    document.getElementById('payment-request-button').style.display = 'none';
	  }
	});
       
       //Complete the payment using payment intent method

       

paymentRequest.on('paymentmethod', function(ev) {
	  stripe.confirmPaymentIntent(clientSecret, {
	    payment_method: ev.paymentMethod.id,
	  }).then(function(result) {
	    if (result.error) {
	    	
	    	alert("transaction failed... "  + result.error);
	    	console.log(result.error);
	      // Report to the browser that the payment failed, prompting it to
	      // re-show the payment interface, or show an error message and close
	      // the payment interface.
	      ev.complete('fail');
	      
	    } else {
	    	 ev.complete('success');
		      // Let Stripe.js handle the rest of the payment flow.
		      stripe.handleCardPayment(clientSecret).then(function(result) {
		    	  if (result.error) {
			        	console.log("error"); 
			        	
		    	  } else{
		    		  
		    			 $.ajax({  
						 	 type: "POST",   
						     url : "http://localhost:3000/payWithNewCard",
						     data:{ paymentId:result.paymentIntent.id},
						    success : function(response) {
						    	 alert("your transaction is " +response);    	 
						    	 
						     },error: function (response){
						        
					        console.log(response.statusText);
							}
		    		  
		    			 });
		    		  
		    	  } 	
			        	
		    	  
		      });
	    	
	    	
	    }
	  });
	  
});
