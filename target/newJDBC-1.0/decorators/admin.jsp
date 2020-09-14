<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ include file = "/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<title><decorator:title  default="/trang chủ"  /></title>
  <!-- include css -->
    <link href="<c:url value = '/template/admin/css/boostrap.min.css'/>" rel="stylesheet" type= "text/css" >
	<link href="<c:url value = '/template/admin/css/bootstrap-responsive.min.css'/>" rel="stylesheet" />
	<link rel="stylesheet" href="<c:url value = '/template/admin/css/font-awesome.min.css'/>" />
	<link rel="stylesheet" href="<c:url value = '/template/admin/css/ace-fonts.css'/> " />
	<link rel="stylesheet" href="<c:url value = '/template/admin/css/ace.min.css'/> " />
	<link rel="stylesheet" href="<c:url value = '/template/admin/css/ace-responsive.min.css'/> " />
	<link rel="stylesheet" href="<c:url value = '/template/admin/css/ace-skins.min.css'/> " />
	<script src="<c:url value = '/template/admin/js/ace-extra.min.js'/> "></script>
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
  
</body>
</html>