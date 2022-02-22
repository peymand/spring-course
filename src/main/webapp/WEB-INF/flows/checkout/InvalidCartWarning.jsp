 <%@include file="/WEB-INF/views/template/header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container-wrapper">
    
    <div class="container">
         <section>
                 <div class="jumbotron">
                   <div class="container">
                      <h1>Invalid Cart</h1>
                   </div>
                 </div>
         </section>
         
         
        <section class="container" >


                 <p>
                <a href="<spring:url value="/product/productList" />" class="btn btn-default">Products</a>
                 
                 </p>

            
        </section>
    </div>

</div>










<%@include file="/WEB-INF/views/template/footer.jsp" %>	