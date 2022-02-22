<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

	<div class="container-wrapper">

		<div class="container">

           <div class="page-header title">
              <h1>Customer</h1>
              
              <p class="lead">Customer Details</p>
           </div>
         
         
        
        
        
        
        
        <div class="form-layout">
	       <form:form      method="post" modelAttribute="order"     class="form-horizontal"  >
						
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" ></label>
					<div class="col-xs-9">
						
					   <h1>Basic Info :</h1>
					</div>
				</div>
						
			  
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="customerName">Name :</label>
					<div class="col-xs-9">
						
                 <form:input path="cart.customer.customerName" id="customerName" class="form-control" disabled="true"/>
					</div>
				</div>
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="customerEmailAddress">Email Address :</label>
					<div class="col-xs-9">
						<form:input path="cart.customer.customerEmailAddress" id="customerEmailAddress" class="form-control" disabled="true"/>
						
					</div>
				</div>
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="customerPhoneNumber">Phone Number:</label>
					<div class="col-xs-9">
						
                 <form:input path="cart.customer.customerPhoneNumber" id="customerPhoneNumber" class="form-control" disabled="true"/>
					</div>
				</div>
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" ></label>
					<div class="col-xs-9">
						
					   <h1>Billing Address :</h1>
					</div>
				</div>
				
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="billingAddress.streetName">Street Name:</label>
					<div class="col-xs-9">
						
                 <form:input path="cart.customer.billingAddress.streetName" id="billingAddress.streetName" class="form-control" disabled="true"/>
					</div>
				</div>
				
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="billingAddress.apartmentNumber">Apartment Number:</label>
					<div class="col-xs-9">
						
                 <form:input path="cart.customer.billingAddress.apartmentNumber" id="billingAddress.apartmentNumber" class="form-control" disabled="true"/>
					</div>
				</div>
				
				
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="billingAddress.city">City:</label>
					<div class="col-xs-9">
						
                 <form:input path="cart.customer.billingAddress.city" id="billingAddress.city" class="form-control" disabled="true"/>
					</div>
				</div>
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="billingAddress.state">State:</label>
					<div class="col-xs-9">
						
                 <form:input path="cart.customer.billingAddress.state" id="billingAddress.state" class="form-control" disabled="true"/>
					</div>
				</div>
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="billingAddress.country">Country:</label>
					<div class="col-xs-9">
						
                 <form:input path="cart.customer.billingAddress.country" id="billingAddress.country" class="form-control" disabled="true"/>
					</div>
				</div>
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="billingAddress.zipCode">Zip Code:</label>
					<div class="col-xs-9">
						
                 <form:input path="cart.customer.billingAddress.zipCode" id="billingAddress.zipCode" class="form-control" disabled="true"/>
					</div>
				</div>
				
				

				<div class="form-group has-success">
					<label class="col-xs-3 control-label"></label>
					<div class="col-xs-9">
						  <input type="hidden" name="_flowExecutionKey" />
            
             <br/><br/>
             <!-- -eventId_customerInfoCollected = transaction result when clicked -->
             <input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected">
             <button  class="btn btn-default" name="_eventId_cancel">Cancel</button>              
             
					</div>
				</div>
			
			 
			</form:form>
		</div>
        

	<%@include file="/WEB-INF/views/template/footer.jsp" %>	