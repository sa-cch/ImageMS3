<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>画像検索</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/addImage.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c&display=swap">
</head>
<body>
<h1>
<img src="icons/iconfinder_Location_19_1530071.png"> search
</h1>
<form action="" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<th>タイトル</th>
			<td>
				<input class="haba" type="text" name="imageName"/>
			</td>
		</tr>
		<tr>
			<th>シセツ</th>
			<td>
				<input class="haba" type="text" name="facilityName"/>
			</td>
		</tr>
		<tr>
			<th>ソト / ナカ</th>
			<td>
				<input type="radio" name="areaTypesId" value="1">屋外
				<input type="radio" name="areaTypesId" value="2">屋内
			</td>
		</tr>
		<tr>
			<th>エリア</th>
			<td>
				<select name="areaNamesId">
					<option value="0">
						すべて
					</option>
					<option value="1">
						八王子市
					</option>
					<option value="2">
						立川市
					</option>
					<option value="3">
						武蔵野市
					</option>
					<option value="4">
						三鷹市
					</option>
					<option value="5">
						青梅市
					</option>
					<option value="6">
						府中市
					</option>
					<option value="7">
						昭島市
					</option>
					<option value="8">
						調布市
					</option>
					<option value="9">
						町田市
					</option>
					<option value="10">
						小金井市
					</option>
					<option value="11">
						小平市
					</option>
					<option value="12">
						日野市
					</option>
					<option value="13">
						東村山市
					</option>
					<option value="14">
						国分寺市
					</option>
					<option value="15">
						国立市
					</option>
					<option value="16">
						福生市
					</option>
					<option value="17">
						狛江市
					</option>
					<option value="18">
						東大和市
					</option>
					<option value="19">
						清瀬市
					</option>
					<option value="20">
						東久留米市
					</option>
					<option value="21">
						武蔵村山市
					</option>
					<option value="22">
						多摩市
					</option>
					<option value="23">
						稲城市
					</option>
					<option value="24">
						羽村市
					</option>
					<option value="25">
						あきる野市
					</option>
					<option value="26">
						西東京市
					</option>
					<option value="27">
						瑞穂町
					</option>
					<option value="28">
						日の出町
					</option>
					<option value="29">
						檜原町
					</option>
					<option value="30">
						奥多摩町
					</option>
				</select>
			</td>
		</tr>
	</table>
	<p>
		<input type="submit" value=" search "/>
	</p>
</form>
<p>
	<a href="myPage.jsp">マイページへ戻る</a>
</p>
<!-- ★jQueryとBootstrap用JavaScriptの読み込み  -->
<script src="js/jquery-2.2.4.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>