package dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class OrderDaoImpl implements OrderDao{
  
	 private DataSource ds;
	 
	 public OrderDaoImpl(DataSource ds) {
		 this.ds = ds;
	 }
	
	@Override
	public void insert(int productId, int quantity) {

    String sql = "INSERT INTO orders (product_id, quantity) VALUES (?, ?)";

    try (Connection con = ds.getConnection();
         PreparedStatement stmt = con.prepareStatement(sql)) {
       
    	
        stmt.setInt(1, productId);
        stmt.setInt(2, quantity);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

	
		
	}


