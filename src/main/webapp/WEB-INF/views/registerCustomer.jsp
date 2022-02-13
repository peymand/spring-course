<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-wrapper">
    
    <div class="container">
   
  

	   <div class="page-header title">
	              <h1>Register Customer</h1>
	              
	              <p class="lead">Fill the below information to create account</p>
	    </div>
	    
	    
	   
	     
		<div class="form-layout" >
		  
		  <c:url value="/customer/register" var="registerUrl"/>
		 
	       <form:form   action="${registerUrl}"   method="post" modelAttribute="customer"     class="form-horizontal"  >
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" ></label>
					<div class="col-xs-9">
						
					   <c:if test="${not empty emailMsg }">
					     <label class="label-danger">${emailMsg}</label>
					   </c:if>
					   
					   
					   <c:if test="${not empty usernameMsg }">
					     <label class="label-danger">${usernameMsg}</label>
					   </c:if>
					   
					   
					   <c:if test="${not empty update }">
					     <input name="update" hidden="true" value="update">
					     <input name="oldUserId" hidden="true" value="${customer.customerId}">
					   </c:if>
					   
					</div>
				</div>
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" ></label>
					<div class="col-xs-9">
						
					   <h1>Basic Info :</h1>
					</div>
				</div>
						
			  
			    <div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="customerName" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
			    
				<div class="form-group has-success">
				
					<label class="col-xs-3 control-label" for="customerName">Name :</label>
					<div class="col-xs-9">
						
					   <form:input path="customerName" class="form-control" placeholder="Enter Full Name" id="customerName" />
					</div>
					
				</div>
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="customerEmailAddress" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
			    
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="customerEmailAddress">Email Address :</label>
					<div class="col-xs-9">
						
					   <form:input path="customerEmailAddress" class="form-control" placeholder="Enter Email Address" id="customerEmailAddress" />
					</div>
				</div>
				
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="customerPhoneNumber" cssStyle="color: #ff0000" />
					</div>
			    
			    </div>
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="customerPhoneNumber">Phone Number:</label>
					<div class="col-xs-9">
						
					   <form:input path="customerPhoneNumber" class="form-control" placeholder="Enter Phone Number" id="customerPhoneNumber" />
					</div>
				</div>
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="username" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="username">Username:</label>
					<div class="col-xs-9">
						
					   <form:input path="username" class="form-control" placeholder="Enter username" id="username" />
					</div>
				</div>
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="password" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="password">Password:</label>
					<div class="col-xs-9">
						
					   <form:password path="password" class="form-control" placeholder="Enter password" id="password" />
					</div>
				</div>
				
				
				
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" ></label>
					<div class="col-xs-9">
						
					   <h1>Billing Address :</h1>
					</div>
				</div>
				
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="billingAddress.streetName" cssStyle="color: #ff0000" />
					</div>
			    
			    </div>
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="billingAddress.strretName">Street Name:</label>
					<div class="col-xs-9">
						
					   <form:input path="billingAddress.streetName"   class="form-control" placeholder="Enter Street Name" id="billingAddress.strretName" />
					</div>
				</div>
				
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="billingAddress.apartmentNumber" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="billingAddress.apartmentNumber">Apartment Number:</label>
					<div class="col-xs-9">
						
					   <form:input path="billingAddress.apartmentNumber" class="form-control" placeholder="Enter Apartment Number" id="billingAddress.apartmentNumber" />
					</div>
				</div>
				
				
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="billingAddress.city" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="billingAddress.city">City:</label>
					<div class="col-xs-9">
						
					   <form:input path="billingAddress.city" class="form-control" placeholder="Enter City" id="billingAddress.city" />
					</div>
				</div>
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="billingAddress.state" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="billingAddress.state">State:</label>
					<div class="col-xs-9">
						
					   <form:input path="billingAddress.state" class="form-control" placeholder="Enter State" id="billingAddress.state" />
					</div>
				</div>
				
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="billingAddress.country" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
			    
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="billingAddress.country">Country:</label>
					<div class="col-xs-9">
						
					   <form:input path="billingAddress.country" class="form-control" placeholder="Enter Country" id="billingAddress.country" />
					</div>
				</div>
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="billingAddress.zipCode" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="billingAddress.zipCode">Zip Code:</label>
					<div class="col-xs-9">
						
					   <form:input path="billingAddress.zipCode" class="form-control" placeholder="Enter Zip Code" id="billingAddress.zipCode" />
					</div>
				</div>
				
				
				
				
				
				
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" ></label>
					<div class="col-xs-9">
						
					   <h1>Shipping Address :</h1>
					</div>
				</div>
				
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="shippingAddress.streetName" cssStyle="color: #ff0000" />
					</div>
			    
			    </div>
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="shippingAddress.strretName">Street Name:</label>
					<div class="col-xs-9">
						
					   <form:input path="shippingAddress.streetName"    class="form-control" placeholder="Enter Street Name" id="shippingAddress.strretName" />
					</div>
				</div>
				
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="shippingAddress.apartmentNumber" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="shippingAddress.apartmentNumber">Apartment Number:</label>
					<div class="col-xs-9">
						
					   <form:input path="shippingAddress.apartmentNumber" class="form-control" placeholder="Enter Apartment Number"    id="shippingAddress.apartmentNumber" />
					</div>
				</div>
				
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="shippingAddress.city" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="shippingAddress.city">City:</label>
					<div class="col-xs-9">
						
					   <form:input path="shippingAddress.city" class="form-control" placeholder="Enter City" id="shippingAddress.city" />
					</div>
				</div>
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="shippingAddress.state" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="shippingAddress.state">State:</label>
					<div class="col-xs-9">
						
					   <form:input path="shippingAddress.state" class="form-control" placeholder="Enter State" id="shippingAddress.state" />
					</div>
				</div>
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="shippingAddress.country" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="shippingAddress.country">Country:</label>
					<div class="col-xs-9">
						
					   <form:input path="shippingAddress.country" class="form-control" placeholder="Enter Country" id="shippingAddress.country" />
					</div>
				</div>
				
				<div class="row">
			    <label class="col-xs-3 control-label" for="customerName"></label>
					<div class="col-xs-9">
				       <form:errors path="shippingAddress.zipCode" cssStyle="color: #ff0000" />		
					</div>
			    
			    </div>
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" for="shippingAddress.zipCode">Zip Code:</label>
					<div class="col-xs-9">
						
					   <form:input path="shippingAddress.zipCode" class="form-control" placeholder="Enter Zip Code" id="shippingAddress.zipCode" />
					</div>
				</div>
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				<div class="form-group has-success">
					<label class="col-xs-3 control-label"></label>
					<div class="col-xs-9">
						 <input type="submit" value="Submit" class="btn btn-default">
             <a href="<c:url value="/" />"  class="btn btn-default">Cancel</a>
					</div>
				</div>
			
			 
			</form:form>
		    
		</div>
    
    </div>

</div>


<%@include file="/WEB-INF/views/template/footer.jsp"%>