<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><decorator:title default="Master-Layout"></decorator:title></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap styles -->
<link href="<c:url value="/assets/user/css/bootstrap.css"/>"
	rel="stylesheet" />
<!-- Customize styles -->
<link href="<c:url value="/assets/user/style.css"/>" rel="stylesheet" />
<!-- font awesome styles -->
<link
	href="<c:url value="/assets/user/font-awesome/css/font-awesome.css"/>"
	rel="stylesheet">
<!--[if IE 7]>
			<link href="css/font-awesome-ie7.min.css" rel="stylesheet">
		<![endif]-->

<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

<!-- Favicons -->
<link rel="shortcut icon"
	href="<c:url value="/assets/user/ico/favicon.ico"/>">
</head>
<decorator:head/>
<body>
	<!-- 
	Upper Header Section 
-->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="topNav">
			<div class="container">
				<div class="alignR">
					<div class="pull-left socialNw">
						<a href="#"><span class="icon-twitter"></span></a> <a href="#"><span
							class="icon-facebook"></span></a> <a href="#"><span
							class="icon-youtube"></span></a> <a href="#"><span
							class="icon-tumblr"></span></a>
					</div>
					<a class="active" href="index.html"> <span class="icon-home"></span>
						Home
					</a> <a href="#"><span class="icon-user"></span> My Account</a> <a
						href="register.html"><span class="icon-edit"></span> Free
						Register </a> <a href="contact.html"><span class="icon-envelope"></span>
						Contact us</a> <a href="<c:url value="/gio-hang"></c:url>"><span
						class="icon-shopping-cart"></span> ${ TotalQuantyCart } Sản phẩm <span 
						
						class="badge badge-warning"> <fmt:formatNumber type="number" groupingUsed="true"
														value="${TotalPriceCart}" />₫ </span></a> 
				</div>
			</div>
		</div>
	</div>

	<!--
Lower Header Section 
-->
	<div class="container">
		<div id="gototop"></div>
	<%@include file="/WEB-INF/views/layouts/user/header.jsp" %>
	
		<decorator:body />
		
	<%@include file="/WEB-INF/views/layouts/user/footer.jsp" %>


	<div class="copyright">
		<div class="container">
			<p class="pull-right">
				<a href="#"><img src='<c:url value="/assets/user/img/maestro.png"></c:url>' alt="payment"></a>
				<a href="#"><img src='<c:url value="/assets/user/img/mc.png"></c:url>' alt="payment"></a> <a
					href="#"><img src='<c:url value="/assets/user/img/pp.png"></c:url>' alt="payment"></a> <a
					href="#"><img src='<c:url value="/assets/user/img/visa.png"></c:url>' alt="payment"></a> <a
					href="#"><img src='<c:url value="/assets/user/img/disc.png"></c:url>' alt="payment"></a>
			</p>
			<span>Copyright &copy; 2013<br> bootstrap ecommerce
				shopping template
			</span>
		</div>
	</div>
	<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src='<c:url value="/assets/user/js/jquery.js" ></c:url>'></script>
	<script
		src='<c:url  value="/assets/user/js/bootstrap.min.js" ></c:url>'></script>
	<script
		src='<c:url  value="/assets/user/js/jquery.easing-1.3.min.js" ></c:url>'></script>
	<script
		src='<c:url  value="/assets/user/js/jquery.scrollTo-1.4.3.1-min.js" ></c:url>'></script>
	<script src='<c:url  value="/assets/user/js/shop.js" ></c:url>'></script>
</body>
</html>