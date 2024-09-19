package dao2;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoFactory2 {
  public static OrderDao createOrderDao() {
  	return new OrderDaoImpl(getDataSource());
  }
  // getDataSourceメソッドでDBと接続
  private static DataSource getDataSource() {
  	DataSource ds = null;
  	try {
  		InitialContext ctx = new InitialContext();
  		ds = (DataSource) ctx.lookup("java:comp/env/jdbc/item_db");
  	}catch(Exception e) {
  		e.printStackTrace();
  	}
  	return ds;
  }
  
  
}