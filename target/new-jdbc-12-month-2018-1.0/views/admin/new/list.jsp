<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách bài viết</title>
</head>
<body>
	<div class="main-content">
		<form action="<c:url value='/admin-new'/>" id="formSubmit" method="get">		
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
									chủ</a></li>
						</ul>
						<!-- /.breadcrumb -->
					</div>
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<div class="row">
									<div class="col-xs-12">
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead>
												<tr>
													<th>Tên bài viết</th>
													<th>Mô tả ngắn</th>
												</tr>
												</thead>
												<tbody>
												<c:forEach var="item" items="${model.listResult }">
												<tr>
													<td>${item.title }</td>
													<td>${item.shortdescription }</td>
												</tr>
												</c:forEach>
												</tbody>
											</table>
											<ul class="pagination" id="pagination"></ul>
											<!-- save page number -->
											<input type="hidden" value="" id="page" name="page">
											<input type="hidden" value="" id="maxPageItem" name="maxPageItem">
											<input type="hidden" value="" id="sortName" name="sortName">
											<input type="hidden" value="" id="sortBy" name="sortBy">
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
		var currentPage = ${model.page};
		var totalPages = ${model.totalPage};
		// var visiblePages = $(model.maxPageItem);
		var limit = 2;
		$(function () {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages: totalPages,
				visiblePages: 10,
				startPage: currentPage,
				onPageClick: function (event, page) {
					if(currentPage != page){
						$('#page').val(page);
						$('#maxPageItem').val(limit);
						$('#sortName').val('title');
						$('#sortBy').val('desc');
						$('#formSubmit').submit();
					}

				}
			});
		});
	</script>
</body>
</html>