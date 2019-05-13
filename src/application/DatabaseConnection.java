package application;
import java.sql.*;
public class DatabaseConnection {

	//database connection
		 Connection conn = null;
		 Statement stmt = null;
		public ResultSet rs = null;
	public PreparedStatement psmt = null;
		 
  
	public void Books(String sqlCode) {
		PreparedStatement psmt = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost:3306/centennial_bookstore_db";
			String connectionUser = "root";			
			String connectionPassword = "password";
				
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
				
			psmt = conn.prepareStatement(sqlCode);
			
			
			
		}
		catch (Exception e) {
			   e.printStackTrace();
			   System.out.println(e.toString());
		     }
	}
}
