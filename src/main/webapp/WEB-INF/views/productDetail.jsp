<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>


            <p class="lead">Here is the detail information of the product:</p>
        </div>

        <div class="container" ng-app="cartApp">
            <div class="row">
                <div class="col-md-5 image">
                    <img style="width:100%" alt="image" src="/product/getImage/${product.productId}"/>
                </div>
                <div class="col-md-5 product-details">
                    <p><strong class="desc-title col-md-4">Name </strong>: ${product.productName}</p>
                    <p><strong class="desc-title col-md-4">Description </strong> :${product.productDescription}</p>
                    <p><strong class="desc-title col-md-4">Model</strong>: ${product.productModel}</p>
                    <p><strong class="desc-title col-md-4">Category</strong>: ${product.productCategory}</p>
                    <p><strong class="desc-title col-md-4">Condition</strong>: ${product.productStatus}</p>
                    <p><strong class="desc-title col-md-4">Price:</strong> : ${product.productPrice} USD</p>

                    <br/>


                    <c:set var="url" scope="page" value="/product/productList/${product.productCategory}/1"/>


                    <c:if test="${pageContext.request.userPrincipal.name=='admin'}">
                        <c:set var="url" scope="page" value="/admin/productManagement/1"/>
                    </c:if>

                    <p ng-controller="cartCtrl">
                        <a href="<c:url value = "${url}" />" class="btn btn-primary btn-md">Back</a>
                        <security:authorize access="hasRole('USER')">
                            <a href="#" class="btn btn-warning btn-large"
                               ng-click="addToCart('${product.productId}')"><span
                                    class="glyphicon glyphicon-shopping-cart"></span> Order Now</a>
                            <a href="<spring:url value="/customer/cart" />" class="btn btn-success btn-md"><span
                                    class="glyphicon glyphicon-hand-right"></span> View Cart</a>
                        </security:authorize>


                    </p>

                </div>
            </div>
        </div>


        <!-- My -->
        <script src="<c:url value="/resources/js/controller.js" /> "></script>

        <%@ include file="/WEB-INF/views/template/footer.jsp" %>
