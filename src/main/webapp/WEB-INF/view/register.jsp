<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>責任者登録</title>
<link rel="stylesheet" href="" />
</head>
<body>
	<h1>新しく責任者を登録</h1>
	
	<form action="" method="post">
	
	  

		<p>
			責任者ID(半角英数字15文字): <input type="text" name="id" />
		</p>

		<p>
			責任者パスワード(半角英数字10文字): <input type="password" name="pass" />
		</p>

		<p>
			<input type="submit" value="登録" />
		</p>
	</form>
	
	<p>
	<a href="login">ログインページへ戻る</a>
	</p>



	<script></script>
</body>
</html>