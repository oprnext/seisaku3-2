<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>商品発注</title>
</head>
<body>
	<h1>商品発注フォーム</h1>
	<form action="" method="post">
		<label for="product_id">商品ID:</label> 
		<input type="text" id="product_id"
			name="product_id" required> <br> 
			<label for="quantity">数量:</label>
		<input type="number" id="quantity" name="quantity" required> <br>
		<input type="submit" value="発注">
	</form>
</body>
</html>
