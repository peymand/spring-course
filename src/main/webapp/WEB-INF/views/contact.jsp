<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-wrapper">
    
    <div class="container">
   
  

	   <div class="page-header title">
	              <h1>Contact With us</h1>
	              
	              
	    </div>
	    
	    
	   
	     
		<div class="form-layout">
	       <form name="loginForm"  action="<c:url value="/contact" />"   method="post"  class="form-horizontal"  >
						
				 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				
					
			  
				<div class="form-group has-success">
					<label class="col-xs-3 control-label" ></label>
					<div class="col-xs-9">
                           <c:if test="${not empty msg}">
                               <div class="msg">${msg}</div>
                            </c:if>						
					</div>
				</div>
				
				
				
				
				
				
				<div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="form_message">Send Message/Query/Report/Complain*</label>
                    <textarea id="form_message" name="message" class="form-control" placeholder="Message for green online shop *" rows="4" required="required" data-error="Please,leave us a message."></textarea>
                    <div class="help-block with-errors"></div>
                </div>
            </div>
            <div class="col-md-12">
               <c:if test="${pageContext.request.userPrincipal.name == null}">
					 <h1>Please Register to send Message</h1>
					 <br/>         
					
					
					<a class="btn btn-success btn-send" href="<c:url  value="/register"/>"><spring:message code="register.page"  /></a>         
			   </c:if>
			   
			   <c:if test="${pageContext.request.userPrincipal.name != null}">
					          
				<input type="submit" class="btn btn-success btn-send" value="Send message">	           
			   </c:if>
                
            </div>
        </div>
				
	
			   
				
				
			
			 
			</form>
		</div>
    
    </div>

</div>



<%@include file="/WEB-INF/views/template/footer.jsp"%>