<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>画像登録</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/addImage.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c&display=swap">
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col">
			<h1>
			<img src="icons/iconfinder_6-Photo_2674052.png"> push
			</h1>
			<form action="" method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<th>タイトル</th>
						<td class="error">
							<c:if test="${not empty imageNameError}">
							<p><c:out value="${imageNameError}"/></p>
							</c:if>
							<input class="haba" type="text" name="imageName" value="<c:out value="${imageName}"/>"/>
						</td>
					</tr>

					<tr>
						<th>フォト</th>
						<td>
						<div class="center">
							<div class="error">
								<c:if test="${not empty photoError}">
								<p><c:out value="${photoError}"/></p>
								</c:if>
							</div>
							<input class="haba" type="file" name="photo" accept="image/*"/>
						</div>
						</td>
					</tr>

					<tr>
						<th>シセツ</th>
						<td class="error">
							<c:if test="${not empty facilityNameError}">
							<p><c:out value="${facilityNameError}"/></p>
							</c:if>
							<input class="haba" type="text" name="facilityName" value="<c:out value="${facilityName}"/>"/>
						</td>
					</tr>
					<tr>
						<th>ソト / ナカ</th>
						<td>
							<c:if test="${not empty areaTypesIdError}">
							<p><c:out value="${areaTypesIdError}"/></p>
							</c:if>
							<input type="radio" name="areaTypesId" value="1" checked>屋外
							<input type="radio" name="areaTypesId" value="2">屋内
						</td>
					</tr>
					<tr>
						<th>エリア</th>
						<td>
							<c:if test="${not empty areaNamesIdError}">
							<p><c:out value="${areaNamesIdError}"/></p>
							</c:if>
							<select name="areaNamesId">
								<option value="1"
									<c:if test="${areaNamesId == 1}">selected</c:if>>
									八王子市
								</option>
								<option value="2"
									<c:if test="${areaNamesId == 2}">selected</c:if>>
									立川市
								</option>
								<option value="3"
									<c:if test="${areaNamesId == 3}">selected</c:if>>
									武蔵野市
								</option>
								<option value="4"
									<c:if test="${areaNamesId == 4}">selected</c:if>>
									三鷹市
								</option>
								<option value="5"
									<c:if test="${areaNamesId == 5}">selected</c:if>>
									青梅市
								</option>
								<option value="6"
									<c:if test="${areaNamesId == 6}">selected</c:if>>
									府中市
								</option>
								<option value="7"
									<c:if test="${areaNamesId == 7}">selected</c:if>>
									昭島市
								</option>
								<option value="8"
									<c:if test="${areaNamesId == 8}">selected</c:if>>
									調布市
								</option>
								<option value="9"
									<c:if test="${areaNamesId == 9}">selected</c:if>>
									町田市
								</option>
								<option value="10"
									<c:if test="${areaNamesId == 10}">selected</c:if>>
									小金井市
								</option>
								<option value="11"
									<c:if test="${areaNamesId == 11}">selected</c:if>>
									小平市
								</option>
								<option value="12"
									<c:if test="${areaNamesId == 12}">selected</c:if>>
									日野市
								</option>
								<option value="13"
									<c:if test="${areaNamesId == 13}">selected</c:if>>
									東村山市
								</option>
								<option value="14"
									<c:if test="${areaNamesId == 14}">selected</c:if>>
									国分寺市
								</option>
								<option value="15"
									<c:if test="${areaNamesId == 15}">selected</c:if>>
									国立市
								</option>
								<option value="16"
									<c:if test="${areaNamesId == 16}">selected</c:if>>
									福生市
								</option>
								<option value="17"
									<c:if test="${areaNamesId == 17}">selected</c:if>>
									狛江市
								</option>
								<option value="18"
									<c:if test="${areaNamesId == 18}">selected</c:if>>
									東大和市
								</option>
								<option value="19"
									<c:if test="${areaNamesId == 19}">selected</c:if>>
									清瀬市
								</option>
								<option value="20"
									<c:if test="${areaNamesId == 20}">selected</c:if>>
									東久留米市
								</option>
								<option value="21"
									<c:if test="${areaNamesId == 21}">selected</c:if>>
									武蔵村山市
								</option>
								<option value="22"
									<c:if test="${areaNamesId == 22}">selected</c:if>>
									多摩市
								</option>
								<option value="23"
									<c:if test="${areaNamesId == 23}">selected</c:if>>
									稲城市
								</option>
								<option value="24"
									<c:if test="${areaNamesId == 24}">selected</c:if>>
									羽村市
								</option>
								<option value="25"
									<c:if test="${areaNamesId == 25}">selected</c:if>>
									あきる野市
								</option>
								<option value="26"
									<c:if test="${areaNamesId == 26}">selected</c:if>>
									西東京市
								</option>
								<option value="27"
									<c:if test="${areaNamesId == 27}">selected</c:if>>
									瑞穂町
								</option>
								<option value="28"
									<c:if test="${areaNamesId == 28}">selected</c:if>>
									日の出町
								</option>
								<option value="29"
									<c:if test="${areaNamesId == 29}">selected</c:if>>
									檜原町
								</option>
								<option value="30"
									<c:if test="${areaNamesId == 30}">selected</c:if>>
									奥多摩町
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>メモ</th>
						<td class="error">
							<c:if test="${not empty memoError}">
							<p><c:out value="${memoError}"/></p>
							</c:if>
							<textarea class="haba" name="memo" cols="40" rows="5">${memo}</textarea>
						</td>
					</tr>
				</table>
				<p>
					<input type="submit" value=" push "/>
				</p>
			</form>
			<p>
				<a href="myPage.jsp"><img class="back" src="icons/iconfinder_return-back-redo-arrow_2075802.png"></a>
			</p>
		</div>
	</div>
</div>
<!-- ★jQueryとBootstrap用JavaScriptの読み込み  -->
<script src="js/jquery-2.2.4.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>