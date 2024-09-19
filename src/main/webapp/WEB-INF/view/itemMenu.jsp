<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>一覧</title>
<link rel="stylesheet" href="" />
</head>
<body>
	<header>
		<h1>責任者ページ</h1>
		<p><a href="<%= request.getContextPath()%>/logout">ログアウト</a></p>
		<p><a href="javascript:history.back()">前のページに戻る</a></p> <!-- 戻るリンクを追加 -->
	</header>
	<main>
	  <h2>作業一覧</h2>
	  <h3><a href="<%= request.getContextPath()%>/item/order">発注</a></h3>
	  <p>商品の発注・在庫確認</p>
	  <h3><a href="<%= request.getContextPath()%>/item/discount">値引き</a></h3>
	  <p>商品の値引き・価格の再設定</p>
	  <h3><a href="<%= request.getContextPath()%>/item/reservation">予約</a></h3>
	  <p>商品の予約・お客様の予約の確認</p>
	</main>
	<footer>
	<p>seisaku.co</p>
	</footer>



	<script></script>
</body>
</html>