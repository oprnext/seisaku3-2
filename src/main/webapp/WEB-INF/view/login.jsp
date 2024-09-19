<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ログインページ</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/loginStyle.css" />
</head>
<body>

	<header>
		<h1>責任者サイト</h1>
		<c:if test="${!empty error}">
		<p>
			<c:out value="${error }" />
		</p>
	</c:if>
	</header>
	<main>
		<h2>ログインする</h2>
		<form action="" method="post">
			<p>管理者ID(15文字)</p>
			<input type="text" minlength="15" maxlength="15" name="supervisorId" />
			<p>管理者パスワード(10文字)</p>
			<input type="password" minlength="10" maxlength="10" name="supervisorPass" />
			<input type="submit" value="ログイン" />
		</form>

		<p>
			<a href="register">会員登録</a>
		</p>
	</main>

	<fotter>
	<h2>@seisaku.co</h2>
	</fotter>


	<script></script>
</body>
</html>