<%@ page import="java.util.*"%>
<%@ page import="domain.Product."%>
<%@ page import="dao2.ProductDao"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<title>商品一覧</title>
</head>
<body>
	<h1>商品一覧</h1>
	<table border="1">
		<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>在庫</th>
			<th>発注</th>
		</tr>
		<%
		ProductDao productDao = new ProductDao();
		List<Product> productList = productDao.getAllProducts();

		for (Product product : productList) {
		%>
		<tr>
			<td><%=product.getName()%></td>
			<td><%=product.getPrice()%></td>
			<td><%=product.getStock()%></td>
			<td>
				<form action="OrderServlet" method="post">
					<input type="hidden" name="product_id"
						value="<%=product.getId()%>"> <input type="number"
						name="quantity" min="1" max="<%=product.getStock()%>" required>
					<button type="submit">発注</button>
				</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
