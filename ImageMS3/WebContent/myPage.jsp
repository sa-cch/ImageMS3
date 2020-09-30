<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>マイページ</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/myPage.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c&display=swap">
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col">
			<img src="images/new3-p5589.jpg">
			<p class="font">
			東京・多摩地域の写真を<br>
			各回“１枚”投稿できる<br>
			たまちーきの掲示板。
			</p>
			<div class="row">
				<div class="col-12"><p><a class="btn btn-info" href="addImage">push：登録</a></p></div>
				<div class="col-12"><p><a class="btn btn-success" href="detailImage2">view：閲覧</a></p></div>
				<div class="col-12"><p><a class="btn btn-primary" href="searchImage">search：検索</a></p></div>
			</div>
		</div>
	</div>
</div>
<!-- ★jQueryとBootstrap用JavaScriptの読み込み  -->
<script src="js/jquery-2.2.4.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>
