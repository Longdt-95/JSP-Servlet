<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ include file = "/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<title><decorator:title  default="/trang chủ"  /></title>
<link
	href="<c:url value='/template/web/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value='/template/web/css/style.css' />"
	rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<!-- include header from page pare parent -->
	<%@ include file="/common/web/header.jsp" %>
	<!-- end header -->
	<div class= "container">
		<decorator:body/>
	</div>
	
	<!-- include footer from page pare parent -->
	<%@ include file="/common/web/footer.jsp" %>
	<!-- end footer -->
	<!-- include jquery -->
	<script type="text/javascript"
		src="<c:url value="/template/web/jquery/jquery.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/template/web/boostrap/js/boostrap.bundle.min.js"/>"></script>
</body>
</html>