<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<c:url var="firstUrl" value="/admin/customerMessages/1" />
<c:url var="lastUrl" value="/admin/customerMessages/${totalPages}" />
<c:url var="prevUrl" value="/admin/customerMessages/${currentPageNumber - 1}" />
<c:url var="nextUrl" value="/admin/customerMessages/${currentPageNumber + 1}" />

 <div class="container-wrapper">
 
 
 
  <div class="container">
      
      <div class=row>
      
             
      
	        <div class="jumbotron col-md-12">
			    <h1>Green Online Shop</h1>
			    <p>Here is all customer messages,reports,complaints</p>
			    
	       </div>
   
		    
		          
		         
		          
		      </div>
		      
		      
		      
  <section class="productsection">
   
     
     
       <div class="container">
       
       
      <c:if test="${not empty msg}">
         <div class="no-product">
            ${msg}
          </div>
       </c:if>
      
         
      
        <c:forEach var="contact" items="${customerContacts}">
         
        
            <div class="row message">
                
               
		              <p class="info"> ${contact.contactInfo}</p>
		               <br/>
		              
		                 <div class="row" style=" margin-bottom: 20px; margin-left: -3px;color: crimson;">
		                   
		                   <div class="col-md-6">
		                   UserName :${contact.customer.customerName}
		                   
		                 </div>
		              
		               
		                <div class="col-md-6">
		                   Date : ${contact.date}
		                
		                </div>
		                 
		                 </div>
		                
		                
		                
		                
		                
                   
               
               
		           <form   action="<c:url value="/admin/customerMessages/deleteMessage" />"  method="post"  class="form-horizontal"  >
							
					
					<input type="hidden" name="customerMessageId" value="${contact.contactId}">
					<input type="hidden" name="currentPageNumber" value="${currentPageNumber}">
					 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				   
				   <input type="submit" value="Delete Message" class="btn btn-danger operation">
				   </form>
		     
               
               
               
               
               
               
               
               
               
              
               
               
               
               
               
               
               
               
            </div>
               
               
          
          
          
          
          </c:forEach> 
          
          
          
      
   </div>
     
     
   
</section>	         
		          
		         
		     
		      
   
  </div>
 
 
 
 
 
 
 
 
 
 
 
 
 
 </div>


 <c:if test="${empty msg}">
 
 
 <div class="Page navigation text-center">
    <ul class="pagination">
    
     
    
    
        <c:choose>
            <c:when test="${currentPageNumber == 1}">
                <li class="disabled"><a href="#">&lt;&lt;</a></li>
                <li class="disabled"><a href="#">&lt;</a></li>
            
            
            
            </c:when>
            <c:otherwise>
                <li><a href="${firstUrl}">&lt;&lt;</a></li>
                <li><a href="${prevUrl}">&lt;</a></li>
            </c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
            <c:url var="pageUrl" value="/admin/customerMessages/${i}" />
            <c:choose>
                <c:when test="${i == currentPageNumber}">
                    <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${currentPageNumber == totalPages}">
                <li class="disabled"><a href="#">&gt;</a></li>
                <li class="disabled"><a href="#">&gt;&gt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${nextUrl}">&gt;</a></li>
                <li><a href="${lastUrl}">&gt;&gt;</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>
 
 
 
 
 
 
 
 </c:if>










<%@include file="/WEB-INF/views/template/footer.jsp" %>	