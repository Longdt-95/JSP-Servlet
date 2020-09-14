<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list news</title>
</head>
<body>

	<div class="main-content">
		<form action='<c:url value="/admin-list-news"/>' id="formSubmit"
			method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">admin-Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="row">
								<div class="col-xs-12">
									<div class=" table-reponsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>id</th>
													<th>title</th>
													<th>code</th>
													<th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${model}" var="item">
													<tr>
														<td>${item.id}</td>
														<td>${item.title}</td>
														<td>${item.code}</td>
													 <%--	<td><c:url var="editURL" value="/admin-new">
																<c:param name="type" value="edit" />
																<c:param name="id" value="${item.id}" />
															</c:url> <a class="btn btn-sm btn-primary btn-edit"
															data-toggle="tooltip" title="Cập nhật bài viết"
															href='${editURL}'><i class="fa fa-pencil-square-o"
																aria-hidden="true"></i> </a></td>  --%>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<ul class="pagination" id="pagination"></ul>
											<input type="hidden" value="" id="page" name="page"/>
											<input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
											<input type="hidden" value="" id="sortName" name="sortName"/>
											<input type="hidden" value="" id="sortBy" name="sortBy"/>
											<input type="hidden" value="" id="type" name="type"/>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>

	<!-- /.main-content -->

	<script type="text/javascript">
	var totalPage = ${model.totalPage}
	var currentPage = ${model.page}
	var limit = 2;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPage,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
               if (currentPage != page)
            	   {
            	   	$('#maxPageItem').val(limit);
					$('#page').val(page);
					$('#formSubmit').submit();
            	   
            	   }
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
</script>
</body>
</html>

