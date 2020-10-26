<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sản phẩm</title>
<style type="text/css">
.pagination {
	display: flex;
	justify-content: center;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>
</head>
<body>
	<h1>${AllProductsByID.size() }</h1>
	<div class="well well-small">
		<div class="row">
			<span style="margin-left: 25px;"> Danh sach san pham</span> <select
				class="pull-right">
				<option>A - Z</option>
				<option>Cao -thấp</option>
			</select>
		</div>
		<h3>Danh sách sản phẩm</h3>
		

		<c:if test="${productsPaginate.size() > 0 }">
			<div class="row-fluid">
				<ul class="thumbnails">

					<c:forEach var="item" items="${ productsPaginate }" varStatus="loop">
						<li class="span4">
							<div class="thumbnail">
								<a href="product_details.html" class="overlay"></a> <a
									class="zoomTool" href="product_details.html"
									title="add to cart"><span class="icon-search"></span> QUICK
									VIEW</a> <a href="product_details.html"><img
									src='<c:url value="/assets/user/img/${item.img}"></c:url>' alt=""></a>
								<div class="caption cntr">
									<p> ${item.name }</p>
									<p>
										<strong> <fmt:formatNumber type="number" groupingUsed="true"
														value="${item.price}" />₫</strong>
									</p>
									<h4>
										<a class="shopBtn" href="#" title="add to cart"> Add to
											cart </a>
									</h4>
									<div class="actionList">
										<a class="pull-left" href="#">Add to Wish List </a> <a
											class="pull-left" href="#"> Add to Compare </a>
									</div>
									<br class="clr">
								</div>
							</div>
						</li>

						<c:if
							test="${(loop.index + 1) % 3 == 0 || (loop.index + 1) == productsPaginate.size()}">
				</ul>
			</div>
			<c:if test="${loop.index+1 < productsPaginate.size()}">
				<div class="row-fluid">
					<ul class="thumbnails">
			</c:if>
		</c:if>
		</c:forEach>
		</c:if>

	</div>
	<div class="pagination">
		<c:forEach var="item" begin="${paginateInfo.start }" end="${paginateInfo.end }" varStatus="loop">
			<c:if test="${ (loop.index) == paginateInfo.currentPage}">
				 <a class="active" href="<c:url value="/san-pham/${idCatelogy }/${loop.index }"></c:url>"> ${loop.index }</a>
			</c:if>
			<c:if test="${ (loop.index) != paginateInfo.currentPage}">
				 <a  href="<c:url value="san-pham/${idCatelogy }/${loop.index }"></c:url>"> ${loop.index }</a>
			</c:if>
		</c:forEach>
	</div>

</body>
</html>