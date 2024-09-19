<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ja">
<head>
<meta charset="UTF-8">
<title>責任者ページ</title>
<link rel="stylesheet" href="" />
</head>
<body>
<header>
<h1>責任者ページ</h1>
<p><a href="<%= request.getContextPath()%>/logout">ログアウト</a></p>
</header>
<main>
<h2><a href="<%= request.getContextPath()%>/item">商品管理</a></h2>
<p>商品の発注や在庫数の確認など</p>
<h2><a href="<%= request.getContextPath()%>/member">勤怠確認</a></h2>
</main>
<footer>
<p>@seisaku.co</p>
</footer>
<script></script>
</body>
</html>