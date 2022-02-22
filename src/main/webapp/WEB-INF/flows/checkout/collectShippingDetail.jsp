<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

	<div class="container-wrapper">

		<div class="container">

           <div class="page-header title">
              <h1>Customer</h1>
              
              <p class="lead">Customer Details</p>
           </div>
         
         
        <div class="form-layout">
	       <form:form      method="post" modelAttribute="order"    class="form-horizontal"  >
						
				
				
				
				
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" ></label>
					<div class="col-xs-9">
						
					   <h1>Shipping Address :</h1>
					</div>
				</div>
				
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="shippingAddress.streetName">Street Name:</label>
					<div class="col-xs-9">
						
                 <form:input path="cart.customer.shippingAddress.streetName" id="shippingAddress.streetName" class="form-control" disabled="true"/>
					</div>
				</div>
				
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="shippingAddress.apartmentNumber">Apartment Number:</label>
					<div class="col-xs-9">
						
<form:input path="cart.customer.shippingAddress.apartmentNumber" id="shippingAddress.apartmentNumber" class="form-control" disabled="true"/>					</div>
				</div>
				
				
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="shippingAddress.city">City:</label>
					<div class="col-xs-9">
					     <form:input path="cart.customer.shippingAddress.city" id="shippingCity" class="form-control" disabled="true"/>
						
					</div>
				</div>
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="shippingAddress.state">State:</label>
					<div class="col-xs-9">
						
                 <form:input path="cart.customer.shippingAddress.state" id="shippingAddress.state" class="form-control" disabled="true"/>
					</div>
				</div>
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="shippingAddress.country">Country:</label>
					<div class="col-xs-9">
						
                 <form:input path="cart.customer.shippingAddress.country" id="shippingCountry" class="form-control" disabled="true"/>
					</div>
				</div>
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="shippingAddress.zipCode">Zip Code:</label>
					<div class="col-xs-9">
						
                 <form:input path="cart.customer.shippingAddress.zipCode" id="shippingZipCode" class="form-control" disabled="true"/>
					</div>
				</div>
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label"></label>
					<div class="col-xs-9">
						    <input type="hidden" name="_flowExecutionKey">
             
             <br/><br/>
             
              <button  class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>
             <!-- -eventId_customerInfoCollected = transaction result when clicked -->
             <input type="submit" value="Next" class="btn btn-default" name="_eventId_shippingDetailCollected">
             <button  class="btn btn-default" name="_eventId_cancel">Cancel</button>              
             
					</div>
				</div>
			
			 
			</form:form>
		</div>

	<%@include file="/WEB-INF/views/template/footer.jsp" %>	