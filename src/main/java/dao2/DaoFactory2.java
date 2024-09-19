package dao2;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoFactory2 {
	public static OrderDao createOrderDao() {
		return new OrderDaoImpl(getDataSource());
	}

	private static DataSource getDataSource() {
		DataSource ds = null;
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/item_db");
		} catch (NamingException e) {
			System.err.println("JNDIのルックアップに失敗しました: " + e.getMessage());
			e.printStackTrace();
		}
		return ds;
	}
}
