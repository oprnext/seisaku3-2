package dao;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoFactory {
  public static SupervisorDao createSupervisorDao() {
  	return new SupervisorDaoImpl(getDataSource());
  }
  // getDataSourceメソッドでDBと接続
  private static DataSource getDataSource() {
  	DataSource ds = null;
  	try {
  		InitialContext ctx = new InitialContext();
  		ds = (DataSource) ctx.lookup("java:comp/env/jdbc/logininfo_db");
  	}catch(Exception e) {
  		e.printStackTrace();
  	}
  	return ds;
  }
  
  
}

