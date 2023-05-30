
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class La_11 {
	    // JDBC driver and database URL
	    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	    static final String DB_URL = "jdbc:mysql://localhost/your_database_name";

	    // Database credentials
	    static final String USER = "your_username";
	    static final String PASS = "your_password";

	    public static void main(String[] args) {
	        Connection conn = null;
	        Statement stmt = null;
	        try {
	            // Register JDBC driver
	            Class.forName(JDBC_DRIVER);

	            // Open a connection
	            System.out.println("Connecting to database...");
	            conn = DriverManager.getConnection(DB_URL, USER, PASS);

	            // Execute a query
	            System.out.println("Creating statement...");
	            stmt = conn.createStatement();
	            String sql = "SELECT * FROM your_table_name";
	            ResultSet rs = stmt.executeQuery(sql);

	            // Process the result set
	            while (rs.next()) {
	                // Retrieve column values
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                // ... retrieve other column values

	                // Display the data
	                System.out.println("ID: " + id);
	                System.out.println("Name: " + name);
	                // ... display other column values
	            }

	            // Clean up resources
	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (SQLException se) {
	            // Handle errors for JDBC
	            se.printStackTrace();
	        } catch (Exception e) {
	            // Handle errors for Class.forName
	            e.printStackTrace();
	        } finally {
	            // Close resources in a finally block to ensure they get closed even if an exception occurs
	            try {
	                if (stmt != null)
	                    stmt.close();
	            } catch (SQLException se2) {
	                se2.printStackTrace();
	            }
	            try {
	                if (conn != null)
	                    conn.close();
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
	        System.out.println("Program ended.");
	    }
	}

