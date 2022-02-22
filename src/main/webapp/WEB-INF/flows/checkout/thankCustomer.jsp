 <%@include file="/WEB-INF/views/template/header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container-wrapper">
    
    <div class="container">
         <section>
                 <div class="jumbotron">
                   <div class="container">
                      <h1>Thank you for your business</h1>
                      <p>Your order wil be shipped in two business days!</p>
                   </div>
                 </div>
         </section>
         
         
        <section class="container" >


                 <p>
                <a href="<spring:url value="/" />" class="btn btn-default">OK</a>
                 
                 </p>

            
        </section>
    </div>

</div>










<%@include file="/WEB-INF/views/template/footer.jsp" %>	