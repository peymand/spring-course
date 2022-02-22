<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<c:url var="firstUrl" value="/product/productList/${productCategory}/1" />
<c:url var="lastUrl" value="/product/productList/${productCategory}/${totalPages}" />
<c:url var="prevUrl" value="/product/productList/${productCategory}/${currentPageNumber - 1}" />
<c:url var="nextUrl" value="/product/productList/${productCategory}/${currentPageNumber + 1}" />

 <div class="container-wrapper">
 
 
 
  <div class="container">
      
      <div class=row>
      
             <div class="col-md-3">
		            <h1 class="Product-category">Product Category</h1>
		             <div class="list-group popular-product">
		                       
		                        <a  href="<c:url  value="/product/productList/MicroOven/1"/>" class="list-group-item">Micro Oven </a>
		                        <a href="<c:url  value="/product/productList/DvdPlayer/1"/>" class="list-group-item">DVD PLayer</a>
		                        <a href="<c:url  value="/product/productList/Fan/1"/>" class="list-group-item">Fan</a>
		                        <a href="<c:url  value="/product/productList/Printer/1"/>" class="list-group-item">Printer</a>
		                        <a href="<c:url  value="/product/productList/Desktop/1"/>" class="list-group-item">Desktop </a>
		                        <a href="<c:url  value="/product/productList/Washing Machine/1"/>" class="list-group-item">Washing Machine </a>
	                            <a href="<c:url  value="/product/productList/ipad/1"/>" class="list-group-item">ipad </a>
	                            <a href="<c:url  value="/product/productList/Game console/1"/>" class="list-group-item">Geaming console </a>
		                        
		                  </div>
		          </div>
      
	        <div class="jumbotron col-md-6">
			    <h1>Green Online Shop</h1>
			    <p>Select your favourite product and buy with 10% discount</p>
			    
	       </div>
   
		    <div class="col-md-3">
		            <h1 class="Product-category">Product Category</h1>
		             <div class="list-group popular-product">
		                        <a href="<c:url  value="/product/productList/Laptop/1"/>" class="list-group-item">Laptop</a>
		                         <a href="<c:url  value="/product/productList/Mobile/1"/>" class="list-group-item">Mobile </a>
		                        <a href="<c:url  value="/product/productList/Camera/1"/>" class="list-group-item ">Camera</a>
		                        <a href="<c:url  value="/product/productList/Tv/1"/>" class="list-group-item">Tv </a>
		                        <a href="<c:url  value="/product/productList/Refrigerator/1"/>" class="list-group-item">Refrigerator </a>
		                        <a href="<c:url  value="/product/productList/Tablet/1"/>" class="list-group-item">Tablet </a>
		                        <a href="<c:url  value="/product/productList/MicroOven/1"/>" class="list-group-item">Micro Oven </a>
		                        <a href="<c:url  value="/product/productList/Router/1"/>" class="list-group-item">Router </a>
		                        
		                  </div>
		          </div>
		          
		         
		          
		      </div>
		      
		
		
		
		
	<div class="container">
	     <div class=row>
	        
		         <div class="searchBox">
		         
		            <form class="form-inline" action="<c:url value="/product/productList/1" />" method="post">
		             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					    <div class="form-group">
					        <label  for="inputEmail">Search more ${productCategory} :</label>
					        <input type="text" name="searchTerm" class="form-control" id="inputEmail" placeholder="Enter Brand , model or Category">
					    </div>
					    <input type="hidden"  value="search" name="search">
					    <button type="submit" class="btn btn-primary">Search Product</button>
                    </form>
		               
		         </div>
	        
	     </div>
	
	</div>	
		
		      
		      
  <section class="productsection">
   
     
     
       <div class="container">
       
       
       <c:if test="${not empty msg}">
          <div class="no-product">
            ${msg}
          </div>
       </c:if>
       
      <div class="row">
         
      
        <c:forEach var="product" items="${products}">
         
        
         <div class="col-md-4">
             <div class="product-single">
                <div class=" text-center productColumn">
                 <div class=" img-responsive productImage">
					 <img  style="width:50%; height: 50%  "  alt="image" src="/product/getImage/${product.productId}" />
                 </div>
                 
             </div>
             
             
             <div class="product-desc">
                 <h2>${product.productModel}</h2>
                 <h3>${product.productPrice} USD</h3>
               
                 <a  href=" <c:url  value="/product/viewProduct/${product.productId}"/>" class="btn btn-info btn-lg">View Detail</a>
                
             </div>
             </div>
             
          </div> 
          
          
          
          </c:forEach> 
          
          
          
      </div>
   </div>
     
     
   
</section>		         
		          
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
	            <c:url var="pageUrl" value="/product/productList/${productCategory}/${i}" />
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
		     
		      
   
  </div>
 
 
 
 
 
 
 
 
 
 
 
 
 
 </div>













<%@include file="/WEB-INF/views/template/footer.jsp" %>	