package dao2;

public interface OrderDao {
    

     void insert (int productId, int quantity);

		

		
    	
    	
//    	
//        String sql = "INSERT INTO orders (product_id, quantity) VALUES (?, ?)";
//
//        try (Connection conn = DriverManager.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            stmt.setInt(1, productId);
//            stmt.setInt(2, quantity);
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
