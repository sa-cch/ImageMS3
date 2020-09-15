<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>画像管理</title>
</head>
<body>
<h1>画像一覧</h1>

<table border="1">
	<c:forEach items="${imageList}" var="image">
	<tr>
		<th><c:out value="${image.photo}" /></th>
		<td><c:out value="${image.imageName}" /></td>
		<td><c:out value="${image.created}" /></td>
		<td><a href="editImage?id=<c:out value="${image.id}" />">編集</a></td>
		<td><a href="deleteImage?id=<c:out value="${image.id}" />">削除</a></td>
	</tr>
	</c:forEach>
</table>
<p>
	<a href="myPage.jsp">マイページへ戻る</a>
</p>
</body>
</html>