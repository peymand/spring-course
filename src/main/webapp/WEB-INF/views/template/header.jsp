<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="utf-8" %>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Green Online Shop</title>

     
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    
    
    <!-- FONT AWESOME -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">

    <!-- normalize css -->
    <link href="<c:url value="/resources/css/normalize.css"/>" rel="stylesheet">
    
     <!-- Angular.JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    
     <!-- main css -->
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">
  </head>
<!-- NAVBAR
================================================== -->
  <body>
    <div class="navbar-wrapper" style="margin-top:0;">
      <div class="container" >

        <nav class="navbar navbar-inverse navbar-fixed-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
             
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                
                <li><a href="#">  <img src="<c:url value="/resources/images/logo.png"/>" alt="logo" class="logo">     </a></li>
                <li class=""><a href="#">Green Online Shop</a></li>
                <li ><a href="<c:url value="/" />"><spring:message code="home.page"/></a></li>
                <li><a href="<c:url value="/product/productList/Laptop/1" />"><spring:message code="product.page"/></a></li>
                <li><a href="<c:url value="/about" />"><spring:message code="about.page"/></a></li>
                <li><a href="<c:url value="/contact" />"><spring:message code="contact.page"/></a></li>
               
                
               </ul>
              
               <ul class="nav navbar-nav pull-right">
					 <!-- <li><a href="?lang=en">English</a></li> 
					     <li><a href="?lang=bn">Bangla</a></li> -->
					   <c:if test="${pageContext.request.userPrincipal.name!=null}">
					      
					     <li> <a>Welcome:${pageContext.request.userPrincipal.name} </a>  </li>
					     
					     <c:if test="${pageContext.request.userPrincipal.name!='admin'}">
					     
					       <li role="presentation" class="dropdown">
								    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
								     <span class="glyphicon glyphicon-user"></span>  <span class="caret" >   </span>
								    </a>
								    <ul class="dropdown-menu">
								        <li> <a href="<c:url value="/customer/update"/>"><spring:message code="updateAccount.page"/></a>  </li>
								    </ul>
								  </li>
					     
					     </c:if>
					     <li> <a href="<c:url value="/logout" />" ><spring:message code="logout.page"/></a> </li>
					     
					      
					      <c:if test="${pageContext.request.userPrincipal.name!='admin'}">
					         
					        
 						  
								  
								
					         <li> <a href="<c:url value="/customer/cart"/>"><spring:message code="cart.page"/></a>  </li>
					         
					      </c:if>
					      
					      <c:if test="${pageContext.request.userPrincipal.name =='admin'}">
					          <li> <a href="<c:url value="/admin"/>"><spring:message code="admin.page"/></a>  </li>
					      </c:if>
					      
					   </c:if>
					   
					    <c:if test="${pageContext.request.userPrincipal.name == null}">
					          
					           <li> <a href="<c:url  value="/login"/>"><spring:message code="login.page"/></a>   </li>
					           <li> <a href="<c:url  value="/dummy/register"/>"><spring:message code="register.page"/></a>   </li>
					      </c:if>
					   
					    
					</ul>
              
              
            </div>
          </div>
        </nav>

      </div>
    </div>
