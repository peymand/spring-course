
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<c:url var="firstUrl" value="/admin/productManagement/1" />
<c:url var="lastUrl" value="/admin/productManagement/${totalPages}" />
<c:url var="prevUrl" value="/admin/productManagement/${currentPageNumber - 1}" />
<c:url var="nextUrl" value="/admin/productManagement/${currentPageNumber + 1}" />
	<div class="container-wrapper">

		<div class="container">

           <div class="page-header">
              <h1>Product Inventory Page:${pageContext.request.userPrincipal.name}</h1>
              
              <p class="lead">This is product inventory page</p>
               <a  class="btn btn-primary" href="<spring:url value="/admin/product/addProduct"/>">Add New Product</a>
                
                <c:if test="${not empty search}">
                     <a  class="btn btn-primary" href="<spring:url value="/admin/productManagement/1"/>">See All Product</a>
                  
                </c:if>
           </div>
         
         
         <div class="container">
	     <div class=row>
	        
		         <div class="searchBox">
		         
		            <form class="form-inline" action="<c:url value="/admin/productManagement/search/1" />" method="post">
		             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					    <div class="form-group">
					        <label  for="inputEmail">Search more product  :</label>
					        <input type="text" name="searchTerm" class="form-control" style="width:300px"  id="inputEmail" placeholder="Enter Brand , model or  category name">
					    </div>
					    <input type="hidden"  value="category" name="search">
					    <button type="submit" class="btn btn-primary">Search Product</button>
                    </form>
		               
		         </div>
	        
	     </div>
	
	</div>
         
         <table class="table table-striped table-hover table-bordered">
         
           <thead>
              <tr class="bg-success">
                 <th>Photo Thumb</th>
                 <th>Product Name</th>
                 <th>Category</th>
                 <th>Unit in Stock</th>
                 <th>Price</th>
                 <th>Operation</th>
              </tr>
           
           </thead>
          
           <c:forEach items="${products}" var="product">
               <tr>
                      
                     
		              <td><img  style="width:50%"  alt="image" src="<c:url value="/resources/images/${product.productId}.png"/>" /></td>
		              <td class="success">${product.productName}</td>
		              <td class="info">${product.productCategory}</td>
		              <td  class="warning">${product.unitInStock}</td>
		              <td class="success">${product.productPrice} USD</td>
		              <td class="info"> 
		              <a href=" <spring:url value="/product/viewProduct/${product.productId}"/>"><span class="glyphicon glyphicon-info-sign"></span></a>
		              <a href=" <spring:url value="/admin/product/deleteProduct/${product.productId}"/>"><span class="glyphicon glyphicon-remove"></span></a>
		              <a href=" <spring:url value="/admin/product/updateProduct/${product.productId}"/>"><span class="glyphicon glyphicon-pencil"></span></a>
		                
		              </td>
                     
                      
              </tr>  
           </c:forEach>
          
           
         </table>
         
        
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
            <c:url var="pageUrl" value="/admin/productManagement/${i}" />
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
       
	<%@include file="/WEB-INF/views/template/footer.jsp" %>	