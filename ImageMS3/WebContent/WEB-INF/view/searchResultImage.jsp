<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% pageContext.setAttribute("newLineChar", "\n"); %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>検索結果詳細</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/addImage.css">
<link rel="stylesheet" href="colorbox/colorbox.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c&display=swap">
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col">
			<h1>
			<img src="icons/iconfinder_6-Photo_2674052.png"> search Result
			</h1>
				<table>
				<c:forEach items="${imageList2}" var="image">
					<tr>
						<th>タイトル</th>
						<td>
							<c:out value="${image.imageName}"/>
						</td>
					</tr>
					<tr>
						<th>フォト</th>
						<td>
							<a class="photo" href="${pageContext.request.contextPath}/uploads/${image.photo}" title="${image.imageName}">
							<img src="${pageContext.request.contextPath}/uploads/${image.photo}" width=90% alt="${image.photo}"/>
							</a>
						</td>
					</tr>
					<tr>
						<th>シセツ</th>
						<td class="shisetsu">
							<c:out value="${image.facilityName}"/>
						</td>
					</tr>
					<tr>
						<th>ソト / ナカ</th>
						<td>
							<c:out value="${image.typeName}"/>
						</td>
					</tr>
					<tr>
						<th>エリア</th>
						<td>
							<c:out value="${image.areaName}"/>
						</td>
					</tr>
					<tr>
						<th>メモ</th>
						<td>
							<c:forEach items="${fn:split(image.memo, newLineChar)}" var="line">
								<c:out value="${line}"/><br/>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<th>ニチジ</th>
						<td>
							<fmt:formatDate value="${image.created}" pattern="yyyy-MM-dd HH:mm"/>
						</td>
					</tr>
					<tr>
						<td class="right" colspan="2">
							<a href="editImage?id=<c:out value="${image.id}"/>">
							<img class="icon" src="icons/iconfinder_Edit-01_1976055.png">
							</a>
							<a href="deleteImage?id=<c:out value="${image.id}"/>">
							<img class="icon" src="icons/iconfinder_Trash_4781812.png">
							</a>
						</td>
					</tr>

					</c:forEach>
				</table>
				<p>
					<a href="searchImage"><img class="back" src="icons/iconfinder_return-back-redo-arrow_2075802.png"></a>
				</p>
		</div>
	</div>
</div>
<!-- ★jQueryとBootstrap用JavaScriptの読み込み  -->
<script src="js/jquery-2.2.4.min.js"></script>
<script src="colorbox/jquery.colorbox-min.js"></script>
<script>
$(document).ready(function(){
	$('a.photo').colorbox({
			width:"60%"
	});
});
</script>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>